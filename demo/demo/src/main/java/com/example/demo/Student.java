package com.example.demo;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "student_course", // Join Table Name
            joinColumns = @JoinColumn(name = "student_id"), // Foreign Key to Student
            inverseJoinColumns = @JoinColumn(name = "course_id") // Foreign Key to Course
    )
    private Set<Course> courses;

    // Constructors, Getters, Setters
    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
