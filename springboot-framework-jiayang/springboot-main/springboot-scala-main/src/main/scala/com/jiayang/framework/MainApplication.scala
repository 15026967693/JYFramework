package com.jiayang.framework

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class MainApplication extends SpringBootServletInitializer{

   import org.springframework.boot.builder.SpringApplicationBuilder

   override  def configure(builder: SpringApplicationBuilder): SpringApplicationBuilder = {
      builder.sources(classOf[Nothing])
   }

}
object MainApplication extends App {
   SpringApplication.run(classOf[MainApplication])


}
