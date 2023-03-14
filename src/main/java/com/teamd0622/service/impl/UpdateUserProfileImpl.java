package com.teamd0622.service.impl;

import com.teamd0622.mapper.UserDetailsMapper;
import com.teamd0622.model.entity.UserDetails;
import com.teamd0622.service.UpdateUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserProfileImpl implements UpdateUserProfile {
    @Autowired
    UserDetailsMapper userDetailsMapper;

    @Override
    public Integer updateUserProfile(Integer id,UserDetails updateDetails) {
        Integer retval = userDetailsMapper.updateUserDetails(updateDetails);
        return retval;
    }
}
