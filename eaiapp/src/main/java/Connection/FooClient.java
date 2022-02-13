package Connection;

import Thread.SenderThread;

public class FooClient {
 public static void main(String[] args) {
     SenderThread client= new SenderThread();
     client.start();
 }   
}
