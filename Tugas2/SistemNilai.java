public class SistemNilai { //deklrasi
    public static void main(String[] args) { //main method
        // Data siswa
        String[] namaSiswa = {"Ani", "Budi", "Cici", "Dodi", "Edi"}; //deklarasi dan inisialisasi
        int[][] nilai = { //deklarasi dan inisialisasi
            {80, 85, 90}, // Nilai Ani
            {75, 70, 85}, // Nilai Budi
            {85, 80, 88}, // Nilai Cici
            {90, 85, 95}, // Nilai Dodi
            {70, 75, 80}  // Nilai Edi
        }; //menutup kode
        String[] mapel = {"Matematika", "Bahasa Inggris", "IPA"}; //deklarasi dan inisialisasi

        // Menghitung rata-rata per siswa
        System.out.println("Rata-rata nilai per siswa:"); //mencetak tulisan rata rata nilai per siswa
        for (int i = 0; i < nilai.length; i++) { //looping mencari nilai persiswa
            double total = 0; //deklarasi dan inisialisasi
            for (int n : nilai[i]) { //iterasi array
                total += n; //nilai n akan di simpan dan di tambah di variabel total
            } //menutup kode
            double rataSiswa = total / nilai[i].length; //menghitung rata rata per siswa
            System.out.printf("%s: %.2f\n", namaSiswa[i], rataSiswa); //mencetak nama siswa dan nilai per siswa
        } //menutup kode 

        // Menghitung rata-rata per mata pelajaran
        System.out.println("\nRata-rata nilai per mata pelajaran:"); //mencetak tulisan rata rata per mata pelajaran
        for (int j = 0; j < nilai[0].length; j++) { //looping mencari total nilai per mapel
            double total = 0; //deklrasi dan inisialisasi
            for (int i = 0; i < nilai.length; i++) { //looping untuk mentotal nilai per mapel
                total += nilai[i][j]; //menjumlah nilai per mapel di varibael total
            } //menutup kode
            double rataMapel = total / nilai.length; //menghitung rata rata total nilai per mapel
            System.out.printf("%s: %.2f\n", mapel[j], rataMapel); //mencetak nilai per mapel
        } //menutup kode
    } //menutup kode
}//menutup kode
