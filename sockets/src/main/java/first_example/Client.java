package first_example;

import java.io.*;
import java.net.Socket;

/**
 * Created by SBTJavastudent on 01.10.2016.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[100];
        try (Socket socket = new Socket("172.16.18.119", 1234);
             InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(out)
        ) {

            oos.writeUTF("GET_TIME");
            oos.flush();
//            System.out.println("Connected!");
//            int readBytes = in.read(buffer);
//            String date = new String(buffer, 0, readBytes);
//            System.out.println(date);
            ObjectInputStream ois = new ObjectInputStream(in);
            String s = ois.readUTF();
            System.out.println(s);
            System.out.println("Done");

        }
    }
}
