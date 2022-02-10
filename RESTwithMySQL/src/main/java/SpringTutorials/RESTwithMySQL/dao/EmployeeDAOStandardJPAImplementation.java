package SpringTutorials.RESTwithMySQL.dao;

import SpringTutorials.RESTwithMySQL.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

// !!! version 2 - standard JPA implementation !!!

@Repository
public class EmployeeDAOStandardJPAImplementation implements EmployeeDAO {

    public final EntityManager entityManager;

    @Autowired
    public EmployeeDAOStandardJPAImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

//        create query
        Query theQuery = entityManager.createQuery("from Employee");

//        execute query and get result list
        List<Employee> employees = theQuery.getResultList();

//        return result list
        return employees;
    }

    @Override
    public Employee findById(int employeeId) {

//        get employee
        Employee theEmployee = entityManager.find(Employee.class, employeeId);

//        return employee
        return theEmployee;
    }

    @Override
    public void save(Employee newEmployee) {

//        save or update the employee
        Employee theEmployee = entityManager.merge(newEmployee);

//        update with id from db - so we can get generated id for save/insert
        newEmployee.setId(theEmployee.getId());
    }

    @Override
    public void deleteById(int employeeId) {

//        delete object with primary key
        Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");

        theQuery.setParameter("employeeId", employeeId);

        theQuery.executeUpdate();
    }
}
