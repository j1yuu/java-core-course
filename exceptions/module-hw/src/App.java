import cli.CliManager;
import java.util.ArrayList;
import java.util.List;
import model.Book;
import services.CatalogService;
import services.implementation.CatalogServiceImpl;

public class App {

  public static void main(String[] args) throws Exception {
    final CatalogService catalogManager = new CatalogServiceImpl();
  
    List<Book> initialCatalog = new ArrayList<>();
    initCatalog(initialCatalog);

    catalogManager.setCatalog(initialCatalog);

    CliManager cliManager = new CliManager(catalogManager);
    cliManager.run();

  }

  private static void initCatalog(List<Book> catalog) {
    catalog.add(new Book("Book 1", "Author 1", 10));
    catalog.add(new Book("Book 2", "Author 2", 5));
    catalog.add(new Book("Book 3", "Author 3", 15));
  }
  
}
