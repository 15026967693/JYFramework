package com.jiayang.framework.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kotlin")
class KotlinController {
    @GetMapping("/index")
    fun index():String {

        return "hello,kotlin"
    }
}