import java.util.Scanner;

public class TablePeriodic {
    private String[] elementNames = { "Hydrogen", "Helium", "Lithium", "Beryllium", "Boron", "Carbon", "Nitrogen",
            "Oxygen", "Fluorine", "Neon", "Sodium", "Magnesium", "Aluminum", "Silicon", "Phosphorus", "Sulfur",
            "Chlorine", "Argon", "Potassium", "Calcium" };
    private int[] atomicNumbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

    public String getElementName(int atomicNumber) {
        // if (atomicNumber >= 1 && atomicNumber <= 20) {
        if (atomicNumber >= 1 && atomicNumber <= elementNames.length) {
            return elementNames[atomicNumber - 1];
        } else {
            return "Unknown Element";
        }
    }

    public int getAtomicNumber(String elementName) {
        // System.out.println(elementName);
        for (int i = 0; i < elementNames.length; i++) {
            if (elementNames[i].equalsIgnoreCase(elementName)) {
                return atomicNumbers[i];
            }
        }
        return -1;
    }

    public void printPeriodicTable() {
        for (int i = 0; i < elementNames.length; i++) {
            System.out.println(atomicNumbers[i] + "\t\t" + elementNames[i]);
        }
    }

    public void addNewElements(String newElement) {
        String[] newElementNames = new String[elementNames.length + 1];
        int[] newAtomicNumbers = new int[atomicNumbers.length + 1];

        System.arraycopy(elementNames, 0, newElementNames, 0, elementNames.length);

        System.arraycopy(atomicNumbers, 0, newAtomicNumbers, 0, atomicNumbers.length);

        int newAtomic = newAtomicNumbers.length;
        newElementNames[newElementNames.length - 1] = newElement;
        newAtomicNumbers[newAtomicNumbers.length - 1] = newAtomic;

        elementNames = newElementNames;
        atomicNumbers = newAtomicNumbers;

        System.out.println("Berhasil menambahkan " + newElement + "( " + newAtomic
                + ") ke tabel periodik!");
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Boolean repeat = true;
        TablePeriodic app = new TablePeriodic();

        do {
            System.out.println("==========================");
            System.out.println("1. Tampilkan tabel periodik");
            System.out.println("2. Cari nama element");
            System.out.println("3. Cari nomor atom");
            System.out.print("Pilihan :");
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    app.printPeriodicTable();
                    break;
                case 2:
                    System.out.print("Masukan nomor atom :");
                    int inputNumber = scanner.nextInt();
                    String resultElement = app.getElementName(inputNumber);
                    System.out.println("Nama element : " + resultElement);
                    break;
                case 3:
                    System.out.print("Masukan nama element :");
                    String inputElement = scanner.next();
                    int resultNumber = app.getAtomicNumber(inputElement);
                    if (resultNumber > 0)
                        System.out.println("Nomor atom : " + resultNumber);
                    else {
                        System.out.println("Nama element tidak ditemukan");
                        System.out.print(
                                "Apakah anda ingin menambahkan " + inputElement + " ke tabel periodik? (ya/tidak) ");
                        String answer = scanner.next();
                        if (answer.equalsIgnoreCase("ya")) {
                            app.addNewElements(inputElement);
                            app.printPeriodicTable();
                        }
                        break;
                    }
                default:
                    break;
            }
        } while (repeat);

        scanner.close();
    }
}