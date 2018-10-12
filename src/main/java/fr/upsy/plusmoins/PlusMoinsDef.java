package fr.upsy.plusmoins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlusMoinsDef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**Genere la combinaison aleatoire et la donne au joueur**/
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i< 4; i++) {
			result.add((int)(Math.random()*9) +1);
		}
		System.out.println("Votre combinaison est " + result + "repondez par +, - ou = pour guider votre adversaire");
		
		/**Algorithme pour deviner la combinaison**/
		int proposition = 5555;            /**Proposition de la machine **/
		int length = String.valueOf(proposition).length();
		String reponse = "";
		int nombreCoup = 0;
		while(!reponse.equals("====")) {
		System.out.println("Votre adversaire propose " + proposition);
		Scanner scReponse = new Scanner(System.in);      /**Demande au joueur de repondre avec des +-=**/
		System.out.println("Donnez un indice a votre adversaire grace a +, - et =");
		reponse = scReponse.next();                 /**Reponse du joueur dans une String**/
		
		/**transforme la string en arraylist pour comparer**/
		String[] temp = reponse.split("");
		ArrayList<String> arrayRep = new ArrayList<String>();    /**Transforme la reponse du joueur en Arraylist pour pouvoir comparer**/
		
		for(String current:temp) {
			arrayRep.add(current);
		}
		System.out.println(arrayRep);   /**affiche l' Array juste pour tester**/
		
		/**Transforme int proposition en arraylist pour renvoyer une diferente reponse a chaque fois**/
		ArrayList<Integer> arrayProp = new ArrayList<Integer>();
		while(proposition>0) {
			arrayProp.add(0, proposition%10);
			proposition=proposition/10;
		}
		System.out.println(arrayProp);
		
		/**Condition pour reponse**/
		for(int i = 0; i < arrayRep.size(); i++) {
			
			if(arrayRep.get(i).equals("+") && nombreCoup == 1 && (arrayProp.set(i, arrayProp.get(i)  + 2) != 5)) {
				arrayProp.set(i, arrayProp.get(i)  + 2);
			}
			else if(arrayRep.get(i).equals("-") && nombreCoup == 1 && (arrayProp.set(i, arrayProp.get(i)  - 2) != 5)) {
				arrayProp.set(i, arrayProp.get(i)  - 2);
			}
			else if(arrayRep.get(i).equals("+") && nombreCoup == 1 && (arrayProp.set(i, arrayProp.get(i)  + 2) == 5)) {
				arrayProp.set(i, arrayProp.get(i)  + 1);
			}
			else if(arrayRep.get(i).equals("-") && nombreCoup == 1 && (arrayProp.set(i, arrayProp.get(i)  - 2) == 5)) {
				arrayProp.set(i, arrayProp.get(i)  - 1);
			}
			else if ((arrayRep.get(i).equals("-") && nombreCoup >= 2) ) {
				arrayProp.set(i, arrayProp.get(i)  - 1);   
			}
			else if(arrayRep.get(i).equals("+") && nombreCoup >= 2 ) {
				arrayProp.set(i, arrayProp.get(i)  + 1);	    
			}
			else if(arrayRep.get(i).equals("+")) {
				arrayProp.set(i, arrayProp.get(i) + arrayProp.get(i)/2); 
			}
			else if (arrayRep.get(i).equals("-") ) {
				arrayProp.set(i, arrayProp.get(i) - arrayProp.get(i)/2);
			}
			else if (arrayRep.get(i).equals("=")) {
				arrayProp.set(i, arrayProp.get(i));
			}
			else {
				System.out.println("Erreur de saisie, repondez par + - ou =");
			}
		}
		
		ArrayList<String> arrayPropStr = new ArrayList<String>(); /**create a new ArrayLsit<String>**/
		arrayPropStr.add(arrayProp.toString().replaceAll("\\[|\\]|\\, ", ""));   /**add the datas from arrayprop in the new ArrayList<String>**/
		String propStr = arrayPropStr.stream().map(Object::toString).collect(Collectors.joining(""));  /**Transform the ArrayList<String> to String primitive**/
		proposition = Integer.parseInt(propStr);   /**Transform the String to integer to be printed and exploited to find the new proposition of combinasion**/
		
		System.out.println(proposition);
		nombreCoup ++;
		
	}
		System.out.println("Votre adversaire a toruve la combinaison en " + nombreCoup);
	
	}
}
