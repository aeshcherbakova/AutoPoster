package ru.mephi.autoposting.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.mephi.autoposting.service.UserService


@RestController
@RequestMapping("/api/test")
class TestUserController(val service: UserService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleNotFound(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping
    fun getAllUsers() = service.allUsers()

    @GetMapping("/projects")
    fun getProjects(@RequestParam username: String): Collection<Long> =
        service.getProjects(username)
        //service.loadUserByUsername(username)?.projects ?: emptyList()
    // изменить возвращаемое при нуле значение

    // TODO: разобраться, где кидать исключение, а где null
}