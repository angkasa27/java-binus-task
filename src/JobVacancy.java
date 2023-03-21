import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

class JobList {
  ArrayList<JobPosition> jobs;

  public JobList() {
    jobs = new ArrayList<>();
  }

  public void addJob(JobPosition job) {
    jobs.add(job);
  }

  public void displayList(ArrayList<JobPosition> list) {
    String format = "%-5s %-12s %-10s";
    System.out.println(String.format(format, "No.", "Posisi", "Usia Maks"));
    for (int i = 0; i < list.size(); i++) {
      System.out.println(String.format(format, i + 1, list.get(i).getTitle(), list.get(i).getMaxAge() + " tahun"));
    }
  }

  public void displayJobs() {
    displayList(jobs);
  }

  public void findJob(int age) {
    ArrayList<JobPosition> list = new ArrayList<>();
    for (JobPosition job : jobs) {
      if (job.getMaxAge() >= age) {
        list.add(job);
      }
    }
    displayList(list);
  }

  public void checkAge(int age, int jobIdx) {
    jobs.get(jobIdx - 1).checkAge(age);
  }
}

class JobPosition {
  String title;
  int maxAge;

  public JobPosition(String title, int maxAge) {
    this.title = title;
    this.maxAge = maxAge;
  }

  public String getTitle() {
    return title;
  }

  public int getMaxAge() {
    return maxAge;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setMaxAge(int maxAge) {
    this.maxAge = maxAge;
  }

  public void checkAge(int age) {
    if (age > maxAge) {
      System.out.println("Usia anda (" + age + " tahun) melebihi batas usia untuk pekerjaan ini");
    } else {
      System.out.println("Anda dapat melamar pekerjaan ini");
    }
  }
}

public class JobVacancy {
  static String changeName() {
    Scanner input = new Scanner(System.in);
    System.out.print("\nNama Lengkap: ");
    String name = input.nextLine();
    return name;
  }

  static int changeAge() {
    Scanner input = new Scanner(System.in);
    System.out.print("Tanggal Lahir (yyyy-mm-dd): ");
    String birthDate = input.next();
    LocalDate dob = LocalDate.parse(birthDate);
    LocalDate curDate = LocalDate.now();
    if ((dob != null) && (curDate != null)) {
      return Period.between(dob, curDate).getYears();
    } else {
      return 0;
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
    Boolean exit = false;
    JobList list = new JobList();
    list.addJob(new JobPosition("Staff", 25));
    list.addJob(new JobPosition("Officer", 30));
    list.addJob(new JobPosition("Supervisor", 35));
    list.addJob(new JobPosition("Manager", 40));

    String name = changeName();
    int age = changeAge();
    System.out.println("Usia anda " + age + " tahun");

    do {
      System.out.println("\nSelamat datang " + name + "!");
      System.out.println("1. Daftar Pekerjaan");
      System.out.println("2. Cari Pekerjaan Sesuai Usia");
      System.out.println("3. Lamar Pekerjaan");
      System.out.println("4. Ubah Usia");
      System.out.println("5. Exit");
      System.out.print("Pilih menu: ");
      int menu = input.nextInt();
      input.nextLine();

      switch (menu) {
        case 1:
          System.out.println("\n===== Semua Pekerjaan =====");
          list.displayJobs();
          break;
        case 2:
          System.out.println("\n===== Cari Pekerjaan =====");
          System.out.println("Pekerjaan yang tersedia untuk anda: ");
          list.findJob(age);
          break;
        case 3:
          System.out.println("\n===== Lamar Pekerjaan =====");
          list.displayJobs();
          System.out.print("Pilih pekerjaan: ");
          int jobIdx = input.nextInt();
          input.nextLine();
          list.checkAge(age, jobIdx);
          break;
        case 4:
          System.out.println("\n===== Ubah Usia =====");
          age = changeAge();
          System.out.println("Usia anda diubah menjadi " + age + " tahun");
          break;
        case 5:
          exit = true;
          break;
        default:
          break;
      }

    } while (!exit);
  }
}