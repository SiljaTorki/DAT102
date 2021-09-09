package no.hvl.dat102;

public interface CDArkivADT {// Bruk gjerne javadoc her i
	// stedet for vanlige
	// kommentarlinjer som her
	// Returnere en tabell av CD-er
	CD[] hentCdTabell();

	// Legger til en ny CD
	void leggTilCd(CD nyCd);

	// Sletter en CD hvis den fins
	boolean slettCd(int cdNr);

	// S�ker og henter CD-er med en gitt delstreng
	CD[] sokTittel(String delstreng);

	// S�ker og henter artister med en gitt delstreng
	CD[] sokArtist(String delstreng);

	// Henter antall CD-er for en gitt sjanger
	int antallSjanger(Sjanger sjanger);

	// Returnerer antall CD-er
	int antall();
}// interface
