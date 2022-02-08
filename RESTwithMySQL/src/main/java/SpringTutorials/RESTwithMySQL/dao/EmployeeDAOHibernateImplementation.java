package SpringTutorials.RESTwithMySQL.dao;

import SpringTutorials.RESTwithMySQL.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

//    !!! Native hibernate Query solution !!!

@Repository
public class EmployeeDAOHibernateImplementation implements EmployeeDAO{

//    define field for entity manager

    private EntityManager entityManager;

//    set up constructor injection

    @Autowired
    public EmployeeDAOHibernateImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

//        get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

//        create a query
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

//        execute query and get result list
        List<Employee> employees = theQuery.getResultList();

//        return results
        return employees;
    }

    @Override
    public Employee findById(int employeeId) {

//        get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

//        get the employee
        Employee employee = currentSession.get(Employee.class, employeeId);

//        return the employee
        return employee;
    }

    @Override
    public void save(Employee newEmployee) {

//        get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

//        save employee
        currentSession.saveOrUpdate(newEmployee);
    }

    @Override
    public void deleteById(int employeeId) {

//        get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

//        delete employee with primary key
        Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", employeeId);
        theQuery.executeUpdate();
    }
}
