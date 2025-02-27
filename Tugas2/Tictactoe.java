public class Tictactoe { //deklrasi dan inisialisasi
    public static void main(String[] args) { //main methode
        char[][] papan = new char[3][3]; //deklrasi dan inisialisasi

        // Inisialisasi papan kosong
        for (int i = 0; i < 3; i++) { //looping untuk mencetak - 
            for (int j = 0; j < 3; j++) { //looping untuk mencetak - 
                papan[i][j] = '-'; //mencetak -
            } //menutup kode
        } //menutup kode

        // Simulasi beberapa langkah
        papan[0][0] = 'X'; //inisialisasi
        papan[1][1] = 'O'; //inisialisasi
        papan[2][2] = 'X'; //inisialisasi

        // Tampilkan papan
        System.out.println("Status Papan:"); //mencetak tulisan status papan 
        tampilkanPapan(papan); //mencetak papan yang sudah di isi diatas
    } //menutup kode

    public static void tampilkanPapan(char[][] papan) { //methode biasa dengan nama tampilkanPapan
        for (int i = 0; i < 3; i++) { //looping untuk memberikan spasi antar elemen
            for (int j = 0; j < 3; j++) { //looping untuk memberikan spasi antar elemen
                System.out.print(papan[i][j] + " "); //mencetak spasi 
            } //menutup kode
            System.out.println(); //mencetak lane kosong
        } //menutup kode
    } //menutup kode
} 
