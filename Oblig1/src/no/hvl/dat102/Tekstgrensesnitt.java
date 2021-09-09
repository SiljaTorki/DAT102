package no.hvl.dat102;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class Tekstgrensesnitt {
	// lese opplysningene om en CD fra tastatur
	public CD lesCD(){
		Scanner tastatur = new Scanner(System.in);
		System.out.println("Legg til CD Nummer");
		int CDnummer = tastatur.nextInt();
		
		System.out.println("Legg til Artist");
		String artist = tastatur.nextLine();
		
		System.out.println("Legg til Tittel");
		String tittel = tastatur.nextLine();
		
		System.out.println("Legg til År");
		int aar = tastatur.nextInt();
		
		System.out.println("Legg til Sjanger");
		Sjanger sjanger = Sjanger.finnSjanger(tastatur.nextLine());
		
		System.out.println("Legg til Plateselskap");
		String plateselskap = tastatur.nextLine();
		
		CD nyCD = new CD(CDnummer, artist, tittel, aar, sjanger, plateselskap);
		
		return nyCD;
		
	}

	// vise en CD med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visCD(CD cd) {
		System.out.println("Cd nummer: " + cd.getNummer() + 
							"\n Artist: " + cd.getArtist() +
							"\n Tittel: " + cd.getTittel()+
							"\n År: " +cd.getTittel() +
							"\n Sjanger: " +cd.getSjanger()+
							"\n Plateselskap: " +cd.getPlateselskap());
	}

	// Skrive ut alle CD-er med en spesiell delstreng i tittelen
	public void skrivUtCdDelstrengITittel(CDArkivADT cda, String delstreng){
		for(CD cd : cda.sokTittel(delstreng)) {
			visCD(cd);
		}
		
		
	}

	// Skriver ut alle CD-er av en artist / en gruppe
	public void skrivUtCdArtist(CDArkivADT cda, String delstreng) {
		for(CD cd : cda.sokArtist(delstreng)) {
			visCD(cd);
		}
	}

	// Skrive ut en enkel statistikk som inneholder antall CD-er totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(CDArkivADT cda) {
		int antall = cda.hentCdTabell().length;
		
		System.out.println(antall);
		
		if(antall < 0) {
			Sjanger[] sjanger = Sjanger.values();
			
			for (int i = 0; i < antall; i++) {
				System.out.println(sjanger[i] + ": " + cda.antallSjanger(sjanger[i]));
			}
		}
	}
	// … Ev. andre metoder
}
