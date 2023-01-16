package com.example.demo.services;

import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService extends UserDetailsService {
    public List<User> getAllUsers();

    public void createNewUser(User user);

    public User getUser(int id);

    public void updateUser(User user);

    public void deleteUser(int id);

    public User findUserByUsername(String username);
}
