package com.teamd0622.controller;

import com.teamd0622.model.entity.UserDetails;
import com.teamd0622.service.UserProfileService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.http.HttpRequest;

@Controller
public class UserProfileController {
    @Autowired
    UserProfileService userProfileService;

    @GetMapping("/profile")
    public String getProfile(HttpServletRequest request,Model model){
        Object ud = request.getSession().getAttribute("ud");
        model.addAttribute("ud",ud);
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfileInfo(Integer id,String username,Integer age,String email,String address,String user_password,Model model,HttpServletRequest request){
        // TODO: 27/03/2023 check username identity(only)  and age whether is number
        //true --> existed
        UserDetails userDetails_new = new UserDetails();
        UserDetails old = userProfileService.getUserProfile(id);
        System.out.println("id is "+id);
        if(userProfileService.usernameExist(username)){
            System.out.println("reached!");
            String username_callback = "Name existed!";
            model.addAttribute("username_callback",username_callback);
            model.addAttribute("user",old);
            System.out.println(username_callback);
            return "profile";
        }

        userDetails_new.setId(id);
        userDetails_new.setUsername(username);
        userDetails_new.setAge(age);
        userDetails_new.setEmail(email);
        userDetails_new.setAddress(address);
        userDetails_new.setUser_password(user_password);
        userProfileService.updateUserProfile(userDetails_new);
        model.addAttribute("user",userDetails_new);
        request.getSession().setAttribute("ud",userDetails_new);
        return "redirect:/profile";
    }

    //data = username
    @PostMapping("/check/username_exist")
    public boolean checkUsernameExist(String username){
        return userProfileService.usernameExist(username);
    }
}
