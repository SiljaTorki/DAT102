package no.hvl.dat102.mengde.tabell;

import java.util.Iterator;
import java.util.Random;

import no.hvl.dat102.mengde.adt.*;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		T svar = null;
		if (antall > 0) {
			int indeks = tilf.nextInt(antall);
			svar = tab[indeks];
			tab[indeks] = tab[antall - 1];
			antall--;
		}
		return svar;
	}

	@Override
	public T fjern(T element) {
		// Søker etter og fjerner element.Retur med null ved ikke-funn
		
		boolean funnet = false;
		T svar = null;
		
		for(int i = 0; i < tab.length && !funnet; i++) {
			if(tab[i].equals(element)) {
				svar = tab[i];
				tab[i] = tab[antall-1];
				funnet = true;
				antall--;
			}
		}
		
		return svar;
	}
/* Lite effektiv!
	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		TabellMengde<T> begge = new TabellMengde<T>();
		for (int i = 0; i < antall; i++) {
			begge.leggTil(tab[i]);
		}
		Iterator<T> teller = m2.oppramser();

		while (teller.hasNext()) {
			begge.leggTil(teller.next());
		}
		return (MengdeADT<T>)begge;
	}
	*/
	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new TabellMengde<T>();
		//T element = null;		
		Iterator<T> it = m2.oppramser();
		
		for(int i = 0; i < antall; i++) {
			((TabellMengde<T>)begge).settInn(tab[i]);
		}
		
		while(it.hasNext()) {
			begge.leggTil(it.next());
		}
		
		return begge;
	}//
	
	

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new TabellMengde<T>();
		T element= null;
		Iterator<T> it = m2.oppramser();
		
		while(it.hasNext()) {
			element = it.next();
			if(this.inneholder(element)) {
				((TabellMengde<T>)snittM).settInn(element);
			}
		}
		
		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new TabellMengde<T>();
		//T element;
		/*
		 * Fyll ut
		 
			if (!m2.inneholder(element))
				 ((TabellMengde<T>) differensM).settInn(element);
		*/
		
		for(int i = 0; i < antall; i++) {
			if(!m2.inneholder(tab[i])) {
				((TabellMengde<T>)differensM).settInn(tab[i]);
			}
		}
		
		return differensM;
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}

	@Override
	public boolean equals(MengdeADT<T> m2) {
		boolean likeMengder = true;
		//T element;

		Iterator<T> it = m2.oppramser();
		
		if(this.antall == m2.antall()) {
			while(it.hasNext() && likeMengder) {
				if(!this.inneholder(it.next())) {
					likeMengder = false;
				}
			}
		}else {
			likeMengder = false;
		}
		
		return likeMengder;
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext())
			leggTil(teller.next());
	}
	

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		Iterator<T> it = m2.oppramser();
		
		while(it.hasNext() && erUnderMengde) {
			if(!this.inneholder(it.next())) {
				erUnderMengde = false;
			}
		}
		
		return false;
	}

	@Override
	public Iterator<T> oppramser() {
		return new TabellIterator<T>(tab, antall);
	}


}// class
