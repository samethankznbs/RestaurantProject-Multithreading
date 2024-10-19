package yazlab3;

import java.util.LinkedList;

public class kasa extends Thread {
	private volatile boolean running = true;
	private int id;
	 private musteri musteri;
	 public static int hesapalmasuresi=8;
	 
	 
	 
	 
	 
	 public kasa (int id)
	 {
		 
		 this.id =id;
		 this.musteri=null;
		 
		 
		 
		 
	 }
	 @Override
	    public void run() {
	        while (running) {
	        	
	        	
	        	
	            try {
	                Thread.sleep(2000);
	               
	                if(this.musteri==null)
	                {
	                	
	                	System.out.println("Kasa beklemede");
	                	String yazma="Kasa beklemede";
	                	DosyaYazici.stringEkle(yazma);
	                	
	                	
	                }

	                if (musteri == null && !yazlab3.musteri.kasabeklemeListesi.isEmpty()) {
	                    musteri = yazlab3.musteri.kasabeklemeListesi.getFirst();
	                    gorsel.updateTextArea1(gorsel.textArea1);
	                    
	                    musteri.setDurum(5);
	                    System.out.println("Hesap alınıyor..."+ musteri.getId());
	                    
	                    String yazma ="Hesap alınıyor..."+ musteri.getId();
	                    DosyaYazici.stringEkle(yazma);
	                    Thread.sleep(hesapalmasuresi*1000);
	                    System.out.println("Hesap alındı - Müşteri: " + musteri.getId());
	                    
	                    String yazma1="Hesap alındı - Müşteri: " + musteri.getId();
	                    DosyaYazici.stringEkle(yazma1);
	                   
	                   
	                    System.out.println("Musteri  "+musteri.getAd()+  " restrorandan ayrildi");
	                    yazlab3.musteri.kasabeklemeListesi.removeFirst();
	                    gorsel.updateTextArea1(gorsel.textArea1);
	                    String yazma2="Musteri  "+musteri.getAd()+  " restrorandan ayrildi";
	                    DosyaYazici.stringEkle(yazma2);
	                    for(masa m : garson.masalar)
	                    {
	                    	if(m.getMusteri_id()==musteri.getId())
	                    	{
	                    		m.setMusteri_id(-1);
	                    		m.setMusteri(null);
	                    		gorsel.updateDurumAdi(m.getId()," ");
	                    		

	                    		
	                    	}
	                    }
	                    gorsel.updateodemedurum();
	                   
	                    musteri.interrupt();
	                    this.musteri=null;
	                    gorsel.masalaraYerlestir(gorsel.textArea);
	                    
	                    
	                }
	            } catch (InterruptedException e) {
	                running = false; // Thread'in çalışmasını durdur
	                return;
	            }
	        }
	    }
	 

	
	
	
	
	
	
	

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public musteri getMusteri() {
		return musteri;
	}

	public void setMusteri(musteri musteri) {
		this.musteri = musteri;
	}
	

}
