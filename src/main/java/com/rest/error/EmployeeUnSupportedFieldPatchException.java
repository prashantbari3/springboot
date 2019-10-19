package com.rest.error;

import java.util.Set;

public class EmployeeUnSupportedFieldPatchException extends RuntimeException {

    public EmployeeUnSupportedFieldPatchException(Set<String> keys) {
        super("Employee " + keys.toString() + " update is not allow.");
    }

}
