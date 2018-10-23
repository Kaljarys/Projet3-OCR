package fr.upsy.mastermind;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;



public class MastermindDef {

	public static void main(String[] args) {
		/**genere la combinaison aleatoire**/
		
		
		ArrayList<Integer> arrayCombinaisonJoueur = new ArrayList<Integer>();
		for(int i = 0; i< 4; i++) {
			arrayCombinaisonJoueur.add((int)(Math.random()*9) +1);
		
		
		}
		ArrayList<String> arrayCombinaisonStr = new ArrayList<String>(); /**create a new ArrayLsit<String>**/
		arrayCombinaisonStr.add(arrayCombinaisonJoueur.toString().replaceAll("\\[|\\]|\\, ", ""));   /**add the datas from arrayprop in the new ArrayList<String>**/
		String propStr = arrayCombinaisonStr.stream().map(Object::toString).collect(Collectors.joining(""));  /**Transform the ArrayList<String> to String primitive**/
		int combinaisonJoueur = Integer.parseInt(propStr);   /**Transform the String to integer to be printed and exploited to find the new proposition of combinasion**/
		
		System.out.println(combinaisonJoueur);
		
		System.out.println(arrayCombinaisonJoueur);
		System.out.println("Votre combinaison est : " + combinaisonJoueur + ", donnez des indications a votre adversaire pour l' aider a la trouver");
		
		/**la machine fait une proposition**/
		ArrayList<Integer> machineProposition = new ArrayList<Integer>();
		for(int i = 0; i < 4 ; i++) {
		machineProposition.add(1);
		}
		System.out.println(machineProposition);
		
		
		 int bienPLace = 0;
		 int present = 0;
		 
		while(bienPLace != 4) {
			/**affiche la propsition de la machine au joueur**/
			System.out.println("Votre adversaire propose " + machineProposition);
		/**Demander le nombre de chiffres bien place**/
			Scanner scBienPLace = new Scanner(System.in);
			System.out.println("Donnez le bnombre de chiffres correctement place dans la combinaison");
			bienPLace = scBienPLace.nextInt();
		/**demander le nombre de chiffre present dans la proposition de la machine**/
			Scanner scPresent = new Scanner(System.in);
			System.out.println("Donnez le bnombre de chiffres present dans la combinaison");
			present = scPresent.nextInt();
			
		}

	}


}
