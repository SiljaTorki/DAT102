package no.hvl.dat102;

import java.util.Scanner;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private CDArkivADT cda;

	public Meny(CDArkivADT cda) {
		tekstgr = new Tekstgrensesnitt();
		this.cda = cda;
	}

	public void start() {

		Scanner sc = new Scanner(System.in);
		int tast;
		String filnavn = "";

		System.out.println(" Meny");
		System.out.println("Gammelt CD akriv: Tast 1");
		System.out.println("Nytt CD akriv: Tast 2");
		tast = sc.nextInt();
		sc.nextLine();

		switch (tast) {
		case 1:
			System.out.println("Skriv inn navn på fil:");
			filnavn = sc.nextLine();
			cda = Fil.lesFraFil(filnavn);
			break;
		case 2:
			System.out.println("Skriv anntall CD-er");
			int antall = sc.nextInt();
			sc.nextLine();
			System.out.println("Skriv navn på fil");
			filnavn = sc.nextLine();
			CDarkiv ny = new CDarkiv(antall);
			Fil.skrivTilFil(ny, filnavn);
		}

		int ferdig = 0;
		do {
			System.out.println(" 1 - Legg til CD");
			System.out.println(" 2 - Slett CD");
			System.out.println(" 3 - Søk etter tittel");
			System.out.println(" 4 - Søk etter artist");
			System.out.println(" 5 - Antall CD-er for ene gitt sjanger");
			System.out.println(" 6 - Antall CD-er");
			System.out.println(" 0 - Avslutt");

			ferdig = sc.nextInt();
			sc.nextLine();

			switch (ferdig) {
			case 1:
				System.out.println("Skriv inn Cd-nummer:");
				int CDNr = sc.nextInt();
				sc.nextLine();
				System.out.println("Navn på Atrist:");
				String artist = sc.nextLine();
				System.out.println("Tittel:");
				String tittel = sc.nextLine();
				System.out.println("Utgivelses år:");
				int aar = sc.nextInt();
				sc.nextLine();
				System.out.println("Sjanger:");
				Sjanger sjanger = Sjanger.finnSjanger(sc.nextLine());
				System.out.println("Plateselskap:");
				String pls = sc.nextLine();

				CD nyCD = new CD(CDNr, artist, tittel, aar, sjanger, pls);

				cda.leggTilCd(nyCD);
				System.out.println(cda.antall());
				break;
			case 2:
				System.out.println("CD nummer til CD-en som du ønsker å slette");
				int CDnr = sc.nextInt();
				sc.nextLine();
				cda.slettCd(CDnr);
				break;
			case 3:
				System.out.println("Søk tittel:");
				String t = sc.nextLine();
				tekstgr.skrivUtCdDelstrengITittel(cda, t);
				break;
			case 4:
				System.out.println("Søk artist");
				String a = sc.nextLine();
				tekstgr.skrivUtCdArtist(cda, a);
				break;
			case 5:
				System.out.println("Angi sjanger du ønsker å vite sjanger på");
				Sjanger sj = Sjanger.finnSjanger(sc.nextLine());
				System.out.println(cda.antallSjanger(sj));
				
				break;
			case 6:
				System.out.println(cda.antall());
				break;
			case 0:
				System.out.println(" \n Avslutt");
			}
			
			Fil.skrivTilFil(cda, filnavn);
		} while (ferdig != 0);

	}
}
