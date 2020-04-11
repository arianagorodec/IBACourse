package com.gorodeckaya.service;

import com.gorodeckaya.entity.User;


public interface UserService {
        User addUser(User user);

        void deleteById(long id);

        User getByUsername(String username);

        User editUser(User user);

        //List<User> getAll();
}
