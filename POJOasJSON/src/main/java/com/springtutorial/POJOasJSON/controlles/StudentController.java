package com.springtutorial.POJOasJSON.controlles;

import com.springtutorial.POJOasJSON.models.StudentModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/students")
    public List<StudentModel> getStudents() {
        List<StudentModel> theStudents = new ArrayList<>();

        theStudents.add(new StudentModel("Tanase", "Alexandru"));
        theStudents.add(new StudentModel("Vlasceanu", "Daniel"));
        theStudents.add(new StudentModel("Paraschiv", "Roxana"));

        return theStudents;
    }
}
