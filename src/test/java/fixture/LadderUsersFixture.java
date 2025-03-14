package fixture;

import model.LadderUser;
import model.LadderUsers;

import java.util.List;

public enum LadderUsersFixture {

    FOUR_USERS(List.of("user1", "user2", "user3", "user4")),
    FIVE_USERS(List.of("userA", "userB", "userC", "userD", "userE"));

    private final List<LadderUser> ladderUsers;

    LadderUsersFixture(List<String> userNames) {
        this.ladderUsers = userNames.stream()
                .map(LadderUser::new)
                .toList();
    }

    public LadderUsers getValue() {
        return new LadderUsers(ladderUsers);
    }

}
