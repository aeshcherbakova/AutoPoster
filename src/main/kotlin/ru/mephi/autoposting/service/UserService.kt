package ru.mephi.autoposting.service

import org.springframework.stereotype.Service
import ru.mephi.autoposting.model.User
import ru.mephi.autoposting.repository.UserRepository

@Service
class UserService(val db: UserRepository) {

    fun allUsers(): Collection<User> = db.findUsers()

    fun createUser(user: User) = db.save(user)

}