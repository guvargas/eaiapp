package Helper;

import java.io.IOException;
import java.net.*;

import Model.MensageiroThread;


public class ConexaoServidor {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        server.setReuseAddress(true);
        int i =0;
        while (i<2) {
            System.out.println("Aguardando conexao...");
            Socket conn = server.accept();

            MensageiroThread mensageiro = new MensageiroThread(conn);
            mensageiro.start();
            i++;
        }

        server.close();
    }
}
