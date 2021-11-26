package ru.mephi.autoposting.repository

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import ru.mephi.autoposting.model.User

interface UserRepository : CrudRepository<User, String> {

    @Query("select * from users")
    fun findUsers(): Collection<User>

}
