package utilitaires;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import model.Aliment;

import java.util.Scanner;

public class Utilitaires {
	
	public static int readInt() {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		try{
			i = sc.nextInt();
		}
		catch(Exception e) {	
		}
		return i;
	}	
	
	public static void printHashMap(HashMap<Aliment, Integer> gardeManger) {
		
	}

	//le truc qui print le potager doit indiquer par une lettre minuscule
	//ce qui n'est pas mûr, et par une majuscule ce qui est prêt à être recolté
	//donc, pas ce qui est en dessous!
	public static void printPotager(ArrayList<Aliment> potager) {
		String pot = "";
		for (Aliment aliment : potager) {
			System.out.println(aliment.toString());
			if(aliment.getDureePousse()==aliment.getMomentPousse()) {
				pot+= aliment.getNom().substring(0, 1).toUpperCase();
			}
			else {
				pot+= aliment.getNom().substring(0, 1).toLowerCase();
			}
		}
		System.out.println(pot);
		
	}
	
	
	
	public static String saisieString() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	
	
}
