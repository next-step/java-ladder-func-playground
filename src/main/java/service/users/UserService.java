package service.users;

import domain.ladder.Ladder;
import domain.ladder.LadderInfo;
import domain.ladder.LadderLine;
import domain.users.User;
import domain.users.Users;
import repository.users.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void makeUsers(final List<String> userNames) {
        userRepository.setUsers(new Users(userNames.stream()
                .map(userName -> new User(userName, userNames.indexOf(userName)))
                .toList()));
    }

    public void updatePosition(final Ladder ladder, final Users users) {
        for (User user : users.users()) {
            updatePosition(user, ladder.ladderLines(), ladder.ladderInfo());
        }
    }

    public Users getUsers() {
        return userRepository.getUsers();
    }

    public User findByName(final String name) {
        return userRepository.findByName(name);
    }

    private void updatePosition(final User user, final List<LadderLine> ladderLines, final LadderInfo ladderInfo) {
        for (LadderLine ladderLine : ladderLines) {
            final boolean isConnectedRight = checkRightConnection(ladderLine.connections(), user.getPosition(), ladderInfo.width());
            final boolean isConnectedLeft = checkLeftConnection(ladderLine.connections(), user.getPosition());
            decideMoving(isConnectedLeft, isConnectedRight, user);
        }
    }

    private boolean checkRightConnection(final List<Boolean> connections, final int position, final int width) {
        if (position == width - 1) {
            return false;
        }
        return connections.get(position);
    }

    private boolean checkLeftConnection(final List<Boolean> connections, final int position) {
        if (position - 1 < 0) {
            return false;
        }
        return connections.get(position - 1);
    }

    private void decideMoving(final boolean isConnectedLeft, final boolean isConnectedRight, final User user) {
        if (!isConnectedLeft && !isConnectedRight) {
            return;
        }
        decideMovingLeftOrRight(isConnectedLeft, user);
    }

    private void decideMovingLeftOrRight(final boolean isConnectedLeft, final User user) {
        if (isConnectedLeft) {
            user.setPosition(user.getPosition() - 1);
            return;
        }
        user.setPosition(user.getPosition() + 1);
    }
}
