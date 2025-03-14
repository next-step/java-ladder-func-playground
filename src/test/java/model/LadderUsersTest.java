package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static fixture.LadderUserFixture.DUPLICATED_USER_COLLECTION;
import static fixture.LadderUserFixture.FIVE_USER_COLLECTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderUsersTest {

    private static final String DEFAULT_USER_NAME = "hello";

    @Test
    @DisplayName("사용자가 2명 미만이면 예외가 발생한다")
    void ifFewUserThenThrowException() {
        List<LadderUser> singleLadderUserCollection = createLadderUserCollection(DEFAULT_USER_NAME);

        assertThatThrownBy(() -> new LadderUsers(singleLadderUserCollection))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자 이름이 중복되면 예외가 발생한다")
    void ifNameDuplicatedThenThrowException() {
        List<LadderUser> duplicatedUserCollection = DUPLICATED_USER_COLLECTION.getValueCollection();

        assertThatThrownBy(() -> new LadderUsers(duplicatedUserCollection))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자 이름을 담은 컬렉션을 반환한다")
    void getNames() {
        List<LadderUser> fiveLadderUserCollection = FIVE_USER_COLLECTION.getValueCollection();
        LadderUsers ladderUsers = new LadderUsers(fiveLadderUserCollection);
        List<String> names = ladderUsers.getNames();

        int actualSize = names.size();
        int expectedSize = fiveLadderUserCollection.size();

        assertThat(actualSize).isSameAs(expectedSize);
    }

    @Test
    @DisplayName("이름을 통해 인덱스 번호를 반환한다")
    void getIndexFromName() {
        List<LadderUser> ladderUserCollection = createLadderUserCollection("1", "2", "3", "4", "5");
        LadderUsers ladderUsers = new LadderUsers(ladderUserCollection);

        for (LadderUser ladderUser : ladderUserCollection) {
            int actualIndex = ladderUsers.findIndexOfUserByName(ladderUser.getName())
                    .orElseThrow();
            int expectedIndex = ladderUserCollection.indexOf(ladderUser);

            assertThat(actualIndex).isSameAs(expectedIndex);
        }
    }

    private List<LadderUser> createLadderUserCollection(String... names) {
        return Arrays.stream(names)
                .map(LadderUser::new)
                .toList();
    }

}
