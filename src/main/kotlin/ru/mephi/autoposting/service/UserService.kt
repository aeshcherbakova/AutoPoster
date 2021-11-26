package ru.mephi.autoposting.service

//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import ru.mephi.autoposting.datasource.UserDataSource
import ru.mephi.autoposting.model.LoginCredentials
import ru.mephi.autoposting.model.PasswordsForChanging
import ru.mephi.autoposting.model.User


@Service
class UserService(private val dataSource: UserDataSource) {

    fun allUsers(): Collection<User> = dataSource.getUsers()

    fun createUser(user: User): User? = dataSource.createUser(user)

    // TODO: разобраться блин в каком месте должна быть логика и проверки - в котроллере/сервисе/датасорсе

    fun loadUserByUsername(username: String): User? =
        dataSource.getUserByUsername(username)

//    fun loadUserById(id: Long): User? =
//        dataSource.getUserById(id)

    fun getProjects(username: String): Collection<Long> =
        dataSource.getUserByUsername(username)?.projects
            ?: throw NoSuchElementException("Client with username $username does not exist")


    // TODO сделать хеширование через security
    // стырено с https://github.com/cvillaseca/mobileAPI/blob/master/src/main/kotlin/com/cvillaseca/mobileapi/service/UserService.kt
    fun updatePassword(username: String, passwords: PasswordsForChanging): Boolean {
        val user = dataSource.getUserByUsername(username)?.let {
            return if (passwords.oldPassword == it.getPassword() &&
                passwords.newPassword == passwords.newPasswordConfirm
            ) {
                it.setPassword(passwords.newPassword)
                // TODO: dataSource.updateUser(it) - разобраться, в каком класс должна быть логика
                true
            } else false
        }
        return false // TODO: вроде как на этом этапе юзер уже авторизован и всегда не ноль
    }

    fun login(credentials: LoginCredentials): User =
        dataSource.login(credentials)

    // TODO: сделать аналогичные формы для изменения юзернейма и почты

}