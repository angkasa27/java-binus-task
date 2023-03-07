// import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    // Scanner scanner = new Scanner(System.in);
    // Boolean repeat = true;
    System.out.println("test");
  }
}

class Mahasiswa {
  private String nama;
  private int umur;
  private String alamat;
  private String nomorMahasiswa;
  private double ipk;
  protected String jurusan; // instance variable for jurusan
  protected String kelas; // instance variable for kelas

  public Mahasiswa(String nama, int umur, String alamat, String nomorMahasiswa, double ipk) {
    this.nama = nama;
    this.umur = umur;
    this.alamat = alamat;
    this.nomorMahasiswa = nomorMahasiswa;
    this.ipk = ipk;
  }

  public String getNama() {
    return this.nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public int getUmur() {
    return this.umur;
  }

  public void setUmur(int umur) {
    this.umur = umur;
  }

  public String getAlamat() {
    return this.alamat;
  }

  public void setAlamat(String alamat) {
    this.alamat = alamat;
  }

  public String getNomorMahasiswa() {
    return this.nomorMahasiswa;
  }

  public void setNomorMahasiswa(String nomorMahasiswa) {
    this.nomorMahasiswa = nomorMahasiswa;
  }

  public double getIPK() {
    return this.ipk;
  }

  public void setIPK(double ipk) {
    this.ipk = ipk;
  }

  public String getJurusan() {
    return this.jurusan;
  }

  public void setJurusan(String jurusan) {
    this.jurusan = jurusan;
  }

  public String getKelas() {
    return this.kelas;
  }

  public void setKelas(String kelas) {
    this.kelas = kelas;
  }

  public void belajar() {
    System.out.println("Mahasiswa sedang belajar...");
  }

  public void kuliah() {
    System.out.println("Mahasiswa sedang kuliah...");
  }
}
