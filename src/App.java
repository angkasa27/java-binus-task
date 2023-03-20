import java.util.ArrayList;
import java.util.List;

class Library {
  private String name;
  private List<Item> items;

  public Library(String name) {
    this.name = name;
    this.items = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public List getItems() {
    return items;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public void displayItems() {
    System.out.println("Items in " + name + ":");
    for (Item item : items) {
      item.display();
    }
  }
}

abstract class Item {
  protected String title;
  protected String author;
  protected int year;

  public Item(String title, String author, int year) {
    this.title = title;
    this.author = author;
    this.year = year;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getYear() {
    return year;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public abstract void display();
}

class Book extends Item {
  private int numPages;

  public Book(String title, String author, int year, int numPages) {
    super(title, author, year);
    this.numPages = numPages;
  }

  public int getNumPages() {
    return numPages;
  }

  public void setNumPages(int numPages) {
    this.numPages = numPages;
  }

  @Override
  public void display() {
    System.out.println("Book: " + title + ", Author: " + author + ", Year: " + year + ", Pages: " + numPages);
  }
}

class DVD extends Item {
  private int runtime;

  public DVD(String title, String author, int year, int runtime) {
    super(title, author, year);
    this.runtime = runtime;
  }

  public int getRuntime() {
    return runtime;
  }

  public void setRuntime(int runtime) {
    this.runtime = runtime;
  }

  @Override
  public void display() {
    System.out.println("DVD: " + title + ", Director: " + author + ", Year: " + year + ", Runtime: " + runtime);
  }
}

public class App {
  public static void main(String[] args) {
    Library library = new Library("My Library");

    Book book1 = new Book("Book 1", "Author 1", 2020, 300);
    DVD dvd1 = new DVD("DVD 1", "Director 1", 2018, 120);

    library.addItem(book1);
    library.addItem(dvd1);

    library.displayItems();
  }
}
