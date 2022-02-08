package Helper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConexaoCliente {
    
    private InputStream in;
    private OutputStream out;
    private String ip;
    private int porta;

    private String LerResposta() throws IOException{
        byte[] dadosBrutos = new byte[1024];
        int qtdBytesLidos = in.read(dadosBrutos);
        String resposta;;
                resposta = new String(dadosBrutos, 0, qtdBytesLidos);
               return resposta;

    }
    public boolean Conectar(String ip, int porta) throws IOException {
        this.ip=ip;
        this.porta=porta;
        try (Socket conn = new Socket(this.ip, this.porta);) {
           
            System.out.println("Conectado!");
            in = conn.getInputStream();
            out = conn.getOutputStream();
            String comando;
           // ClienteView v= new ClienteView();
            System.out.println(LerResposta());
            /*        
            do {
                comando = v.Escolher();  
                // enviar o comando para o servidor
               
               
                out.write(comando.getBytes());
                //ler resposta
                if(comando.equals("sair")){
                    break;
                }
                System.out.println(LerResposta());          

                
            } while (!comando.equals("sair"));
            */
        } catch (UnknownHostException e) {
            e.printStackTrace();
            
            return false;
        } 
        return true;
    }
/*
    public String enviarComando(String s) throws IOException {
        out.write(s.getBytes());
        byte[] dadosBrutos = new byte[1024];
        int qtdBytesLidos;
        qtdBytesLidos = in.read(dadosBrutos);
        String resultado = new String(dadosBrutos, 0, qtdBytesLidos);
        return resultado;
    }*/
}
