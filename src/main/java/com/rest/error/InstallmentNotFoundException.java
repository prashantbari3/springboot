package com.rest.error;

public class InstallmentNotFoundException extends RuntimeException {

    public InstallmentNotFoundException(Long id) {
        super("Student id not found : " + id);
    }

}
