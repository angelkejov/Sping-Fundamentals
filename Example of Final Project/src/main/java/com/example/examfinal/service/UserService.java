package com.example.examfinal.service;

import com.example.examfinal.model.service.UserRegistrationServiceModel;

public interface UserService {


    void initializeUsersAndRoles();

    void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);

    boolean isUserNameFree(String username);
}
