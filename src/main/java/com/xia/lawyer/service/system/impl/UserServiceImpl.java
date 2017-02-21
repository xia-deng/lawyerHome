package com.xia.lawyer.service.system.impl;

import com.xia.lawyer.dao.system.UserDao;
import com.xia.lawyer.models.ResponseMsg;
import com.xia.lawyer.models.system.User;
import com.xia.lawyer.service.system.UserService;
import com.xia.lawyer.util.IteratorToList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by lindeng on 2/17/2017.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> find() {
        Iterator<User> userIterator= userDao.findAll().iterator();
       return this.iteratorToList(userIterator);
    }

    @Override
    public ResponseMsg<User> add(User user) {
        return null;
    }

    @Override
    public ResponseMsg<User> update(User user) {
        return null;
    }

    @Override
    public ResponseMsg<User> delete(Object id) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
