package yazlab3;

import javax.swing.JButton;

public class masa extends JButton {
	
	 private int id;
	    private int musteri_id;
	    private musteri musteri;
	   

	    public masa(int id) {
	        this.id = id;
	        this.musteri_id = -1;
	        this.musteri = null;
	        
	    }

	public int getId() {
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
	


