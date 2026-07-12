package repository.users;

import domain.users.User;
import domain.users.Users;

public class UserRepository {

    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(final Users users) {
        this.users = users;
    }

    public User findByName(final String userName) {
        return users.users().stream()
                .filter(user -> user.getName().equals(userName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("해당 유저를 찾을 수 없습니다!")); // 또는 예외를 던질 수 있습니다.
    }

}
