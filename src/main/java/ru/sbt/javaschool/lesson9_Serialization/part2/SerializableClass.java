package ru.sbt.javaschool.lesson9_Serialization.part2;

import java.io.Serializable;

/**
 * Created by скурихин on 03.09.2016.
 */
public class SerializableClass implements Serializable{
    String supername;
    private int likes;
    private static String vesion ="1.0.2";
    private static long serialVersionUID =3100689139114642940L;
    SerializableClass next = this;
}
