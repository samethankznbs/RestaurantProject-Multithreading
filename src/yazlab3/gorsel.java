package yazlab3;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimerTask;
import java.util.Timer;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JLabel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import java.util.concurrent.*;

public class gorsel extends JFrame {

	static JTextArea textArea = new JTextArea();
	static JTextArea textArea1 = new JTextArea();
	 private static final int MASASAYISI = 6; // Masaların sayısı
	    private static final ExecutorService executorService = Executors.newFixedThreadPool(MASASAYISI);
	    private static final CountDownLatch latch = new CountDownLatch(MASASAYISI); // CountDownLatch
	private JPanel contentPane;
	 static ArrayList<musteri> musterilerim=new ArrayList<>();
	 public static String musteriAdi1="Müsteri Yok";
	 public static String musteriAdi2="Müsteri Yok";
	 public static String musteriAdi3="Müsteri Yok";
	 public static String musteriAdi4="Müsteri Yok";
	 public static String musteriAdi5="Müsteri Yok";
	 public static String musteriAdi6="Müsteri Yok";
	 public static String musteridurum1="";
	 public static String musteridurum2="";
	 public static String musteridurum3="";
	 public static String musteridurum4="";
	 public static String musteridurum5="";
	 public static String musteridurum6="";
	 public static JLabel lbllabelmasa1;
	 public static JLabel lbllabelmasa2;
	 public static JLabel lbllabelmasa3;
	 public static JLabel lbllabelmasa4;
	 public static JLabel lbllabelmasa5;
	 public static JLabel lbllabelmasa6;
	 public static JLabel lbllabelmasa1_1;
	 public static JLabel lbllabelmasa1_2;
	 public static JLabel lbllabelmasa1_3;
	 public static JLabel lbllabelmasa1_4;
	 public static JLabel lbllabelmasa1_5;
	 public static JLabel lbllabelmasa1_6;
	 public static JLabel garsonlabel_1;
	 public static JLabel garsonlabel_2;
	 public static JLabel garsonlabel_3;
	 public static JLabel ascilabel_1;
	 public static JLabel ascilabel_2;
	 public static String garsondurum1="Garson Bekliyor";
	 public static String garsondurum2="Garson Bekliyor";
	 public static String garsondurum3="Garson Bekliyor";
	 public static String ascidurum1="Aşçı Bekliyor";
	 public static String ascidurum2="Aşçı Bekliyor";
	 public static int odemesayi=0;
	
	 public static JLabel odemesayilabel ;
	 public static int musteribeklemesuresi=40;
	 
	 
	 static ArrayList<garson> garsonlar=new ArrayList<>();
	 private JLabel lblNewLabelResimAsci;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gorsel frame = new gorsel(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param musteriler 
	 */
	public gorsel(ArrayList<String> musteriler) {
		
		
		
		
		for(int i=0;i<6;i++)
		{
			masa masa = new masa(i);
			garson.masalar.add(masa);
		}
		for(int i =0;i<3 ; i++)
		{
			garson garson =new garson(i);
			garsonlar.add(garson);
		}
		for(int i =0;i<2 ; i++)
		{
			asci asci =new asci(i);
			garson.ascilar.add(asci);
		}
		kasa kasa =  new kasa(0);
		boolean oncelik = false;
		int id;
		for(int i=0;i<musteriler.size();i=i+3)
		{
			id = Integer.parseInt(musteriler.get(i));
			if(musteriler.get(i+2).contains("true"))
			{
				oncelik=true;
			}
			else if (musteriler.get(i+2).contains("false"))
			{
				oncelik=false;
			}
			musteri musteri = new musteri(id, oncelik,musteriler.get(i+1));
			
		    musterilerim.add(musteri);
		   
		   
		    
		    
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1312, 757);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		// UI Manager üzerinden butonun arka plan rengini ayarlama
		UIManager.put("Button.background", new Color(69, 1, 164));
		UIManager.put("Button.opaque", true);
		
		JButton btnNewButton = new JButton("MASA 1");
		btnNewButton.setForeground(new Color(69, 1, 164));
		btnNewButton.setFont(new Font("Marker Felt", Font.BOLD, 16));
		btnNewButton.setBounds(29, 120, 117, 110);

	

		contentPane.add(btnNewButton);


		
		JButton btnMasa_1 = new JButton("MASA 3");
		btnMasa_1.setForeground(new Color(69, 1, 164));
		btnMasa_1.setFont(new Font("Marker Felt", Font.BOLD, 16));
		btnMasa_1.setBounds(29, 349, 117, 110);
		contentPane.add(btnMasa_1);
		JLabel lblNewLabelKasa = new JLabel("New label");
        lblNewLabelKasa.setBounds(617, 321, 60, 44);
        Image imgIcon2 = new ImageIcon(this.getClass().getResource("/4.png")).getImage();
        ImageIcon icon2 = new ImageIcon(imgIcon2);
        lblNewLabelKasa.setIcon(icon2);
        contentPane.add(lblNewLabelKasa);
          
        
     
      

        JLabel lblNewLabelBekle = new JLabel("New label");
        lblNewLabelBekle.setBounds(1058, 318, 60, 44);
        Image imgIcon3 = new ImageIcon(this.getClass().getResource("/3.png")).getImage();
        ImageIcon icon3= new ImageIcon(imgIcon3);
        lblNewLabelBekle.setIcon(icon3);
        contentPane.add(lblNewLabelBekle);
          
        
		
		
		JButton btnMasa_3 = new JButton("MASA 5");
		btnMasa_3.setForeground(new Color(69, 1, 164));
		btnMasa_3.setFont(new Font("Marker Felt", Font.BOLD, 16));
		btnMasa_3.setBounds(29, 586, 117, 110);
		contentPane.add(btnMasa_3);
		
		JButton btnMasa = new JButton("MASA 2");
		btnMasa.setForeground(new Color(69, 1, 164));
		btnMasa.setFont(new Font("Marker Felt", Font.BOLD, 16));
		btnMasa.setBounds(253, 120, 117, 110);
		contentPane.add(btnMasa);
		
		JButton btnMasa_2 = new JButton("MASA 4");
		btnMasa_2.setForeground(new Color(69, 1, 164));
		btnMasa_2.setFont(new Font("Marker Felt", Font.BOLD, 16));
		btnMasa_2.setBounds(253, 349, 117, 110);
		contentPane.add(btnMasa_2);
		
		JButton btnMasa_4 = new JButton("MASA 6");
		btnMasa_4.setForeground(new Color(69, 1, 164));
		btnMasa_4.setFont(new Font("Marker Felt", Font.BOLD, 16));
		btnMasa_4.setBounds(253, 586, 117, 110);
		contentPane.add(btnMasa_4);
		
		  TableModel tableModel = null;
		  
	         JLabel lblKasaSras = new JLabel("KASA SIRASI");
	         lblKasaSras.setForeground(new Color(69, 1, 164));
	         lblKasaSras.setFont(new Font("Marker Felt", Font.BOLD, 16));
	         lblKasaSras.setBounds(458, 349, 147, 16);
	         contentPane.add(lblKasaSras);
	         // müsteri.beklemeListesi'nde bulunan müşteri bilgilerini textArea'ya ekle
	        
	         JLabel lblNewLabel = new JLabel("GARSONLAR");
	         lblNewLabel.setFont(new Font("Marker Felt", Font.BOLD, 16));
	         lblNewLabel.setForeground(new Color(69, 1, 164));
	         lblNewLabel.setBounds(458, 32, 127, 16);
	         contentPane.add(lblNewLabel);
	         
//	           lblNewLabelFoto= new JLabel("New label");
//	          Image img2 = new ImageIcon(this.getClass().getResource("/img.png")).getImage();
//	          lblNewLabelFoto .setIcon(new ImageIcon(img));
//	          lblNewLabelFoto.setBounds(29, 16, 95, 89);
//	          sidebarYonetici.add(lblNewLabelFoto);
	         
		       
		     
	         
	         JLabel lblNewLabelResim = new JLabel("New label");

	     
	      Image imgIcon = new ImageIcon(this.getClass().getResource("/1.png")).getImage();
	      ImageIcon icon = new ImageIcon(imgIcon);

	      lblNewLabelResim.setIcon(icon);
	      lblNewLabelResim.setBounds(597, 20, 40, 40);
	      contentPane.add(lblNewLabelResim);

	      
	       
	      lblNewLabelResimAsci = new JLabel("New label");
	      lblNewLabelResimAsci.setBounds(1046, 28, 40, 40);
	      Image imgIcon1 = new ImageIcon(this.getClass().getResource("/2.png")).getImage();
	      ImageIcon icon1 = new ImageIcon(imgIcon1);

	      lblNewLabelResimAsci.setIcon(icon1);
	     
	      contentPane.add(lblNewLabelResimAsci);



	         // müsteri.beklemeListesi'nde bulunan müşteri bilgilerini textArea'ya ekle
	         for (musteri m : musteri.beklemeListesi) {
	             textArea.append("Müşteri ID: " + m.getId() + " - Müşteri Adı: " + m.getAd() + "\n");
	         }
	         for (musteri m : musteri.kasabeklemeListesi) {
	             textArea1.append("Müşteri ID: " + m.getId() + " - Müşteri Adı: " + m.getAd() + "\n");
	         }

	         // Scroll pane oluştur ve textArea'yı içine yerleştir
	         JScrollPane scrollPanebekleme = new JScrollPane();
	         scrollPanebekleme.setBackground(SystemColor.textHighlight);
	         scrollPanebekleme.setBounds(899, 377, 390, 298);
	         contentPane.add(scrollPanebekleme);
	         scrollPanebekleme.setViewportView(textArea);
	         textArea.setBackground(SystemColor.textHighlight);
	         textArea.setForeground(Color.WHITE);
	         textArea.setFont(new Font("Marker Felt", Font.BOLD, 16));
	         masalaraYerlestir(textArea);
	         
	         JScrollPane scrollPaneKasa = new JScrollPane();
	         scrollPaneKasa.setBackground(SystemColor.textHighlight);
	         scrollPaneKasa.setBounds(458, 377, 390, 298);
	         contentPane.add(scrollPaneKasa);
	         scrollPaneKasa.setViewportView(textArea1);
	         textArea1.setBackground(SystemColor.textHighlight);
	         textArea1.setForeground(Color.WHITE);
	         textArea1.setFont(new Font("Marker Felt", Font.BOLD, 16));	        
	         	       
	         	         
	         	      

	         
	         JLabel lblBeklemeSras = new JLabel("BEKLEME SIRASI");
	         lblBeklemeSras.setForeground(new Color(69, 1, 164));
	         lblBeklemeSras.setFont(new Font("Marker Felt", Font.BOLD, 16));
	         lblBeklemeSras.setBounds(899, 349, 147, 16);
	         contentPane.add(lblBeklemeSras);
	        

				 for (musteri m : musterilerim)
				 {
			            
			                m.start(); 
			                
			            
			     }

				 for (garson m : garsonlar)
				 {
			            
			                m.start(); 
			                
			            
			     }
				 for (asci m : garson.ascilar)
				 {
			            
			                m.start(); 
			                
			            
			     }
				 kasa.start();
			       
				 
			        
		
				 for (musteri m : musteri.beklemeListesi) {
                     if (m.getDurum() == 0 && m.getTimer() == null) {
                         Timer timer = new Timer();
                         m.setTimer(timer);

                         timer.schedule(new TimerTask() {
                             @Override
                             public void run() {
                                 // Müşteri bekleyen bir işlemdeyse ve durumu hala 0 ise
                                 if (m.getDurum() == 0) {
                                     System.out.println("Müşteri " + m.getId() + " zaman aşımına uğradı ve yok edildi.");
                                     String yazma="Müşteri " + m.getId() + " zaman aşımına uğradı ve yok edildi.";

                                     m.removeMusteriFromList();
                                     updateTextArea(textArea);
                                     DosyaYazici.stringEkle(yazma);
                                     m.interrupt(); // Thread'i durdur
                                 }
                                 m.setTimer(null); // Timer'ı sıfırla
                             }
                         }, musteribeklemesuresi*1000); // 20 saniye bekleyecek
                     }
                 }
		         lbllabelmasa1 = new JLabel(musteriAdi1);
			        lbllabelmasa1.setFont(new Font("Marker Felt", Font.BOLD, 15));
			        lbllabelmasa1.setBounds(29, 64, 117, 28);
			        contentPane.add(lbllabelmasa1);
			      
			        
			        lbllabelmasa2 = new JLabel(musteriAdi2);
			        lbllabelmasa2.setFont(new Font("Marker Felt", Font.BOLD, 15));
			        lbllabelmasa2.setBounds(253, 64, 117, 28);
			        contentPane.add(lbllabelmasa2);
			        lbllabelmasa2.revalidate();
			        
			        lbllabelmasa3 = new JLabel(musteriAdi3);
			        lbllabelmasa3.setFont(new Font("Marker Felt", Font.BOLD, 15));
			        lbllabelmasa3.setBounds(29, 293, 117, 28);
			        contentPane.add(lbllabelmasa3);
			        lbllabelmasa3.revalidate();
			        
			        lbllabelmasa4 = new JLabel(musteriAdi4);
			        lbllabelmasa4.setFont(new Font("Marker Felt", Font.BOLD, 15));
			        lbllabelmasa4.setBounds(253, 293, 117, 28);
			        contentPane.add(lbllabelmasa4);
			        lbllabelmasa4.revalidate();
			        
			        lbllabelmasa5 = new JLabel(musteriAdi5);
			        lbllabelmasa5.setFont(new Font("Marker Felt", Font.BOLD, 15));
			        lbllabelmasa5.setBounds(29, 527, 117, 28);
			        contentPane.add(lbllabelmasa5);
			        lbllabelmasa5.revalidate();
			        
			        lbllabelmasa6 = new JLabel(musteriAdi6);
			        lbllabelmasa6.setFont(new Font("Marker Felt", Font.BOLD, 15));
			        lbllabelmasa6.setBounds(253, 527, 117, 28);
			        contentPane.add(lbllabelmasa6);
			        
			        lbllabelmasa1_1 = new JLabel(musteridurum1);
			        lbllabelmasa1_1.setFont(new Font("Marker Felt", Font.BOLD, 11));
			        lbllabelmasa1_1.setBounds(29, 94, 212, 28);
			        contentPane.add(lbllabelmasa1_1);
			        
			        lbllabelmasa1_3 = new JLabel(musteridurum2);
			        lbllabelmasa1_3.setFont(new Font("Marker Felt", Font.BOLD, 11));
			        lbllabelmasa1_3.setBounds(29, 318, 212, 28);
			        contentPane.add(lbllabelmasa1_3);
			        
			        lbllabelmasa1_2 = new JLabel(musteridurum3);
			        lbllabelmasa1_2.setFont(new Font("Marker Felt", Font.BOLD, 11));
			        lbllabelmasa1_2.setBounds(253, 94, 193, 28);
			        contentPane.add(lbllabelmasa1_2);
			        
			        lbllabelmasa1_4 = new JLabel(musteridurum4);
			        lbllabelmasa1_4.setFont(new Font("Marker Felt", Font.BOLD, 11));
			        lbllabelmasa1_4.setBounds(253, 318, 193, 28);
			        contentPane.add(lbllabelmasa1_4);
			        
			        lbllabelmasa1_5 = new JLabel(musteridurum5);
			        lbllabelmasa1_5.setFont(new Font("Marker Felt", Font.BOLD, 11));
			        lbllabelmasa1_5.setBounds(29, 548, 212, 28);
			        contentPane.add(lbllabelmasa1_5);
			        
			        lbllabelmasa1_6 = new JLabel(musteridurum6);
			        lbllabelmasa1_6.setFont(new Font("Marker Felt", Font.BOLD, 11));
			        lbllabelmasa1_6.setBounds(253, 546, 193, 28);
			        contentPane.add(lbllabelmasa1_6);
			        
			        JLabel lblAlar = new JLabel("AŞÇILAR");
			        lblAlar.setForeground(new Color(69, 1, 164));
			        lblAlar.setFont(new Font("Marker Felt", Font.BOLD, 16));
			        lblAlar.setBounds(899, 32, 135, 16);
			        contentPane.add(lblAlar);
			        
			        garsonlabel_1 = new JLabel(garsondurum1);
			        garsonlabel_1.setFont(new Font("Marker Felt", Font.BOLD, 15));
			        garsonlabel_1.setBounds(458, 60, 390, 92);
			        contentPane.add(garsonlabel_1);
			        
			        garsonlabel_2 = new JLabel(garsondurum2);
			        garsonlabel_2.setFont(new Font("Marker Felt", Font.BOLD, 15));
			        garsonlabel_2.setBounds(458, 147, 390, 92);
			        contentPane.add(garsonlabel_2);
			        
			        garsonlabel_3 = new JLabel(garsondurum3);
			        garsonlabel_3.setFont(new Font("Marker Felt", Font.BOLD, 15));
			        garsonlabel_3.setBounds(458, 242, 390, 92);
			        contentPane.add(garsonlabel_3);
			        
			        ascilabel_1 = new JLabel(ascidurum1);
			        ascilabel_1.setFont(new Font("Marker Felt", Font.BOLD, 15));
			        ascilabel_1.setBounds(899, 80, 390, 92);
			        contentPane.add(ascilabel_1);
			        
			        ascilabel_2 = new JLabel(ascidurum2);
			        ascilabel_2.setFont(new Font("Marker Felt", Font.BOLD, 15));
			        ascilabel_2.setBounds(899, 197, 390, 92);
			        contentPane.add(ascilabel_2);
			        
			        odemesayilabel = new JLabel();
			        odemesayilabel.setBounds(468, 685, 368, 38);
			        contentPane.add(odemesayilabel);
			        odemesayilabel.setFont(new Font("Dialog", Font.BOLD, 15));
			        
			       
			       
			        lbllabelmasa6.revalidate();
		         


			        contentPane.revalidate();
		
	       
		
		
	}
	static void masalaraYerlestir(JTextArea TextArea) {

        Iterator<musteri> iterator = musteri.beklemeListesi.iterator();
        int k= musteri.beklemeListesi.size();
        while (iterator.hasNext()) {
            k++;
            musteri m = iterator.next();
            for (masa masa : garson.masalar) {

                if (masa.getMusteri_id() == -1) { // Eğer masa boşsa
                    masa.setMusteri_id((int) m.getId()); // Musteriyi masaya yerleştir
                    masa.setMusteri(m);
                    System.out.println("Müşteri " + m.getId() + " masaya yerleştirildi: " + masa.getId());
                    String yazma="Müşteri " + m.getId() + " masaya yerleştirildi: " + masa.getId();
                    updateMusteriAdi(masa.getId(),masa.getMusteri().getAd());
                    DosyaYazici.stringEkle(yazma);

                    try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    m.setDurum(1);
                    updateDurumAdi(masa.getId(),"Musteri Yok");

                    iterator.remove(); // Iterator üzerinden elemanı kaldır
                    break;
                }
            }
        }
        if(k==0)
        {
             for (masa masa : garson.masalar) {

                    if (masa.getMusteri_id() == -1) { // Eğer masa boşsa

                       updateMusteriAdi(masa.getId(),"Musteri Yok");



                    }
                }
        }

        updateTextArea(TextArea);
    }
	public static void updateMusteriAdi(int masaId, String yeniAd) {
	    // Masa ID'sine göre ilgili müşteri adını güncelle
	    switch (masaId) {
	        case 0:
	            musteriAdi1 = yeniAd;
	            updateLabel(masaId,musteriAdi1);
	            break;
	        case 1:
	            musteriAdi2 = yeniAd;
	            updateLabel(masaId,musteriAdi2);
	            break;
	        case 2:
	            musteriAdi3 = yeniAd;
	            updateLabel(masaId,musteriAdi3);
	            break;
	        case 3:
	            musteriAdi4 = yeniAd;
	            updateLabel(masaId,musteriAdi4);
	            break;
	        case 4:
	            musteriAdi5 = yeniAd;
	            updateLabel(masaId,musteriAdi5);
	            break;
	        case 5:
	            musteriAdi6 = yeniAd;
	            updateLabel(masaId,musteriAdi6);
	            break;
	       
	    }

	    // İlgili label'ı güncelle
	   
	}
	public static void updategarsondurum(int garsonid, String durum) {
	    // Masa ID'sine göre ilgili müşteri adını güncelle
	    switch (garsonid) {
	        case 0:
	            garsondurum1 = durum;
	            updateLabeldurumgarson(garsonid, garsondurum1);
	            break;
	        case 1:
	            garsondurum2=durum;
	            updateLabeldurumgarson(garsonid, garsondurum2);
	            break;
	        case 2:
	            garsondurum3 = durum;
	            updateLabeldurumgarson(garsonid, garsondurum3);
	            break;
	      
	       
	    }

	    // İlgili label'ı güncelle
	   
	}
	public static void updateodemedurum() {
	           
	            odemesayi++; 
	            String intDegeri = String.valueOf(odemesayi);
	            updateLabelodemedurum(intDegeri);
	            
	      
	       
	    }

	    // İlgili label'ı güncelle
	   
	
	public static void updateascidurum(int asciid, String durum) {
	    // Masa ID'sine göre ilgili müşteri adını güncelle
	    switch (asciid) {
	        case 0:
	            ascidurum1 = durum;
	            updateLabelasci(asciid, ascidurum1);
	            break;
	        case 1:
	            ascidurum2=durum;
	            updateLabelasci(asciid, ascidurum2);
	            break;
	        
	      
	       
	    }

	    // İlgili label'ı güncelle
	   
	}
	public static void updateDurumAdi(int masaId, String yeniAd) {
	    // Masa ID'sine göre ilgili müşteri adını güncelle
	    switch (masaId) {
	        case 0:
	            musteridurum1 = yeniAd;
	            updateLabeldurum(masaId,musteridurum1);
	            break;
	        case 1:
	            musteridurum2 = yeniAd;
	            updateLabeldurum(masaId,musteridurum2);
	            break;
	        case 2:
	            musteridurum3 = yeniAd;
	            updateLabeldurum(masaId,musteridurum3);
	            break;
	        case 3:
	            musteridurum4 = yeniAd;
	            updateLabeldurum(masaId,musteridurum4);
	            break;
	        case 4:
	            musteridurum5= yeniAd;
	            updateLabeldurum(masaId,musteridurum5);
	            break;
	        case 5:
	            musteridurum6= yeniAd;
	            updateLabeldurum(masaId,musteridurum6);
	            break;
	       
	    }

	    // İlgili label'ı güncelle
	   
	}
	public static void updateLabel(int masaId,String yeniAd) {
	    JLabel label = null;
	    switch (masaId) {
	        case 0:
	            label = lbllabelmasa1;
	            break;
	        case 1:
	            label = lbllabelmasa2;
	            break;
	        case 2:
	            label = lbllabelmasa3;
	            break;
	        case 3:
	            label = lbllabelmasa4;
	            break;
	        case 4:
	            label = lbllabelmasa5;
	            break;
	        case 5:
	            label = lbllabelmasa6;
	            break;
	        // Diğer masalar için de aynı şekilde devam edebilirsiniz
	    }

	    // Label null değilse ve müşteri adı null değilse güncelle
	    if (label != null && yeniAd != null) {
	        label.setText(yeniAd);
	        label.revalidate();
	    }
	}
	public static void updateLabelodemedurum(String intDegeri) {
	    JLabel label = null;
	    label=odemesayilabel;

	    // Label null değilse ve müşteri adı null değilse güncelle
	    if (label != null && intDegeri != null) {
	        label.setText(intDegeri);
	        label.revalidate();
	    }
	}
	public static void updateLabeldurum(int masaId,String yeniAd) {
	    JLabel label = null;
	    switch (masaId) {
	        case 0:
	            label = lbllabelmasa1_1;
	            break;
	        case 1:
	            label = lbllabelmasa1_2;
	            break;
	        case 2:
	            label = lbllabelmasa1_3;
	            break;
	        case 3:
	            label = lbllabelmasa1_4;
	            break;
	        case 4:
	            label = lbllabelmasa1_5;
	            break;
	        case 5:
	            label = lbllabelmasa1_6;
	            break;
	        // Diğer masalar için de aynı şekilde devam edebilirsiniz
	    }

	    // Label null değilse ve müşteri adı null değilse güncelle
	    if (label != null && yeniAd != null) {
	        label.setText(yeniAd);
	        label.revalidate();
	    }
	}
	public static void updateLabeldurumgarson(int garsonid,String durum) {
	    JLabel label = null;
	    switch (garsonid) {
	        case 0:
	            label = garsonlabel_1;
	            break;
	        case 1:
	            label = garsonlabel_2;
	            break;
	        case 2:
	            label = garsonlabel_3;
	            break;
	      
	    }

	    // Label null değilse ve müşteri adı null değilse güncelle
	    if (label != null && durum != null) {
	        label.setText(durum);
	        label.revalidate();
	    }
	}
	public static void updateLabelasci(int asciid,String durum) {
	    JLabel label = null;
	    switch (asciid) {
	        case 0:
	            label = ascilabel_1;
	            break;
	        case 1:
	            label = ascilabel_2;
	            break;
	        
	      
	    }

	    // Label null değilse ve müşteri adı null değilse güncelle
	    if (label != null && durum != null) {
	        label.setText(durum);
	        label.revalidate();
	    }
	}

	
	

	
	public static void updateTextArea(JTextArea textArea) {
	    textArea.setText(""); // Mevcut içeriği temizle

	    // Güncel bekleme listesini JTextArea'ya ekleme
	    for (musteri m : musteri.beklemeListesi) {
	        textArea.append("Müşteri ID: " + m.getId() + " - Müşteri Adı: " + m.getAd() + "\n");
	    }
	}

	public static void updateTextArea1(JTextArea textArea1) {
	    textArea1.setText(""); // Mevcut içeriği temizle

	    // Güncel bekleme listesini JTextArea'ya ekleme
	    for (musteri m : musteri.kasabeklemeListesi) {
	        textArea1.append("Müşteri ID: " + m.getId() + " - Müşteri Adı: " + m.getAd() + "\n");
	    }
	}
    }