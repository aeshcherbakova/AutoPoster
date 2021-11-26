package ru.mephi.autoposting.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.mephi.autoposting.model.PasswordsForChanging
import ru.mephi.autoposting.model.User
import ru.mephi.autoposting.service.UserService
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/api/settings")
class UserSettingsController(private val service: UserService) {

    @GetMapping
    fun getUser(@RequestParam username: String) =
        service.loadUserByUsername(username)//?.let {
         //   ResponseEntity(it.id, HttpStatus.FOUND)
       // } ?: ResponseEntity.status(HttpStatus.NOT_FOUND).build()


    @PatchMapping
    fun updatePassword(@RequestParam username: String, @RequestBody passwords: PasswordsForChanging) =
        service.updatePassword(username, passwords)

    // TODO: сделать аналогично изменение юзернейма и почты

}
