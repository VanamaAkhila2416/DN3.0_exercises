package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);

    List<Employee> findByDepartmentId(Long departmentId);

     List<Employee> findByNameStartingWith(String prefix);
 
     @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
        List<Employee> searchByNameLike(String name);

        @Query(name = "Employee.findByEmail")
        List<Employee> findEmployeesByEmail(String email);
        

    List<Employee> findByDepartmentName(@Param("departmentName") String departmentName);
     Page<Employee> findAll(Pageable pageable);
     List<Employee> findAll(Sort sort);
     Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);

    Page<Employee> findByName(String name,
            org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable pageable);

    Page<Employee> findByEmail(String email,
            org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable pageable);

    Page<Employee> findByDepartmentId(Long departmentId,
            org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable pageable);

}

