package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @PostMapping
    public Project addProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    //task search

    @GetMapping("/search")
    public List<Project> searchProjectsByDescription(@RequestParam String keyword) {
        return projectRepository.findByDescriptionContainingIgnoreCase(keyword);
    }


}
