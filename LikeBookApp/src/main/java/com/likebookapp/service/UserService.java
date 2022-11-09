package com.likebookapp.service;

import com.likebookapp.model.entity.service.UserServiceModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);
}
