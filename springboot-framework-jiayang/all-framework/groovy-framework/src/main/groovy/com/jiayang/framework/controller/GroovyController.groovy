package com.jiayang.framework.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author 贾洋
 * groovy测试控制器
 *
 */
@RestController
@RequestMapping("/groovy")
class GroovyController
{
    @GetMapping("/index")
    def index(){

        "hello,groovy"
    }

}