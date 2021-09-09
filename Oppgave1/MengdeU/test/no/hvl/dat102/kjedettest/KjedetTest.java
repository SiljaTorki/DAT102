package no.hvl.dat102.kjedettest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class KjedetTest {

	MengdeADT<Integer> m1;
	MengdeADT<Integer> m2;
	MengdeADT<Integer> fasit;
	MengdeADT<Integer> begge;
	
	@Before
	public void setup() {
		m1 = new KjedetMengde<Integer>();
		m2 = new KjedetMengde<Integer>();
		fasit = new KjedetMengde<Integer>();
		begge = new KjedetMengde<Integer>();
	}
	
	/**
	 * Sjekker at union for kjedet fungerer
	 */
	@Test
	public void testUnion() {
		m1.leggTil(1);
		m1.leggTil(2);
		m1.leggTil(3);
		
		m2.leggTil(1);
		m2.leggTil(4);
		
		fasit.leggTil(1);
		fasit.leggTil(2);
		fasit.leggTil(3);
		fasit.leggTil(4);
		
		
		begge = m1.union(m2);
		
		assertTrue(fasit.equals(begge));
	}
	
	/**
	 * Sjekker at union for kjedet fungerer når m1 og m2 er disjunkte
	 */
	@Test
	public void testUnionDisjunkt() {
		m1.leggTil(1);
		m1.leggTil(2);
		m1.leggTil(3);
		
		m2.leggTil(5);
		m2.leggTil(4);
		
		fasit.leggTil(1);
		fasit.leggTil(2);
		fasit.leggTil(3);
		fasit.leggTil(4);
		fasit.leggTil(5);
	
		begge = m1.union(m2);
		
		assertTrue(fasit.equals(begge));
	}
	
	/**
	 * Sjekker at snitt for kjedet fungerer
	 */
	@Test
	public void testSnitt() {
		m1.leggTil(1);
		m1.leggTil(2);
		m1.leggTil(3);
		
		m2.leggTil(1);
		m2.leggTil(3);
		
		fasit.leggTil(1);
		fasit.leggTil(3);
	
		begge = m1.snitt(m2);
		
		assertTrue(fasit.equals(begge));
	}
	
	/**
	 * Sjekker at snitt for kjedet fungerer når m1 og m2 er disjunkte
	 */
	@Test
	public void testSnittDisjunkt() {
		m1.leggTil(1);
		m1.leggTil(2);
		m1.leggTil(3);
		
		m2.leggTil(5);
		m2.leggTil(4);
	
		begge = m1.snitt(m2);
		
		assertTrue(fasit.equals(begge));
	}
	
	/**
	 * Sjekker at differens for kjedet fungerer
	 */
	@Test
	public void testDifferens() {
		m1.leggTil(1);
		m1.leggTil(2);
		m1.leggTil(3);
		
		m2.leggTil(1);
		m2.leggTil(4);
		
		fasit.leggTil(2);
		fasit.leggTil(3);
	
		begge = m1.differens(m2);
		
		assertTrue(fasit.equals(begge));
	}
	
	/**
	 * Sjekker at differens for kjedet fungerer når m1 og m2 er disjunkte
	 */
	@Test
	public void testDifferensDisjunkt() {
		m1.leggTil(1);
		m1.leggTil(2);
		m1.leggTil(3);
		
		m2.leggTil(5);
		m2.leggTil(4);
		
		fasit.leggTil(1);
		fasit.leggTil(2);
		fasit.leggTil(3);
		
		begge = m1.differens(m2);
		
		assertTrue(fasit.equals(begge));
	}

}
