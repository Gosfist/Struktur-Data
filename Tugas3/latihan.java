import java.util.List;
import java.util.ArrayList;

public class latihan {
    public static void main(String[] args) {
        List<String> daftarNama = new ArrayList<>();

        daftarNama.add("Budi");
        daftarNama.add(1, "toni");


        for (int i = 0; i < 2; i++) {
            System.out.println(daftarNama.get(i));
        }
        System.out.println("hai");
    }
}