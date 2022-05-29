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

    /*the method checks for the presence of a user by name in the repository,
    if there is no user in the database - it returns false, if a user with the same name exists - true*/
    public boolean findUserByUsername(String userName) {
        boolean existingUser;
        if (userRepository.findByUsername(userName) != null) {
            existingUser = true;
        } else {
            existingUser = false;
        }
        return existingUser;
    }

    /*the method searches for a user by a unique id*/
    public boolean findUserById(User user) {
        boolean existingUser;
        if (userRepository.existsById(user.getId())) {
            existingUser = true;
            System.out.println("This user is present: " + existingUser);
        } else {
            existingUser = false;
            System.out.println("This user is missing: " + existingUser);
        }
        return existingUser;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }


}
