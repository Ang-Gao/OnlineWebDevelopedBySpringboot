package com.teamd0622.mapper;

import com.teamd0622.model.entity.UserDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// TODO: 09/03/2023 IF customer account(customer ID -> UserDetails ID) doesn't exist, cannot create User details.
@Mapper
public interface UserDetailsMapper {
    int addUserDetails(UserDetails userDetails);
    int updateUserDetails(UserDetails userDetails);
    int deleteUserDetailsById(Integer id);
    UserDetails getUserDetailsById(Integer id);
    List<UserDetails> getAllUsers();

    int usernameExist(String username);

    String getPwdByUsername(String username);

    UserDetails getUserDetailsByUsername(String username);

    int addNewUser(String username,Integer age,String email,String address,String user_password);
}
