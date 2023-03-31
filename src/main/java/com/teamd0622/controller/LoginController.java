package com.teamd0622.controller;

import com.teamd0622.model.dto.LoginState;
import com.teamd0622.model.entity.UserDetails;
import com.teamd0622.service.UserLoginService;
import com.teamd0622.util.MD5Util;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class LoginController {
    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        LoginState login_state = (LoginState) request.getSession().getAttribute("login_state");
        model.addAttribute("login_state", login_state);
        return "/index";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String loginIndex() {
        return "/login";
    }

    //username + password
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(@RequestParam(name = "username")String username, @RequestParam(name = "password")String password,
                        Model model, HttpServletRequest request) {
        // TODO: 31/03/2023 login authentication 
//        @Autowired
//        UserLoginService userLoginService;
//        //1.getPwdByUsername
//        //2.getPassword
//        UserDetails userDetails = userLoginService.getPwdByUsername(username);
//        String pwd = userLoginService.getPassword();
//        String password1 = MD5Util.md5Upper(password);
//        String password2 = MD5Util.md5Upper()
//        if (pwd.equals(password2)) {
//            model.addAttribute("user", user);
//            request.getSession().setAttribute("user", user);
//            return "redirect:/index";
//        } else {
//            return "users/failed";
//        }
        return "";
    }
}
