package gadalka;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by SBTJavastudent on 01.10.2016.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Random random = new Random();
        while (true) {
            try(Socket client = serverSocket.accept();
                InputStream is = client.getInputStream();
                OutputStream os = client.getOutputStream();
            ){
                int task = random.nextInt(10);

                Gadalka gadalka = new Gadalka(is,os);
                pool.submit(gadalka);

            }
        }
    }
}
