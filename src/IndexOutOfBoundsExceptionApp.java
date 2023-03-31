import java.util.ArrayList;

public class IndexOutOfBoundsExceptionApp {

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);

    try {
      int value = list.get(3);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Caught an IndexOutOfBoundsException");
    }
  }
}