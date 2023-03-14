package com.teamd0622.service;

import com.teamd0622.model.entity.UserDetails;

public interface UpdateUserProfile {
    Integer updateUserProfile(Integer id, UserDetails updateDetails);
}
