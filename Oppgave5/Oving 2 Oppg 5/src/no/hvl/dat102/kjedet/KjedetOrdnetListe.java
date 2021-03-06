package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.OrdnetListeADT;

/**
 * 
 * @param <T>
 *            elementtypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		T svar = null;
		
		if(!erTom()) {
			svar = foerste.getElement();
			foerste = foerste.getNeste();
			antall--;
		}
		
		//...Fyll ut
		return svar;
	}

	@Override
	public T fjernSiste() {
		T svar = null;
		
		if(!erTom()) {
			svar = siste.getElement();
			
			if(antall == 1) {
				siste = null;
				foerste = null;
			}else {
				LinearNode<T> denne = foerste;
				
				while(!denne.getNeste().equals(siste)) {
					denne = denne.getNeste();
				}
				
				denne.setNeste(null);
				siste = denne;
				
			}
			
			antall--;
		}
		
		//...Fyll ut
		return svar;
	}

	@Override
	public T foerste() {
		T svar = null;
		if (!erTom()) {
			svar = foerste.getElement();
		}
		return svar;
	}

	@Override
	public T siste() {
		T svar = null;
		if (!erTom()) {
			svar = siste.getElement();
		}
		return svar;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {
		LinearNode<T> forrige = null, denne = foerste;
		LinearNode<T> nyNode = new LinearNode<T>(element);
		boolean lagtInn = false;
		
		if(erTom()) {
			foerste = nyNode;
			siste = nyNode;
		}else {
			if(foerste.getElement().compareTo(element) >= 0) {
				nyNode.setNeste(foerste);
				foerste = nyNode;
			}else if(siste.getElement().compareTo(element) <= 0){
				siste.setNeste(nyNode);
				
				siste = nyNode;
				
				if(antall == 1) {
					foerste.setNeste(siste);
				}
			}else {
				while(denne != null && !lagtInn) {
					if(denne.getElement().compareTo(element) >= 0) {
						forrige.setNeste(nyNode);
						nyNode.setNeste(denne);
						lagtInn = true;
					}
					
					forrige = denne;
					denne = denne.getNeste();
					
				}
			}
		}
		
		antall++;
		
		
		//...Fyll ut
	}


	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) {     // F?rste element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

}// class
