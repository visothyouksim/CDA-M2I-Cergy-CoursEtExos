package fait;

import java.util.Random;

public class ToCode1 {

	public static void main(String[] args) {

		int nbMaxOccurence = 0;
		
		//génération d'un tableau de 1000 chiffres aléatoire
		//int[] tabInt = new int[100000000];
		int[] tabInt = {1,4,1,1,5,4,4,4,4};
		/*for(int i = 0; i<tabInt.length; i++ ) {
			tabInt[i] = getRandomNumberUsingNextInt(0,10);
		}*/
		//{1,4,1,1,5,4,4,4,4}
		//check le plus grand nombre de chiffre identique consécutif
		int nbTempOccurence = 1;
		for(int i = 0; i<=tabInt.length; i++) {
			if(i<tabInt.length-1 && tabInt[i]==tabInt[i+1]) {
				nbTempOccurence++;
			}
			else {
				if(nbTempOccurence > nbMaxOccurence) {
					nbMaxOccurence = nbTempOccurence;
				}
				nbTempOccurence = 1;
			}
		}
		System.out.println("Nb occurence max : " + nbMaxOccurence);
	}
	
	
	public static int getRandomNumberUsingNextInt(int min, int max) {
	    Random random = new Random();
	    return random.nextInt(max - min) + min;
	}
}
