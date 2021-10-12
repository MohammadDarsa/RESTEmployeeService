package com.darsa.empservice.model;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeDao {

    static List<Employee> list = new ArrayList<>();
    static {
        list.add(new Employee(0, "mohamad", "mhmd@gmail.com"));
        list.add(new Employee(1, "ali", "ali@gmail.com"));
        list.add(new Employee(2, "ahmad", "ahmad@gmail.com"));
    }

    public static List<Employee> getAllEmployees() {
        return list;
    }
    public Employee getEmployeeById(int id) {
        return list.stream().filter(emp -> emp.getEmployeeId() == id).findAny().orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        employee.setEmployeeId(list.size());
        list.add(employee); return employee;
    }

    public Employee deleteEmployee(int id) {
        Iterator<Employee> it = list.iterator();
        while(it.hasNext()) {
            Employee emp = it.next();
            if(emp.getEmployeeId() == id) {
                it.remove();
                return emp;
            }
        }
        return null;
    }
}
