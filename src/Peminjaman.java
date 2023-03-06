import java.util.Scanner;

public class Peminjaman {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);

    // Deklarasi Variable
    Type[] types = new Type[3], newTypes;
    Boolean repeat = true;

    // Inisialisasi jenis buku
    types[0] = new Type("Pelajaran", 2000);
    types[1] = new Type("Novel", 5000);
    types[2] = new Type("Skripsi", 10000);

    // Looping menu
    do {
      System.out.println("\n-------------Pilih Menu--------------");
      System.out.println("1. Daftar jenis buku");
      System.out.println("2. Tambah jenis buku baru");
      System.out.println("3. Hitung denda");
      System.out.println("4. Keluar");
      System.out.print("Pilihan : ");
      int menu = scanner.nextInt();

      switch (menu) {
        case 1:
          System.out.println("\n----------Daftar jenis buku----------");
          // Tampilkan table jenis buku
          System.out.println("Jenis buku\t\tDenda");
          // Looping jenis buku
          for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ". " + types[i].getName() + "\t\t" + types[i].getFine());
          }
          break;

        case 2:
          System.out.println("\n--------Tambah jenis buku baru-------");
          System.out.print("Masukan nama jenis buku : ");
          String name = scanner.next();
          System.out.print("Masukan denda per hari : Rp");
          int fine = scanner.nextInt();
          // Membuat array baru dengan panjang array lama + 1
          newTypes = new Type[types.length + 1];
          // Copy array lama ke array baru
          System.arraycopy(types, 0, newTypes, 0, types.length);
          // Tambahkan jenis buku baru ke array baru
          newTypes[newTypes.length - 1] = new Type(name, fine);
          // Ganti array lama dengan array baru
          types = newTypes;

          System.out.println("Berhasil menambahkan jenis buku baru!");
          break;

        case 3:
          System.out.println("\n----------Hitung denda----------");
          // Tampilkan table jenis buku
          for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ". " + types[i].getName());
          }
          // Input jenis buku dan jumlah hari
          System.out.print("Masukan jenis buku : ");
          int type = scanner.nextInt();
          System.out.print("Masukan jumlah hari : ");
          int day = scanner.nextInt();

          // Hitung denda
          double fineCount = types[type - 1].countFine(day);
          System.out.println("Denda : Rp" + fineCount);
          break;
        case 4:
          // Keluar dari program
          repeat = false;
        default:
          break;
      }
    } while (repeat);

    scanner.close();
  }
}

// Obkjek yang akan dijadikan array
class Type {
  // Deklarasi variabel
  public String name;
  public int fine;

  // Constructor
  public Type(String name, int fine) {
    this.name = name;
    this.fine = fine;
  }

  // Getter
  public String getName() {
    return name;
  }

  public String getFine() {
    return "Rp" + fine;
  }

  // Method untuk menghitung denda
  public double countFine(int day) {
    int pastDeadline = day - 10;
    // Jika melebihi batas waktu, maka akan dikenakan denda
    if (pastDeadline > 0) {
      return pastDeadline * fine;
    } else {
      return 0;
    }
  }
}