package com.teamd0622.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DBTestingController {
    @GetMapping("/events")
    public String testPage(){
        return "events";
    }
}
