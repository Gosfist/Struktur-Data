import java.util.Scanner;

public class uas2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] daftarMenu = {"Nasi Goreng","Mie Goreng","Roti Bakar","Kentang Goreng","Teh Tarik","Cappucino","Chocolate Ice"};
        int[] hargaMenu = {20000,15000,12000,10000,8000,20000,25000};
        int pilihan;
        int index=0;
        int maxData = 100;
        int totalBiaya=0;
        int[][] daftarPesanan = new int[maxData][2];
        String [] menuDipesan = new String[maxData];

        System.out.println("=== Selamat Datang Di Kafe ===");
        System.out.println();
        System.out.println("=== Menu ===");
        for (int i = 0; i < hargaMenu.length; i++) {
            System.out.println((i+1)+". "+daftarMenu[i]+" - Rp"+hargaMenu[i]);
        }
        System.out.println();
        do {
            System.out.println("Pilih opsi berikut: ");
            System.out.println("1. Tambah pesanan");
            System.out.println("2. Lihat daftar pesanan");
            System.out.println("3. Hitung total biaya");
            System.out.println("4. Selesai");
            System.out.print("Masukan pilhan anda: ");
            pilihan = input.nextInt();
            
            if (pilihan==1) {
                do {
                    System.out.print("Masukan nomer menu yang ingin dipesan: ");
                    pilihan = input.nextInt();
                    if (pilihan>0 && pilihan <8 ) {
                        System.out.print("Masukan jumlah pesanan: ");
                        int jumlahPesanan = input.nextInt();
                        input.nextLine();
                        boolean cek=true;

                        for (int i = 0; i < index; i++) {
                            if (menuDipesan[i].equalsIgnoreCase(daftarMenu[pilihan-1])) {
                                daftarPesanan[i][0] += jumlahPesanan;
                                daftarPesanan[i][1] += jumlahPesanan*hargaMenu[pilihan-1];
                                totalBiaya += jumlahPesanan*hargaMenu[pilihan-1];
                                System.out.println(jumlahPesanan+" "+menuDipesan[i]+" berhasil ditambahkan ke pesanan");
                                System.out.println();
                                cek = false;
                                break;
                            }
                        }
                        if (cek) {
                            daftarPesanan[index][0] += jumlahPesanan;
                            daftarPesanan[index][1] = jumlahPesanan*hargaMenu[pilihan-1];
                            totalBiaya += daftarPesanan[index][1];
                            menuDipesan[index] = daftarMenu[pilihan-1];
                            System.out.println(jumlahPesanan+" "+menuDipesan[index]+" berhasil ditambahkan ke pesanan");
                            System.out.println();
                            index++;
                            break;
                        }
                        
                    } else {
                        System.out.println("menu tidak valid. Coba lagi");
                        continue;
                    }
                   
                    break;
                } while (true);
                
            } else if (pilihan==2) {
                System.out.println();
                System.out.println("=== Daftar pesanan ===");
                for (int i = 0; i < index; i++) {
                    System.out.println((i+1)+" "+menuDipesan[i]+" x"+daftarPesanan[i][0]+" - Rp."+daftarPesanan[i][1]);
                }
                System.out.println("Total biaya sementara: "+totalBiaya);
                System.out.println();
            } else if (pilihan==3) {
                System.out.println("Total biaya seluruh pesanan: "+totalBiaya);
                System.out.println();
            } else if (pilihan==4) {
                break;
            } else {
                System.out.println("Menu tidak valid. Coba lagi");
                System.out.println();
            } 
                
           
        } while (true);
        
    }
}
