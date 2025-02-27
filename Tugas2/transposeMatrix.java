public class transposeMatrix {
    public static void main(String[] args) { // main method
        // Program operasi matriks
        int[][] matriksA = { // deklarasi dan inisialisasi
            {1, 2, 3}, 
            {4, 5, 6}
        }; //menutup code

        System.out.println("Sebelum Transpose: "); //mencetak tulisan sebelum transpose
        for (int i = 0; i < matriksA.length; i++) { //looping ini bagian row
            for (int j = 0; j < matriksA[0].length; j++) { //looping ini bagian kolom
                System.out.print(matriksA[i][j]+" "); //mencetak hasil looping
            } //menutup kode
            System.out.println(); //mencetak lane kososng
        } //menutup code
        System.out.println(); //mencetak lane kososng
        System.out.println("Sesudah Transpose"); //mencetak tulisan sesudah transpose
        for (int i = 0; i < matriksA[0].length; i++) { //looping ini bagian kolom
            for (int j = 0; j < matriksA.length; j++) { //looping ini bagian row
                System.out.print(matriksA[j][i]+" "); //mencetak hasil looping
            } //menutup code
            System.out.println(); //mencetak lane kosong
        } //menutup code
    } //menutup code
} //menutup code
