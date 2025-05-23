public class BinarySearch { // Deklarasi kelas utama BinarySearch
    // Metode binary search iteratif
    public static int binarySearch(int[] arr, int target) { // Metode untuk mencari elemen dalam array
        int low = 0; // Menetapkan batas bawah pencarian
        int high = arr.length - 1; // Menetapkan batas atas pencarian

        while (low <= high) { // Perulangan berjalan selama low masih lebih kecil atau sama dengan high
            // Cari indeks tengah menggunakan formula untuk menghindari overflow
            int mid = low + (high - low) / 2; 

            // Jika elemen tengah adalah target, kembalikan indeksnya
            if (arr[mid] == target) {
                return mid;
            }

            // Jika target lebih kecil dari elemen tengah, abaikan setengah kanan array
            if (arr[mid] > target) {
                high = mid - 1;
            }
            // Jika target lebih besar dari elemen tengah, abaikan setengah kiri array
            else {
                low = mid + 1;
            }
        }

        // Jika target tidak ditemukan, kembalikan -1
        return -1;
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
