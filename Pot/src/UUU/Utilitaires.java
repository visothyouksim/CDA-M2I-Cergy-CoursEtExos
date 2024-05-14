package UUU;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import m.Aliment;

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
	public static void printArrayList(ArrayList<Aliment> potager) {
		for (Aliment aliment : potager) {
			if (aliment.isReadyToHarvest()) {
				System.out.println(aliment.toString().toUpperCase());
			} else {
				System.out.println(aliment.toString().toLowerCase());
			}
		}
	}
	
	public static void printPotager(ArrayList<Aliment> potager) {
		for (Aliment aliment : potager) {
			if (aliment.isReadyToHarvest()) {
				System.out.println(aliment.toString().toUpperCase());
			} else {
				System.out.println(aliment.toString().toLowerCase());
			}
		}
	}	
}
