package model;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LadderUsers {

    private final List<LadderUser> ladderUsers;

    public LadderUsers(List<LadderUser> ladderUsers) {
        validateSize(ladderUsers);
        validateDuplicate(ladderUsers);

        this.ladderUsers = Collections.unmodifiableList(ladderUsers);
    }

    public List<String> getNames() {
        return ladderUsers.stream()
                .map(LadderUser::getName)
                .toList();
    }

    public Optional<Integer> findIndexOfUserByName(String name) {
        Optional<LadderUser> findUser = ladderUsers.stream()
                .filter(ladderUser -> ladderUser.getName().equals(name))
                .findAny();

        return findUser.map(ladderUsers::indexOf);
    }

    public int size() {
        return ladderUsers.size();
    }

    private void validateSize(List<LadderUser> ladderUsers) {
        if (ladderUsers.size() < 2) {
            throw new IllegalArgumentException("참여자는 2명 미만일 수 없습니다.");
        }
    }

    private void validateDuplicate(List<LadderUser> ladderUsers) {
        boolean duplicated = ladderUsers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .anyMatch(count -> count > 1);

        if (duplicated) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

}
