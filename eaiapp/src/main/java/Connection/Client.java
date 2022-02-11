package Connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

import Helper.Global;

public class Client extends Thread {
    private Socket socket = null;
    private InputStreamReader leitor = null;
    private OutputStreamWriter escritor = null;
    private Scanner scanner = null;
    // leitor pra ser mais rapido
    private  BufferedReader bufferLeitor = null;
    // leitor pra ser mais rapido
    private BufferedWriter bufferEscritor = null;

    @Override
    public void run() {

        try {
            // abro o socket
            socket = new Socket(Global.IP_CONEXAO, Global.PORTA_CONEXAO);

            // leitor pega do que vem
            leitor = new InputStreamReader(socket.getInputStream());// , Global.ENCODER_STRING);
            bufferLeitor = new BufferedReader(leitor);
            // escritor pega o que vai
            escritor = new OutputStreamWriter(socket.getOutputStream());
            bufferEscritor = new BufferedWriter(escritor);

            scanner = new Scanner(System.in);
           
            System.out.println("Server: " + new String(bufferLeitor.readLine().getBytes()));

            while (true) {

                String msgToSend = scanner.nextLine();
                bufferEscritor.write(msgToSend);
                bufferEscritor.newLine();
                // pra eficiencia
                bufferEscritor.flush();

                // esperando resposta do servidor
               String respostaServer = new String(bufferLeitor.readLine().getBytes());// , Global.ENCODER_STRING);
                System.out.println("Server: " + respostaServer);

                if (msgToSend.equals("thau")) {
                    break;
                }

            }
        } catch (IOException e) {
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
}
