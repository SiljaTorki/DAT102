package no.hvl.dat102;

import java.util.Scanner;

public class Tekstgrensesnitt {
	private Scanner sc;
	
	public Tekstgrensesnitt(Scanner sc) {
		this.sc = sc;
	}
	
	public Medlem lesInnMedlem() {
		String navn = sc.nextLine(); 

		return new Medlem(navn);
	}
	
	public Hobby lesInnHobby() {
		
		String hobby = sc.nextLine();
		
		return new Hobby(hobby);
	}
	
	public void skrivUtPar(DataKontakt dk) {
		Medlem[] medlemmer = dk.getMedlemmer();
		int ind = -1;
		Medlem medlem;
		int antPar = 0;
		
		System.out.printf("%-20s %s\n", "Parnavn", "Hobbyer");
		
		for(int i = 0; i < dk.getAntallMedlemmer(); i++) {
			medlem = medlemmer[i];
			
			if(medlem.getStatusIndeks() == -1) {
				ind = dk.finnPartnerFor(medlem.getNavn());
			}
			
		 	if(medlem.getStatusIndeks() != -1 && medlem.getStatusIndeks() > i) {
		 		ind = medlem.getStatusIndeks();
		 		System.out.printf("%-20s %s\n", medlem.getNavn() + " og " + medlemmer[ind].getNavn(), medlem.getHobbyer());
		 		antPar++;
		 	}
		}
		
		System.out.println("Antall par funnet: " + antPar);
	}
}
