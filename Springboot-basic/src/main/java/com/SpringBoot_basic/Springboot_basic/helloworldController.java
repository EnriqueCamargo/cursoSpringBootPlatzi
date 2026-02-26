package com.SpringBoot_basic.Springboot_basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworldController {
    @GetMapping("/")
    public String helloworld(){
        return "hello world";
    }
}
