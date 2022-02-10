package SpringTutorials.RESTwithMySQL.service;

import SpringTutorials.RESTwithMySQL.dao.EmployeeDAO;
import SpringTutorials.RESTwithMySQL.dao.EmployeeRepositorySpringDataJPA;
import SpringTutorials.RESTwithMySQL.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

//    public final EmployeeDAO employeeDAO; -> this is for when we are using the other 2 variants,
//                                              hibernate and standard JPA
//
//    choose which repository with @Qualifier
//    @Autowired
//    public EmployeeServiceImplementation(@Qualifier("employeeDAOJpaImplementation") EmployeeDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
//    }

    public final EmployeeRepositorySpringDataJPA employeeRepositorySpringDataJPA;

    @Autowired
    public EmployeeServiceImplementation(EmployeeRepositorySpringDataJPA employeeRepositorySpringDataJPA) {
        this.employeeRepositorySpringDataJPA = employeeRepositorySpringDataJPA;
    }

    @Override
//    @Transactional -> this is for when we are using the other 2 variants, hibernate and standard JPA
    public List<Employee> findAll() {
        return employeeRepositorySpringDataJPA.findAll();
    }

    @Override
//    @Transactional
    public Employee findById(int employeeId) {
        Optional<Employee> result = employeeRepositorySpringDataJPA.findById(employeeId);

        Employee theEmployee = null;

        if(result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Did not find the employee id - "+employeeId);
        }

        return theEmployee;
    }

    @Override
//    @Transactional
    public void save(Employee newEmployee) {
        employeeRepositorySpringDataJPA.save(newEmployee);
    }

    @Override
//    @Transactional
    public void deleteById(int employeeId) {
        employeeRepositorySpringDataJPA.deleteById(employeeId);
    }
}
