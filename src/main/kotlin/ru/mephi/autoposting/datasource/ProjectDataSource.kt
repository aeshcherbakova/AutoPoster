package ru.mephi.autoposting.datasource

import ru.mephi.autoposting.model.Project
import ru.mephi.autoposting.model.User

interface ProjectDataSource {

    fun retrieveProjects(): Collection<Project>
    fun retrieveProjectById(id: Long): Project
    fun createProject(project: Project): Project
    fun updateProject(project: Project): Project
    fun deleteProject(project: Project)

}