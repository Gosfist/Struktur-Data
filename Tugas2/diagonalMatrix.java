import java.util.Scanner; //library scanner yang ada di java

public class diagonalMatrix { //deklrasi
    public static void main(String[] args) { //main method
        Scanner input = new Scanner(System.in); //deklarasi nama scanner

        System.out.print("Masukkan ukuran matriks (x * x): "); //mencetak tulisan masukan ukuran matriks
        int ukuran = input.nextInt(); //inputan matriks akan di simpan di variabel ukuran

        int[][] matriks = new int[ukuran][ukuran]; //deklrasi dan inisialisasi

        System.out.println("Masukkan elemen matriks:"); //mencetak tulisan masukan elemen matriks
        for (int i = 0; i < ukuran; i++) { //looping untuk memasukan elemen matrix
            for (int j = 0; j < ukuran; j++) { //looping untuk memasukan elemen matrix
                matriks[i][j] = input.nextInt(); //inputan akan di simpan di matrix 
            } //menutup kode
        } //menutup kode
        System.out.println(); //mencertak lane kosong

        System.out.println("Hasil Matrix "); //mencetrak tulisan hasil matrix
        for (int i = 0; i < ukuran; i++) { //looping ini bagian row
            for (int j = 0; j < ukuran; j++) { //looping ini bagian kolom
                System.out.print(matriks[i][j]+" "); //mencetak hasil looping
            } //menutup kode
            System.out.println(); //mencetak lane kososng
        } //menutup code

        System.out.print("Diagonal Utama Matriks: "); //mencetak tulisan diagonal utama matrix
        for (int i = 0; i < ukuran; i++) {  //looping untuk mencetak diagonal utama
            System.out.print(matriks[i][i] + " "); //mencertak diagonal utama
        } //menutup kode
        System.out.println(); //mencertak lane kosong

        // Menampilkan Diagonal Samping
        System.out.print("Diagonal Samping Matriks: "); //mencetak tulisan diagonal samping matrix
        for (int i = 0; i < ukuran; i++) { //looping untuk mencetak diagonal samping
            System.out.print(matriks[i][ukuran - 1 - i] + " ");  //mencertak diagonal samping
        } //menutup code
        System.out.println(); //mencertak lane kosong
    } //menutup kode
} //menutup kode