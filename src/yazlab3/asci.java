package yazlab3;

public class asci extends Thread{
	
    private int id;
    private int yemek1_musteri_id;
    //-1 se müsterisi yok
    private int yemek2_musteri_id;
    //-1 se müsterisi yok
    public static int yemekhazirlamasuresi=10;
	
	public asci(int id)
	{
		this.setId(id);
		this.setYemek1_musteri_id(-1);
		this.setYemek2_musteri_id(-1);
		
		
		
		
	}
	
	
	@Override
	public void run() {
	    try {
	    
	      
	        while (true) {
	        	if(yemek1_musteri_id==-1 && yemek2_musteri_id==-1 ) 
		    	{
		    		System.out.println("Ascı " + id + " beklemede.");
		  	        String text = "Ascı " + id + " beklemede.";
		  	        gorsel.updateascidurum(this.id, text);
		  	        DosyaYazici.stringEkle(text);
		    	}
	            if (yemek1_musteri_id != -1 && yemek2_musteri_id==-1) {
	                System.out.println("Ascı " + id + ", " + yemek1_musteri_id + " id'li musterinin yemegini yapiyor.");
	                String text1 = "Ascı " + id + ", " + yemek1_musteri_id + " id'li musterinin siparisini aldi yemegi yapiyor.";
	                gorsel.updateascidurum(this.id, text1);
	                DosyaYazici.stringEkle(text1);
	                Thread.sleep(yemekhazirlamasuresi*1000);
	                System.out.println("Ascı " + id + ", " + yemek1_musteri_id + " id'li musterinin yemegi hazir ve musteriye verildi ");
	                String text2 ="Ascı " + id + ", " + yemek1_musteri_id + " id'li musterinin yemegi hazir garsona veriliyor ";
	                gorsel.updateascidurum(this.id, text2);
	                DosyaYazici.stringEkle(text2);
	                yemek1_musteri_id = -1;
	            }

	            if (yemek2_musteri_id != -1  && yemek1_musteri_id==-1) {
	                System.out.println("Ascı " + id + ", " + yemek2_musteri_id + " id'li musterinin yemegini yapiyor.");
	                String text3 = "Ascı " + id + ", " + yemek2_musteri_id + " id'li musterinin siparisini aldi yemegi yapiyor.";
	                gorsel.updateascidurum(this.id, text3);
	                DosyaYazici.stringEkle(text3);
	                Thread.sleep(yemekhazirlamasuresi*1000);
	                System.out.println("Ascı " + id + ", " + yemek2_musteri_id + " id'li musterinin yemegi hazir ve musteriye verildi ");
	                String text4 ="Ascı " + id + ", " + yemek2_musteri_id + " id'li musterinin yemegi hazir garsona veriliyor ";
	                gorsel.updateascidurum(this.id, text4);
	                DosyaYazici.stringEkle(text4);
	                yemek2_musteri_id = -1;
	            }
	            if (yemek2_musteri_id != -1  && yemek1_musteri_id!=-1) {
	                System.out.println("Ascı " + id + ", " + yemek1_musteri_id + " id'li  ve "+ yemek2_musteri_id+ " idl'li musterinin siparisini aldi yemekleri yapiyor.");
	                String text3 = "Ascı " + id + ", " + yemek1_musteri_id + " id'li  ve "+ yemek2_musteri_id+ " idl'li musterinin siparisini aldi yemekleri yapiyor.";
	                gorsel.updateascidurum(this.id, text3);
	                DosyaYazici.stringEkle(text3);
	                Thread.sleep(yemekhazirlamasuresi*1000);
	                System.out.println("Ascı " + id + ", " + yemek1_musteri_id + " id'li  ve "+ yemek2_musteri_id+ " idl'li musterinin yemeklerini yaptı. ilgili garsona veriyor.");
	                String text4 ="Ascı " + id + ", " + yemek1_musteri_id + " id'li  ve "+ yemek2_musteri_id+ " idl'li musterinin yemeklerini yaptı. ilgili garsona veriyor.";
	                
	                gorsel.updateascidurum(this.id, text4);
	                DosyaYazici.stringEkle(text4);
	                yemek2_musteri_id = -1;
	                yemek1_musteri_id = -1;
	            }
	            try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
               } 
	        }
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}



	public long getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getYemek1_musteri_id() {
		return yemek1_musteri_id;
	}


	public void setYemek1_musteri_id(int yemek1_musteri_id) {
		this.yemek1_musteri_id = yemek1_musteri_id;
	}


	public int getYemek2_musteri_id() {
		return yemek2_musteri_id;
	}


	public void setYemek2_musteri_id(int yemek2_musteri_id) {
		this.yemek2_musteri_id = yemek2_musteri_id;
	}




}
