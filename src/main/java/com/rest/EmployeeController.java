package com.rest;

import com.rest.error.EmployeeNotFoundException;
import com.rest.error.EmployeeUnSupportedFieldPatchException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    // Find
    @GetMapping("/employees")
    List<Employee> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/employee")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    // Find
    @GetMapping("/employee/{id}")
    Employee findOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    // Save or update
    @PutMapping("/employee/{id}")
    Employee saveOrUpdate(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setEmpId(newEmployee.getEmpId());
                    x.setFirstName(newEmployee.getFirstName());
                    x.setLastName(newEmployee.getLastName());
                    x.setMobileNo(newEmployee.getMobileNo());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    // update mobileNo only
    @PatchMapping("/employee/{id}")
    Employee patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {

                    String mobileNo = update.get("mobileNo");
                    if (!StringUtils.isEmpty(mobileNo)) {
                        x.setMobileNo(mobileNo);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    } else {
                        throw new EmployeeUnSupportedFieldPatchException(update.keySet());
                    }

                })
                .orElseGet(() -> {
                    throw new EmployeeNotFoundException(id);
                });

    }

    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
