package ru.mephi.autoposting.service

import org.springframework.stereotype.Service
import ru.mephi.autoposting.datasource.ProjectDataSource
import ru.mephi.autoposting.datasource.UserDataSource


@Service
class ProjectService(private val dataSource: ProjectDataSource) {
}