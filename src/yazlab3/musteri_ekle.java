package yazlab3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class musteri_ekle extends JFrame {

    private JPanel contentPane;
    private JTextArea textArea;
    static ArrayList<String> musteriler=new ArrayList<>();
    public static int sayi=0;
    private JTextField txtMusteriBeklemeSuresi;
    private JTextField txtSiparisAlmaSuresi;
    private JTextField txtYemekHazirlamaSuresi;
    private JTextField txtYemekYemeSuresi;
    private JTextField txtOdemeIslemiSuresi;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    musteri_ekle frame = new musteri_ekle();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public musteri_ekle() {

        getContentPane().setBackground(new Color(175, 176, 251));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 642, 490);
        getContentPane().setLayout(null);

        JButton ekleButton = new JButton("Müşteri Ekle");
        ekleButton.setBounds(490, 122, 120, 30);
        getContentPane().add(ekleButton);

        textArea = new JTextArea();
        textArea.setBounds(30, 24, 428, 257);
        getContentPane().add(textArea);
        
        JButton btnGeri = new JButton("Geri");
        btnGeri.setBounds(490, 177, 120, 30);
        getContentPane().add(btnGeri);
        
        JButton btnBaslat = new JButton("Baslat");
        btnBaslat.setBounds(490, 230, 120, 30);
        getContentPane().add(btnBaslat);
        btnBaslat.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		musteri_ekle.super.setVisible(false);
          		 gorsel.musteribeklemesuresi = Integer.parseInt(txtMusteriBeklemeSuresi.getText());
                 garson.siparisalmasuresi = Integer.parseInt(txtSiparisAlmaSuresi.getText());
                 asci.yemekhazirlamasuresi = Integer.parseInt(txtYemekHazirlamaSuresi.getText());
                 musteri.yemekyemesuresi=Integer.parseInt(txtYemekYemeSuresi.getText());
                 kasa.hesapalmasuresi=Integer.parseInt(txtOdemeIslemiSuresi.getText());
          		gorsel gorsel = new gorsel(musteriler);
          		gorsel.setVisible(true);
          	}
          });
        btnGeri.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		musteri_ekle.super.setVisible(false);
          		anapanel anapanel = new anapanel();
          		anapanel.setVisible(true);
          	}
          });
        JLabel lblMusteriBekleme = new JLabel("Müşteri Bekleme Süresi:");
        lblMusteriBekleme.setBounds(10, 323, 160, 20);
        getContentPane().add(lblMusteriBekleme);

        txtMusteriBeklemeSuresi = new JTextField();
        txtMusteriBeklemeSuresi.setBounds(173, 321, 150, 25);
        getContentPane().add(txtMusteriBeklemeSuresi);
        txtMusteriBeklemeSuresi.setText(String.valueOf(gorsel.musteribeklemesuresi));

        JLabel lblSiparisAlma = new JLabel("Sipariş Alma Süresi:");
        lblSiparisAlma.setBounds(10, 353, 160, 20);
        getContentPane().add(lblSiparisAlma);

        txtSiparisAlmaSuresi = new JTextField();
        txtSiparisAlmaSuresi.setBounds(173, 351, 150, 25);
        getContentPane().add(txtSiparisAlmaSuresi);
        txtSiparisAlmaSuresi.setText(String.valueOf(garson.siparisalmasuresi));
        JLabel lblYemekHazirlama = new JLabel("Yemek Hazırlama Süresi:");
        lblYemekHazirlama.setBounds(10, 389, 160, 20);
        getContentPane().add(lblYemekHazirlama);

        txtYemekHazirlamaSuresi = new JTextField();
        txtYemekHazirlamaSuresi.setBounds(173, 387, 150, 25);
        getContentPane().add(txtYemekHazirlamaSuresi);
        txtYemekHazirlamaSuresi.setText(String.valueOf(asci.yemekhazirlamasuresi));
        
        JLabel lblYemekYeme = new JLabel("Yemek Yeme Süresi:");
        lblYemekYeme.setBounds(333, 323, 160, 20);
        getContentPane().add(lblYemekYeme);

        txtYemekYemeSuresi = new JTextField();
        txtYemekYemeSuresi.setBounds(466, 321, 150, 25);
        getContentPane().add(txtYemekYemeSuresi);
       txtYemekYemeSuresi.setText(String.valueOf(musteri.yemekyemesuresi));

        JLabel lblOdemeIslemi = new JLabel("Ödeme İşlemi Süresi:");
        lblOdemeIslemi.setBounds(333, 354, 160, 20);
        getContentPane().add(lblOdemeIslemi);

        txtOdemeIslemiSuresi = new JTextField();
        txtOdemeIslemiSuresi.setBounds(466, 351, 150, 25);
        getContentPane().add(txtOdemeIslemiSuresi);
        txtOdemeIslemiSuresi.setText(String.valueOf(kasa.hesapalmasuresi));

        ekleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (sayi!=10)
            	{
            		String musteriID = JOptionPane.showInputDialog("Müşteri ID'sini giriniz:");
                    String musteriAdi = JOptionPane.showInputDialog("Müşteri adını giriniz:");

                    if (musteriID != null && !musteriID.isEmpty() && musteriAdi != null && !musteriAdi.trim().isEmpty()) {
                        
                        String oncelikStr = JOptionPane.showInputDialog("Müşteri önceliğini giriniz (true/false):");
                        boolean oncelik = Boolean.parseBoolean(oncelikStr);
                        
                        String musteriBilgisi;
                        
                        if(oncelik == false)
                        {
                         musteriBilgisi = "Müşteri ID: " + musteriID + " - Müşteri Adı: " + musteriAdi + " - Öncelik: " + "65 yaş üstü değil";
                         
                        }
                        else {
                        	 musteriBilgisi = "Müşteri ID: " + musteriID + " - Müşteri Adı: " + musteriAdi + " - Öncelik: " + "65 yaş üstü";
                        	 
    					}
                        musteriler.add(musteriID);
                        musteriler.add(musteriAdi);
                        musteriler.add(oncelikStr);
                        sayi++;
                        
                        
                        JLabel profilResmi = new JLabel(new ImageIcon("path/to/your/image.jpg"));
                        textArea.add(profilResmi);
                        textArea.append(musteriBilgisi + "\n");
                    } else {
                        
                        JOptionPane.showMessageDialog(null, "Bilgileri eksiksiz giriniz.", "Hata", JOptionPane.ERROR_MESSAGE);
                    }
            	}
            	if (sayi ==10)
            	{
            		JOptionPane.showMessageDialog(null, "En fazla 10 müşteri eklenebilir.", "Hata", JOptionPane.ERROR_MESSAGE);
            	}
            			
                                
            }
        });



    }
}