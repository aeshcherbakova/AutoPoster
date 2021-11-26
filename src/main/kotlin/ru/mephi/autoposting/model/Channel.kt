package ru.mephi.autoposting.model

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
    val setUpDate: String
    // TODO: прикрутить либу для работы с датами
): Channel()

data class InstagramChannel(
    override val id: Long,
    override val token: String,
    val setUpDate: String
    // TODO: прикрутить либу для работы с датами
): Channel()

