package ru.mephi.autoposting.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.mephi.autoposting.service.UserService


@RestController
@RequestMapping("/api/test")
class TestUserController(val service: UserService) {

    @GetMapping
    fun getAllUsers() = service.allUsers()

}