package com.example.demo.services;

import com.example.demo.domain.User;
import com.example.demo.repositories.ToDoRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public boolean findUserByUsername(String userName) {
        boolean existingUser;
        if (userRepository.findByUsername(userName) != null) {
            existingUser = true;
            System.out.println("User existence: " + existingUser);
        } else {
            existingUser = false;
        }
        return existingUser;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

}
