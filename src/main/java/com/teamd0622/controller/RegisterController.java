package com.teamd0622.controller;

import com.teamd0622.model.entity.UserDetails;
import com.teamd0622.service.UserRegisterService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired
    UserRegisterService userRegisterService;

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    //id 自动生成
    @PostMapping("/register")
    public String register(@RequestParam(name = "username")String username,
                           @RequestParam(name = "age")Integer age,
                           @RequestParam(name = "email")String email,
                           @RequestParam(name = "address")String address,
                           @RequestParam(name = "user_password")String password,
                           Model model, HttpServletRequest request){
        //register logic
        //if username existed, return ""username existed"" to thymeleaf 回显区域（在username input下面多一行提示）
        Integer check = userRegisterService.checkUsernameExist(username);

        if (check != null){
            //String pagecallback = (String) model.getAttribute("pagecallback");

            String pagecallback = "Username existed";
            model.addAttribute("pagecallback",pagecallback);
            return "/register";
        }
        //success and judge input
        if(username == null || age == null || email == null || address == null || password == null){
            //String pagecallback = (String) model.getAttribute("pagecallback");
            //System.out.println(pagecallback);
            String pagecallback = "You CANNOT register with EMPTY ROW(S)";
            model.addAttribute("pagecallback",pagecallback);
            //request.getSession().setAttribute("pagecallback", pagecallback);
            return "/register";
        }
        //id 处理问题
        UserDetails current_user = userRegisterService.createNewUserDetails(username,age,email,address,password);
        model.addAttribute("ud", current_user);
        request.getSession().setAttribute("ud", current_user);
        return "redirect:/index";
    }
}
