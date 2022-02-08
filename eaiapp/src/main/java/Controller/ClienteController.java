package Controller;

import java.io.IOException;

import Helper.ConexaoCliente;
import Helper.Global;

public class ClienteController {
   public static void main(String[] args) throws IOException {
       ConexaoCliente conexaoCliente = new ConexaoCliente();
       conexaoCliente.Conectar(Global.IP_CONEXAO, 80);

   } 
}
