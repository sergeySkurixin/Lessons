package gadalka;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;

/**
 * Created by SBTJavastudent on 01.10.2016.
 */
public class Gadalka implements Callable{
    private InputStream is;
    private OutputStream os;

    public Gadalka(InputStream is1, OutputStream os1) {
        this.is = is1;
        this.os = os1;
    }

    @Override
    public Object call() throws Exception {
        byte[] inArray=new byte[100];

//        os.write();
        int countBytes;
        while((countBytes = is.read(inArray))>=0) {
            System.out.println(inArray);
        }
        return null;
    }
}
