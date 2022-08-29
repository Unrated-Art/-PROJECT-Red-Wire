package com.saturne.redwire.exceptions;

@SuppressWarnings("serial")
public class CatalogueNotFoundException extends RuntimeException {

  public CatalogueNotFoundException(String message) {
    super(message);
  }
}
