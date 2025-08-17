package model;

import java.util.List;

public class Person {

    private final String name;
    private int position;

    public Person(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveLeft() {
        position--;
    }

    public void moveRight() {
        position++;
    }

    public static List<Person> fromNames(List<String> names) {
        return names.stream()
                .map(name -> new Person(name, names.indexOf(name)))
                .toList();

    }
}
