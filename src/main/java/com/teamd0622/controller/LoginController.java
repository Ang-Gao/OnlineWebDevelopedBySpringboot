package com.teamd0622.controller;

import com.teamd0622.model.dto.LoginState;
import com.teamd0622.model.entity.UserDetails;
import com.teamd0622.service.UserLoginService;
import com.teamd0622.util.MD5Util;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class LoginController {
    @Autowired
    UserLoginService userLoginService;
    
    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        UserDetails ud = (UserDetails) request.getSession().getAttribute("ud");
        model.addAttribute("ud", ud);
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
        //1.getPwdByUsername
        //2.getPassword

        String pwd = userLoginService.getPwdByUsername(username);
        String password1 = MD5Util.md5Upper(password);
        String password2 = MD5Util.md5Upper(pwd);
        if (password1.equals(password2)) {
            UserDetails ud = userLoginService.getUserDetailsByUsername(username);
            model.addAttribute("ud", ud);
            request.getSession().setAttribute("ud", ud);
            return "redirect:/index";
        } else {
            return "/4xx";
        }
        
    }
    //// TODO: 03/04/2023 实现一个注册功能 
}
