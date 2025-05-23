import java.util.Scanner; // Mengimpor kelas Scanner untuk mengambil input dari pengguna

// Kelas Buku merepresentasikan informasi tentang sebuah buku
class Buku {
    String isbn; // Nomor ISBN buku
    String judul; // Judul buku
    String penulis; // Nama penulis buku
    int tahunTerbit; // Tahun terbit buku

    // Konstruktor untuk menginisialisasi objek Buku
    public Buku(String isbn, String judul, String penulis, int tahunTerbit) {
        this.isbn = isbn;
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    // Metode untuk menampilkan informasi buku dalam format yang rapi
    @Override
    public String toString() {
        return String.format("ISBN: %s\nJudul: %s\nPenulis: %s\nTahun Terbit: %d",
                            isbn, judul, penulis, tahunTerbit);
    }
}

// Kelas utama untuk sistem pencarian buku menggunakan binary search
public class PencarianBuku {
    public static void main(String[] args) { // Metode utama untuk menjalankan program
        // Data buku yang sudah diurutkan berdasarkan ISBN
        Buku[] daftarBuku = {
            new Buku("9780071606301", "Java: The Complete Reference", "Herbert Schildt", 2007),
            new Buku("9780132222204", "Effective Java", "Joshua Bloch", 2008),
            new Buku("9780132778046", "Head First Java", "Kathy Sierra & Bert Bates", 2005),
            new Buku("9780134685991", "Effective Python", "Brett Slatkin", 2019),
            new Buku("9780135957059", "Clean Code", "Robert C. Martin", 2008),
            new Buku("9780137081073", "The Clean Coder", "Robert C. Martin", 2011),
            new Buku("9780262033848", "Introduction to Algorithms", "Cormen, Leiserson, Rivest & Stein", 2009),
            new Buku("9780321356680", "Effective Java", "Joshua Bloch", 2008),
            new Buku("9780596009205", "Head First Design Patterns", "Eric Freeman & Elisabeth Robson", 2004)
        };

        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input pengguna

        System.out.println("=== SISTEM PENCARIAN BUKU PERPUSTAKAAN ===");
        System.out.print("Masukkan nomor ISBN buku yang dicari: ");
        String isbnCari = scanner.nextLine(); // Membaca input ISBN dari pengguna

        // Lakukan pencarian binary search
        int index = cariBukuByISBN(daftarBuku, isbnCari);

        System.out.println("\nHASIL PENCARIAN:");
        if (index != -1) { // Jika buku ditemukan, tampilkan informasinya
            System.out.println("Buku ditemukan!");
            System.out.println(daftarBuku[index]); // Menampilkan detail buku
        } else { // Jika buku tidak ditemukan, tampilkan pesan
            System.out.println("Buku dengan ISBN " + isbnCari + " tidak ditemukan.");
        }

        scanner.close(); // Menutup objek Scanner untuk mencegah kebocoran sumber daya
    }

    // Metode binary search untuk mencari buku berdasarkan ISBN
    public static int cariBukuByISBN(Buku[] daftarBuku, String isbn) {
        int low = 0; // Menetapkan batas bawah pencarian
        int high = daftarBuku.length - 1; // Menetapkan batas atas pencarian

        while (low <= high) { // Perulangan berjalan selama low masih lebih kecil atau sama dengan high
            int mid = low + (high - low) / 2; // Menghitung indeks tengah untuk menghindari overflow

            // Bandingkan ISBN
            int comparison = daftarBuku[mid].isbn.compareTo(isbn);

            // Jika ISBN sama, kembalikan indeks buku
            if (comparison == 0) {
                return mid;
            }

            // Jika ISBN yang dicari lebih kecil, cari di setengah kiri array
            if (comparison > 0) {
                high = mid - 1;
            }
            // Jika ISBN yang dicari lebih besar, cari di setengah kanan array
            else {
                low = mid + 1;
            }
        }

        // Jika buku tidak ditemukan, kembalikan -1
        return -1;
    }
}
