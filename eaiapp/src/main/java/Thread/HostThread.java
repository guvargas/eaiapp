package Thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import Helper.ServerFactory;

public class HostThread extends Thread {
    private int porta = 8080;
    private ServerFactory fabricaServidores = null;
    public boolean on = false;
    private HashMap<String, HostCommunicationThread> servidores = new HashMap<String, HostCommunicationThread>();

    public HostThread(int porta) {
        this.porta = porta;
        fabricaServidores = new ServerFactory();
    }

    public void desligarHost() {
        on = false;
        this.stop();
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
                HostCommunicationThread servidor = fabricaServidores.criarConexao(conn);
                servidor.start();
               // servidores.put(conn.getInetAddress().getHostAddress(), servidor);
            } while (on);

            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
