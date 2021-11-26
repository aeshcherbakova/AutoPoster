package ru.mephi.autoposting.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.mephi.autoposting.model.LoginCredentials
import ru.mephi.autoposting.model.User
import ru.mephi.autoposting.service.UserService

class WrongAuthDataException(message: String): IllegalArgumentException(message)


@RestController
@RequestMapping("/api/auth")
class AuthController(val service: UserService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleNotFound(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.CONFLICT)

    @ExceptionHandler(WrongAuthDataException::class)
    fun handleNotFound(e: WrongAuthDataException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.UNAUTHORIZED)

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    fun signup(@RequestBody user: User) =
        service.createUser(user)//?.let {
       //     ResponseEntity(it.id, HttpStatus.CREATED)
       // } ?: ResponseEntity.status(HttpStatus.CONFLICT).build()

    @GetMapping
    fun registration() = "hello world"

    @PostMapping
    fun login(@RequestBody credentials: LoginCredentials) =
        service.login(credentials)


//    @GetMapping
//    fun registration(): User = User()

//    @GetMapping("/welcome")
//    fun welcome() = "Welcome! You passed the spring security"

}