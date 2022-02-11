package Old;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import Helper.Global;

public class oldServer {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        InputStreamReader leitor = null;
        OutputStreamWriter escritor = null;

        // leitor pra ser mais rapido
        BufferedReader bufferLeitor = null;

        // leitor pra ser mais rapido
        BufferedWriter bufferEscritor = null;

        ServerSocket serverSocket = null;

        serverSocket = new ServerSocket(Global.PORTA_CONEXAO);

        while (true) {
            try {
                socket = serverSocket.accept();

                //pega o ip
                InetSocketAddress sockaddr = (InetSocketAddress)socket.getRemoteSocketAddress();
                InetAddress inaddr = sockaddr.getAddress();
                Inet4Address in4addr = (Inet4Address)inaddr;
                String ip4string = in4addr.toString();
                System.out.println("IP: " + ip4string+ " ip2: " + socket.getRemoteSocketAddress() );


                // leitor pega do que vem
                leitor = new InputStreamReader(socket.getInputStream());//,Global.ENCODER_STRING);
                bufferLeitor = new BufferedReader(leitor);

                // escritor pega o que vai
                escritor = new OutputStreamWriter(socket.getOutputStream());
                bufferEscritor = new BufferedWriter(escritor);

                while (true) {
                    String msgFromClient = new String(bufferLeitor.readLine().getBytes());//, Global.ENCODER_STRING);
                    System.out.println("Client: " + msgFromClient);
                    bufferEscritor.write("áçãoé?!");
                    bufferEscritor.newLine();
                    // pra eficiencia
                    bufferEscritor.flush();
                    if (msgFromClient.equals("thau")) {
                        break;
                    }
                }

                if(bufferEscritor != null){
                    bufferEscritor.close();
                }
                if(bufferLeitor != null){
                    bufferLeitor.close();
                }
                if(escritor != null){
                    escritor.close();
                }
                if(leitor != null){
                    leitor.close();
                }
                if(socket != null){
                    socket.close();
                }

            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        
    }
}
