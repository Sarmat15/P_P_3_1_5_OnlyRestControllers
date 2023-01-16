package com.example.demo.DAO;

import com.example.demo.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    void removeUserById(int id);

    List<User> getAllUsers();

    User getUserById(int id);

    void updateUser(User user);

    User getUserByUsername(String username);
}
