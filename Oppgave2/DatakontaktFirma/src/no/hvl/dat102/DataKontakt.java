package no.hvl.dat102;

public class DataKontakt {
	private final static int STDK = 10;
	private Medlem[] medlemmer;
	private int antallMedlemmer;
	
	public DataKontakt() {
		medlemmer = new Medlem[STDK];
		antallMedlemmer = 0;
	}
	
	public DataKontakt(int lengde) {
		medlemmer = new Medlem[lengde];
		antallMedlemmer = 0;
	}
	
	public void leggTilMedlem(Medlem person) {
		
		if(antallMedlemmer == medlemmer.length - 1) {
			Medlem[] nyTab = new Medlem[medlemmer.length * 2 ];
			
			for(int i = 0; i < medlemmer.length; i++) {
				nyTab[i] = medlemmer[i];
			}
			
			medlemmer = nyTab;
		}
		
		medlemmer[antallMedlemmer] = person;
		antallMedlemmer++;
	}
	
	public int finnMedlemsIndeks(String navn) {
		int indeks = -1;
		
		for(int i = 0; i < antallMedlemmer; i++) {
			if(medlemmer[i].getNavn() == navn) {
				indeks = i;
			}
		}
		return indeks;
	}
	
	public int finnPartnerFor(String navn) {
		int indeks = -1;
		int denne = -1;
		
		for(int i = 0; i < antallMedlemmer; i++) {
			if(medlemmer[i].getNavn() == navn && medlemmer[i].getStatusIndeks() == -1) {
				denne = i;
			}
		}
		
		if(denne != -1) {
			for(int i = 0; i < antallMedlemmer; i++) {
				if(i != denne && medlemmer[denne].passerTil(medlemmer[i]) && medlemmer[i].getStatusIndeks() == -1) {
					medlemmer[denne].setStatusIndeks(i);
					medlemmer[i].setStatusIndeks(denne);
						
					indeks = i;
				}
			}
		}
		
		return indeks;
	}
	
	public void tilbakestillStatusIndeks(String navn) {
		Medlem denne = null;
		
		for(int i = 0; i < antallMedlemmer; i++) {
			if(medlemmer[i].getNavn() == navn && medlemmer[i].getStatusIndeks() != -1) {
				denne = medlemmer[i];
			}
		}
		
		if(denne != null) {
			Medlem andre = medlemmer[denne.getStatusIndeks()];
			
			andre.setStatusIndeks(-1);
			
			denne.setStatusIndeks(-1);
			
		}
		
	}
	
	public String[] getAlleNavn() {
		String[] etternavn = new String[medlemmer.length];
		
		for(int i = 0; i < antallMedlemmer; i++) {
			if(medlemmer[i] != null) {
				etternavn[i] = medlemmer[i].getNavn();
			}
		}
		
		return etternavn;
	}
	
	public Medlem getMedlem(String navn) {
		Medlem medlem = null;
		
		for(Medlem m : medlemmer) {
			if(m.getNavn() == navn) {
				medlem = m;
			}
		}
		
		return medlem;
	}
	
	public Medlem[] getMedlemmer() {
		return medlemmer;
	}
	
	public int getAntallMedlemmer() {
		return antallMedlemmer;
	}
	
}
