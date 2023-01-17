package com.example.demo.services;

import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService extends UserDetailsService {
    public List<User> getAllUsers();

     void createNewUser(User user);

     User getUser(int id);

     void updateUser(User user);

     void deleteUser(int id);

     User findUserByUsername(String username);
}
