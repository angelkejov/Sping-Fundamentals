package com.softuni.exam.service;


import com.softuni.exam.model.service.UserServiceModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}
