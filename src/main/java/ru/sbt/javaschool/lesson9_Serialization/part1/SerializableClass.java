package ru.sbt.javaschool.lesson9_Serialization.part1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by скурихин on 03.09.2016.
 */
public class SerializableClass extends NotSerializableParent implements Serializable {
    String childData;
    public SerializableClass() {
        super("!");
        System.out.println("SDFSSDFS");
    }

    public SerializableClass(String superData) {
        super(superData);
    }

    private void writeObject(ObjectOutputStream out) throws IOException{
        out.defaultWriteObject();
        out.writeUTF(superData);
        out.writeInt(likes);
        out.writeUTF(version);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        in.defaultReadObject();
        superData= in.readUTF();
        likes = in.readInt();
        version=in.readUTF();
    }
}
