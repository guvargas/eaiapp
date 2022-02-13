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

public class SenderThread extends Thread {


    public SenderThread() {

    }

    public SenderThread(String ip, int porta) {
        this.ip = ip;
        this.porta = porta;
    }

    @Override
    public void run() {

        try {
            // abro o socket
            socket = new Socket(ip, porta);

            // leitor pega do que vem

            leitor = new InputStreamReader(socket.getInputStream());// , Global.ENCODER_STRING);
            bufferLeitor = new BufferedReader(leitor);
            /*
             * OuvinteThread ouvinte = new OuvinteThread(socket);
             * ouvinte.start();
             */

            // escritor pega o que vai
            escritor = new OutputStreamWriter(socket.getOutputStream());
            bufferEscritor = new BufferedWriter(escritor);

          

            // System.out.println("Server: " + new
            // String(bufferLeitor.readLine().getBytes()));

          //  do {

            //    if (!BancoMensagens.filaMensagens.isEmpty()) {
                    String msgToSend = BancoMensagens.filaMensagens.get(0);
                    BancoMensagens.filaMensagens.remove(0);
                    bufferEscritor.write(msgToSend);
                    bufferEscritor.newLine();
                    // pra eficiencia
                    bufferEscritor.flush();
                    // esperando resposta do servidor
                    
                     String respostaServer = new String(bufferLeitor.readLine().getBytes());//
                     System.out.println("Server: " + respostaServer);
                     

             //   } else {
              //      sleep(500);
              //  }

          //  } while (true);
          fecharConexoes();
        } catch (IOException e ) {
            e.printStackTrace();
        } finally {
            fecharConexoes();
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

    private String ip = Global.IP_CONEXAO;
    private int porta = Global.PORTA_CONEXAO;
}
