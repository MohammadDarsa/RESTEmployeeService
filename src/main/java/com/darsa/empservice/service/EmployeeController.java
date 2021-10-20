package com.darsa.empservice.service;

import com.darsa.empservice.exception_handler.EmployeeNotFound;
import com.darsa.empservice.model.Employee;
import com.darsa.empservice.model.EmployeeDao;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeDao service;

    @GetMapping("/employees") //localhost:8080/employees
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable int id) {
        Employee employee =  service.getEmployeeById(id);
        if(employee == null) throw new EmployeeNotFound("Employee Not Found!");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "employeeId");
        FilterProvider filters = new SimpleFilterProvider().addFilter("EmployeeFilter", filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employee);
        mappingJacksonValue.setFilters(filters);
        return new ResponseEntity<>(mappingJacksonValue, HttpStatus.FOUND);
    }


    @PostMapping(value = "/employees/persist")
    public ResponseEntity<Object> persistEmployee(@Valid @RequestBody Employee employee) {
        Employee emp = service.persistEmployee(employee);
        FilterProvider filters = new SimpleFilterProvider().addFilter("EmployeeFilter", SimpleBeanPropertyFilter.filterOutAllExcept("name", "employeeId"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(emp);
        mappingJacksonValue.setFilters(filters);
        return new ResponseEntity<>(mappingJacksonValue, HttpStatus.CREATED);
    }

    @DeleteMapping("/employees/delete/{id}")
    public void deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
    }
}
