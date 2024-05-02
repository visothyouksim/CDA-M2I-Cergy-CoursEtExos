package model;

public class Voiture {

	
	//model, reserve d'essence, marche/arret
	private int nbRoues = 4;
	private final String MODEL;
	private int essence = 50;
	private boolean marche = false;
	
	public Voiture(String model) {
		this.MODEL = model;
	}

	public int getNbRoues() {
		return nbRoues;
	}

	public void setNbRoues(int nbRoues) {
		this.nbRoues = nbRoues;
	}
	
	
	public String getModel() {
		return MODEL;
	}

	public int getEssence() {
		return essence;
	}

	public void setEssence(int essence) {
		this.essence = essence;
	}

	public boolean isMarche() {
		return marche;
	}

	public void setMarche(boolean marche) {
		this.marche = marche;
	}



	@Override
	public String toString() {
		return "Voiture [nbRoues=" + nbRoues + ", model=" + MODEL + ", essence=" + essence + ", marche=" + marche + "]";
	}

	
}
