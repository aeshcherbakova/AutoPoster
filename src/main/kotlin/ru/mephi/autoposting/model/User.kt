package ru.mephi.autoposting.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("USERS")
data class User(

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) //- что-то подобное надо над сущностью в бд прописать
    val id: Long = 1,  // чекнуть увеличение айдишников автоматически
    val email: String = "example",
    val username: String = "example",
    val password: String = "example",
    // val passwordConfirm: String = "example",
    //val projects: List<Project> = emptyList()

)