package yazlab3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DosyaYazici {

    private static final Object lock = new Object(); 
    private static final String dosyaYolu = "dosya.txt";
    
    
    
    
    public static void stringEkle(String metin) {
        synchronized (lock) { 
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaYolu, true))) {
                writer.write(metin + "\n"); // Metni dosyaya yaz
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
