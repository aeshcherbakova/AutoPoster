package ru.mephi.autoposting.model

abstract class Post {
    abstract val id: Long
    abstract val text: String // как хранить очень большие строки?
    abstract val date: String // прикрутить либу с датами
}

// TODO уточнить, какие параметры у них различаются. Должно же что-то быть разное...

data class TelegramPost (
    override val id: Long,
    override val text: String,
    override val date: String
): Post()

data class VKPost (
    override val id: Long,
    override val text: String,
    override val date: String
): Post()

data class InstagramPost (
    override val id: Long,
    override val text: String,
    override val date: String
): Post()
