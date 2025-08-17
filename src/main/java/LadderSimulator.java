import java.util.List;

import model.Ladder;
import model.Person;
import util.InputParser;
import view.InputView;
import view.OutPutView;

public class LadderSimulator {

    private Ladder ladder;
    private int height;
    private int width;

    public void start() {
        processLadderInput();
        processLadderPersonMove();
        processLadderResult();
    }

    private void processLadderInput() {
        List<Person> persons = InputParser.parsePersons(InputView.inputPersons());
        List<String> results = InputParser.parseResults(InputView.inputResults());
        height = InputParser.parseLadderHeight(InputView.inputLadderHeight());
        width = persons.size() - 1;

        this.ladder = new Ladder(height, width, persons, results);
        OutPutView.printLadder(ladder);
    }

    private void processLadderPersonMove() {
        for (Person person : ladder.getPersons()) {
            PersonMovement(person);
        }
    }

    private void processLadderResult() {
        while (true) {
            String resultPersonName = InputView.inputResultPerson();

            if (resultPersonName.equals("all")) { // all 입력시 모든 사람의 결과 출력
                OutPutView.printLadderResult(ladder);
                return;
            }

            Person resultPerson = ladder.getPersonByName(resultPersonName);
            OutPutView.printPersonResult(resultPerson, ladder);
        }
    }

    // 우측우선이동임
    private void personMovement(Person person) {
        for (int nowHeight = 0; nowHeight < height; nowHeight++) {
            if (canMoveRight(person, ladder, nowHeight)) {
                person.moveRight();
                continue;
            }

            if (canMoveLeft(person, ladder, nowHeight)) {
                person.moveLeft();
                continue;
            }
        }
    }

    private boolean canMoveLeft(Person person, Ladder ladder, int nowHeight) {
        return person.getPosition() > 0 && ladder.isPoint(nowHeight, person.getPosition() - 1);
    }

    private boolean canMoveRight(Person person, Ladder ladder, int nowHeight) {
        return person.getPosition() < width && ladder.isPoint(nowHeight, person.getPosition());
    }

}
