import java.util.Arrays; // Mengimpor kelas Arrays untuk manipulasi array
import java.util.Comparator; // Mengimpor kelas Comparator untuk perbandingan elemen dalam array
import java.util.Scanner; // Mengimpor kelas Scanner untuk mengambil input dari pengguna

// Interface untuk mendefinisikan perilaku pencarian
interface Searchable<T> {
    int compare(T value); // Metode untuk membandingkan nilai yang dicari dengan elemen dalam array
}

public class GenericBinarySearch { // Kelas utama untuk implementasi pencarian binary search generik

    // Metode binary search generik yang menerima array tipe T dan objek pencarian
    public static <T> int binarySearch(T[] array, Searchable<T> searchable) {
        int low = 0; // Batas bawah pencarian
        int high = array.length - 1; // Batas atas pencarian

        while (low <= high) { // Perulangan selama batas bawah tidak melebihi batas atas
            int mid = low + (high - low) / 2; // Menghitung indeks tengah untuk menghindari overflow

            int comparison = searchable.compare(array[mid]); // Membandingkan elemen tengah dengan target

            if (comparison == 0) { // Jika sama, kembalikan indeksnya
                return mid;
            } else if (comparison < 0) { // Jika target lebih kecil, cari di setengah kiri
                high = mid - 1;
            } else { // Jika target lebih besar, cari di setengah kanan
                low = mid + 1;
            }
        }

        return -1; // Jika target tidak ditemukan
    }

    public static void main(String[] args) { // Metode utama untuk menjalankan program
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input pengguna

        System.out.println("=== SISTEM PENCARIAN DATASET ===");
        System.out.println("Pilih jenis data yang ingin dicari:");
        System.out.println("1. Integer");
        System.out.println("2. Double");
        System.out.println("3. String");
        System.out.print("Pilihan Anda (1-3): ");

        int pilihan = scanner.nextInt(); // Membaca pilihan tipe data
        scanner.nextLine(); // Membersihkan buffer input

        switch (pilihan) { // Menentukan jenis pencarian berdasarkan input pengguna
            case 1:
                // Pencarian nilai Integer
                Integer[] dataInteger = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}; // Array integer

                System.out.println("\nData Integer: " + Arrays.toString(dataInteger)); // Menampilkan data
                System.out.print("Masukkan nilai integer yang dicari: ");
                int targetInt = scanner.nextInt(); // Input nilai target

                int indexInt = binarySearch(dataInteger, new Searchable<Integer>() {
                    @Override
                    public int compare(Integer value) {
                        return targetInt - value; // Menghitung perbedaan antara target dan elemen
                    }
                });

                if (indexInt != -1) { // Menampilkan hasil pencarian
                    System.out.println("Nilai " + targetInt + " ditemukan pada indeks " + indexInt);
                } else {
                    System.out.println("Nilai " + targetInt + " tidak ditemukan dalam dataset");
                }
                break;

            case 2:
                // Pencarian nilai Double
                Double[] dataDouble = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9}; // Array double

                System.out.println("\nData Double: " + Arrays.toString(dataDouble)); // Menampilkan data
                System.out.print("Masukkan nilai double yang dicari: ");
                double targetDouble = scanner.nextDouble(); // Input nilai target

                int indexDouble = binarySearch(dataDouble, new Searchable<Double>() {
                    @Override
                    public int compare(Double value) {
                        return Double.compare(targetDouble, value); // Bandingkan target dengan elemen
                    }
                });

                if (indexDouble != -1) { // Menampilkan hasil pencarian
                    System.out.println("Nilai " + targetDouble + " ditemukan pada indeks " + indexDouble);
                } else {
                    System.out.println("Nilai " + targetDouble + " tidak ditemukan dalam dataset");
                }
                break;

            case 3:
                // Pencarian nilai String
                String[] dataString = {"alpha", "beta", "delta", "gamma", "omega", "sigma", "theta", "zeta"}; // Array string
                Arrays.sort(dataString); // Pastikan array terurut agar binary search berfungsi

                System.out.println("\nData String: " + Arrays.toString(dataString)); // Menampilkan data
                System.out.print("Masukkan string yang dicari: ");
                String targetString = scanner.nextLine(); // Input nilai target

                int indexString = binarySearch(dataString, new Searchable<String>() {
                    @Override
                    public int compare(String value) {
                        return targetString.compareTo(value); // Bandingkan target dengan elemen
                    }
                });

                if (indexString != -1) { // Menampilkan hasil pencarian
                    System.out.println("String \"" + targetString + "\" ditemukan pada indeks " + indexString);
                } else {
                    System.out.println("String \"" + targetString + "\" tidak ditemukan dalam dataset");
                }
                break;

            default:
                System.out.println("Pilihan tidak valid!"); // Pesan error jika input tidak sesuai
        }

        scanner.close(); // Menutup objek Scanner untuk mencegah kebocoran sumber daya
    }
}
