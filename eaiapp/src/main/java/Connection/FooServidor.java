package Connection;

import Helper.Global;
import Thread.HostThread;

public class FooServidor {
    public static void main(String[] args) {
        //clicou em servidor
        HostThread serverController = new HostThread(Global.PORTA_CONEXAO);
        serverController.run();
    }
}
