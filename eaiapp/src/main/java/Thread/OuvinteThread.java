package Thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class OuvinteThread extends Thread {
    private InputStreamReader leitor = null;
    private BufferedReader bufferLeitor = null;
    Socket socket;
    public OuvinteThread(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
            // leitor pega do que vem
            try {
                leitor = new InputStreamReader(socket.getInputStream());
                bufferLeitor = new BufferedReader(leitor);

                do{
                    
                    String respostaServer = new String(bufferLeitor.readLine().getBytes());// , Global.ENCODER_STRING);
                    System.out.println("Server: " + respostaServer);
                    
                }while(true);


            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }// , Global.ENCODER_STRING);
          
    }
}
