package exceptions;

public class ContactDoesNotExistException extends RuntimeException {
  public ContactDoesNotExistException() {
    super();
  }

  public ContactDoesNotExistException(String message) {
    super(message);
  }
}
