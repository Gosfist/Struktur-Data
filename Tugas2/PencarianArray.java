public class PencarianArray { //deklrasi
    public static void main(String[] args) { //main method
        // Program mencari nilai dalam array
        int[] nilai = {75, 80, 65, 90, 85, 70, 95, 88}; //deklrasi dan inisialisasi
        int cari = 90; //deklarasi dan inisialisasi
        boolean ketemu = false; //deklarasi dan inisialisasi
        int indeks = -1; //deklrasi dan inisialisasi

        // Mencari nilai
        for (int i = 0; i < nilai.length; i++) { //looping untuk mencari nilai
            if (nilai[i] == cari) { //untuk mencocokan nilai yang dicari dengan yang ada di array
                ketemu = true; //jika cocok maka variabel ketemu bernilai true
                indeks = i; //variabel indeks akan bernilai sesuai i 
                break; //keluar dari perulangan / looping
            } //menutup kode
        } //menutup kode

        // Menampilkan hasil
        if (ketemu) { //jika varibel ketemu bernilai true maka akan lanjut ke kode berikutnya
            System.out.println("Nilai " + cari + " ditemukan pada indeks " + indeks); //mencetak nilai yang dicaari ditemukan
        } else { //jika varibel ketemu bernilai false maka akan ke kode berikutnya
            System.out.println("Nilai " + cari + " tidak ditemukan"); //mencetak nilai yang dicari tidak ditemukan
        } //menutup kode
    } //menutup kode
} //menutup kode
