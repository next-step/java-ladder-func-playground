package model;

import java.util.List;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;
    private List<Person> persons;
    private List<String> results;

    public Ladder(int height, int width, List<Person> persons, List<String> results) {
        this.lines = Stream.generate(() -> new Line(width))
                .limit(height)
                .toList();
        this.persons = persons;
        this.results = results;
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public List<String> getResults() {
        return results;
    }

    public boolean isPoint(int lineIndex, int pointIndex) {
        if (lineIndex < 0 || lineIndex >= lines.size()) {
            throw new IndexOutOfBoundsException("인덱스 범위 초과");
        }
        return lines.get(lineIndex).isPoint(pointIndex);
    }

    public Person getPersonByName(String name) {
        return persons.stream()
                .filter(person -> person.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 사람이 없습니다: "));
    }

}
