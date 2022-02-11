package Old;

import java.io.IOException;

import Helper.Global;

public class oldClienteController {
   public static void main(String[] args) throws IOException {
       oldConexaoCliente conexaoCliente = new oldConexaoCliente();
       conexaoCliente.Conectar(Global.IP_CONEXAO, 8080);

   } 
}
