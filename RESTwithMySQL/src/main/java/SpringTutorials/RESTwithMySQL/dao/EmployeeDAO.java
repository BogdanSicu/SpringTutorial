package SpringTutorials.RESTwithMySQL.dao;

import SpringTutorials.RESTwithMySQL.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int employeeId);

    public void save(Employee newEmployee);

    public void deleteById(int employeeId);
}
