package com.saturne.redwire.exceptions;

@SuppressWarnings("serial")
public class TrainingNotFoundException extends RuntimeException {

  public TrainingNotFoundException(String message) {
    super(message);
  }
}
