package com.rest;

import java.math.BigDecimal;
import java.util.Date;
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

import com.rest.error.InstallmentNotFoundException;
import com.rest.error.StudentNotFoundException;
import com.rest.error.InstallmentUnSupportedFieldPatchException;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class InstallmentController {

	
    @Autowired
    private InstallmentRepository repository;

    // Find
 
    @GetMapping("/installments")
    List<Installment> findAll() {
        return repository.findAll();
    }
 // Save
    @PostMapping("/installment")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
  Installment newInstallment(@RequestBody Installment newInstallment) {
        return repository.save(newInstallment);
    }
    
    // Find
    @GetMapping("/installments/{id}")
    Installment findOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new InstallmentNotFoundException(id));
    }
 // Save or update
    @PutMapping("/Installment/{id}")
    Installment saveOrUpdate(@RequestBody Installment newInstallment, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                	x.setId(newInstallment.getId());
                    x.setAmount(newInstallment.getAmount());
                    x.setSheduledDate(newInstallment.getSheduledDate());
                    x.setPaymentdate(newInstallment.getPaymentdate());
                    x.setStatus(newInstallment.getStatus());
                   
                    
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newInstallment.setId(id);
                    return repository.save(newInstallment);
                });
    }
 // update mobileNo only
    @PatchMapping("/Installment/{id}")
    Installment patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {

                    BigDecimal amount = new BigDecimal(update.get("amount"));
                    if (!StringUtils.isEmpty(amount)) {
                        x.setAmount(amount);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    } else {
                        throw new InstallmentUnSupportedFieldPatchException(update.keySet());
                    }

                })
                .orElseGet(() -> {
                    throw new InstallmentNotFoundException(id);
                });

    }

    @DeleteMapping("/installment/{id}")
    void deleteInstallment(@PathVariable Long id) {
        repository.deleteById(id);
    }


}




