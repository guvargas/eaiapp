package Connection;

import Helper.Global;
import Thread.ServerMainThread;

public class FooServidor {
    public static void main(String[] args) {
        //clicou em servidor
        ServerMainThread serverController = new ServerMainThread(Global.PORTA_CONEXAO);
        serverController.run();
    }
}
