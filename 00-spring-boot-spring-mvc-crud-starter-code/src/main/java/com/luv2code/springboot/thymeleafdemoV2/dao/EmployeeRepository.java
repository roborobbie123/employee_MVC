package com.luv2code.springboot.thymeleafdemoV2.dao;

import com.luv2code.springboot.thymeleafdemoV2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    public List<Employee> findAllByOrderByLastNameAsc();

}
