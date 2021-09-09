package no.hvl.dat102;

public class CDarkivKlient {

	public static void main(String[] args) {
		CDArkivADT cda = new CDarkiv(1);
		Meny meny = new Meny(cda);
		meny.start();
	}

}
