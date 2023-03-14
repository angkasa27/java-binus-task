import java.util.Scanner;

public class GenerateArrayInt {
  int[] createArray(int length) {
    int[] array = new int[length];
    for (int i = 0; i < array.length; i++) {
      array[i] = (int) (Math.random() * 100);
    }
    return array;
  }

  void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.println("Bilangan ke-" + (i + 1) + " : " + array[i]);
    }
  }

  void findLargestValue(int[] array) {
    int largest = array[0];
    for (int i = 0; i < array.length; i++) {
      if (array[i] > largest) {
        largest = array[i];
      }
    }
    System.out.println("Bilangan terbesar : " + largest);
  }

  void findSmallestValue(int[] array) {
    int smallest = array[0];
    for (int i = 0; i < array.length; i++) {
      if (array[i] < smallest) {
        smallest = array[i];
      }
    }
    System.out.println("Bilangan terkecil : " + smallest);
  }

  void countAverageValue(int[] array) {
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }
    System.out.println("Rata-rata : " + (sum / array.length));
  }

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    GenerateArrayInt app = new GenerateArrayInt();

    System.out.print("Jumlah bilangan : ");
    int length = scanner.nextInt();
    int[] array = app.createArray(length);

    app.printArray(array);

    app.findLargestValue(array);

    app.findSmallestValue(array);

    app.countAverageValue(array);

    scanner.close();
  }

}
