package Controller;

import java.net.Socket;

import Thread.HostCommunicationThread;

public class ServerFactory {
    public HostCommunicationThread criarConexao(Socket conectado) {
        return new HostCommunicationThread(conectado);
    }
}
