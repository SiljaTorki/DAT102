package no.hvl.dat102.klient;

import java.util.Scanner;

import no.hvl.dat102.Balansering;

public class KlientBalansering{
     public static void main(String[] args){
        String filnavn;
        Balansering balansering = new Balansering();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Skriv inn antall filer:");
        
        int n = Integer.parseInt(sc.nextLine());
        
        for(int i = 0; i < n; i++) {
        	System.out.println("Skriv inn navnet på filen");
        	filnavn = sc.nextLine();
            balansering.lesFraFil(filnavn);
        }
        
        sc.close();
 }//main

}//class
