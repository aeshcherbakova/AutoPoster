package ru.mephi.autoposting.datasource

import ru.mephi.autoposting.model.LoginCredentials
import ru.mephi.autoposting.model.User

interface UserDataSource {

    fun getUsers(): Collection<User>
    //fun getUserById(id: Long): User?
    fun getUserByUsername(username: String): User?
    fun createUser(user: User): User?
    fun updateUser(user: User): User?
    fun deleteUser(user: User): Boolean
    fun authUser(user: User): User
    fun getProjects(user: User): Collection<Long>
    fun login(credentials: LoginCredentials): User

}