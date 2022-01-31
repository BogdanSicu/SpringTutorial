package com.springtutorial.pathvariables.controllers;

import com.springtutorial.pathvariables.models.StudentModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    List<StudentModel> theStudents = new ArrayList<>();

    public StudentController() {
        theStudents.add(new StudentModel("Papuc", "Alex"));
        theStudents.add(new StudentModel("Petrache", "Ionita"));
        theStudents.add(new StudentModel("Paraschiv", "Alexia"));
    }

    @GetMapping("/{studentId}")
    public StudentModel getStudent(@PathVariable int studentId){
        try {
            return theStudents.get(studentId);
        } catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
    }

}
