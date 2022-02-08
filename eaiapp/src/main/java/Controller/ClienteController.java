package Controller;

import java.io.IOException;

import Helper.ConexaoCliente;

public class ClienteController {
   public static void main(String[] args) throws IOException {
       ConexaoCliente conexaoCliente = new ConexaoCliente();
       conexaoCliente.Conectar("192.168.18.195", 80);

   } 
}
