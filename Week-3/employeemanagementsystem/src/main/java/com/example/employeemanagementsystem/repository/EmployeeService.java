package com.example.employeemanagementsystem.repository;

import java.util.List;
import com.example.employeemanagementsystem.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
	@Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void batchInsert(List<Employee> employees) {
        int batchSize = 50;
        for (int i = 0; i < employees.size(); i++) {
            employeeRepository.save(employees.get(i));
            if (i % batchSize == 0 && i > 0) {
                employeeRepository.flush(); 
            }
        }
    }	
}