package org.allen.dubbo.api;

import java.util.List;

public interface DubboDemoService {

    public String helloDubbo(String msg);

    public User getUserById(Long userId);

    public List<User> getUserByName(String username);

    public void createUser(User user) throws DemoException;
}
