package no.hvl.dat102.klient;

import java.util.Scanner;

import no.hvl.dat102.Person;
import no.hvl.dat102.kjedet.KjedetKoe;
import no.hvl.dat102.sirkulaer.SirkulaerKoe;

public class KlientPersonKoe {

	public static void main(String[] args) {
		KjedetKoe<Person> kjedet = new KjedetKoe<Person>();
		SirkulaerKoe<Person> sirkulaer = new SirkulaerKoe<Person>();
		
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
			
			kjedet.innKoe(new Person(fornavn, etternavn, fodselsar));
			sirkulaer.innKoe(new Person(fornavn, etternavn, fodselsar));
			
		}
		
		System.out.println("Kjedet kø");
		for(int i = 0; i < n; i++) {
			System.out.println(kjedet.utKoe().toString());
		}
		
		System.out.println("Sirkulærkø");
		for(int i = 0; i < n; i++) {
			System.out.println(sirkulaer.utKoe().toString());
		}
		
		sc.close();
	}

}
