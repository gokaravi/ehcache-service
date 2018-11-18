package com.ravi.cache.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ravi.cache.service.UserService;
import com.ravi.dto.User;
import com.ravi.dto.Users;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Users getUsers(){
        LOG.info("Retrieving from service call....");
        User user1 = new User(1, "David", "Meyer");
        User user2 = new User(2, "Sunil", "Gavaskar");
        User user3 = new User(3, "Md.", "Azharuddin");
        User user4 = new User(4, "Aravinda", "De Silva");
        User user5 = new User(5, "Brian", "Lara");
        List<User> usersList = new ArrayList<>();
        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);
        usersList.add(user4);
        usersList.add(user5);
        Users users = new Users(usersList);
        return users;
    }
}
