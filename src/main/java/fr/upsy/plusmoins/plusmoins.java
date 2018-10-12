package fr.upsy.plusmoins;

import java.util.ArrayList;
import java.util.Scanner;

public class plusmoins {
	
	public  static void main(String[] args) {
	
	
	
		// TODO Auto-generated method stub
		/**genere 4 chiffre random entre 1 et 9**/
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i< 4; i++) {
			result.add((int)(Math.random()*9) +1);
		
		
		}
		System.out.println(result);
		/**demander au joueur un nombre a 4 chiffres**/
		String indiceStr = "";
		/** Tant que le resultat nest pas "====" boucle sur demander une combinaison**/
		while(!indiceStr.equals("====")) {
		Scanner scProposition = new Scanner(System.in);
		System.out.println("Essayez de deviner la combinaison a 4 chiffre \n");
		int proposition = scProposition.nextInt();
		
		/** transformer le nombre en arraylist **/
		String[] temp = Integer.toString(proposition).split("");
		ArrayList<Integer> arrayProp = new ArrayList<Integer>();
		
		for(String current:temp) {
			arrayProp.add(Integer.parseInt(current));
		}
		System.out.println(arrayProp);
		
		
		/** comparer chaque chiffre avec la combinaison **/
		ArrayList<String> indice = new ArrayList<String>();
		for(int i = 0; i < result.size(); i++) {
			/** si egale renvoyer = dans une array**/
			if(arrayProp.get(i) == result.get(i)) {
				indice.add("=");
			}
			/** si inferieur renvoyer + dans une array**/
			else if(arrayProp.get(i) < result.get(i)) {
				indice.add("+");
			}
			/** si superieur renvoyer - dans une array**/
			else if(arrayProp.get(i) > result.get(i)) {
				indice.add("-");
			}
		}
		System.out.println(indice);
		 
		/** renvoyer larray sous forme de string avec les + - =  **/
		indiceStr = "";
		for ( String s : indice) {
			indiceStr += s + "";
		}
		System.out.println("Proposition : " + proposition + " -> Reponse : "+ indiceStr);
		
		
		}
		/**si tout identique gagne!**/
		System.out.println("Felicitaion, vous avez trouvé la combinaison");
		

		}

}

