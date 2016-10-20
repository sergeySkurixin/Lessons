package spring;


/**
 * Created by SBTJavastudent on 20.10.2016.
 */
public class HelloWorld {
    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    private String name;

    public void printHello() {
        System.out.println("Spring: Hello " + name);
    }
}
