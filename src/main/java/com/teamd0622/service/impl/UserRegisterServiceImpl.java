package com.teamd0622.service.impl;

import com.teamd0622.mapper.UserDetailsMapper;
import com.teamd0622.model.entity.UserDetails;
import com.teamd0622.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {
    @Autowired
    UserDetailsMapper userDetailsMapper;
    @Override
    public int checkUsernameExist(String username) {
        return userDetailsMapper.usernameExist(username);
    }

    @Override
    public UserDetails createNewUserDetails(String username,Integer age,String email,String address,String user_password) {
        int msg = userDetailsMapper.addNewUser(username,age,email,address,user_password);
        return userDetailsMapper.getUserDetailsByUsername(username);
    }
}
