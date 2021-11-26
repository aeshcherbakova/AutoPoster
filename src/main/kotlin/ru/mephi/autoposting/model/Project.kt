package ru.mephi.autoposting.model

data class Project (
    val id: Long,
    val name: String,
    val channels: Collection<Long>  // список айдишников каналов
)
