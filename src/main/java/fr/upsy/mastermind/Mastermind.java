package fr.upsy.mastermind;

import java.util.ArrayList;
import java.util.Scanner;

public class Mastermind {

	public static void main(String[] args) {
		/**genere la combinaison**/
		ArrayList<Integer> combinaisonMachine = new ArrayList<Integer>();
		for(int i = 0; i< 4; i++) {
			combinaisonMachine.add((int)(Math.random()*9) +1);
		
		
		}
		
		System.out.println(combinaisonMachine);
		
		/**variables**/
		int present = 0;
		int bienPlace = 0;
		int nombreCoup = 0;
		
		/**boucle while tant que le joueur na pas trouve la combinaison**/
		while(bienPlace != 4) {
			ArrayList<Integer> listComb = new ArrayList<Integer>();  // garde en memoir les chiffre deja present ou bien place sur ce tour
		/**demande au joueur dessayer de deviner la combinaison**/
			Scanner scJoueurProposition = new Scanner(System.in);
			System.out.println("Essayez de deviner la combinaison de votre adversaire :  \n");
			int joueurProposition = scJoueurProposition.nextInt();
		/**reset des variables **/
			bienPlace = 0;
			present = 0;
		/**transforme joueurProposition en arraylist**/
			String[] temp = Integer.toString(joueurProposition).split("");
			ArrayList<Integer> arrayJoueurProposition = new ArrayList<Integer>();
			
			for(String current:temp) {
				arrayJoueurProposition.add(Integer.parseInt(current));
			}
			System.out.println(arrayJoueurProposition);
			
		/*compare les combinaisons*/
			
			ArrayList<Integer> arrayIndex = new ArrayList<Integer>();
			
			for(int i = 0; i < combinaisonMachine.size(); i++) {
				if(arrayJoueurProposition.get(i) == combinaisonMachine.get(i) ) {   /**si bien place bienPlace++**/
					arrayIndex.add(i);
					
					bienPlace ++;
					
				}
			}
				 
			for(int j =0; j < combinaisonMachine.size(); j++) {
				for(int k = 0; k < combinaisonMachine.size(); k++) {
					if(arrayJoueurProposition.get(j) == combinaisonMachine.get(k) && !arrayIndex.contains(k) ) {
						present++;
						arrayIndex.add(k);
						break;
					}
				}
				
			}
				
			
		
			
			/**renvoi present et bien place**/
			System.out.println(arrayIndex);
		System.out.println("Proposition : " + joueurProposition + " -> reponse : presents " + present + ", bien places " + bienPlace);
		
		
		}
		
		System.out.println("Bravo vous avez trouve la combinaison !!");
	}
	
	/*public static int BienPlace(ArrayList<Integer> combinaisonMachine, ArrayList<Integer> arrayJoueurProposition) {
			
		int  bienPlace = 0 ;
			for(int i = 0; i < combinaisonMachine.size(); i++) {
				if(arrayJoueurProposition.get(i) == combinaisonMachine.get(i) ) {   *//**si bien place bienPlace++**//*
					
					
					bienPlace ++;
					
				}
			}
			return bienPlace;
					
				
			}
	public static int Present(ArrayList<Integer> combinaisonMachine, ArrayList<Integer> arrayJoueurProposition) {
		int present = 0;
		int present1 = 0;
		int present2 = 0;
		int present3 = 0;
		int present4 = 0;
		int present5 = 0;
		int present6 = 0;
		int present7 = 0;
		int present8 = 0;
		int present9 = 0;
		for(int i = 0; i < combinaisonMachine.size(); i++) {
		 if (combinaisonMachine.contains(arrayJoueurProposition.get(i)) && arrayJoueurProposition.get(i) != combinaisonMachine.get(i)) {
				present++;
			}
		}
		return present;
	}*/
		
	
}





		










