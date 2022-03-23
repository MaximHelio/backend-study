package com.example.demo.system

import com.example.stereotype.Controller
import com.example.web.bind.annotation.GetMapping

@Controller
class CrashController {

    @GetMapping("/oups")
    public String triggerException() {
        throw new RuntimeException(
                "Excepted: controller used to showcase what" + "happens when an exception is thrown"
        )
    }
}