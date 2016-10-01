package first_example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;

/**
 * Created by SBTJavastudent on 01.10.2016.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Started");
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     OutputStream out = clientSocket.getOutputStream();
                     InputStream is = clientSocket.getInputStream();
                     ObjectInputStream ois = new ObjectInputStream(is)

                ) {

                    System.out.println("Connected" + clientSocket.getInetAddress());

                    String s = ois.readUTF();
                    System.out.println("Readed: " + s);
                    if (s.equals("GET_TIME")) {
                        ObjectOutputStream oos = new ObjectOutputStream(out);
                        oos.writeUTF(LocalTime.now().toString());
                        oos.flush();
                    }
//                    String res = LocalTime.now().toString();
//                    byte[] bytes = res.getBytes();
//                    out.write(bytes);
                    System.out.println("Done");

                }
            }
        }
    }
}
