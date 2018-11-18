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
		
		System.out.println(combinaisonJoueur);  /*print de controle*/
		
		System.out.println(arrayCombinaisonJoueur);   /*print de controle*/
		System.out.println("Votre combinaison est : " + combinaisonJoueur + ", donnez des indications a votre adversaire pour l' aider a la trouver");
		
		/**la machine fait une proposition**/
		ArrayList<Integer> machineProposition = new ArrayList<Integer>();
		machineProposition.add(1);
		machineProposition.add(1);
		machineProposition.add(2);
		machineProposition.add(2);
		System.out.println(machineProposition);
		/*Genere la liste de toute les combinaisons possible*/
		ArrayList<Integer> listCombinaison = new ArrayList<Integer>();
		int possibleComb = 1111;
		for (int i = 1111; i < 9999; i++) {
			listCombinaison.add(possibleComb);
			possibleComb++;
		}
		for (int i = 0; i < listCombinaison.size(); i++) {
			if(String.valueOf(listCombinaison.get(i)).contains("0")) {
				listCombinaison.remove(i);
			}
		}
		System.out.println(listCombinaison);   /*print de controle*/
		ArrayList<Integer> arrayRemainingComb = new ArrayList<Integer>();  /*list des combinaison restante*/
		for(int i = 0; i < listCombinaison.size(); i++ ) {
			arrayRemainingComb.add(listCombinaison.get(i));
		}
		
		System.out.println(arrayRemainingComb);  /*print de controle*/
		 int bienPlace = 0;
		 int present = 0;
		 int nbCoups = 0;
		 int maxScore = 0;
		 
		 
		while(bienPlace != 4) {
			int currentScore = 0;
			nbCoups ++;
			/**affiche la propsition de la machine au joueur**/
			System.out.println("Votre adversaire propose " + machineProposition);
		/**Demander le nombre de chiffres bien place**/
			Scanner scBienPlace = new Scanner(System.in);
			System.out.println("Donnez le nombre de chiffres correctement place dans la combinaison");
			bienPlace = scBienPlace.nextInt();
			if(bienPlace == 4) {
				break;
			}
		/**demander le nombre de chiffre present dans la proposition de la machine**/
			Scanner scPresent = new Scanner(System.in);
			System.out.println("Donnez le nombre de chiffres present dans la combinaison qui ne sont pas correctement place");
			present = scPresent.nextInt();
			
			
		/*Compare les chiffres des list avec les resultats obtenue et cherche pour la meilleur proposition*/	
			
			
			currentScore = (bienPlace*2) + present;
			System.out.println("currentScore" + currentScore);
			System.out.println("maxScore  " + maxScore);
			if(currentScore > maxScore) {
				maxScore = currentScore;
			}
			System.out.println(maxScore);
			if (currentScore == 0) {
				for(int i = 0; i < arrayRemainingComb.size(); i++){
					for(int j = 0; j < String.valueOf(arrayRemainingComb.get(i)).length(); j++) {
						if(String.valueOf(arrayRemainingComb.get(i)).contains(String.valueOf(machineProposition.get(j)))) {
							arrayRemainingComb.remove(i);
							i=0;
						}
					}
				}
			}
			System.out.println(arrayRemainingComb);   /*print de controle*/

		}	
			
			
		
		System.out.println("Votre adversaire a trouver la combinaison en " + nbCoups + " coups.");

	}

}

