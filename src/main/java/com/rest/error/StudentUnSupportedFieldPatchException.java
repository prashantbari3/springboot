package com.rest.error;

import java.util.Set;

public class StudentUnSupportedFieldPatchException extends RuntimeException {

    public StudentUnSupportedFieldPatchException(Set<String> keys) {
        super("Employee " + keys.toString() + " update is not allow.");
    }

}
