package Thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import Controller.MainController;
import Controller.ServerFactory;

public class HostThread extends Thread {
    private int porta = 8080;
    private ServerFactory fabricaServidores = null;
    public boolean on = false;
    private MainController clienteController=null;

    public HostThread(int porta, MainController clienteController) {
        this.porta = porta;
        fabricaServidores = new ServerFactory();
        this.clienteController = clienteController;
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
                servidor.setClienteController(clienteController);
                servidor.start();
            } while (on);

            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
