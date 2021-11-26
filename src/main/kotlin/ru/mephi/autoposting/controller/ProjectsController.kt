package ru.mephi.autoposting.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.mephi.autoposting.service.ProjectService


@RestController
@RequestMapping("/api/projects")
class ProjectsController(val service: ProjectService) {

    //@GetMapping
    //fun getProjects() =



}