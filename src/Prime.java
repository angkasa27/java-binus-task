import java.util.Scanner;

public class Prime {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Deklarasi Variable
        boolean isPrime = true;
        int reason = 0;

        // Input bilangan
        System.out.print("Masukan bilangan bulat: ");
        int input = scanner.nextInt();

        // Cek bilangan prima
        for (int i = 2; i < input; i++) {
            // Cek jika bilangan dapat dibagi dengan i
            if (input % i == 0) {
                isPrime = false;
                // Masukan nilai i ke variable reason
                reason = i;
                // Hentikan perulangan
                break;
            }
        }

        // Print hasil
        if (isPrime) {
            System.out.println(input + " adalah angka prima");
        } else {
            System.out.println(input + " bukan angka prima, karena dapat dibagi dengan " + reason);
        }

        scanner.close();
    }
}