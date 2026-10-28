package org.example.StudentController;

import org.example.Data.Student;
import org.example.dto.StudentRequestDTO;
import org.example.dto.StudentResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/students")
public class StudentControllerApp {

    private final StudentService service;

    public StudentControllerApp(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<StudentResponseDTO> findAll() {
        return service.getAll()
                .stream()
                .map(student -> new StudentResponseDTO(
                        student.getId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getEmail())).toList();
    }

    @GetMapping("/{id}")
    public StudentResponseDTO findById(@PathVariable Long id) {

        Student student = service.getById(id);
        return new StudentResponseDTO(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    @PostMapping
    public StudentResponseDTO create(@RequestBody StudentRequestDTO studentdto) {
        Student student = new Student(
                studentdto.getFirstName(),
                studentdto.getLastName(),
                studentdto.getEmail()
        );

        Student savedStudent = service.create(student);

        return new StudentResponseDTO(
                savedStudent.getId(),
                savedStudent.getFirstName(),
                savedStudent.getLastName(),
                savedStudent.getEmail()
        );
    }
}