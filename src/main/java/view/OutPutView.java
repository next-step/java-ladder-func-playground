package view;

import java.util.List;

import model.Ladder;
import model.Line;
import model.Person;

public class OutPutView {

    public static void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        System.out.println("사다리 결과");
        for (Person person : ladder.getPersons()) {
            System.out.print(person.getName() + " ");
        }
        System.out.println();
        for (Line line : lines) {
            System.out.println(line);
        }
        for (String result : ladder.getResults()) {
            System.out.print(result + "   ");
        }
        System.out.println();
    }

    public static void printLadderResult(Ladder ladder) {
        System.out.println("실행 결과");
        for (Person person : ladder.getPersons()) {
            System.out.println(person.getName() + " : " + ladder.getResults().get(person.getPosition()));
        }
    }

    public static void printPersonResult(Person person, Ladder ladder) {
        System.out.println(ladder.getResults().get(person.getPosition()));
    }
}
