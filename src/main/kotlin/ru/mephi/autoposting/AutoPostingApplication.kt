package ru.mephi.autoposting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication
//@EnableWebSecurity
class AutoPostingApplication

fun main(args: Array<String>) {
    runApplication<AutoPostingApplication>(*args)
}
