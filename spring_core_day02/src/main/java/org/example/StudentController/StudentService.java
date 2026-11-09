package org.example.StudentController;

import org.example.Data.Student;
import org.example.Repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student findByFirstName(String firstName) {
        return repo.findFirstByFirstName(firstName);
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found: " + id));
    }

    public Student create(Student student) {
        return repo.save(student);
    }

    public  Student update(Long id ,Student student) {
        Student savedStudent = getById(id);
        savedStudent.setFirstName(student.getFirstName());
        savedStudent.setLastName(student.getLastName());
        savedStudent.setEmail(student.getEmail());

        return repo.save(savedStudent);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}