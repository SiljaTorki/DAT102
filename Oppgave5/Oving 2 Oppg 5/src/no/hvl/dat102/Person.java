package no.hvl.dat102;

public class Person implements Comparable<Person>{

	private String fornavn;
	private String etternavn;
	private int fodselsar;
	
	
	public Person(String fornavn, String etternavn, int fodselsar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.fodselsar = fodselsar;
	}
	
	

	public String toString() {
		return fodselsar + " " + etternavn + ", " + fornavn;
	}
	
	@Override
	public int compareTo(Person o) {
		int compare = 0;
		
		if(this.fodselsar == o.fodselsar) {
			if(this.etternavn.equals(o.etternavn)) {
				if(this.fornavn.equals(o.fornavn)) {
					compare = 0;
				}else {
					compare = this.fornavn.compareTo(o.fornavn);
				}
			}else {
				compare = this.etternavn.compareTo(o.etternavn);
			}
			
		}else if(this.fodselsar > o.fodselsar) {
			compare = 1;
		}else if(this.fodselsar < o.fodselsar) {
			compare = -1;
		}
		return compare;
	}
	
	public String getFornavn() {
		return fornavn;
	}



	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}



	public String getEtternavn() {
		return etternavn;
	}



	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}



	public int getFodselsar() {
		return fodselsar;
	}



	public void setFodselsar(int fodselsar) {
		this.fodselsar = fodselsar;
	}





}
