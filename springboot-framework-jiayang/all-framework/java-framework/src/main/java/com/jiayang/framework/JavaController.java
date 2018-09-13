package com.jiayang.framework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 贾洋
 * 测试的控制器
 */
@RestController
@RequestMapping("/java")
public class JavaController {

    @GetMapping("/index")
    public String  index(){
        return "hello,java";
    }
}
