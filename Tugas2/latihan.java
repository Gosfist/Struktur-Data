public class latihan {
    public static void main(String[] args) {
        // deklrasi dan inisialisasi
        int[] number = new int[5];
        // inisialisasi
        number[0]=1; 
        number[1]=2; 
        number[2]=3; 
        number[3]=4;
        number[4]=5;



        System.out.print("Soal1: ");
        for (int i = 0; i < number.length; i++) {
                System.out.print(number[i]+" ");     
        }
        System.out.println();

        System.out.print("Soal2: ");
        for (int i = 0; i < number.length; i++) {
                System.out.print(number[i]);  
                if (i<4) {
                        System.out.print(",");
            }     
        }
        System.out.println();
        
        System.out.print("Soal3: ");
        for (int i = 0; i < number.length; i++) {
            if (i%2==0) {
                System.out.print(number[i]);  
                if (i<4) {
                        System.out.print(",");
                    } 
            }     
        }
        System.out.println();

        System.out.print("Soal4: ");
        for (int i = 4; i > -1; i--) {
            if (i%2==0) {
                System.out.print(+number[i]); 
                if (i>1) {
                    System.out.print(",");
                }
            } 
        }
        System.out.println();

        System.out.print("Soal5: ");
        for (int i = 0; i < number.length; i++) {
            if (i%2==1) {
                System.out.print(+number[i]);  
                if (i<2) {
                    System.out.print(",");
                } 
            }     
        }
        System.out.println();

        System.out.print("Soal6: ");
        for (int i = 0; i < number.length; i++) {
            if (i%2==0) {
              System.out.print(number[i]);
              if (i<number.length-1) {
                  System.out.print(",");
              }
            }  
            if (i%2==1) {
              System.out.print(number[i/2]+",");
            }
        }

    }
}
