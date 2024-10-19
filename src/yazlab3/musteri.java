package yazlab3;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;


public class musteri extends Thread{
	
	private volatile boolean running = true;
	private Thread customerThread;
	static final LinkedList<musteri> beklemeListesi = new LinkedList<>();
	static final LinkedList<musteri> kasabeklemeListesi = new LinkedList<>();
	public static int yemekyemesuresi=5;
	private String ad;
    private int id;
    private boolean oncelik ; 
	private int durum ;
	private int masa_id;
	private Timer timer; // Timer değişkeni
	// 0 giris sirada
	// 1 oturdu bekliyor
	// 2 siparis alındı bekliyor
	// 3 siparis geldi yiyor
	// 4 kasa sirada
	// 5 odeme yapiyor.
	
	
	public musteri(int id , boolean oncelik, String ad)
	{
		this.setAd(ad);
		this.setId(id);
		this.setOncelik(oncelik);
		this.setDurum(0);
		 if (oncelik) {
	            beklemeListesi.addFirst(this); // Öncelikli müşteriyi listenin en başına ekle
	        } else {
	            beklemeListesi.addLast(this); // Diğer müşterileri listenin sonuna ekle
	        }
		
		
		
	}
	
	
	@Override
	public void run() {
	    while (true) {
	        try {
	        	Thread.sleep(3000);
	           
	            
	            System.out.println("Adım: " + this.ad + " ve şu anki durumum: " + this.durum);
	            String yazma="Adım: " + this.ad + " ve şu anki durumum: " + this.durum;
	            DosyaYazici.stringEkle(yazma);

	            if (this.durum == 3) {
	            	System.out.println("Adım: " + this.ad + " ve yemegimi yiyorum ");
	            	String yazma1 ="Adım: " + this.ad + " ve yemegimi yiyorum ";
	            	DosyaYazici.stringEkle(yazma1);
	            	String text1="yemegimi yiyorum ";
	            	for(masa masa : garson.masalar)
	            	{
	            		if(masa.getMusteri_id()==this.id)
	            		{
	            			masa_id=masa.getId();
	            			gorsel.updateDurumAdi(masa_id, text1);
	            		}
	            	
	            	}
	            		
	            	
	            	
	            	
	            	
	                Thread.sleep(yemekyemesuresi*1000); // 4 saniye bekleme
	                this.durum = 4; // Durumu 4 olarak ayarla
	               
	                kasabeklemeListesi.addLast(this);
	                
	                
	                
	               
	            }
	            for(musteri musteri : kasabeklemeListesi)
	            {
	            	System.out.println(musteri.ad);
	            }
	           
	            if (this.durum == 5) {
	            	
					{
				            	
				                System.out.println(getAd()+" odeme yapiyor ");
				                String yazma2 =getAd()+" odeme yapiyor ";
				                DosyaYazici.stringEkle(yazma2);
				                String text2 ="kasada odeme yapiyor ";
				                gorsel.updateDurumAdi(masa_id, text2);
				            
				     } 
	            }
	        } catch (InterruptedException e) {
	            // Beklenmedik bir kesilme durumuyla başa çıkmak için gerekli işlemler...
	           
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

	public boolean getOncelik() {
		return oncelik;
	}

	public void setOncelik(boolean oncelik) {
		this.oncelik = oncelik;
	}


	public int getDurum() {
		return durum;
	}


	public void setDurum(int durum) {
		this.durum = durum;
	}


	public String getAd() {
		return ad;
	}


	public void setAd(String ad) {
		this.ad = ad;
	}


	public Timer getTimer() {
		return timer;
	}


	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	public void stopThread() {
        running = false;
        if (timer != null) {
            timer.cancel();
        }
    }
	 public void removeMusteriFromList() {
	        beklemeListesi.remove(this);
	    }
	 public void removeMusterikasaFromList() {
	        kasabeklemeListesi.remove(this);
	    }
}
