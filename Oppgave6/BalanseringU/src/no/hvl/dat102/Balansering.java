package no.hvl.dat102;

import java.io.*;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.kjedet.KjedetStabel;
import no.hvl.dat102.kjedet.LinearNode;

public class Balansering {
	// Her opphever du kommentarsetning n�r du har f�tt lagt inn
	// n�dvendig kode
	KjedetStabel<Parentesinfo>stabel = new KjedetStabel<Parentesinfo>();

	private boolean passer(char �pent, char lukket) {
		switch (�pent) {
		case '(':
			return (lukket == ')');
		case '[':
			return (lukket == ']');
		case '{':
			return (lukket == '}');
		default:
			return false;
		}
	}//

	public void foretaBalansering(String innDataStreng, int linjenr) {

		LinearNode<Parentesinfo> nyNode = new LinearNode<Parentesinfo>();
		Parentesinfo par;
		
		int lengde = innDataStreng.length();
		// Fyll ut
		
		for(int i = 0; i < lengde; i++) {
			char c = innDataStreng.charAt(i);
			
			if(c == '(' || c == '{' || c == '[') {
				par = new Parentesinfo();
				par.setVenstreparentes(c);
				par.setLinjenr(linjenr);
				par.setPosisjon(i);
				
				nyNode.setElement(par);
				
				stabel.push(par);
			}
			
			if(c == ')' || c == '}' || c == ']') {
				try {
					par = stabel.pop();
					
					if(!passer(par.getVenstreparentes(), c)) {
						System.out.println("Lukkeparentes " + c + " p� linje " + linjenr + ", tegn nummer " + i + 
											" har feil �pnesymbol");
					}
				}catch(EmptyCollectionException e) {
					System.out.println("Lukkeparentes " + c + " p� linje " + linjenr + ", tegn nummer " + i + 
										" mangler tilsvarende �pnesymbol");
				}
				
			}
			
		}
	}//

	public void lesFraFil(String filnavn) {
		FileReader tekstFilLeser = null;
		try {
			tekstFilLeser = new FileReader(filnavn);
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ike filen!");
			System.exit(-1);
		}

		BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
		String linje = null;
		int linjenr = 0;
		try {
			linje = tekstLeser.readLine();
			while (linje != null) {
				// kalle metode her!
				// Fyll ut
				
				foretaBalansering(linje, linjenr);
				linjenr++;
				
				linje = tekstLeser.readLine();

			} // while
			
			if(stabel.antall() > 0) {
				Parentesinfo par;
				while(stabel.antall() > 0) {
					par = stabel.pop();
					System.out.println("�pnesymbol p� linje " + par.getLinjenr() + ", tegn nummer " + par.getPosisjon() + 
										" blir ikke lukket");
				}
			}
			
		}

		catch (IOException unntak) {
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}
		try {
			tekstFilLeser.close();
		} catch (IOException unntak) {
			System.out.println("Feil ved lukking av fil!");
		}

	}// metode

}// class
