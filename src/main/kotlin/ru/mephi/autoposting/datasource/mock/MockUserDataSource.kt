package ru.mephi.autoposting.datasource.mock

//import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Repository
import ru.mephi.autoposting.controller.WrongAuthDataException
import ru.mephi.autoposting.datasource.UserDataSource
import ru.mephi.autoposting.model.LoginCredentials
import ru.mephi.autoposting.model.User

@Repository
class MockUserDataSource: UserDataSource {

    private val users = mutableListOf(
        User(1, "1@ya", "client1", "hash1", listOf(1, 2)),
        User(2, "2@ya", "client2", "hash2", listOf(3, 4, 5)),
        User(3, "3@ya", "client3", "hash3", listOf(2, 6)),
        User(4, "4@ya", "client4", "hash4", listOf(7))
    )

    override fun getUsers(): Collection<User> = users

//    override fun getUserById(id: Long): User? =
//        users.firstOrNull() { it.id == id }
//    //        ?: throw NoSuchElementException("Client with id $id does not exist")
//    // TODO переделать название исключение

    override fun getUserByUsername(username: String): User? =
        users.firstOrNull { it.getUsername() == username }
            //?: throw UsernameNotFoundException("Client with id $username does not exist")
            //?: throw NoSuchElementException("Client with username $username does not exist")

    override fun createUser(user: User): User? {
        if ( users.any { it.id == user.id })
//            return null
            throw IllegalArgumentException("Client with id ${user.id} already exists")
//        if (user.password != user.passwordConfirm)
//            throw IllegalArgumentException("Passwords don't match")
        // TODO найти более подходящее исключение
        // TODO выяснить, здесь ли вообще должны быть ифы или внутри контроллера?
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()))
        users.add(user)
        return user
    }

    // TODO: разобраться, нужна ли эта функция здесь и куда запихнуть логику...
    override fun updateUser(user: User): User? {
        val currentClient = users.firstOrNull { it.id == user.id }
            ?: //throw NoSuchElementException("Client with id ${user.id} does not exist")
            return null
        users.remove(currentClient)
        users.add(user)
        return user
    }

    override fun deleteUser(user: User): Boolean {
        val currentUser = users.firstOrNull { it.id == user.id }
            ?: //throw NoSuchElementException("Could not find a user with id ${user.id}")
            return false
        users.remove(currentUser)
        return true
    }

    override fun authUser(user: User): User =
        users.firstOrNull { it.getUsername() == user.getUsername() && it.getPassword() == user.getPassword() }
            ?: throw NoSuchElementException("Invalid username or password")

    override fun getProjects(user: User): Collection<Long> = user.projects

    override fun login(credentials: LoginCredentials): User =
        users.firstOrNull {
            it.getUsername() == credentials.username && it.getPassword() == credentials.password
        } ?: throw WrongAuthDataException("Wrong username of password")

        }