package com.dashboard.backend.services;

import com.dashboard.backend.exceptions.InvalidInput;
import com.dashboard.backend.interfaces.serviceInterfaces.DashboardServiceInterface;
import com.dashboard.backend.models.jpa.Title;
import com.dashboard.backend.models.jpa.Employee;
import com.dashboard.backend.models.jpa.EmployeeDto;
import com.dashboard.backend.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DashboardService implements DashboardServiceInterface {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void createAccount(EmployeeDto employeeDto) throws InvalidInput {

        if(!employeeDto.getPassword1().equalsIgnoreCase(employeeDto.getPassword2())){
            throw new InvalidInput("Passwords do not match");
        }

        Employee employee = new Employee(employeeDto.getUsername(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getPassword1(), employeeDto.getSalary(), Title.valueOf(employeeDto.getPosition()));
        employeeRepository.save(employee);
        log.debug("New employee is saved {}", employee);
    }

}
