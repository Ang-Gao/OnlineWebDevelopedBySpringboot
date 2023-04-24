package com.teamd0622.service.impl;

import com.teamd0622.mapper.UserDetailsMapper;
import com.teamd0622.model.entity.UserDetails;
import com.teamd0622.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    UserDetailsMapper userDetailsMapper;

    @Override
    public Integer updateUserProfile(UserDetails updateDetails) {
        Integer id = updateDetails.getId();
        String username = updateDetails.getUsername();

        return userDetailsMapper.updateUserDetails(updateDetails.getId(),updateDetails.getUsername(),updateDetails.getAge(),updateDetails.getEmail(),updateDetails.getAddress(),updateDetails.getUser_password());
    }

    @Override
    public UserDetails getUserProfile(Integer id) {
        return userDetailsMapper.getUserDetailsById(id);
    }

    @Override
    public boolean usernameExist(String username) {
        try{
            int callback = userDetailsMapper.usernameExist(username);
            return callback == 1 ;
        }catch (Exception ex){
            return false;
        }
        
    }
}
