package com.rest;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.rest.error.StudentUnSupportedFieldPatchException;
import com.rest.error.StudentNotFoundException;

@CrossOrigin(origins="https://angular-mgv99x.stackblitz.io:4200", allowedHeaders="*" )
@RestController
public class StudentController {

	
    @Autowired
    private StudentRepository repository;

    // Find
 
    @GetMapping("/students")
    List<Student> findAll() {
        return repository.findAll();
    }
    // Save
    @PostMapping("/student")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
  Student newStudent(@RequestBody Student newStudent) {
        return repository.save(newStudent);
    }

    // Find
    @GetMapping("/students/{id}")
    Student findOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }
    // Save or update
    @PutMapping("/student/{id}")
    Student saveOrUpdate(@RequestBody Student newStudent, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                	x.setSchoolId(newStudent.getSchoolId());
                    x.setStudId(newStudent.getStudId());
                    x.setFirstName(newStudent.getFirstName());
                    x.setMiddleName(newStudent.getMiddleName());
                    x.setLastName(newStudent.getLastName());
                    x.setTempAddr(newStudent.getTempAddr());
                    x.setPermAddr(newStudent.getPermAddr());
                    x.setEmailId(newStudent.getEmailId());
                    x.setMobileNo(newStudent.getMobileNo());
                    x.setContactNo(newStudent.getContactNo());
                    x.setShortDescr(newStudent.getShortDescr());
                    x.setLongDescr(newStudent.getLongDescr());
                    x.setShortDescr(newStudent.getShortDescr());
                    
                    
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return repository.save(newStudent);
                });
    }
 // update mobileNo only
    @PatchMapping("/student/{id}")
    Student patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {

                    String mobileNo = update.get("mobileNo");
                    if (!StringUtils.isEmpty(mobileNo)) {
                        x.setMobileNo(mobileNo);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    } else {
                        throw new StudentUnSupportedFieldPatchException(update.keySet());
                    }

                })
                .orElseGet(() -> {
                    throw new StudentNotFoundException(id);
                });

    }

    @DeleteMapping("/student/{id}")
    void deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
    }


}

