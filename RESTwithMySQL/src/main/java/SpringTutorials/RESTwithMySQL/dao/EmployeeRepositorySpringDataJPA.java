package SpringTutorials.RESTwithMySQL.dao;

import SpringTutorials.RESTwithMySQL.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositorySpringDataJPA extends JpaRepository<Employee, Integer> {
}
