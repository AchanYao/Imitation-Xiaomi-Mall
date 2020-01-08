package com.achan.xiaomi_store.admin.exception;

import org.springframework.validation.BindingResult;

public class DataValidationException extends AdminException {

    public DataValidationException(BindingResult result) {
        super(result.getAllErrors().toString());
    }
}
