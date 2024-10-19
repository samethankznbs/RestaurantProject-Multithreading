package yazlab3;

import java.util.ArrayList;

public class garson extends Thread{
	 static ArrayList<masa> masalar=new ArrayList<>();
	 static ArrayList<asci> ascilar=new ArrayList<>();
	 
	  private static int currentTableIndex = 0; // Başlangıç masası
	 private static Object lock = new Object();
    private int id;
    private int musteri_id;
    //-1 se müsterisi yok
    private musteri musteri;
    public static int siparisalmasuresi=6;
	
	
	public garson(int id)
	{
		this.setId(id);
		this.setMusteri_id(-1);
		this.setMusteri(null);;
		
		
		
	}
	 

	
	public void run() {
	    while (true) {
	        if (this.musteri_id == -1) {
	            System.out.println(this.id + " idli garson beklemede");
	            String text_garson= this.id + " idli garson beklemede";
	            DosyaYazici.stringEkle(text_garson);
	            gorsel.updategarsondurum(this.id, text_garson);
	        }

	        synchronized (masalar) {
	            for (masa currentTable : masalar) {
	                synchronized (currentTable) {
	                    if (this.musteri_id != -1 && this.musteri.getDurum() == 3) {
	                        setMusteri_id(-1);
	                        setMusteri(null);
	                    }

	                    if (this.musteri_id == -1 && currentTable.getMusteri_id() != -1 && currentTable.getMusteri().getDurum() == 1) {
	                        setMusteri_id(currentTable.getMusteri_id());
	                        setMusteri(currentTable.getMusteri());

	                        System.out.println(this.id + " idli garson " + this.musteri_id + " idli müşteriden sipariş alıyor");
	                        String text1_garson= this.id + " idli garson " + this.musteri_id + " idli müşteriden sipariş alıyor";
	                       
	                        gorsel.updategarsondurum(this.id, text1_garson);
	                        DosyaYazici.stringEkle(text1_garson);

	                        currentTable.getMusteri().setDurum(2);
	                        String text1=this.id+" İdli garson siparisi aldı";
	                       
	                        gorsel.updateDurumAdi(currentTable.getId(),text1);
	                        DosyaYazici.stringEkle(text1);
	                        boolean aşçıBulundu = false;
	                        synchronized (ascilar) {
	                            for (asci asci : ascilar) {
	                                if (asci.getYemek1_musteri_id() == -1) {
	                                    asci.setYemek1_musteri_id(this.musteri_id);
	                                    String text4_garson= this.id + " idli garson " + this.musteri_id + " idli musterinin siparisini "+asci.getId()+" adili asciye iletti .";
	                                    
	                                    gorsel.updategarsondurum(this.id, text4_garson);
	                                    DosyaYazici.stringEkle(text4_garson);
	                                    try {
	                                        Thread.sleep(siparisalmasuresi*1000);
	                                    } catch (InterruptedException e) {
	                                        e.printStackTrace();
	                                    } 
	                                    aşçıBulundu = true;
	                                    break;
	                                } else if (asci.getYemek2_musteri_id() == -1 && asci.getYemek1_musteri_id() != this.musteri_id) {
	                                    asci.setYemek2_musteri_id(this.musteri_id);
	                                    String text5_garson= this.id + " idli garson " + this.musteri_id + " idli musterinin siparisini "+asci.getId()+" adili asciye iletti .";
	                                   
	                                    gorsel.updategarsondurum(this.id, text5_garson);
	                                    DosyaYazici.stringEkle(text5_garson);
	                                    try {
	                                        Thread.sleep(siparisalmasuresi*1000);
	                                    } catch (InterruptedException e) {
	                                        e.printStackTrace();
	                                    } 
	                                    aşçıBulundu = true;
	                                    break;
	                                }
	                            }
	                            if (!aşçıBulundu) {
	                                System.out.println(this.id + " idli garson bekliyor - Tüm aşçılar meşgul");
	                                String text3_garson= this.id + " idli garson " + this.musteri_id + " idli musterinin siparisini iletemedi. - Tüm aşçılar meşgul";
	                                gorsel.updategarsondurum(this.id, text3_garson);
	                                DosyaYazici.stringEkle(text3_garson);
	                                try {
	                                    masalar.wait();
	                                } catch (InterruptedException e) {
	                                    e.printStackTrace();
	                                }
	                            }
	                        }



	                    

	                        String text2="yemek hazır ."+this.id+" İdli garson yemegi getirdi";
	                        gorsel.updateDurumAdi(currentTable.getId(),text2);
	                        String text6_garson="yemek hazır ."+this.id+" İdli garson "+this.musteri_id +" idli müsteriye yemegi getirdi";
	                        gorsel.updategarsondurum(this.id, text6_garson);
	                        DosyaYazici.stringEkle(text6_garson);
	                        currentTable.getMusteri().setDurum(3);
	                        setMusteri_id(-1);
	                        setMusteri(null);
	                        

	                        masalar.notifyAll();

	                        break;
	                    }
	                }
	            }
	        }
	        try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
           } 
	       
	    }
	}







	




	public long getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getMusteri_id() {
		return musteri_id;
	}


	public void setMusteri_id(int musteri_id) {
		this.musteri_id = musteri_id;
	}
	


	public musteri getMusteri() {
		return musteri;
	}


	public void setMusteri(musteri musteri) {
		this.musteri = musteri;
	}
	


}
