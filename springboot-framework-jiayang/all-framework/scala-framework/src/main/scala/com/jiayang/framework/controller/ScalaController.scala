package com.jiayang.framework.controller

import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

/**
  * @author 贾洋
  * scala测试控制器
  *
  */
@RestController
@RequestMapping(Array("/scala"))
class ScalaController {
  @GetMapping(Array("/index"))
  def index: String = {
    "hello,scala"
  }
}
