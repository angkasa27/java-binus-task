import java.util.ArrayList;
import java.util.Scanner;

class Library {
  private String name;
  private ArrayList<Item> items;

  public Library(String name) {
    this.name = name;
    this.items = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public ArrayList<Item> getItems() {
    return items;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public void displayItems() {
    // System.out.println("Items in " + name + ":");
    for (Item item : items) {
      item.display();
    }
  }

  public Boolean findItem(String title) {
    for (Item item : items) {
      if (item.getTitle().toLowerCase().equals(title.toLowerCase())) {
        return true;
      }
    }
    return false;
  }
}

abstract class Item {
  protected String title;
  protected String author;
  protected int year;
  protected String borrower;

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

  public String getBorrower() {
    return borrower;
  }

  public void setBorrower(String borrower) {
    this.borrower = borrower;
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
    System.out.println("Book: " + title + ", Author: " + author + ", Year: " + year + ", Pages: " + numPages
        + ", Borrower: " + (borrower == null ? "-" : borrower));
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
    System.out.println("DVD: " + title + ", Director: " + author + ", Year: " + year + ", Runtime: " + runtime
        + ", Borrower: " + (borrower == null ? "-" : borrower));
  }
}

public class App {
  static void setBorrower(Library library, String title, String borrower) {
    for (Item item : library.getItems()) {
      if (item.getTitle().equals(title)) {
        item.setBorrower(borrower);
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Library library = new Library("My Library");
    boolean quit = false;

    Book book1 = new Book("Book 1", "Author 1", 2020, 300);
    DVD dvd1 = new DVD("DVD 1", "Director 1", 2018, 120);

    library.addItem(book1);
    library.addItem(dvd1);

    do {
      System.out.println("\n============== " + library.getName() + " ==============");
      System.out.println("1. Daftar Item");
      System.out.println("2. Pinjam Item");
      System.out.println("3. Kembalikan Item");
      System.out.println("4. Keluar");
      System.out.print("Pilih Menu : ");
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
        case 1:
          System.out.println("\n============== Daftar Item ==============");
          library.displayItems();
          break;
        case 2:
          System.out.println("\n============== Peminjaman ==============");
          Boolean result = false;
          String title = "";
          do {
            System.out.print("Masukan nama item: ");
            title = scanner.nextLine();
            result = library.findItem(title);
            if (!result) {
              System.out.println("Item tidak ditemukan!");
            }
          } while (!result);
          System.out.print("Masukan Nama Peminjam: ");
          String borrower = scanner.nextLine();
          setBorrower(library, title, borrower);
          System.out.println("Item berhasil dipinjam!");
          break;
        case 3:
          System.out.println("\n============== Pengembalian ==============");
          do {
            System.out.print("Masukan nama item: ");
            title = scanner.nextLine();
            result = library.findItem(title);
            if (!result) {
              System.out.println("Item tidak ditemukan!");
            }
          } while (!result);
          setBorrower(library, title, null);
          System.out.println("Item berhasil dikembalikan!");
          break;
        case 4:
          quit = true;
          break;
        default:
          System.out.println("Pilihan tidak valid");
      }
    } while (!quit);

    scanner.close();
  }
}
