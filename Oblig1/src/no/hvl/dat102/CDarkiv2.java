package no.hvl.dat102;

import no.hvl.dat102.Sjanger;

public class CDarkiv2 implements CDArkivADT {
	private int antall;
	private LinearNode<CD> start;

	public CDarkiv2() {
		antall = 0;
		start = null;
	}

	@Override
	public CD[] hentCdTabell() {
		LinearNode<CD> denne = start;
		CD[] nyTab = new CD[antall];
		int i = 0;
		while (denne != null) {
			nyTab[i] = denne.getElement();
			denne = denne.getNeste();
			i++;
		}

		return (trimTab(nyTab, i));
	}

	@Override
	public void leggTilCd(CD nyCd) {
		LinearNode<CD> denne = new LinearNode<CD>(nyCd);
	
		denne.setNeste(start);
		start = denne;
		antall++;
	}

	@Override
	public boolean slettCd(int cdNr) {
		boolean slettet = false;
		LinearNode<CD> denne = start;
		LinearNode<CD> forrige = start;
		
		if ((denne.getElement().getNummer() == cdNr)) {
			start = start.getNeste();
			antall--;
			slettet = true;
		} else {
			while (denne != null && !slettet){
				denne = denne.getNeste();
				if(denne.getElement().getNummer() == cdNr) {
					forrige.setNeste(denne.getNeste());
					antall--;
					slettet = true;
				}
			}
			
		}
		
		

		return slettet;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		CD[] tittel = new CD[antall];
		LinearNode<CD> denne = start;
		int j = 0;

		while (denne != null) {
			if (denne.getElement().getTittel().contains(delstreng)) {
				tittel[j] = denne.getElement();
				j++;
			}
			denne = denne.getNeste();
		}

		return (trimTab(tittel, j));
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		CD[] artist = new CD[antall];
		LinearNode<CD> denne = start;
		int i = 0;
		int j = 0;
		boolean funnet = false;

		while (i < antall && !funnet) {
			if (denne.getElement().getArtist().contains(delstreng)) {
				artist[j] = denne.getElement();
				j++;
				funnet = true;
			}

			denne = denne.getNeste();
			i++;
		}

		return artist;
	}

	@Override
	// Henter antall CD-er for en gitt sjanger
	public int antallSjanger(Sjanger sjanger) {
		int ant = 0;
		LinearNode<CD> denne = start;
		CD[] nyTab = new CD[antall];
		int i = 0;
		while (denne != null) {
			nyTab[i] = denne.getElement();
			denne = denne.getNeste();
			i++;
		}

		for (CD nyCd : nyTab) {
			if (nyCd.getSjanger().equals(sjanger)) {
				ant++;
			}
		}

		return ant;
	}

	@Override
	// Returnerer antall CD-er
	public int antall() {
		return antall;
	}

	public CD[] trimTab(CD[] tab, int n) {
		CD[] cdtab2 = new CD[n];
		int i = 0;
		while (i < n) {
			cdtab2[i] = tab[i];
			i++;
		}
		return cdtab2;
	}

}
