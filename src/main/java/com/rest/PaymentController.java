package com.rest;

import com.rest.error.BookNotFoundException;
import com.rest.error.BookUnSupportedFieldPatchException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
public class PaymentController {

    @Autowired
    private PaymentRepository repository;

    // Find
    @GetMapping("/payments")
    List<Payment> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/Payments")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Payment newPayment(@RequestBody Payment newPayment) {
        return repository.save(newPayment);
    }

    // Find
    @GetMapping("/Payments/{amount}")
    Payment findOne(@PathVariable String amount) {
        return repository.findByAmount(amount)
                .orElseThrow(() -> new PaymentNotFoundException(Amount));
    }

    // Save or update
    @PutMapping("/payments/{amount}")
    Payment saveOrUpdate(@RequestBody Payment newPayment, @PathVariable BigDecimal amount) {

        return repository.findByAmount(amount)
                .map(x -> {
                    x.setAmount(newPayment.getAmount());
                    x.setPayment(newPayment.getPayment());
                    x.setFeespaid(newPayment.getFeespaid());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newPayment.setAmount(amount);
                    return repository.save(newPayment);
                });
    }

    // update author only
    @PatchMapping("/payments/{amount}")
    Payment patch(@RequestBody Map<String, String> update, @PathVariable BigDecimal amount) {

        return repository.findByAmount(amount)
                .map(x -> {

                    String author = update.get("author");
                    if (!StringUtils.isEmpty(author)) {
                        x.setAuthor(author);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    } else {
                        throw new PaymentUnSupportedFieldPatchException(update.keySet());
                    }

                })
                .orElseGet(() -> {
                    throw new PaymentNotFoundException(amount);
                });

    }

    @DeleteMapping("/Payments/{amount}")
    void deletePayment(@PathVariable BigDecimal amount) {
        repository.deleteByAmount(amount);
    }

}
