package com.darsa.empservice.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeDao {

    @Autowired
    EmployeeRepository empRepo;

    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }
    public Employee getEmployeeById(int id) {
        return empRepo.getById(id);
    }

    public Employee persistEmployee(Employee employee) {
        empRepo.save(employee);
        return employee;
    }

    public void deleteEmployee(int id) {
        empRepo.delete(empRepo.getById(id));
    }
}
