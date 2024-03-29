package com.dashboard.backend.security;

import com.dashboard.backend.exceptions.EmployeeNotFoundException;
import com.dashboard.backend.models.jpa.Employee;
import com.dashboard.backend.models.security.CustomEmployeeDetails;
import com.dashboard.backend.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomEmployeeDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findByUsername(username);
        employee.orElseThrow(EmployeeNotFoundException::new);
        return employee.map(CustomEmployeeDetails::new).get();
    }
}

class UserService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    EmployeeRepository employeeRepository;

    public long saveUser(Employee employee) {
        Employee savedEntity = employeeRepository.save(employee);
        return savedEntity.getId();
    }

    public Employee findUserByUsername(String userName) {
        return employeeRepository.findByUsername(userName).orElse(null);
    }
}