package com.teamd0622.controller;

import com.teamd0622.model.entity.UserDetails;
import com.teamd0622.service.UserProfileService;
import com.teamd0622.service.impl.UserProfileServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

@Controller
public class UserProfileController {
    @Autowired
    UserProfileService userProfileService;

    @GetMapping("/profile/{id}")
    public String getProfile(@PathVariable Integer id, Model model){
        UserDetails userDetails = userProfileService.getUserProfile(id);
        model.addAttribute("user",userDetails);
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfileInfo(Integer id,String username,Integer age,String email,String address,String user_password){

        UserDetails userDetails_new = new UserDetails();
        userDetails_new.setId(id);
        userDetails_new.setUsername(username);
        userDetails_new.setAge(age);
        userDetails_new.setEmail(email);
        userDetails_new.setAddress(address);
        userDetails_new.setUser_password(user_password);
        userProfileService.updateUserProfile(userDetails_new);
        return "redirect:/profile/"+id;
    }
}
