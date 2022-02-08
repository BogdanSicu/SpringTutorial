package SpringTutorials.RESTwithMySQL.service;

import SpringTutorials.RESTwithMySQL.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int employeeId);

    public void save(Employee newEmployee);

    public void deleteById(int employeeId);
}
