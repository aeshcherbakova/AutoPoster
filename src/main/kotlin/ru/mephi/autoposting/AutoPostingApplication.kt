package ru.mephi.autoposting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AutoPostingApplication

fun main(args: Array<String>) {
    runApplication<AutoPostingApplication>(*args)
}
