import java.util.ArrayList; // Mengimpor kelas ArrayList untuk membuat daftar dinamis
import java.util.Scanner; // Mengimpor kelas Scanner untuk membaca input dari pengguna

class Produk { // Kelas untuk merepresentasikan data produk
    String id; // Atribut untuk menyimpan ID produk
    String nama; // Atribut untuk menyimpan nama produk
    String kategori; // Atribut untuk menyimpan kategori produk
    double harga; // Atribut untuk menyimpan harga produk
    int stok; // Atribut untuk menyimpan jumlah stok produk

    // Konstruktor untuk menginisialisasi atribut kelas Produk
    public Produk(String id, String nama, String kategori, double harga, int stok) {
        this.id = id; // Menginisialisasi atribut id
        this.nama = nama; // Menginisialisasi atribut nama
        this.kategori = kategori; // Menginisialisasi atribut kategori
        this.harga = harga; // Menginisialisasi atribut harga
        this.stok = stok; // Menginisialisasi atribut stok
    }

    @Override // Mengoverride metode toString untuk menampilkan informasi produk dalam format tertentu
    public String toString() {
        return String.format("%-5s | %-25s | %-15s | Rp %.2f | Stok: %d", 
                             id, nama, kategori, harga, stok); 
        // Mengembalikan string dengan format informasi produk
    }
}

public class PencarianProduk { // Kelas utama untuk menjalankan program
    public static void main(String[] args) { // Metode utama 
        // Data produk berupa array objek Produk
        Produk[] daftarProduk = {
            new Produk("P001", "Laptop Asus VivoBook", "Elektronik", 8500000, 10), // Membuat objek Produk
            new Produk("P002", "Smartphone Samsung Galaxy", "Elektronik", 5000000, 15), // Membuat objek Produk
            new Produk("P003", "Kemeja Formal Pria", "Fashion", 250000, 50), // Membuat objek Produk
            new Produk("P004", "Sepatu Lari Nike", "Fashion", 1200000, 25), // Membuat objek Produk
            new Produk("P005", "Buku Pemrograman Java", "Buku", 150000, 30), // Membuat objek Produk
            new Produk("P006", "Mouse Gaming Logitech", "Elektronik", 350000, 20), // Membuat objek Produk
            new Produk("P007", "Novel Bumi Manusia", "Buku", 95000, 40), // Membuat objek Produk
            new Produk("P008", "Tas Ransel", "Fashion", 300000, 35) // Membuat objek Produk
        };

        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input dari pengguna

        System.out.println("=== SISTEM PENCARIAN PRODUK ==="); // Menampilkan judul program
        System.out.println("Kategori tersedia: Elektronik, Fashion, Buku"); // Menampilkan daftar kategori produk
        System.out.print("Masukkan kategori produk: "); // Meminta pengguna memasukkan kategori
        String kategoriCari = scanner.nextLine(); // Membaca input kategori dari pengguna

        System.out.print("Masukkan harga minimum: Rp "); // Meminta pengguna memasukkan harga minimum
        double hargaMin = scanner.nextDouble(); // Membaca input harga minimum dari pengguna

        System.out.print("Masukkan harga maksimum: Rp "); // Meminta pengguna memasukkan harga maksimum
        double hargaMax = scanner.nextDouble(); // Membaca input harga maksimum dari pengguna

        // Lakukan pencarian linear multi-kriteria
        ArrayList<Produk> hasilPencarian = cariProdukByKriteria(daftarProduk, kategoriCari, hargaMin, hargaMax); 
        // Memanggil metode cariProdukByKriteria untuk mencari produk berdasarkan kriteria

        System.out.println("\nHASIL PENCARIAN:"); // Menampilkan hasil pencarian
        System.out.println("==============================================================="); // Garis pemisah
        System.out.printf("%-5s | %-25s | %-15s | %-10s | %-10s\n", 
                          "ID", "Nama Produk", "Kategori", "Harga", "Stok"); 
        // Menampilkan header tabel
        System.out.println("---------------------------------------------------------------"); // Garis pemisah

        if (hasilPencarian.size() > 0) { // Jika ada produk yang ditemukan
            for (Produk p : hasilPencarian) { // Iterasi melalui daftar hasil pencarian
                System.out.println(p); // Menampilkan informasi produk yang ditemukan
            }
        } else { // Jika tidak ada produk yang ditemukan
            System.out.println("Tidak ada produk yang sesuai dengan kriteria pencarian."); 
            // Menampilkan pesan bahwa tidak ada produk yang cocok
        }
        System.out.println("==============================================================="); // Garis pemisah akhir

        scanner.close(); // Menutup objek Scanner untuk membebaskan sumber daya
    }

    // Metode untuk mencari produk berdasarkan kriteria (kategori, harga minimum, dan harga maksimum)
    public static ArrayList<Produk> cariProdukByKriteria(Produk[] daftarProduk, 
                                                         String kategori, 
                                                         double hargaMin, 
                                                         double hargaMax) {
        ArrayList<Produk> hasilPencarian = new ArrayList<>(); // Membuat daftar untuk menyimpan hasil pencarian

        for (int i = 0; i < daftarProduk.length; i++) { // Melakukan iterasi pada array daftarProduk
            Produk produk = daftarProduk[i]; // Mengambil produk saat ini

            // Periksa apakah produk memenuhi semua kriteria
            if (produk.kategori.equalsIgnoreCase(kategori) && // Periksa kecocokan kategori (tidak case-sensitive)
                produk.harga >= hargaMin && // Periksa apakah harga >= harga minimum
                produk.harga <= hargaMax) { // Periksa apakah harga <= harga maksimum
                hasilPencarian.add(produk); // Tambahkan produk ke daftar hasil pencarian
            }
        }

        return hasilPencarian; // Mengembalikan daftar hasil pencarian
    }
}