package ru.mephi.autoposting.model

import java.time.LocalDateTime

abstract class Channel {
    abstract val id: Long
    abstract val token: String
}

data class TelegramChannel(
    override val id: Long,
    override val token: String,
    val url: String
): Channel()

data class VKChannel(
    override val id: Long,
    override val token: String,
    val userId: String,
    val setUpDate: LocalDateTime
    // TODO узнать, через какое время надо обновлять токен
): Channel()

data class InstagramChannel(
    override val id: Long,
    override val token: String,
    val setUpDate: LocalDateTime
    // TODO узнать, через какое время надо обновлять токен
): Channel()

