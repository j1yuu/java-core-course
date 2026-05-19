package exceptions;

/**
 * Исключение, выбрасываемое в случае отсутствия книги в каталоге.
 */
public class NoSuchABookException extends Exception {
  public NoSuchABookException() {
    super();
  }

  public NoSuchABookException(String message) {
    super(message);
  }
}
