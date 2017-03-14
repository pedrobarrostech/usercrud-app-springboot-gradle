package com.pedroaugust8.usercrud;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Pedro Barros
 */
@Repository
public class UserRepositorySpringData implements UserRepository {

    private final UserDaoMongo dao;

    @Autowired
    public UserRepositorySpringData(final UserDaoMongo dao) {
        this.dao = dao;
    }

    @Override
    public List<User> list() {
        return dao.findAll();
    }

    @Override
    public User get(String id) {
        return dao.findOne(id);
    }

    @Override
    public void save(User user) {
        dao.save(user);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }
}