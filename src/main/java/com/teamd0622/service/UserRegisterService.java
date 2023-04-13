package com.teamd0622.service;

import com.teamd0622.model.entity.UserDetails;

public interface UserRegisterService {
    int checkUsernameExist(String username);
    UserDetails createNewUserDetails(String username,Integer age,String email,String address,String user_password);
}
