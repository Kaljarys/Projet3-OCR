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
		/**demande au joueur dessayer de deviner la combinaison**/
			Scanner scJoueurProposition = new Scanner(System.in);
			System.out.println("Essayez de deviner la combinaison de votre adversaire :  \n");
			int joueurProposition = scJoueurProposition.nextInt();
		/**reset des variables **/
			present = 0;
			bienPlace = 0;
		/**transforme joueurProposition en arraylist**/
			String[] temp = Integer.toString(joueurProposition).split("");
			ArrayList<Integer> arrayJoueurProposition = new ArrayList<Integer>();
			
			for(String current:temp) {
				arrayJoueurProposition.add(Integer.parseInt(current));
			}
			System.out.println(arrayJoueurProposition);
			
		/**compare les combinaison**/
			for(int i = 0; i < combinaisonMachine.size(); i++) {
				if(arrayJoueurProposition.get(i) == combinaisonMachine.get(i) ) {   /**si bien place bien place++**/
					bienPlace ++;
					
				}
				else{
					for(int a = 0; a < combinaisonMachine.size(); a++) {
						if(arrayJoueurProposition.get(i) == combinaisonMachine.get(a)) {  /**sinon si dans l' array present++**/
							
							present ++;
						}
					}
				}
			}
			
			/**renvoi present et bien place**/
			
		System.out.println("Proposition : " + joueurProposition + " -> reponse : presents " + (present) + ", bien places " + bienPlace);
		
		
		}
		
		System.out.println("Bravo vous avez trouve la combinaison !!");
	}

}
