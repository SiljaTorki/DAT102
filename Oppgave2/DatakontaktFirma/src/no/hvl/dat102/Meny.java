package no.hvl.dat102;

import java.util.Scanner;

public class Meny {
	private Scanner sc = new Scanner(System.in);
	private Tekstgrensesnitt tekstgr = new Tekstgrensesnitt(sc);
	private DataKontakt dk = new DataKontakt();
	
	public void start() {
		System.out.println("Skriv inn antall medlemmer du vil legge inn");
		int antall = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < antall; i++) {
			leggTilMedlem();
			
		}
		
		tekstgr.skrivUtPar(dk);
		
	}
	
	public void leggTilMedlem() {
		Medlem medlem;
		
		System.out.println("Skriv inn navn på medlem");
		String inn = sc.nextLine();
		
		medlem = new Medlem(inn);
		
		System.out.println("Skriv inn hobbyer, 0 for å avslutte");
		
		inn = sc.nextLine();
		while(!inn.equals("0")) {
			medlem.leggTilHobby(new Hobby(inn));
			inn = sc.nextLine();
		}
		
		
		dk.leggTilMedlem(medlem);
		
	}
	
	
}
