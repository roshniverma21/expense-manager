package com.example.springboot.expensetracker.service;

import com.example.springboot.expensetracker.entity.User;
import com.example.springboot.expensetracker.entity.UserModel;

public interface UserService {
    User create(UserModel userModel);
}
