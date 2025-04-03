package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentController(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public Student addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (student != null && course != null) {
            student.getCourses().add(course);
            return studentRepository.save(student);
        }
        return null;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }
}
