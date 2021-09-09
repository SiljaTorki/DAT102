package no.hvl.dat102;

public class Hobby {
	private String hobbyNavn;
	
	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}
	
	public String toString() {
		return hobbyNavn;
	}
	
	public boolean equals(Object hobby2) {
		Hobby andre = (Hobby) hobby2;
		return (hobbyNavn.equals(andre.getHobbyNavn()));
	}
	
	public String getHobbyNavn() {
		return hobbyNavn;
	}
}
