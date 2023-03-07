package com.teamd0622.mapper;

import com.teamd0622.entity.UserDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDetailsMapper {
    int addUserDetails(UserDetails userDetails);
    int updateUserDetails(UserDetails userDetails);
    int deleteUserDetailsById(Integer id);
    UserDetails getUserDetailsById(Integer id);
    List<UserDetails> getAllUsers();
}
