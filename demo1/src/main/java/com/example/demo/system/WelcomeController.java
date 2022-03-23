package com.example.demo.system

import com.example.stereotype.Controller
import com.example.web.bind.annotation.GetMapping


@Controller
class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "welcome"
    }
}