import java.util.ArrayList; // Mengimpor libbrary ArrayList
import java.util.Scanner; // Mengimpor libbrary Scanner untuk input dari user

public class TodoList2A {
    private ArrayList<String> todoList; // Deklarasi variabel untuk menyimpan daftar tugas

    // Constructor
    public TodoList2A() {
        todoList = new ArrayList<>(); // inisialisasi ArrayList 
    }

    // menambahkan task
    public void addTask(String task) {
        if (!task.isEmpty()) { // Memeriksa apakah input tidak kosong
            todoList.add(task); // Menambahkan task ke ArrayList
            System.out.println("Task berhasil di tambahkan: "+task); // pesan jika task berhasil di tambahkan
        } else {
            System.out.println("Task tidak boleh kosong!"); // Pesan jika input kosong
        }
    }

    // menghapus task berdasarkan nama
    public void removeTask(String task) {
        boolean cek = false; // deklarasi dan inisialisasi, apakah task name ditemukan 
        for (int i = 0; i < todoList.size(); i++) { // Iterasi untuk mencari task
            if (task.equalsIgnoreCase(todoList.get(i))) { // mengecek apakah task cocok 
                todoList.remove(task); // Hapus task dari ArrayList
                System.out.println("Task name "+task+" berhasil dihapus"); // pesan jika task berhasil di hapus
                cek = true; // mengubah nilai cek menjadi true, berarti task ditemukan
                break; // keluar dari perulangan
            }    
        }
        if (!cek) { // Jika task tidak ditemukan
            System.out.println("Task name tidak ada / salah"); // pesan jika task tidak ada / salah
        } 
    }

    // menghapus task berdasarkan index
    public void removeTaskByIndex(int index) {
        boolean cek = false; // deklarasi dan inisialisasi, apakah index ditemukan
        for (int i = 0; i < todoList.size(); i++) { // Iterasi untuk mencari index
            if (index==i) { // mengecek apakah index cocok
                todoList.remove(index); // Hapus task berdasarkan index
                System.out.println("Index task "+(index+1)+" berhasil dihapus"); // pesan jika task berhasil di hapus
                cek = true; // mengubah nilai cek menjadi true, berarti task ditemukan
                break; // keluar dari perulangan
            }
        }
        if (!cek) { // Jika index tidak ditemukan
            System.out.println("Task index tidak ada / salah"); // pesan jika task tidak ada / salah
        }
    }

    // menampilkan display task 
    public void displayTasks() {
        if (!todoList.isEmpty()) { // mengecek apakah array tidak kosong
            System.out.println("List Task: "); // mencetak tulisan list task
            for (int i = 0; i < todoList.size(); i++) { // Iterasi untuk menampilkan setiap task
                System.out.println((i+1)+". "+todoList.get(i)); // mencetak nomer urut task dan nama tasknya
            }
        } else {
            System.out.println("Tidak ada task"); // jika array list kosong maka akan keluar tidak ada task
        } 
    }

    // mencari task berdasarkan index
    public void searchTaskByIndex(int index) {
        boolean cek = false; //  deklarasi dan inisialisasi, apakah index ditemukan
        System.out.print("Hasil search: "); // mencetak tulisan hasil search
        for (int i = 0; i < todoList.size(); i++) { // Iterasi untuk mencari index
            if (index==i) { // menngecek apakah index cocok
                System.out.println(todoList.get(i)); // Menampilkan task pada index tersebut
                cek = true; // mengubah nilai cek menjadi true, berarti index ditemukan
            }
        } 
        if (!cek) { // Jika index tidak ditemukan
            System.out.println("Tidak ditemukan"); // mencetak Pesan kesalahan
        }
    }

    public static void main(String[] args) {
        TodoList2A app = new TodoList2A(); // Membuat instansiasi kelas TodoList2A
        Scanner scanner = new Scanner(System.in); // Membuat instance Scanner untuk input
        boolean running = true; // agar app berjalan / looping terus

        while (running) { // Loop untuk aplikasi
            System.out.println("\nTo-Do List Application"); //mencetak tulisan 
            System.out.println("1. Add Task"); // Opsi menu
            System.out.println("2. Remove Task By Task Name"); // Opsi menu
            System.out.println("3. Remove Task By Index"); // Opsi menu
            System.out.println("4. Search Task By Index"); // Opsi menu
            System.out.println("5. Display Tasks"); // Opsi menu
            System.out.println("6. Exit"); // Opsi menu
            System.out.print("Enter your choice: "); // Prompt untuk input pengguna
            int choice = scanner.nextInt(); // Membaca pilihan menu yang di input pengguna
            scanner.nextLine(); // Membersihkan buffer input

            switch (choice) { // Pilihan berdasarkan menu
                case 1:
                    System.out.print("Enter task to add: "); // Prompt untuk menambah task
                    String task = scanner.nextLine(); // Membaca input task
                    app.addTask(task); // Memanggil metode untuk menambah task
                    break;

                case 2:
                    app.displayTasks(); // Menampilkan daftar task
                    if (app.todoList.isEmpty()) { // mengecek apakah array kosong
                        break; // keluar dari case
                    }
                    System.out.print("Enter task to remove by name: "); // Prompt untuk menghapus berdasarkan nama
                    String taskName = scanner.nextLine(); // Membaca input nama task
                    app.removeTask(taskName); // Memanggil metode untuk menghapus task berdasarkan nama
                    break; // keluar dari case

                case 3:
                    app.displayTasks(); // Menampilkan daftar task
                    if (app.todoList.isEmpty()) { // mengecek apakah array kosong
                        break; // keluar dari case
                    }
                    System.out.print("Enter index to remove task: "); // Prompt untuk menghapus berdasarkan index
                    int indexremove = scanner.nextInt(); // Membaca input index
                    app.removeTaskByIndex(indexremove-1); // Memanggil metode untuk menghapus task berdasarkan index
                    break; // keluar dari case

                case 4:
                    if (app.todoList.isEmpty()) { // mengecek apakah array kosong
                        System.out.println("Tidak ada task"); // Pesan kesalahan
                        break; // keluar dari case
                    }
                    System.out.print("Enter index to search task: "); // Prompt untuk mencari task
                    int indexToSearch = scanner.nextInt(); // Membaca input index
                    app.searchTaskByIndex(indexToSearch-1); // Memanggil metode pencarian dengan index 
                    break; // keluar dari case

                case 5:
                    app.displayTasks(); // Menampilkan daftar task
                    break; // keluar dari case

                case 6:
                    running = false; // Menghentikan loop aplikasi
                    System.out.println("Exiting the application..."); // Pesan keluar
                    break; // keluar dari case

                default:
                    System.out.println("Invalid choice. Please try again."); // Pesan jika input tidak valid
            }
        }

        scanner.close(); // Menutup scanner setelah aplikasi selesai
    }
}
