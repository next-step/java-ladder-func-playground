package people;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class People {
    private final List<Person> people;

    public People(List<Person> people) {
        this.people = List.copyOf(people);
    }

    public static People from(List<String> names) {
        // 중복 이름 체크
        long uniqueCount = names.stream().distinct().count();
        if (uniqueCount != names.size()) {
            throw new IllegalArgumentException("중복된 이름은 허용되지 않습니다.");
        }

        List<Person> people = names.stream()
                .map(Person::from)
                .toList();
        return new People(people);
    }

    public int size() {
        return people.size();
    }

    public boolean contains(String name) {
        return people.stream()
                .anyMatch(person -> person.name().equals(name));
    }

    public Person personAt(int index) {
        return people.get(index);
    }

    public int indexOf(String name) {
        return IntStream.range(0, people.size())
                .filter(i -> people.get(i).isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이름입니다."));
    }

    public List<Person> values() {
        return Collections.unmodifiableList(people);
    }

}

