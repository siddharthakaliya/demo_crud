package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
//@Autowired
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

// Save
    public User saveUser(User user){
    return userRepository.save(user);
    }

    //Get
  public List<User> getAllUsers(){
        return userRepository.findAll();

  }

}
