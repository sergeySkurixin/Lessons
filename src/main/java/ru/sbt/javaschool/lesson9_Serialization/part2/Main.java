package ru.sbt.javaschool.lesson9_Serialization.part2;

import java.io.*;
import java.util.List;

/**
 * Created by скурихин on 03.09.2016.
 */
public class Main {

    public static final String SERIALIZED_FILE_NAME = "serializes.ser";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        SerializableClass sourceObject = new SerializableClass();
//        sourceObject.next = sourceObject;
//        System.out.println(sourceObject);
//        System.out.println(sourceObject.next);
//
//        write(sourceObject);
//        System.out.println("--------------");
//        SerializableClass deserializedObject = new SerializableClass();
//        read(deserializedObject);
//        System.out.println(deserializedObject);
//        System.out.println(deserializedObject.next);

        SerializableClass sourceObject = new SerializableClass();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);

        sourceObject.supername = "data1";
        out.writeObject(sourceObject);
        sourceObject.supername = "data2";
        //IMPORTANT!
//        out.writeObject(sourceObject);
        out.writeUnshared(sourceObject);
        sourceObject.supername = "data3";
        out.writeObject(sourceObject);

        byte[] bytes = byteArrayOutputStream.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream in = new ObjectInputStream(byteArrayInputStream);

        SerializableClass o1 = (SerializableClass) in.readObject();
        SerializableClass o2 = (SerializableClass) in.readObject();
        SerializableClass o3 = (SerializableClass) in.readObject();

        System.out.println(o1);
        System.out.println(o1.supername);
        System.out.println(o2);
        System.out.println(o2.supername);
        System.out.println(o3);
        System.out.println(o3.supername);
    }

    private static void read(SerializableClass deserializedObject) throws IOException, ClassNotFoundException {
        try (InputStream inputStream = new FileInputStream(SERIALIZED_FILE_NAME);
             ObjectInputStream in = new ObjectInputStream(inputStream)) {
            deserializedObject = (SerializableClass) in.readObject();
            System.out.println(deserializedObject.supername);

        }
    }

    private static void write(SerializableClass sourceObject) throws IOException {
        FileOutputStream fos = new FileOutputStream(SERIALIZED_FILE_NAME);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        sourceObject.supername = "supername";
        out.writeObject(sourceObject);
    }
}
