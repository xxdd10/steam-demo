package com.xxdd.steam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Leo.Xu on 2018/6/14.
 */
@Controller
public class HtmlController {

    @GetMapping("/html")
    public String html(){
        return "/index.html";
    }
}


