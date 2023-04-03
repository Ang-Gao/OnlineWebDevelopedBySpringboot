package com.teamd0622.service.impl;

import com.teamd0622.mapper.UserDetailsMapper;
import com.teamd0622.model.entity.UserDetails;
import com.teamd0622.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    UserDetailsMapper userDetailsMapper;
    @Override
    public String getPwdByUsername(String username) {
        return userDetailsMapper.getPwdByUsername(username);
    }

    @Override
    public UserDetails getUserDetailsByUsername(String username) {
        return userDetailsMapper.getUserDetailsByUsername(username);
    }
}
