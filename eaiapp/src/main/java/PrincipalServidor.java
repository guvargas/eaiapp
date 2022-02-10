import Controller.ServerController;
import Helper.Global;

public class PrincipalServidor {
    public static void main(String[] args) {
        //clicou em servidor
        ServerController serverController = new ServerController(Global.PORTA_CONEXAO);
        serverController.run();
    }
}
