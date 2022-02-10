package Helper;

import java.net.Socket;

import Model.ServerConnectionThread;

public class ServerFactory {
    public ServerConnectionThread criarConexao(Socket conectado) {
        return new ServerConnectionThread(conectado);
    }
}
