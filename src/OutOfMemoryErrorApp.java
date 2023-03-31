public class OutOfMemoryErrorApp {
  public static void main(String[] args) {
    try {
      int[] arr = new int[Integer.MAX_VALUE];
    } catch (OutOfMemoryError e) {
      System.out.println("Caught an OutOfMemoryError");
    }
  }
}