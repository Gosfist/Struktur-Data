public class StatistikArray { //deklrasi 
    public static void main(String[] args) { //main method
        // Program menghitung statistik nilai siswa
        int[] nilai = {75, 80, 65, 90, 85, 70, 95, 88}; //deklrasi dan innisialisasi

        // Mencari nilai tertinggi dan terendah
        int tertinggi = nilai[0]; //deklrasi dan innisialisasi
        int terendah = nilai[0]; //deklrasi dan innisialisasi
        int total = nilai[0]; //deklrasi dan innisialisasi

        for (int i = 1; i < nilai.length; i++) { //looping mencari nilai terendah, tertinggi, dan rata rata
            if (nilai[i] > tertinggi) tertinggi = nilai[i]; //jika nilaix lebih besar dari pada nilai tertinggi maka akan disimpan di variabel tertinggi
            if (nilai[i] < terendah) terendah = nilai[i]; //jika nilaix lebih kecil dari pada nilai terendah maka akan disimpan di variabel terendah
            total += nilai[i]; //total= total+nilaix berguna menyimpan nilai total semua angka nantinya
        } //menutup kode

        double rataRata = (double) total / nilai.length; //menghitung rata rata

        System.out.println("Nilai tertinggi: " + tertinggi); //mencetak nilai tertinggi
        System.out.println("Nilai terendah: " + terendah); //mencetak nilai terendah
        System.out.println("Rata-rata: " + rataRata); //mencetak nilai rata rata
    } //menutup kode
} //menutup kode
