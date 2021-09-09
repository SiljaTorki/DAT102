package no.hvl.dat102;

public class CD {
	
	private int nummer;
	private String artist;
	private String tittel;
	private int aar;
	public Sjanger sjanger;
	private String plateselskap;
	
	
	public CD() {
		this.nummer = 0;
		this.artist = "";
		this.tittel = "";
		this.aar = 0;
		this.sjanger = null;
		this.plateselskap = "";
	}
	
	public CD(int nummer, String artist, String tittel, int aar, Sjanger sjanger, String plateselskap) {
		this.nummer = nummer;
		this.artist = artist;
		this.tittel = tittel;
		this.aar = aar;
		this.sjanger = sjanger;
		this.plateselskap = plateselskap;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	@Override
	public String toString() {
		return "CD [nummer=" + nummer + ", artist=" + artist + ", tittel=" + tittel + ", aar=" + aar + ", sjanger="
				+ sjanger + ", plateselskap=" + plateselskap + "]";
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getAar() {
		return aar;
	}

	public void setAar(int aar) {
		this.aar = aar;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getPlateselskap() {
		return plateselskap;
	}

	public void setPlateselskap(String plateselskap) {
		this.plateselskap = plateselskap;
	}
	

}
