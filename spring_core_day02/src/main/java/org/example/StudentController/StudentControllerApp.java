package org.example.StudentController;

import jakarta.validation.Valid;
import org.example.Data.Student;
import org.example.dto.StudentRequestDTO;
import org.example.dto.StudentResponseDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@RestController

@RequestMapping("/students")
public class StudentControllerApp {

    private final StudentService service;

    public StudentControllerApp(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public Page<StudentResponseDTO> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size) {

        return service.getAll(PageRequest.of(page,size))
                .map(student -> new StudentResponseDTO(
                        student.getId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getEmail()
                ));
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
    public StudentResponseDTO create(@Valid @RequestBody StudentRequestDTO studentdto) {
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

    @PutMapping("/{id}")
    public StudentResponseDTO update(@PathVariable Long id, @RequestBody StudentRequestDTO studentdto) {
        Student student = new Student(
                studentdto.getFirstName(),
                studentdto.getLastName(),
                studentdto.getEmail()
        );

        Student savedStudent = service.update(id , student);

        return new StudentResponseDTO(
                savedStudent.getId(),
                savedStudent.getFirstName(),
                savedStudent.getLastName(),
                savedStudent.getEmail()
        );
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}