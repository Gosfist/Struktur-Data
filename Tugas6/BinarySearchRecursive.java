public class BinarySearchRecursive { // Deklarasi kelas utama BinarySearchRecursive
    // Metode binary search rekursif
    public static int binarySearchRecursive(int[] arr, int target, int low, int high) { // Metode rekursif untuk binary search
        // Kasus dasar: jika batas bawah melebihi batas atas, elemen tidak ditemukan
        if (low > high) {
            return -1;
        }

        // Cari indeks tengah menggunakan formula untuk menghindari overflow
        int mid = low + (high - low) / 2;

        // Jika elemen tengah adalah target, kembalikan indeksnya
        if (arr[mid] == target) {
            return mid;
        }

        // Jika target lebih kecil dari elemen tengah, lakukan pencarian di setengah kiri
        if (arr[mid] > target) {
            return binarySearchRecursive(arr, target, low, mid - 1);
        }

        // Jika target lebih besar dari elemen tengah, lakukan pencarian di setengah kanan
        return binarySearchRecursive(arr, target, mid + 1, high);
    }

    // Metode wrapper untuk memanggil metode rekursif dengan batas awal dan akhir yang sesuai
    public static int binarySearch(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1); // Memanggil metode rekursif dengan parameter awal
    }

    public static void main(String[] args) { // Metode utama untuk menjalankan program
        // Deklarasi dan inisialisasi array yang sudah terurut
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};
        int target = 23; // Elemen yang akan dicari dalam array

        int result = binarySearch(arr, target); // Memanggil metode binarySearch dan menyimpan hasilnya

        // Mengecek apakah elemen ditemukan atau tidak
        if (result == -1) {
            System.out.println("Elemen " + target + " tidak ditemukan dalam array");
        } else {
            System.out.println("Elemen " + target + " ditemukan pada indeks " + result);
        }
    }
}
