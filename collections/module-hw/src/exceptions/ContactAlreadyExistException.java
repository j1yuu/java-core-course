package exceptions;

public class ContactAlreadyExistException extends RuntimeException {
  public ContactAlreadyExistException(String message) {
    super(message);
  }

  public ContactAlreadyExistException() {
    super();
  }
}
