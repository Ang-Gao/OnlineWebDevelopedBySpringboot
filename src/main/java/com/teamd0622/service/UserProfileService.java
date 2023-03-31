package com.teamd0622.service;

import com.teamd0622.model.entity.UserDetails;

public interface UserProfileService {
    Integer updateUserProfile(UserDetails updateDetails);
    UserDetails getUserProfile(Integer id);
    boolean usernameExist(String username);
}
