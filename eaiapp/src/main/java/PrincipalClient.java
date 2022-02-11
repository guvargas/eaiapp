import Connection.Client;
import Controller.ClienteController;

public class PrincipalClient {
    public static void main(String[] args) {
        //clicou em cliente
        ClienteController cliente = new ClienteController();
        cliente.abrirTela();
    }
}
