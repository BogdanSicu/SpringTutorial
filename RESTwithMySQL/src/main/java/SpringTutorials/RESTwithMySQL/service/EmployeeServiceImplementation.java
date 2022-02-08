package SpringTutorials.RESTwithMySQL.service;

import SpringTutorials.RESTwithMySQL.dao.EmployeeDAO;
import SpringTutorials.RESTwithMySQL.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

    public final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImplementation(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int employeeId) {
        return employeeDAO.findById(employeeId);
    }

    @Override
    @Transactional
    public void save(Employee newEmployee) {
        employeeDAO.save(newEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int employeeId) {
        employeeDAO.deleteById(employeeId);
    }
}
