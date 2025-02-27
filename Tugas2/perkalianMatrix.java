public class perkalianMatrix {
    public static void main(String[] args) { // main method
        // Program operasi matriks
        int[][] matriksA = { // deklarasi dan inisialisasi
            {1, 2},
            {3, 4}
        };

        int[][] matriksB = { // deklarasi dan inisialisasi
            {5, 6},
            {7, 8}
        };

        // Perkalian matriks
        int[][] hasil = new int[2][2]; // deklarasi dan inisialisasi

        for (int i = 0; i < hasil.length; i++) { // looping untuk perkalian matriks
            for (int j = 0; j < hasil.length; j++) { // looping untuk perkalian matriks
                for (int k = 0; k < hasil.length; k++) { // looping untuk perkalian matriks
                    hasil[i][j] += (matriksA[i][k] * matriksB[k][j]); // menyimpan hasil perkalian
                } //menutup code
            } //menutup code
        } //menutup code

        // Menampilkan hasil
        System.out.println("Hasil perkalian matriks:"); // mencetak tulisan hasil perkalian matriks
        for (int[] baris : hasil) { // iterasi array
            for (int nilai : baris) { // iterasi array
                System.out.print(nilai + " "); // mencetak nilai dan beri spasi antar nilai
            }
            System.out.println(); // mencetak baris kosong
        } //menutup code
    } //menutup code
} //menutup code
