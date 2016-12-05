package org.allen.dubbox;

import org.allen.dubbox.api.User;
import org.allen.dubbox.api.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User getUser(Long id) {
        return new User(id, "username" + id);
    }
}
