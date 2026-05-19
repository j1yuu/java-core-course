package exceptions;

/**
 * Исключение, выбрасываемое в случае пустого каталога.
 */
public class EmptyCatalogException extends Exception {
  public EmptyCatalogException() {
    super();
  }

  public EmptyCatalogException(String message) {
    super(message);
  }
}
