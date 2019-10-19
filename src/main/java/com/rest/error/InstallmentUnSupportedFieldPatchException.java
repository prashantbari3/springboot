package com.rest.error;

import java.util.Set;

public class InstallmentUnSupportedFieldPatchException extends RuntimeException {

    public InstallmentUnSupportedFieldPatchException(Set<String> keys) {
        super("Employee " + keys.toString() + " update is not allow.");
    }

}
