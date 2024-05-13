package utilitaires;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import model.Groupe;
import model.Scene;

public class Utilitaires {

	public static int saisieInt() {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		try{
			i = sc.nextInt();
		}
		catch(Exception e) {	
		}
		return i;
	}	
	
	public static String getStringFromUser() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		return s;
	}
	
	public static void printGroupes(HashMap<String, Groupe> mapToPrint) {
		for (Entry<String, Groupe> data : mapToPrint.entrySet()) {
			System.out.println(data);
		}	
	}
	
	public static void printScenes(HashMap<String, Scene> mapToPrint) {
		for (Entry<String, Scene> data : mapToPrint.entrySet()) {
			System.out.println(data);
		}
		
	}
}
