package com.example.springboot.expensetracker.service;

import com.example.springboot.expensetracker.entity.User;
import com.example.springboot.expensetracker.entity.UserModel;
import com.example.springboot.expensetracker.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    //this will create a copy of userModel in user and will save it in repository
    @Override
    public User create(UserModel userModel){
        User user = new User();
        BeanUtils.copyProperties(userModel, user);
        return userRepository.save(user);
    }
}
