package com.test.steam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Maybe on 2018/6/14.
 */
@Controller
public class HtmlController {

    @GetMapping("/html")
    public String html(){
        return "/index.html";
    }
}


