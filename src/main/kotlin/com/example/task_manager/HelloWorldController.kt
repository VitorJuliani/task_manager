package com.example.task_manager

import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class HelloWorldController {

    @GetMapping
    fun hello(authentication: Authentication): String {
        return "Olá, agora vc tem acesso"
    }
}