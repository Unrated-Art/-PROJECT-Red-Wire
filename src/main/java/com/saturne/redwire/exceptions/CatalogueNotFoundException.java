package com.saturne.redwire.exceptions;

public class CatalogueNotFoundException extends RuntimeException {

    public CatalogueNotFoundException(String message) {
        super(message);
    }
}
