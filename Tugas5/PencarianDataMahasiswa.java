import java.util.Scanner; // Mengimpor kelas Scanner untuk membaca input dari pengguna

class Mahasiswa { // Mendeklarasikan kelas Mahasiswa untuk merepresentasikan data mahasiswa
    String nim; // Atribut untuk menyimpan Nomor Induk Mahasiswa (NIM)
    String nama; // Atribut untuk menyimpan nama mahasiswa
    String jurusan; // Atribut untuk menyimpan jurusan mahasiswa
    double ipk; // Atribut untuk menyimpan Indeks Prestasi Kumulatif (IPK)

    // Konstruktor untuk menginisialisasi atribut kelas Mahasiswa
    public Mahasiswa(String nim, String nama, String jurusan, double ipk) {
        this.nim = nim; // Menginisialisasi atribut nim
        this.nama = nama; // Menginisialisasi atribut nama
        this.jurusan = jurusan; // Menginisialisasi atribut jurusan
        this.ipk = ipk; // Menginisialisasi atribut ipk
    }

    @Override // Mengoverride metode toString untuk menampilkan informasi mahasiswa dalam format tertentu
    public String toString() {
        return String.format("NIM: %s\nNama: %s\nJurusan: %s\nIPK: %.2f", nim, nama, jurusan, ipk); 
        // Mengembalikan string dengan format informasi mahasiswa
    }
}

public class PencarianDataMahasiswa { // Kelas utama untuk menjalankan program
    public static void main(String[] args) { // Metode utama 
        // Data mahasiswa berupa array objek Mahasiswa
        Mahasiswa[] daftarMahasiswa = {
            new Mahasiswa("2023001", "Budi Santoso", "Teknik Informatika", 3.75), // Membuat objek Mahasiswa
            new Mahasiswa("2023002", "Andi Wijaya", "Sistem Informasi", 3.50), // Membuat objek Mahasiswa
            new Mahasiswa("2023003", "Dewi Lestari", "Teknik Komputer", 3.90), // Membuat objek Mahasiswa
            new Mahasiswa("2023004", "Rina Maulana", "Teknik Informatika", 3.60), // Membuat objek Mahasiswa
            new Mahasiswa("2023005", "Doni Kusuma", "Manajemen Informatika", 3.25), // Membuat objek Mahasiswa
            new Mahasiswa("2023006", "Sinta Rahma", "Sistem Informasi", 3.85), // Membuat objek Mahasiswa
            new Mahasiswa("2023007", "Rudi Hermawan", "Teknik Komputer", 3.40) // Membuat objek Mahasiswa
        };

        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input dari pengguna

        System.out.println("=== SISTEM PENCARIAN DATA MAHASISWA ==="); // Menampilkan judul program
        System.out.print("Masukkan NIM Mahasiswa yang dicari: "); // Meminta pengguna memasukkan NIM
        String nimCari = scanner.nextLine(); // Membaca input NIM dari pengguna

        // Lakukan pencarian linear
        Mahasiswa hasilPencarian = cariMahasiswaByNIM(daftarMahasiswa, nimCari); 
        // Memanggil metode cariMahasiswaByNIM untuk mencari mahasiswa berdasarkan NIM

        System.out.println("\nHASIL PENCARIAN:"); // Menampilkan hasil pencarian
        if (hasilPencarian != null) { // Jika mahasiswa ditemukan
            System.out.println("Mahasiswa ditemukan!"); // Menampilkan pesan mahasiswa ditemukan
            System.out.println(hasilPencarian); // Menampilkan informasi mahasiswa
        } else { // Jika mahasiswa tidak ditemukan
            System.out.println("Mahasiswa dengan NIM " + nimCari + " tidak ditemukan."); 
            // Menampilkan pesan mahasiswa tidak ditemukan
        }

        scanner.close(); // Menutup objek Scanner untuk membebaskan sumber daya
    }

    // Metode untuk mencari mahasiswa berdasarkan NIM menggunakan pencarian linear
    public static Mahasiswa cariMahasiswaByNIM(Mahasiswa[] daftarMahasiswa, String nim) {
        for (int i = 0; i < daftarMahasiswa.length; i++) { // Melakukan iterasi pada array daftarMahasiswa
            // Bandingkan NIM mahasiswa saat ini dengan NIM yang dicari
            if (daftarMahasiswa[i].nim.equals(nim)) { // Jika NIM cocok
                return daftarMahasiswa[i]; // Mengembalikan objek mahasiswa yang ditemukan
            }
        }
        // Jika tidak ditemukan
        return null; // Mengembalikan null jika NIM tidak ditemukan
    }
}