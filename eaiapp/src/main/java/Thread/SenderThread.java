package Thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

import Data.BancoMensagens;
import Helper.Global;
import Model.Conversa;

public class SenderThread extends Thread {

    public SenderThread() {
    }

    public void setMensagem(String msg) {
        this.msg = msg;
    }

    public SenderThread(Conversa conversa) {
        this.ip = conversa.getIp();
        this.porta = conversa.getPorta();
    }

    public SenderThread(String ip, int porta) {
        this.ip = ip;
        this.porta = porta;
    }

    private boolean isConnected() throws IOException {
        String respostaServer = new String(bufferLeitor.readLine().getBytes());//
        System.out.println(respostaServer);
        if (respostaServer.split(";")[0].equals("confirmacao")
                && respostaServer.split(";")[1].equals("conectado")) {
            System.out.println("Usuario online");
            return true;
        } else {
            System.out.println("Usuario offline");
            return false;
        }
    }

    private void enviarMensagem() throws IOException {
      //  String msg = BancoMensagens.filaMensagens.get(0);
       // BancoMensagens.filaMensagens.remove(0);

        bufferEscritor.write(msg);
        bufferEscritor.newLine();
        // pra eficiencia
        bufferEscritor.flush();
        // esperando resposta do servidor
    }

    @Override
    public void run() {

        try {
            // abro o socket
            socket = new Socket(ip, porta);

            // leitor pega do que vem
            leitor = new InputStreamReader(socket.getInputStream());// , Global.ENCODER_STRING);
            bufferLeitor = new BufferedReader(leitor);

            // escritor pega o que vai
            escritor = new OutputStreamWriter(socket.getOutputStream());
            bufferEscritor = new BufferedWriter(escritor);

            if (isConnected()) {
                enviarMensagem();
                lerResposta();
            }

            fecharConexoes();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fecharConexoes();
        }

    }

    private void lerResposta() throws IOException {
        String respostaServer = new String(bufferLeitor.readLine().getBytes());//
        System.out.println(respostaServer);
        if (respostaServer.split(";")[0].equals("confirmacao")
                && respostaServer.split(";")[1].equals("recebido")) {
            System.out.println("Usuario recebeu mensagem");
        } else {
            System.out.println("Usuario nao recebeu mensagem");
        }
    }

    private void fecharConexoes() {
        try {
            if (bufferEscritor != null) {
                bufferEscritor.close();
            }
            if (bufferLeitor != null) {
                bufferLeitor.close();
            }
            if (escritor != null) {
                escritor.close();
            }
            if (leitor != null) {
                leitor.close();
            }
            if (socket != null) {
                socket.close();
            }
            if (scanner != null) {
                scanner.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Socket socket = null;
    private InputStreamReader leitor = null;
    private OutputStreamWriter escritor = null;
    private Scanner scanner = null;
    // leitor pra ser mais rapido
    private BufferedReader bufferLeitor = null;
    // leitor pra ser mais rapido
    private BufferedWriter bufferEscritor = null;
    private String msg;
    private String ip = Global.IP_CONEXAO;
    private int porta = Global.PORTA_CONEXAO;
}
