package exceptions;

/**
 * Исключение, выбрасываемое в случае отсутствия доступных экземпляров.
 */
public class NoAvailableCopiesException extends Exception {
  public NoAvailableCopiesException() {
    super();
  }
  
  public NoAvailableCopiesException(String message) {
    super(message);
  }
}