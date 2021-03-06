package com.example.demo.repositories;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByPassword(String password);

    User findByUsernameAndPassword(String username,String password);
}
