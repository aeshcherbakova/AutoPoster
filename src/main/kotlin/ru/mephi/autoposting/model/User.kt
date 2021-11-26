package ru.mephi.autoposting.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
//import org.springframework.security.core.GrantedAuthority
//import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.Entity

//@Entity
//@Table("USERS")
data class User(
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO) //- что-то подобное надо над сущностью в бд прописать
    val id: Long = 1,  // чекнуть увеличение айдишников автоматически
    private var email: String = "example",
    private var username: String = "example",
    private var password: String = "example",
    // val passwordConfirm: String = "example", - надо это в другую структуру запихнуть
    val projects: List<Long> = emptyList() //- точно это тут должно храниться? long - это айдишники проектов

) {

    fun getEmail() = email
    fun getUsername() = username
    fun getPassword() = password

    fun setEmail(email: String) {
        this.email = email
    }

    fun setUsername(username: String) {
        this.username = username
    }

    fun setPassword(password: String) {
        this.password = password
    }

}


data class PasswordsForChanging(
    val oldPassword: String,
    val newPassword: String,
    val newPasswordConfirm: String,
)

data class LoginCredentials(
    val username: String,
    val password: String
)

// TODO переделать все с security:
//  https://github.com/cvillaseca/mobileAPI/blob/master/src/main/kotlin/com/cvillaseca/mobileapi/model/User.kt