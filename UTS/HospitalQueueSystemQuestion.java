
// Mengimpor library yang diperlukan
import java.util.ArrayList;
import java.util.Scanner;

public class HospitalQueueSystemQuestion {
    // Daftar untuk menyimpan pasien dalam antrian
    private static ArrayList<Patient> patientQueue = new ArrayList<>();
    // Objek Scanner untuk membaca input dari pengguna
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        // Pesan sambutan
        System.out.println("Welcome to Hospital Queue Management System");

        // Loop utama untuk sistem
        while (running) {
            // Menampilkan opsi menu
            displayMenu();
            // Mendapatkan pilihan pengguna dengan validasi
            int choice = getValidIntInput("Enter your choice: ");

            // Melakukan tindakan berdasarkan pilihan pengguna
            switch (choice) {
                case 1:
                    // Menambahkan pasien baru
                    addPatient();
                    break;
                case 2:
                    // Melayani pasien berikutnya dalam antrian
                    serveNextPatient();
                    break;
                case 3:
                    // Menampilkan antrian saat ini
                    displayQueue();
                    break;
                case 4:
                    // Memperbarui prioritas pasien
                    updatePriority();
                    break;
                case 5:
                    // Mencari pasien berdasarkan nama
                    searchPatient();
                    break;
                case 6:
                    // Keluar dari sistem
                    System.out.println("Thank you for using Hospital Queue Management System. Goodbye!");
                    running = false; // Menghentikan loop
                    break;
                default:
                    // Menangani pilihan yang tidak valid
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        // Menutup scanner
        scanner.close();
    }

    // Menampilkan opsi menu
    private static void displayMenu() {
        System.out.println("\n===== HOSPITAL QUEUE SYSTEM =====");
        System.out.println("1. Add a new patient to the queue");
        System.out.println("2. Serve next patient");
        System.out.println("3. Display current queue");
        System.out.println("4. Update patient priority");
        System.out.println("5. Search for a patient");
        System.out.println("6. Exit");
        System.out.println("=================================");
    }

    // Menambahkan pasien baru ke antrian
    private static void addPatient() {
        System.out.println("\n--- Add New Patient ---");
        // Mendapatkan detail pasien dari pengguna
        String name = getValidStringInput("Masukan Nama Pasien: ");
        int age = getValidIntInput("Masukan Umur Pasien: ");
        String condition = getValidStringInput("Masukan deskripsi kondisi pasien: ");
        int priority = getValidIntInRange("Masukan prioritas (1-Critical to 5-Non-urgent): ", 1, 5);

        // Membuat objek pasien baru
        Patient newPatient = new Patient(name, age, condition, priority);

        // Menemukan posisi yang tepat untuk menyisipkan pasien berdasarkan prioritas
        int index = 0;
        while (index < patientQueue.size() && patientQueue.get(index).getPriority() <= priority) {
            index++;
        }

        // Menambahkan pasien pada posisi yang dihitung
        patientQueue.add(index, newPatient);
        System.out.println("Pasien berhasil ditambahkan");
    }

    // Melayani pasien berikutnya dalam antrian
    private static void serveNextPatient() {
        if (patientQueue.isEmpty()) {
            // Memeriksa apakah antrian kosong
            System.out.println("Tidak ada pasien");
        } else {
            // Menghapus dan mengambil pasien dengan prioritas tertinggi
            Patient next = patientQueue.remove(0);
            // Menampilkan detail pasien
            System.out.println("Serving patient: " + next.getName() +
                    " | Age: " + next.getAge() +
                    " | Condition: " + next.getCondition() +
                    " | Priority: " + getPriorityText(next.getPriority()));
        }
    }

    // Menampilkan antrian pasien saat ini
    private static void displayQueue() {
        if (patientQueue.isEmpty()) {
            System.out.println("Tidak ada pasien");
        } else {
            System.out.println("\n--- Current Patient Queue ---");
            // Melakukan iterasi melalui antrian dan menampilkan detail setiap pasien
            for (int i = 0; i < patientQueue.size(); i++) {
                Patient p = patientQueue.get(i);
                System.out.println((i + 1) + ". " + p.getName() +
                        " | Age: " + p.getAge() +
                        " | Condition: " + p.getCondition() +
                        " | Priority: " + getPriorityText(p.getPriority()));
            }
        }
    }

    // Memperbarui prioritas pasien
    private static void updatePriority() {
        if (patientQueue.isEmpty()) {
            // Memeriksa apakah antrian kosong
            System.out.println("No patients to update.");
            return;
        }

        // Mendapatkan nama pasien yang akan diperbarui
        String name = getValidStringInput("Enter the patient's name to update: ");
        boolean found = false;

        // Mencari pasien dalam antrian
        for (int i = 0; i < patientQueue.size(); i++) {
            Patient p = patientQueue.get(i);
            if (p.getName().equalsIgnoreCase(name)) {
                // Mendapatkan prioritas baru dari pengguna
                int newPriority = getValidIntInRange("Enter new priority (1-Critical to 5-Non-urgent): ", 1, 5);
                // Menghapus pasien dari antrian
                patientQueue.remove(i);
                // Memperbarui prioritas
                p.setPriority(newPriority);

                // Menyisipkan kembali pasien pada posisi yang tepat
                int index = 0;
                while (index < patientQueue.size() && patientQueue.get(index).getPriority() <= newPriority) {
                    index++;
                }
                patientQueue.add(index, p);
                System.out.println("Update prioritas berhasil");
                found = true;
                break;
            }
        }

        // Menampilkan pesan jika pasien tidak ditemukan
        if (!found) {
            System.out.println("Pasien tidak ditemukan!");
        }
    }

    // Mencari pasien berdasarkan nama
    private static void searchPatient() {
        if (patientQueue.isEmpty()) {
            // Memeriksa apakah antrian kosong
            System.out.println("Tidak ada pasien di antrian");
            return;
        }

        // Mendapatkan nama pasien yang akan dicari
        String name = getValidStringInput("Enter the patient's name to search: ");
        boolean found = false;

        // Mencari pasien dalam antrian
        for (Patient p : patientQueue) {
            if (p.getName().equalsIgnoreCase(name)) {
                // Menampilkan detail pasien jika ditemukan
                System.out.println("Found: " + p.getName() +
                        " | Age: " + p.getAge() +
                        " | Condition: " + p.getCondition() +
                        " | Priority: " + getPriorityText(p.getPriority()));
                found = true;
                break;
            }
        }

        // Menampilkan pesan jika pasien tidak ditemukan
        if (!found) {
            System.out.println("Pasien tidak ditemukan!");
        }
    }

    // Mengonversi prioritas menjadi teks
    private static String getPriorityText(int priority) {
        switch (priority) {
            case 1:
                return "1-Critical";
            case 2:
                return "2-Urgent";
            case 3:
                return "3-High";
            case 4:
                return "4-Medium";
            case 5:
                return "5-Non-urgent";
            default:
                return "Unknown";
        }
    }

    // Mendapatkan input integer yang valid dari pengguna
    private static int getValidIntInput(String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                // Menangani input angka yang tidak valid
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return value;
    }

    // Mendapatkan input integer yang valid dalam rentang tertentu
    private static int getValidIntInRange(String prompt, int min, int max) {
        int value;
        while (true) {
            value = getValidIntInput(prompt);
            // Memeriksa apakah input berada dalam rentang
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Please enter a value between " + min + " and " + max + ".");
        }
        return value;
    }

    // Mendapatkan input string yang valid dan tidak kosong dari pengguna
    private static String getValidStringInput(String prompt) {
        String value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextLine().trim();
            // Memeriksa apakah input tidak kosong
            if (!value.isEmpty()) {
                break;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
        return value;
    }
}

// Kelas untuk merepresentasikan seorang pasien
class Patient {
    // Atribut pasien
    private String name; // Nama pasien
    private int age; // Umur pasien
    private String condition; // Deskripsi kondisi pasien
    private int priority; // Tingkat prioritas (1-Critical hingga 5-Non-urgent)

    // Konstruktor untuk menginisialisasi objek pasien
    public Patient(String name, int age, String condition, int priority) {
        this.name = name;
        this.age = age;
        this.condition = condition;
        this.priority = priority;
    }

    // Getter untuk nama
    public String getName() {
        return name;
    }

    // Getter untuk umur
    public int getAge() {
        return age;
    }

    // Getter untuk kondisi
    public String getCondition() {
        return condition;
    }

    // Getter untuk prioritas
    public int getPriority() {
        return priority;
    }

    // Setter untuk prioritas
    public void setPriority(int priority) {
        this.priority = priority;
    }
}