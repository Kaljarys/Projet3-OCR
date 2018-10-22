package fr.upsy.plusmoins;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlusMoinsDuel {

	public static void main(String[] args) {
		/**genere une combinaison pour la machine**/
		ArrayList<Integer> combinaisonMachine = new ArrayList<Integer>();
		for(int i = 0; i< 4; i++) {
			combinaisonMachine.add((int)(Math.random()*9) +1);
		
		
		}
		System.out.println(combinaisonMachine);
		
		/**genere une combinaison pour le joueur et lui transmet**/
		ArrayList<Integer> combinaisonJoueur = new ArrayList<Integer>();
		for(int i = 0; i< 4; i++) {
			combinaisonJoueur.add((int)(Math.random()*9) +1);
		}
		System.out.println("Votre combinaison est " + combinaisonJoueur.toString() );
		
		String joueurIndiceStr = "";
		String machineIndiceStr = ""; 
		int machineProposition = 5555;
		int length = String.valueOf(machineProposition).length();
		int nombreCoup = 0;
		/**boucle while tant que auccun des joueurs nas gagne**/
		while((!joueurIndiceStr.equals("====")) && (!machineIndiceStr.equals("===="))) {
			
		/**demande au joueur une proposition pour deviner la combinaison de la machine**/
			Scanner scJoueurProposition = new Scanner(System.in);
			System.out.println("Essayez de deviner la combinaison a 4 chiffre de votre adversaire, avant qu' il ne decouvre la votre \n");
			int joueurProposition = scJoueurProposition.nextInt();
			
			/** transformer le nombre en arraylist **/
			String[] temp = Integer.toString(joueurProposition).split("");
			ArrayList<Integer> arrayJoueurProp = new ArrayList<Integer>();
			
			for(String current:temp) {
				arrayJoueurProp.add(Integer.parseInt(current));
			}
			System.out.println(arrayJoueurProp);
			
			
			/** comparer chaque chiffre avec la combinaison **/
			ArrayList<String> machineIndice = new ArrayList<String>();
			for(int i = 0; i < combinaisonJoueur.size(); i++) {
				/** si egale renvoyer = dans une array**/
				if(arrayJoueurProp.get(i) == combinaisonMachine.get(i)) {
					machineIndice.add("=");
				}
				/** si inferieur renvoyer + dans une array**/
				else if(arrayJoueurProp.get(i) < combinaisonMachine.get(i)) {
					machineIndice.add("+");
				}
				/** si superieur renvoyer - dans une array**/
				else if(arrayJoueurProp.get(i) > combinaisonMachine.get(i)) {
					machineIndice.add("-");
				}
			}
			System.out.println(machineIndice);
		/**Renvoi la reponse de la machine**/
			machineIndiceStr = "";
			for ( String s : machineIndice) {
				machineIndiceStr += s + "";
			}
			System.out.println("Vous avez propose : " + joueurProposition + " -> Votre adversaire vous repond : "+ machineIndice);
			nombreCoup ++;
			if(machineIndiceStr.equals("====")) {
				break;
			}
		/**envoi la proposition de la machine**/
			System.out.println("Votre adversaire propose " + machineProposition);   /**Proposition de la machine **/
			Scanner scJoueurIndice = new Scanner(System.in);      /**Demande au joueur de repondre avec des +-=**/
			System.out.println("Donnez un indice a votre adversaire grace a +, - et =");
			joueurIndiceStr = scJoueurIndice.next();   /**Reponse du joueur dans une String**/
			
			/**transforme la string en arraylist pour comparer**/
			String[] temp1 = joueurIndiceStr.split("");
			ArrayList<String> arrayJoueurIndice = new ArrayList<String>();    /**Transforme la reponse du joueur en Arraylist pour pouvoir comparer**/
			
			for(String current:temp1) {
				arrayJoueurIndice.add(current);
			}
			System.out.println(arrayJoueurIndice);   /**affiche l' Array juste pour tester**/
			System.out.println("Votre adversaire a propose " + machineProposition + " Vous avez repondu ==> " + joueurIndiceStr );
			/**Transforme int proposition en arraylist pour renvoyer une diferente reponse a chaque fois**/
			ArrayList<Integer> arrayMachineProposition = new ArrayList<Integer>();
			while(machineProposition>0) {
				arrayMachineProposition.add(0, machineProposition%10);
				machineProposition=machineProposition/10;
			}
			
			
			/**Condition pour reponse**/
			
			for(int i = 0; i < arrayJoueurIndice.size(); i++) {
				
				if(arrayJoueurIndice.get(i).equals("+") && nombreCoup == 0){
					arrayMachineProposition.set(i, arrayMachineProposition.get(i)  + 3);
				}
				else if(arrayJoueurIndice.get(i).equals("-") && nombreCoup == 0) {
					arrayMachineProposition.set(i, arrayMachineProposition.get(i)  - 3);
				}
				else if(arrayJoueurIndice.get(i).equals("+") && nombreCoup == 1 && (arrayMachineProposition.get(i) + 2 < 10)) {
					arrayMachineProposition.set(i, arrayMachineProposition.get(i)  + 2);
				}
				else if(arrayJoueurIndice.get(i).equals("-") && nombreCoup == 1 && (arrayMachineProposition.get(i) - 2 > 0)) {
					arrayMachineProposition.set(i, arrayMachineProposition.get(i)  - 2);
				}
				else if (arrayJoueurIndice.get(i).equals("-")) {
					arrayMachineProposition.set(i, arrayMachineProposition.get(i)  - 1);   
				}
				else if(arrayJoueurIndice.get(i).equals("+") ) {
					arrayMachineProposition.set(i, arrayMachineProposition.get(i)  + 1);	    
				}
				else if (arrayJoueurIndice.get(i).equals("=")) {
					arrayMachineProposition.set(i, arrayMachineProposition.get(i));
				}
				else {
					System.out.println("Erreur de saisie, repondez par + - ou =");
				}
			}
			
			ArrayList<String> arrayPropStr = new ArrayList<String>(); /**create a new ArrayLsit<String>**/
			arrayPropStr.add(arrayMachineProposition.toString().replaceAll("\\[|\\]|\\, ", ""));   /**add the datas from arrayprop in the new ArrayList<String>**/
			String propStr = arrayPropStr.stream().map(Object::toString).collect(Collectors.joining(""));  /**Transform the ArrayList<String> to String primitive**/
			machineProposition = Integer.parseInt(propStr);   /**Transform the String to integer to be printed and exploited to find the new proposition of combinasion**/
			
			System.out.println(machineProposition);
			
			
			
		/**fin de boucle while**/
		}
		/**si joueur renvoi "====" vous avez perdu la machine a trouve avant vous**/
		if(machineIndiceStr.equals("====")) {
			System.out.println("Felicitaion, vous avez trouvé la combinaison (" + nombreCoup + " coups)");
		}
		/**si machine renvoi "====" vous avez battue la machine**/
		else if(joueurIndiceStr.equals("====")) {
			System.out.println("Votre adversaire a trouver votre combinaison en premier, vous avez perdu, la combinaison ete " + combinaisonMachine + "(" + nombreCoup + " coups)");
		}
	}
	
	public static ArrayList<Integer> intRandom() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i< 4; i++) {
			result.add((int)(Math.random()*9) +1);
		}
		
		return result;
		}

}
