package SpringTutorials.RESTwithMySQL.controller;

import SpringTutorials.RESTwithMySQL.dao.EmployeeDAO;
import SpringTutorials.RESTwithMySQL.entity.Employee;
import SpringTutorials.RESTwithMySQL.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

//    inject employeeService

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //    expose /employees and return list of employees

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null) {
            throw new RuntimeException("Employee id not found - "+employeeId);
        }

        return theEmployee;
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null) {
            throw new RuntimeException("Employee id not found - "+employeeId);
        }

        employeeService.deleteById(employeeId);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee newEmployee) {

        if(newEmployee == null) {
            throw new RuntimeException("Employee fields are not complete");
        }

        newEmployee.setId(0);

        employeeService.save(newEmployee);

        return newEmployee;
    }

    @PutMapping()
    public Employee updateEmployee(@RequestBody Employee updatedEmployee) {

        employeeService.save(updatedEmployee);

        return updatedEmployee;
    }

}
