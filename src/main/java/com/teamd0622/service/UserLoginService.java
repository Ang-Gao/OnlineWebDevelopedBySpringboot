package com.teamd0622.service;

import com.teamd0622.model.entity.UserDetails;

public interface UserLoginService {
    String getPwdByUsername(String username);
    UserDetails getUserDetailsByUsername(String username);
}
