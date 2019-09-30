package com.org.lambda.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
@Component
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee findByAadharNumber(long aadharNumber);

//	void deleteByAadharNumber(long aadharNumber);
	
//	@Query("delete from employee where aadharNumber = ?1")
//	void deleteByAadharNumber(long aadharNumber);
}
