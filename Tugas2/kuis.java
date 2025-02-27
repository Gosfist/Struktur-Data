public class kuis { //deklrasi
    public static void main(String[] args) { //main method
        
        int[] number = new int[5]; // deklrasi dan inisialisasi
        
        number[0]=1; // inisialisasi
        number[1]=2; // inisialisasi
        number[2]=3; // inisialisasi
        number[3]=4; // inisialisasi
        number[4]=5; // inisialisasi

        System.out.print("Soal1: "); //mencetak tulisan soal1
        for (int i = 0; i < number.length; i++) { //looping untuk mencetak angka 1-5
                System.out.print(number[i]+" "); //mencetak angka 1-5     
        } //menutup kode
        System.out.println(); //mencetak lane kosong

        System.out.print("Soal2: "); //mencetak tulisan soal2
        for (int i = 0; i < number.length; i++) { //looping untuk mencetak angka 1-5 dengan ditambah , dibelakang angka 
                System.out.print(number[i]); //mencetak tulisan angka 1-5
                if (i<4) { //kondisi agar dibelakang 5 tidak diberi ,
                        System.out.print(","); //mencetak koma
            } //menutup kode
        } //menutup kode
        System.out.println(); //mencetak lane kosong
        
        System.out.print("Soal3: "); //mencetak tulisan soal3
        for (int i = 0; i < number.length; i++) { //looping untuk mencetak angka ganjil
            if (i%2==0) { //mengecek apakah i modulus 2 = nol
                System.out.print(number[i]); //mencetak angka i yang bernilai true pada kondisi if diatas
                if (i<4) { //mengecek lagi apakah i kurang dari 4 agar , tidak ada di angka paling belakang
                        System.out.print(","); //mencetak koma
                    } //menutup kode
            } //menutup kode     
        } //menutup kode
        System.out.println(); //mencetak lane kosong

        System.out.print("Soal4: "); //mencetak tulisan soal4
        for (int i = 4; i > -1; i--) { //looping mencetak angka ganjil tapi di mulai dari belakang mencetaknya
            if (i%2==0) { //mengecek kondisi apakah i habis dibagi 2 = nol
                System.out.print(+number[i]); //mencetak angka i yang bernilai true pada kondisi if diatas
                if (i>1) { //mengecek kondisi apakah i lebih besar dari 1
                    System.out.print(","); //mencetak koma
                } //menutup kode
            } //menutup kode
        } //menutup kode
        System.out.println(); //mencetak lane kosong

        System.out.print("Soal5: "); //mencetak tulisan soal5
        for (int i = 0; i < number.length; i++) { //looping untuk mencetak angka genap
            if (i%2==1) { //mengecek apakah i habis dibagi 2 = 1
                System.out.print(+number[i]); //mencetak angka i
                if (i<2) { //mengecek apakah i kurang dari 2
                    System.out.print(","); //mencetak koma
                } //menutup kode 
            } //menutup kode     
        } //menutup kode
        System.out.println(); //mencetak lane kosong

        System.out.print("Soal6: "); //mencetak tulisan soal6
        for (int i = 0; i < number.length; i++) { //looping untuk mencetak angka 1,1,3,2,5
            if (i%2==0) { //mengecek apakah i habis dibagi 2 bernilai 0 
              System.out.print(number[i]); //mencetak angka i
              if (i<number.length-1) { //mengecek apakah i kurang dari 4
                  System.out.print(","); //mencetak koma
              } //menutup kode
            } //menutup kode  
            if (i%2==1) { //mengecek apakah i habis di bagi 2 adalah 1
              System.out.print(number[i/2]+","); //mencetak koma
            } //menutup kode
        } //menutup kode
    } //menutup kode
} //menutup kode
