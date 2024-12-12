package com.amaralph.ds_clients.services.exceptions;

import com.amaralph.ds_clients.dto.CustomError;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String msg) {
        super(msg);
    }
}
