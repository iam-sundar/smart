package com.smart.smart.service;

import com.smart.smart.dao.EmployeeRepository;
import com.smart.smart.dto.EmployeeDTO;
import com.smart.smart.entity.Employee;
import com.smart.smart.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        List<Employee> employeeList = employeeRepository.findAll();
        for (Employee employee : employeeList) {
            EmployeeDTO employeeDTO = new EmployeeDTO(employee.getId(), employee.getName(), employee.getAge(), employee.getGender(), employee.getTown(), employee.getCity(), employee.getState(), employee.getAddress());
            employeeDTOS.add(employeeDTO);
        }
        return employeeDTOS;
    }

    public EmployeeDTO fetchEmployeeById(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            Employee emp = employee.get();
            return new EmployeeDTO(emp.getId(), emp.getName(), emp.getAge(), emp.getGender(), emp.getTown(), emp.getCity(), emp.getState(), emp.getAddress());
        } else {
            throw new NotFoundException("Employee not found in the SMART system.");
        }
    }

}
