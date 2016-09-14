package ru.sbt.javaschool.lesson3;

import java.util.*;

/**
 * Created by SBTJavaStudent on 11.08.2016.
 */
public class Main {

    public static void main(String[] args) {
        //System.out.println("Bob"=="Bob");
        //System.out.println("Bob"==new String("Bob"));
        //Person person1 = new Person("Bob");
        //Person person2 = new Person("Ivan");

        //Set<Person> personSet = new HashSet<>();
        //personSet.add(person1);

        //person1.setName("Ivan");
        //System.out.println(personSet.contains(person1));
        //personSet.remove(person1);
        //personSet.removeAll(Arrays.asList(person1,person1,person1));

        //personSet.retainAll(Arrays.asList(person2));
        //System.out.println(personSet);

        Set<Person> personSet = new HashSet<>();
        personSet.addAll(Arrays.asList(
                new Person("asdf"),
                new Person("asdfwefr"),
                new Person("grt")
        ));

        ArrayList<Person> personList = new ArrayList<>(personSet);
        getSorted(personList);
        System.out.println(personList);
    }

    public static void getSorted(List<Person> personList){
        Comparator<Person> comparator = new Comparator<Person>() {
            public int compare(Person o1, Person o2){
                return o1.getName().compareTo(o2.getName());
            }
        };
    }
}
