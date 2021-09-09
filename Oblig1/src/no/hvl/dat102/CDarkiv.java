package no.hvl.dat102;

public class CDarkiv implements CDArkivADT {
	// Instansvariable
	private CD[] cdTabell;
	private int antall;
	// Konstruktører og andre metoder

	public CD[] hentCdTabell() {
		return this.cdTabell;
	}
	
	public CDarkiv(int antall) {
		cdTabell = new CD[antall];
	}

	public void leggTilCd(CD nyCd) {
		if(antall == cdTabell.length) {
			utvid();
		} 
		
		cdTabell[antall] = nyCd;
		antall++;
	}

	public boolean slettCd(int cdNr) {
		boolean slettet = false;
	
		for (int i = 0; i < cdTabell.length; i++) {
			if (cdTabell[i].getNummer() == cdNr && !slettet) {
				cdTabell[i] = null;
				antall--;
				slettet = true;
			}
		}
		
		return slettet;
	}
	
	public CD[] sokTittel(String delstreng) {
		CD[] tittel = new CD[antall];
		int i = 0;
		int j = 0;
		boolean funnet = false;
		
		while(i < antall && !funnet) {
			if(cdTabell[i].getTittel().contains(delstreng)) {
				funnet = true;
				tittel[j] = cdTabell[i];
				j++;
			}
		}
		
		return tittel;
	}
	
	public CD[] sokArtist(String delstreng) {
		CD[] artist = new CD[antall];
		int i = 0;
		int j = 0;
		boolean funnet = false;
		
		while(i < antall && !funnet) {
			if(cdTabell[i].getArtist().contains(delstreng)) {
				funnet = true;
				artist[j]  = cdTabell[i];
				j++;
			}
		}
		
		return artist;
	}

	// Henter antall CD-er for en gitt sjanger
	public int antallSjanger(Sjanger sjanger) {
		int ant = 0;
		
		for(CD nyCd : cdTabell) {
			if(nyCd.getSjanger().equals(sjanger)){
				ant++;
			}
		}
		
		return ant;
	}

	// Returnerer antall CD-er
	public int antall() {
		return antall;
		
	}
	
	private void utvid() {
		CD[] hjelpeTabell = new CD[antall * 2];

		for (int indeks = 0; indeks < antall; indeks++)
			hjelpeTabell[indeks] = cdTabell[indeks];

		cdTabell = hjelpeTabell;
	}
	// …fyll ut
}// class
