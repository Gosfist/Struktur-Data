public class LatihanArray1 { //deklrasi 
    public static void main(String[] args) { //main method
        // Buat program untuk:
        // 1. Membuat array dengan 10 bilangan bulat
        // 2. Mengisi array dengan bilangan genap mulai dari 2
        // 3. Menampilkan isi array
        // 4. Menghitung jumlah semua elemen array

        int[] bilanganGenap = new int[10]; //Deklrasi dan inisialisasi
        int jumlah = 0; //Deklrasi dan inisialisasi

        // Mengisi array
        for (int i = 0; i < bilanganGenap.length; i++) { //untuk mengisi nilai array 
            bilanganGenap[i] = (i + 1) * 2; //nilai akan di simpan di array bilanganGenap dengan hasil perkalian 2
        } //menutup kode

        // Menampilkan array
        System.out.println("Isi array:"); //mencetak tulisan isi array
        for (int bilangan : bilanganGenap) { //untuk mengambil nilai pada bilanganGenap secara satu satu dan disimpan di bilangan
            System.out.print(bilangan + " "); //mencetak bilangan yang di dapat dari bilangan genap dan diberikan spasi antar bilangan
            jumlah += bilangan; //bilangan yang sudah di cetak akan di simpan di variabel jumlah. jumlah = bilangan + jumlah. 
        } //menutup kode

        System.out.println("\nJumlah semua elemen: " + jumlah); //mencetak nama jumlah semua elemen yang di simpan di variabel jumlah
    } //menutup kode
} //menutup kode
