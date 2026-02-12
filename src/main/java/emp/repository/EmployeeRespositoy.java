package emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import emp.entity.Employee;

public interface EmployeeRespositoy extends JpaRepository<Employee, Integer> {

}
