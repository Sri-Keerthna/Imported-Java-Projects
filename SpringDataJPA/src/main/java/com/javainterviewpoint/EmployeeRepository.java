package com.javainterviewpoint;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;


public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{

	@Query("select e from Employee e join fetch e.employeeAddress ea where ea.country=:country")
	List<Employee> findEmpByCountry(@Param ("country") String country);
	
	@Query("select e from Employee e join fetch e.employeeAddress ea where ea.state=?1 order by ?2")
	List<Employee> findEmpByCountryandstate(String country,String state);
}
