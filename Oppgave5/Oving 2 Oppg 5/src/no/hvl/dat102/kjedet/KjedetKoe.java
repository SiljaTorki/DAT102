package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;

public class KjedetKoe<T> implements KoeADT<T>{

	private LinearNode<T> forste = new LinearNode<T>();
	private int antall = 0;
	
	@Override
	public void innKoe(T element) {
		if(antall == 0) {
			forste.setElement(element);
		}else{
			LinearNode<T> node = forste;
			for(int i = 0; i < antall-1; i++) {
				node = node.getNeste();
			}
			node.setNeste(new LinearNode<T>(element));
		}
		
		antall++;
	}

	@Override
	public T utKoe() {
		T retVerdi;
		
		if(erTom()) {
			retVerdi = null;
		}
		
		retVerdi = forste.getElement();
		forste = forste.getNeste();
		antall--;
		
		return retVerdi;
	}

	@Override
	public T foerste() {
		if(erTom()) {
			return null;
		}
		return forste.getElement();
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
