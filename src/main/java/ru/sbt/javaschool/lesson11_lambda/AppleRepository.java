package ru.sbt.javaschool.lesson11_lambda;

import java.lang.reflect.Array;
import java.util.*;


/**
 * Created by SBTJavaStudent on 10.09.2016.
 */

enum Color {
    RED, YELLOW, BLUE, GREEN
}

class Apple {
    private Color color;
    private int weight;
    private String name;

    public Apple(String name, Color color, int weight) {
        this.color = color;
        this.weight = weight;
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}

interface Predicate<T> {
    boolean apply(Apple apple);
}

class RedApplePredicates implements Predicate<Apple> {

    @Override
    public boolean apply(Apple apple) {
        return apple.getColor() == Color.RED;
    }
}

class AppleGreaterThen50GrammPredicate implements Predicate {

    @Override
    public boolean apply(Apple apple) {
        return apple.getWeight() > 50;
    }
}

public class AppleRepository {
    private static List<Apple> apples = Arrays.asList(
            new Apple("apple1", Color.RED, 13),
            new Apple("apple21", Color.GREEN, 43),
            new Apple("apple31", Color.RED, 15),
            new Apple("apple15", Color.BLUE, 15),
            new Apple("apple451", Color.RED, 73),
            new Apple("apple13", Color.BLUE, 8),
            new Apple("apple51", Color.RED, 93),
            new Apple("apple61", Color.YELLOW, 87)
    );

    public static void main(String[] args) {
        //вывести все названия красных яблок в алфавитом порядке у которых вес больше 50 гр.
        List<Apple> filtered1 = filterApples(apples, Arrays.<Predicate<Apple>>asList(
                new RedApplePredicates(),
                new AppleGreaterThen50GrammPredicate()
        ));

        List<Apple> filtered = filterApples(apples,(apple -> apple.getColor()==Color.BLUE));
        List<String> names = new ArrayList<>();
        for (Apple apple : filtered) {
            names.add(apple.getName());
        }
        Collections.sort(names);
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("---------------------");

        //LAMBDASSSS

        apples.stream()
                .filter(apple -> apple.getColor() == Color.RED && apple.getWeight() > 50)
                .map(Apple::getName)
                .sorted()
                .forEach(StaticRef::print);//static!!
    }

    private static List<Apple> filterApples(List<Apple> apples, List<Predicate<Apple>> predicates) {
        List<Apple> filtered = new ArrayList<>();
        for (Apple apple : apples) {
            boolean isOk = true;
            for (Predicate<Apple> predicate : predicates) {
                isOk = isOk && predicate.apply(apple);
            }
            if (isOk) {
                filtered.add(apple);
            }
        }
        return filtered;
    }

    private static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> predicate) {
        List<Apple> filtered = new ArrayList<>();
        for (Apple apple : apples) {
            boolean isOk = true;
                isOk = isOk && predicate.apply(apple);
            if (isOk) {
                filtered.add(apple);
            }
        }
        return filtered;
    }

    static class StaticRef {

        public static void print(String s) {
            System.out.println(s);
        }
    }
}