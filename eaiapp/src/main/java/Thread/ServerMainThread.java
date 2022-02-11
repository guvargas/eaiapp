package Thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import Helper.ServerFactory;
import Old.oldServer;

public class ServerMainThread extends Thread {
    private int porta = 8080;
    private ServerFactory fabricaServidores = null;
    public boolean on = false;
   private HashMap<String, ServerConnectionThread> servidores = new HashMap<String, ServerConnectionThread>();

    public ServerMainThread(int porta) {
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
                ServerConnectionThread servidor = fabricaServidores.criarConexao(conn);
                servidor.start();
                servidores.put(conn.getInetAddress().getHostAddress(), servidor);
            } while (on);

            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
