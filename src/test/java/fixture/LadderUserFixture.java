package fixture;

import model.LadderUser;

import java.util.List;

public enum LadderUserFixture {

    FIVE_USER_COLLECTION(List.of("1", "2", "3", "4", "5")),
    NOT_DUPLICATED_USER_COLLECTION(List.of("A", "B", "C", "D", "E")),
    DUPLICATED_USER_COLLECTION(List.of("A", "B", "C", "A", "D"));

    private final List<LadderUser> ladderUserCollection;

    LadderUserFixture(List<String> names) {
        this.ladderUserCollection = names.stream()
                .map(LadderUser::new)
                .toList();
    }

    public List<LadderUser> getValueCollection() {
        return ladderUserCollection;
    }

}
