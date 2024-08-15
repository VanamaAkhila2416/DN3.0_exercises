package com.example.employeemanagementsystem.repository;


import com.example.employeemanagementsystem.model.Department;
import java.util.List;
import com.example.employeemanagementsystem.projection.DepartmentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByName(String name);
    List<DepartmentProjection> findByName1(String name);
    
@Query("SELECT d FROM Department d WHERE d.name LIKE %:name%")
Department searchByNameLike(String name);


}