package no.hvl.dat102.sirkulaer;

import no.hvl.dat102.adt.KoeADT;

public class SirkulaerKoe<T> implements KoeADT<T>{
	private final static int STDK = 100;
	private int front, bak, antall;
	private T[] koe;
	
	
	public SirkulaerKoe() {
		this(STDK);
	}
	
	public SirkulaerKoe(int kapasitet) {
		koe = (T[])(new Object[kapasitet]);
		front = bak = 0;
		antall = 0;
	}
	
	@Override
	public void innKoe(T element) {
		if(antall == koe.length) {
			T[] nyTab = (T[])(new Object[antall * 2]);
			for(int i = 0; i < antall; i++) {
				nyTab[i] = koe[front];
				front = (front + 1) % koe.length;
			}
			front = 0;
			bak = antall;
			koe = nyTab;
		}
		
		koe[bak] = element;
		bak = (bak + 1) % koe.length;
		antall++;
		
	}

	@Override
	public T utKoe() {
		
		T retVerdi;
		
		if(erTom()) {
			retVerdi = null;
		}
		
		retVerdi = koe[front];
		koe[front] = null;
		front = (front + 1) % koe.length;
		antall--;
		
		return retVerdi;
	}

	@Override
	public T foerste() {
		
		if(erTom()) {
			return null;
		}
		
		return koe[front];
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

}
