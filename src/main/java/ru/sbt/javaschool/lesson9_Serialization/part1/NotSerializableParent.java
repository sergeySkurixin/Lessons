package ru.sbt.javaschool.lesson9_Serialization.part1;

/**
 * Created by скурихин on 03.09.2016.
 */
public class NotSerializableParent {
    String superData;
    int likes;
    static String version ="1.0.2";

    public NotSerializableParent(String superData) {
        this.superData = superData;
    }

    public NotSerializableParent() {
        System.out.println("super");
    }
}
