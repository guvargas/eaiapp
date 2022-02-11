import Controller.ClienteController;
import Thread.ClientThread;

public class PrincipalClient {
    public static void main(String[] args) {
          // clicou em cliente
          ClienteController cliente = new ClienteController();
          cliente.iniciarConexao();
          cliente.abrirTela();
    }
    public void iniciar() {
        // clicou em cliente
        ClienteController cliente = new ClienteController();
        cliente.abrirTela();
    }
}
