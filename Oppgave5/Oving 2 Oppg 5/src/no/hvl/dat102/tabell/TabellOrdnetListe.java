package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.OrdnetListeADT;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	
	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		T resultat = null;

		if(!erTom()) {
			resultat = liste[bak - 1];
			
			liste[bak - 1] = null;
			
			bak--;
		}
		//... Fyll ut
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		T resultat = null;
		//... Fyll ut
		
		if(!erTom()) {
			resultat = liste[0];
			
			for(int i = 0; i < bak - 1; i++) {
				liste[i] = liste[i + 1];
			}
			
			bak--;
		}
		
		
		return resultat;
	}

     @Override
	public T foerste() {
		T resultat = null;
		if (!erTom()){
			resultat = liste[0];
		}
		return resultat;
	}

	@Override
	public T siste() {
		T resultat = null;
		
		if(!erTom()) {
			resultat = liste[bak - 1];
		}
		
	return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}
	
    @Override
	public void leggTil(T element) {
    	if(bak == liste.length) {
    		utvid();
    	}
    	
    	if(erTom()) {
    		liste[0] = element;
    	}else if(liste[0].compareTo(element) >= 0) {
    		for(int i = bak-1; i >= 0; i--) {
    			liste[i + 1] = liste[i];
    		}
    		
    		liste[0] = element;
    	} else if(liste[bak - 1].compareTo(element) <= 0) {
    		liste[bak] = element;
    	} else {
    		int i = 0;
    		while(i < bak && liste[i].compareTo(element) < 0) {
    			i++;
    		}
    		
    		if(i == bak) {
    			liste[bak] = element;
    		}else {
    			for(int j = bak-1; j >= i; j--) {
    				liste[j + 1] = liste[j];
    			}
    			
    			liste[i] = element;
    		}
    	}
    	bak++;
    	
    	//TODO
	}

	
	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		// ...Fyll ut
		if(!erTom()) {
			int indeks = finn(element);
			
			if(indeks != -1) {
				for(int i = indeks; i < bak; i++) {
					liste[i] = liste[i + 1];
				}
				bak--;
			}
		}else {
			return null;
		}
		
		
		return element;
		
	}		

	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;
		//...Fyll ut
		
		while(i < bak && resultat == IKKE_FUNNET) {
			if(liste[i] == el) {
				resultat = i;
			}
			i++;
		}
		
		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}


	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++){
			hjelpeTabell[i] = liste[i];
		}
		
		liste = hjelpeTabell;
	}

}// class
