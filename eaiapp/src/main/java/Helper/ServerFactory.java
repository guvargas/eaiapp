package Helper;

import java.net.Socket;

import Thread.ServerConnectionThread;

public class ServerFactory {
    public ServerConnectionThread criarConexao(Socket conectado) {
        return new ServerConnectionThread(conectado);
    }
}
