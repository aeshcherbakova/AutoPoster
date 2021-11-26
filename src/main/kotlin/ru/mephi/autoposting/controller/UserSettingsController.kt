package ru.mephi.autoposting.controller

import org.springframework.web.bind.annotation.*
import ru.mephi.autoposting.model.User
import ru.mephi.autoposting.service.UserService
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/api/settings")
class UserSettingsController(private val service: UserService) {

    @GetMapping
    fun getUser() : User {
        return User()
    }
    // TODO как достать инфу про текущего авторизованного юзера?

    @PostMapping
    fun changeInfo(user: User): String {
        return "Successful"
    }
    //TODO изменение пароля и емейла

}