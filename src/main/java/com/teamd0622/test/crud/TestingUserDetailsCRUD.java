package com.teamd0622.test.crud;

import com.teamd0622.entity.UserDetails;
import com.teamd0622.mapper.UserDetailsMapper;
import com.teamd0622.util.RandomGenerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestingUserDetailsCRUD {
    @Autowired
    UserDetailsMapper userDetailsMapper;
    RandomGenerated rg = new RandomGenerated();
    //create New user info randomly.
    public UserDetails createNewUserInfo(){
        UserDetails user = new UserDetails();
        user.setId(1);
        user.setUsername(rg.randomString(10));
        user.setAge(1);
        user.setEmail(rg.randomEmailAddress());
        user.setAddress(rg.randomString(10));
        user.setUser_password(rg.randomString(10));
        return user;
    }

    @GetMapping("/test/addUserDetailsTesting")
    public String addUserDetailsTesting(){
        int msg = userDetailsMapper.addUserDetails(createNewUserInfo());
        System.out.println("ADD NEW DATA>>>" + msg);
        return "\"ADD NEW DATA>>>\"";
    }

    @PostMapping("/test/updateUserDetailsTesting")
    public String updateUserDetailsTesting(){
        int msg = userDetailsMapper.updateUserDetails(createNewUserInfo());
        System.out.println("UPDATE NEW DATA>>>" + msg);
        return "\"UPDATE NEW DATA>>>\"";
    }

    @DeleteMapping("/test/deleteUserDetailsByIdTesting/{id}")
    public String deleteUserDetailsByIdTesting(@PathVariable Integer id){
        userDetailsMapper.deleteUserDetailsById(id);
        return "DELETE";
    }

    @GetMapping("/test/getUserDetailsByIdTesting/{id}")
    public String getUserDetailsByIdTesting(@PathVariable Integer id){
        System.out.println(userDetailsMapper.getUserDetailsById(id));
        return "GET USER";
    }

    @GetMapping("/test/getUserDetailsByIdTesting")
    public String getAllUsersTesting(){
        List<UserDetails> list = new ArrayList<>();
        list = userDetailsMapper.getAllUsers();
        for (UserDetails user : list){
            System.out.println(user);
        }
        return "GET ALL USERS";
    }
}
