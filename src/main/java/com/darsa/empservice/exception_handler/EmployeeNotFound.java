package com.darsa.empservice.exception_handler;

import com.darsa.empservice.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFound extends RuntimeException{
    public EmployeeNotFound(String msg) {
        super(msg);
    }
}
