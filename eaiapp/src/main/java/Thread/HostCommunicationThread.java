package Thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

import Controller.MainController;

public class HostCommunicationThread extends Thread {

    public HostCommunicationThread(Socket conn) {
        this.conexao = conn;
    }

    private void enviaMensagem(String s) throws IOException {
        bufferEscritor.write(s);
        bufferEscritor.newLine();
        bufferEscritor.flush();
    }

    @Override
    public void run() {
        on = true;
        try {
            System.out.println("Alguem conectou comigo o ip eh: " + conexao.getInetAddress().getHostAddress());

            // leitor pega do que vem
            leitor = new InputStreamReader(conexao.getInputStream());// ,Global.ENCODER_STRING);
            bufferLeitor = new BufferedReader(leitor);

            // escritor pega o que vai
            escritor = new OutputStreamWriter(conexao.getOutputStream());
            bufferEscritor = new BufferedWriter(escritor);

            enviaMensagem("confirmacao;conectado;");
            // pega o ip
            clienteController.messageReceived(new String(bufferLeitor.readLine().getBytes()),
                    conexao.getRemoteSocketAddress().toString());
            enviaMensagem("confirmacao;recebido;");

            fecharConexoes();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fecharConexoes();
        }

    }

    public void turnOff() {
        on = false;
        this.stop();
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
            if (conexao != null) {
                conexao.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Socket conexao = null;
    public Boolean on = false;

    // leitor e escritor
    private InputStreamReader leitor = null;
    private OutputStreamWriter escritor = null;

    // leitor pra ser mais rapido
    private BufferedReader bufferLeitor = null;

    // leitor pra ser mais rapido
    private BufferedWriter bufferEscritor = null;
    private MainController clienteController = null;

    public void setClienteController(MainController clienteController) {
        this.clienteController = clienteController;
    }

}
