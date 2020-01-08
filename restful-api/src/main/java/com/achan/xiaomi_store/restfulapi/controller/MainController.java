package com.achan.xiaomi_store.restfulapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Achan
 */
@Controller
public class MainController {

    @GetMapping("/")
    public String api() {
        return "redirect:/swagger-ui.html#/";
    }
}
