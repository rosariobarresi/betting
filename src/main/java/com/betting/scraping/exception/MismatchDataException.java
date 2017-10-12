package com.betting.scraping.exception;

public class MismatchDataException extends Exception {
  private static final long serialVersionUID = 8652010549805186193L;

  public MismatchDataException() {
    super();
  }

  public MismatchDataException(String message, Throwable cause) {
    super(message, cause);
  }

  public MismatchDataException(String message) {
    super(message);
  }

  public MismatchDataException(Throwable cause) {
    super(cause);
  }
}
