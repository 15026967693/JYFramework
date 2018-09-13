package com.jiayang.framework

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class MainApplication extends SpringBootServletInitializer {
     static main(args){
        SpringApplication.run(MainApplication.class)

    }
    @Override
     SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MainApplication.class)
    }
}
