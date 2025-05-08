import java.util.ArrayList; // Mengimpor kelas ArrayList untuk membuat daftar dinamis
import java.util.Scanner; // Mengimpor kelas Scanner untuk membaca input dari pengguna

public class PencarianKata { // Kelas utama untuk menjalankan program
    public static void main(String[] args) { // Metode utama 
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input dari pengguna

        System.out.println("=== SISTEM PENCARIAN KATA ==="); // Menampilkan judul program
        System.out.print("Masukkan teks: "); // Meminta pengguna memasukkan teks
        String teks = scanner.nextLine(); // Membaca input teks dari pengguna

        System.out.print("Masukkan kata yang dicari: "); // Meminta pengguna memasukkan kata yang dicari
        String kataCari = scanner.nextLine(); // Membaca input kata dari pengguna

        // Lakukan pencarian kata
        ArrayList<Integer> posisiDitemukan = cariKata(teks, kataCari); 
        // Memanggil metode cariKata untuk mencari posisi kata dalam teks

        System.out.println("\nHASIL PENCARIAN:"); // Menampilkan hasil pencarian
        if (posisiDitemukan.size() > 0) { // Jika kata ditemukan
            System.out.println("Kata '" + kataCari + "' ditemukan sebanyak " +
                               posisiDitemukan.size() + " kali pada posisi:"); 
            // Menampilkan jumlah kata yang ditemukan

            for (int i = 0; i < posisiDitemukan.size(); i++) { // Iterasi melalui daftar posisi kata yang ditemukan
                System.out.println("- Indeks ke-" + posisiDitemukan.get(i) +
                                   " (karakter ke-" + (posisiDitemukan.get(i) + 1) + ")"); 
                // Menampilkan posisi indeks dan karakter dari kata yang ditemukan
            }

            // Tampilkan teks dengan highlight kata yang ditemukan
            System.out.println("\nTeks dengan highlight:"); // Menampilkan teks dengan highlight
            tampilkanTeksHighlight(teks, kataCari, posisiDitemukan); 
            // Memanggil metode tampilkanTeksHighlight untuk menampilkan teks dengan highlight
        } else { // Jika kata tidak ditemukan
            System.out.println("Kata '" + kataCari + "' tidak ditemukan dalam teks."); 
            // Menampilkan pesan bahwa kata tidak ditemukan
        }

        scanner.close(); // Menutup objek Scanner untuk membebaskan sumber daya
    }

    // Metode untuk mencari kata dalam teks dan mengembalikan daftar posisi
    public static ArrayList<Integer> cariKata(String teks, String kata) {
        ArrayList<Integer> posisi = new ArrayList<>(); // Membuat daftar untuk menyimpan posisi kata yang ditemukan

        // Konversi ke lowercase untuk pencarian case-insensitive
        String teksLower = teks.toLowerCase(); // Mengubah teks menjadi huruf kecil
        String kataLower = kata.toLowerCase(); // Mengubah kata menjadi huruf kecil

        int panjangKata = kataLower.length(); // Mendapatkan panjang kata yang dicari
        int panjangTeks = teksLower.length(); // Mendapatkan panjang teks

        // Lakukan linear search
        for (int i = 0; i <= panjangTeks - panjangKata; i++) { // Iterasi melalui teks
            // Periksa apakah substring dari posisi i sampai i+panjangKata sama dengan kata
            String potongan = teksLower.substring(i, i + panjangKata); // Mengambil potongan substring

            if (potongan.equals(kataLower)) { // Jika potongan substring cocok dengan kata
                posisi.add(i); // Menambahkan posisi ke daftar

                // Optional: Skip ke akhir kata yang ditemukan untuk menghindari overlap
                // i += panjangKata - 1; // (dapat diaktifkan jika ingin menghindari overlap)
            }
        }

        return posisi; // Mengembalikan daftar posisi kata yang ditemukan
    }

    // Metode untuk menampilkan teks dengan highlight pada kata yang ditemukan
    public static void tampilkanTeksHighlight(String teks, String kata, ArrayList<Integer> posisi) {
        StringBuilder hasil = new StringBuilder(teks); // Membuat StringBuilder untuk memodifikasi teks

        // Tambahkan marker untuk highlight (dari posisi terjauh dulu untuk menghindari pergeseran indeks)
        for (int i = posisi.size() - 1; i >= 0; i--) { // Iterasi dari posisi terakhir ke pertama
            int pos = posisi.get(i); // Mendapatkan posisi kata
            hasil.insert(pos + kata.length(), "]"); // Menyisipkan tanda penutup "]" setelah kata
            hasil.insert(pos, "["); // Menyisipkan tanda pembuka "[" sebelum kata
        }

        System.out.println(hasil.toString()); // Menampilkan teks dengan highlight
    }
}