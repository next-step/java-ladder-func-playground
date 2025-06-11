package people;

import java.util.Collections;
import java.util.List;

public class People {
    private final List<Person> people;

    public People(List<Person> people) {
        this.people = List.copyOf(people);
    }

    public static People from(List<String> names) {
        List<Person> people = names.stream()
                .map(Person::from)
                .toList();
        return new People(people);
    }

    public int size() {
        return people.size();
    }

    public List<Person> values() {
        return Collections.unmodifiableList(people);
    }
}
