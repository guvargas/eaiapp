package Old;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class oldMensageiroThread extends Thread {
    private Socket conn;

    public oldMensageiroThread(Socket conn) {
        this.conn = conn;
    }

    @Override
    public void run() {
        // Envia uma piada pelo socket
        try {
            System.out.println("Enviando dados pela thread...");
            //conn.setSoTimeout(5000); // timeout para receber algum dado do cliente, se for o caso
            OutputStream out  = conn.getOutputStream();

            // escolher piada e enviar as frases da piada
            String[] piada = {"áçãoé?!", "beirando o mar", "com rispidez"};
            for (int i = 0; i < piada.length; i++) {
                Thread.sleep(1000);
                out.write(piada[i].getBytes());
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro de entrada/saída ou thread interrompida");
            e.printStackTrace();
        } finally{
            try {
                this.conn.close();
            } catch (IOException ex) {
                System.out.println("Erro ao fechar socket");
                ex.printStackTrace();
            }
        }
        System.out.println("Thread finalizada.");
    }
}
