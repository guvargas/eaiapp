package Controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import Connection.Server;
import Helper.ServerFactory;
import Model.ServerConnectionThread;

public class ServerController extends Thread {
    private int porta = 8080;
    private ServerFactory fabricaServidores = null;
    public boolean on = false;
   //private HashMap<String, ServerConnectionThread> servidores = new HashMap<String, ServerConnectionThread>();

    public ServerController(int porta) {
        this.porta = porta;
        fabricaServidores = new ServerFactory();
    }

    @Override
    public void run() {
        on = true;
        try {
            ServerSocket server = new ServerSocket(porta);
            server.setReuseAddress(true);

            do {
                System.out.println("Aguardando conexao...");
                Socket conn = server.accept();
                fabricaServidores.criarConexao(conn).start();;
            } while (on);

            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
