package com.test.steam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maybe
 * @date 2018/6/14
 */
@Controller
public class TemplatesController {
    @GetMapping("/templates")
    String test(HttpServletRequest request) {
        //逻辑处理
        request.setAttribute("key", "hello world");
        return "/index.html";
    }
}
