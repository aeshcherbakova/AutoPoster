package ru.mephi.autoposting.datasource.mock

import org.springframework.stereotype.Repository
import ru.mephi.autoposting.datasource.ProjectDataSource
import ru.mephi.autoposting.model.InstagramChannel
import ru.mephi.autoposting.model.Project
import ru.mephi.autoposting.model.TelegramChannel
import ru.mephi.autoposting.model.VKChannel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Repository
class MockProjectDataSource : ProjectDataSource {

    private val projects = mutableListOf(
        Project(1, "proj1", listOf(1, 3)),
        Project(2, "proj2", listOf()),
        Project(3, "proj3", listOf(2, 3)),
        Project(4, "proj4", listOf(4))
    )

    private val channels = mutableListOf(
        TelegramChannel(1, "token1", "url1"),
        VKChannel(2, "token2", "userid2", LocalDateTime.now()),
        TelegramChannel(3, "token3", "url3"),
        TelegramChannel(4, "token4", "url4"),
        VKChannel(5, "token5", "userid5", LocalDateTime.now()),
        InstagramChannel(6, "token6", LocalDateTime.now()),
        InstagramChannel(7, "token7", LocalDateTime.now())
    )

    override fun retrieveProjectsId(): Collection<Long> {
        TODO("Not yet implemented")
    }

    override fun retrieveProjects(): Collection<Project> = projects

    override fun retrieveProjectById(id: Long): Project =
        projects.firstOrNull() { it.id == id }
            ?: throw NoSuchElementException("Project with id $id does not exist")

    override fun createProject(project: Project): Project {
        if (projects.any { it.id == project.id })
            throw IllegalArgumentException("Project with id ${project.id} already exists")
        projects.add(project)
        return project
    }

    override fun updateProject(project: Project): Project {
        val currentClient = projects.firstOrNull { it.id == project.id }
            ?: throw NoSuchElementException("Project with id ${project.id} does not exist")
        projects.remove(currentClient)
        return project
    }

    override fun deleteProject(project: Project) {
        val currentUser = projects.firstOrNull { it.id == project.id }
            ?: throw NoSuchElementException("Could not find a project with id ${project.id}")
        projects.remove(currentUser)    }
}