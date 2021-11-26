package ru.mephi.autoposting.model

import java.time.LocalDateTime

abstract class Post {
    abstract val id: Long
    abstract val text: String // как хранить очень большие строки?
    abstract val date: LocalDateTime
}

// TODO уточнить, какие параметры у них различаются. Должно же что-то быть разное...

data class TelegramPost (
    override val id: Long,
    override val text: String,
    override val date: LocalDateTime
): Post()

data class VKPost (
    override val id: Long,
    override val text: String,
    override val date: LocalDateTime
): Post()

data class InstagramPost (
    override val id: Long,
    override val text: String,
    override val date: LocalDateTime
): Post()
