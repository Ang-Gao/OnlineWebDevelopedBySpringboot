package com.teamd0622.test;

import com.teamd0622.entity.UserDetails;
import com.teamd0622.mapper.UserDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBTestingController {
    @Autowired

    UserDetailsMapper userDetailsMapper;

    @GetMapping("/test")
    public void test(){
        // 新增数据
        UserDetails user1 = new UserDetails();
        user1.setId(1);
        user1.setUsername("Jason");
        user1.setAge(22);
        user1.setEmail("example@mail.com");
        user1.setAddress("Dubai");
        user1.setUser_password("123456");

        int i1 = userDetailsMapper.addUserDetails(user1);
        System.out.println("ADD NEW DATA>>>" + i1);
        return ;
    }
}
