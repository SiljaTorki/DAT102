package no.hvl.dat102;

import no.hvl.dat102.kjedetmengde.KjedetMengde;

public class Medlem {
	private String navn;
	private KjedetMengde<Hobby> hobbyer;
	private int statusIndeks;
	
	public Medlem(String navn) {
		this.navn = navn;
		hobbyer = new KjedetMengde<Hobby>();
		statusIndeks = -1;
	}
	
	public void leggTilHobby(Hobby hobby) {
		hobbyer.leggTil(hobby);
	}
	
	public boolean passerTil(Medlem medlem2) {
		boolean passer = false;
		
		if(hobbyer.antall() == medlem2.hobbyer.antall()) {
			if(hobbyer.equals(medlem2.hobbyer)) {
				passer = true;
			}
		}
		
		return passer;
	}
	
	public String toString() {
		return navn + " har hobbyer " + hobbyer.toString();
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}
	
	public int getStatusIndeks() {
		return statusIndeks;
	}
	
	public String getHobbyer() {
		return hobbyer.toString();
	}
}
