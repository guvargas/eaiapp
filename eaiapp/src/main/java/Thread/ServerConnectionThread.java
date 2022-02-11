package Thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerConnectionThread extends Thread {

    public ServerConnectionThread(Socket conn) {
        this.conexao = conn;
    }

    @Override
    public void run() {
        on= true;
        try {
            System.out.println("Thread de conexao com o servidor iniciada.");
            // leitor pega do que vem
            leitor = new InputStreamReader(conexao.getInputStream());// ,Global.ENCODER_STRING);
            bufferLeitor = new BufferedReader(leitor);

            // escritor pega o que vai
            escritor = new OutputStreamWriter(conexao.getOutputStream());
            bufferEscritor = new BufferedWriter(escritor);


            bufferEscritor.write("conectado;"+this.getId());
            bufferEscritor.newLine();
            bufferEscritor.flush();

            while (on) {
                String msgFromClient = new String(bufferLeitor.readLine().getBytes());// , Global.ENCODER_STRING);
                System.out.println("Client enviou: " + msgFromClient);
                bufferEscritor.write("Mensagem recebida pelo servidor");
                bufferEscritor.newLine();
                // pra eficiencia
                bufferEscritor.flush();
                if (msgFromClient.equals("tchau")) {
                    break;
                }
            }

            fecharConexoes();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            fecharConexoes();
        }

    }

    public void turnOff() {
        on= false;
        //this.stop();
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
    public Boolean on= false;

    // leitor e escritor
    private InputStreamReader leitor = null;
    private OutputStreamWriter escritor = null;

    // leitor pra ser mais rapido
    private BufferedReader bufferLeitor = null;

    // leitor pra ser mais rapido
    private BufferedWriter bufferEscritor = null;


}
