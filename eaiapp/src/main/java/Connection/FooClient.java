package Connection;

import Thread.ClientThread;

public class FooClient {
 public static void main(String[] args) {
     ClientThread client= new ClientThread();
     client.start();
 }   
}
