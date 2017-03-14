package com.pedroaugust8.usercrud;

import java.util.List;

/**
 * @author Pedro Barros
 */
public interface UserRepository {
    List<User> list();

    User get(String id);

    void save(User user);

    void delete(String id);
}
