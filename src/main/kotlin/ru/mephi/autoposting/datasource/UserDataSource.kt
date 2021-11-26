package ru.mephi.autoposting.datasource

import ru.mephi.autoposting.model.User

interface UserDataSource {

    fun retrieveUsers(): Collection<User>
    fun retrieveUserById(id: Long): User
    fun retrieveUserByUsername(username: String): User
    fun createUser(user: User): User
    fun updateUser(user: User): User
    fun deleteUser(user: User)
    fun authUser(user: User): User

}