package com.ranjit.cache.exceptions;

public class StorageFullException extends RuntimeException {
    public StorageFullException(String msg) {
        super(msg);
    }
}
