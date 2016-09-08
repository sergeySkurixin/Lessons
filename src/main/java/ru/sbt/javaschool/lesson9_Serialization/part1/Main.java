package ru.sbt.javaschool.lesson9_Serialization.part1;

import org.apache.commons.codec.binary.Hex;

import java.io.*;

/**
 * Created by скурихин on 01.09.2016.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        SerializableClass obj = new SerializableClass("1");
        obj.superData ="my super data";
        System.out.println(obj);
        System.out.println(obj.superData);
        out.writeObject(obj);

        byte[] bytes = bos.toByteArray();
        String hexString = Hex.encodeHexString(bytes);
        System.out.println(bytes);

        InputStream inputStream = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream in = new ObjectInputStream(inputStream);
        SerializableClass o=(SerializableClass) in.readObject();
        System.out.println(o);
        System.out.println(o.superData);

    }
}
