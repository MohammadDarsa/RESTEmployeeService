package com.darsa.empservice.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@JsonFilter("EmployeeFilter")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    @Column(name = "employee_name")
    @Size(min = 1, max = 10)
    private String name;
    @Column(name = "employee_email")
    @Email
    private String email;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee() {
    }

    public Employee(int employeeId, String name, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
    }
}

