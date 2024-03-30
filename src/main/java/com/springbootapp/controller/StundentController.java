package com.springbootapp.controller;

import com.springbootapp.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StundentController {

    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Ramesh", "Fadatare");
        return ResponseEntity.ok()
                .header("Custom-Header", "ramesh")
                .body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = List.of(
                new Student(1, "Ramesh", "Fadatare"),
                new Student(2, "Tony", "Stark"),
                new Student(3, "James", "Gosling")
        );
        return ResponseEntity.ok(students);
    }

    //Spring BOOT REST API with Path Variable
    @GetMapping("{id}/{firstName}/{lastName}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId
            , @PathVariable("firstName") String firstName
            , @PathVariable("lastName") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // http://localhost:8080/students/query?id=1&firstName=Ramesh&lastName=Fadatare
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id
            , @RequestParam String firstName
            , @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // http://localhost:8080/students/create
    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

  // spring boot REST API that handles HTTP PUT REQUEST - updating existing resource
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    // spring boot REST API that handles HTTP DELETE REQUEST - deleting existing resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        return ResponseEntity.ok("Student deleted successfully");
    }
}
