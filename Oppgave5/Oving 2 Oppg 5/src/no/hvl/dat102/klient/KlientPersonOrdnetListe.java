package no.hvl.dat102.klient;

import java.util.Scanner;

import no.hvl.dat102.Person;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class KlientPersonOrdnetListe {

	public static void main(String[] args) {
		KjedetOrdnetListe<Person> kjedet = new KjedetOrdnetListe<Person>();
		TabellOrdnetListe<Person> tabell = new TabellOrdnetListe<Person>();
		
		Scanner sc = new Scanner(System.in);
		
		int n = 4;
		
		for(int i = 0; i < n; i++) {
			int fodselsar;
			String etternavn, fornavn;
			
			System.out.println("Skriv inn fødselsår:");
			fodselsar = Integer.parseInt(sc.nextLine());
			
			System.out.println("Skriv inn fornavn:");
			fornavn = sc.nextLine();
			
			System.out.println("Skriv inn etternavn:");
			etternavn = sc.nextLine();
			
			kjedet.leggTil(new Person(fornavn, etternavn, fodselsar));
			tabell.leggTil(new Person(fornavn, etternavn, fodselsar));
			
		}
		
		System.out.println("Kjedet liste");
		for(int i = 0; i < n; i++) {
			System.out.println(kjedet.fjernFoerste().toString());
		}
		
		System.out.println("Tabelliste");
		for(int i = 0; i < n; i++) {
			System.out.println(tabell.fjernFoerste().toString());
		}
		
		sc.close();
		
	}

}
