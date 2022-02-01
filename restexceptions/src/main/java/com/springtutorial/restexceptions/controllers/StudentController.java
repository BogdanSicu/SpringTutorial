package com.springtutorial.restexceptions.controllers;

import com.springtutorial.restexceptions.responses.StudentErrorResponse;
import com.springtutorial.restexceptions.exceptions.StudentNotFoundException;
import com.springtutorial.restexceptions.models.StudentModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    List<StudentModel> theStudents = new ArrayList<>();

    public StudentController() {
        theStudents.add(new StudentModel("Papuc", "Alex"));
        theStudents.add(new StudentModel("Petrache", "Ionita"));
        theStudents.add(new StudentModel("Paraschiv", "Alexia"));
    }

    @GetMapping("/{studentId}")
    public StudentModel getStudent(@PathVariable int studentId){
        if(theStudents != null && theStudents.size() > studentId && studentId >= 0) {
            return theStudents.get(studentId);
        } else {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
    }

//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exception.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exception.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
}
