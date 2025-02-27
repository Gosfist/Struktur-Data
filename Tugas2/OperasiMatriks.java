public class OperasiMatriks { //deklrasi
    public static void main(String[] args) { //main method
        // Program operasi matriks
        int[][] matriksA = { // deklrasi dan inisialisasi
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] matriksB = { // deklrasi dan inisialisasi
            {7, 8, 9},
            {10, 11, 12}
        };

        // Penjumlahan matriks
        int[][] hasil = new int[2][3]; // deklrasi dan inisialisasi

        for (int i = 0; i < matriksA.length; i++) { //looping untuk penjumlahan matrix 
            for (int j = 0; j < matriksA[0].length; j++) {  //agar kolom terjumlahkan semua 
                hasil[i][j] = matriksA[i][j] + matriksB[i][j]; //menyimpan hasil penjumlahan 
            } //menutup kode
        } //menutup kode

        // Menampilkan hasil
        System.out.println("Hasil penjumlahan matriks:"); //mencetak tulisan hasil penjumlahan matriks
        for (int[] baris : hasil) { //iterasi array
            for (int nilai : baris) { //iterasi array
                System.out.print(nilai + " "); //mencetak nilai dan beri spasi antar nilai
            } //menutup kode
            System.out.println(); //mencetak lane kosong
        } //menutup kode
    } //menutup kode
} //menutup kode
