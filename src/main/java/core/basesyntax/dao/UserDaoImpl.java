package core.basesyntax.dao;

import core.basesyntax.db.UsersStorage;
import core.basesyntax.model.User;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        UsersStorage.users.add(user);
    }

    @Override
    public List<User> getAll() {
        return UsersStorage.users;
    }
}
