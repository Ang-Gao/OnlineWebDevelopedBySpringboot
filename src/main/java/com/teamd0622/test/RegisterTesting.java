package com.teamd0622.test;

import com.teamd0622.model.entity.UserDetails;
import com.teamd0622.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterTesting {
    @Autowired
    UserRegisterService userRegisterService;
    @GetMapping("/test/checkExistedUsername")
    public String testUsername(@RequestParam("username") String username){
        //1 existed -- uname
        int retval = userRegisterService.checkUsernameExist(username);
        return retval == 1 ? "Username Existed!" : "Success";
    }

    @PostMapping("/test/addNewUser")
    public String testAddNewUser(@RequestParam(name = "username")String username,
                                 @RequestParam(name = "age")Integer age,
                                 @RequestParam(name = "email")String email,
                                 @RequestParam(name = "address")String address,
                                 @RequestParam(name = "password")String password){
        UserDetails ud = userRegisterService.createNewUserDetails(username,age,email,address,password);
        return ud.toString();
    }
}
