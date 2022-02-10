package Helper;

import java.io.IOException;
import java.net.*;

import Model.oldMensageiroThread;


public class oldConexaoServidor {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        server.setReuseAddress(true);
        int i =0;
        while (i<2) {
            System.out.println("Aguardando conexao...");
            Socket conn = server.accept();

            oldMensageiroThread mensageiro = new oldMensageiroThread(conn);
            mensageiro.start();
            i++;
        }

        server.close();
    }
}
