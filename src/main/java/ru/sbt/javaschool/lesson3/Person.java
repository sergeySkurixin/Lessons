package ru.sbt.javaschool.lesson3;

/**
 * Created by SBTJavaStudent on 11.08.2016.
 */
public class Person {
    private String name;

    public Person(String name){
        if(name==null){
            throw new IllegalStateException("name is null");
        }
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setName(String newstr){
        name = newstr;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;

        return name.equals(person.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
