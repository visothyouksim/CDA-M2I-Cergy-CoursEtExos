package model;

public class Voiture {

	
	//model, reserve d'essence, marche/arret
	private int nbRoues = 4;
	private String model;
	private int essence = 50;
	private boolean marche = false;

	public Voiture(int nbRoues) {
		this.nbRoues = nbRoues;
	}
	
	public Voiture(String model) {
		this.model = model;
	}

	public Voiture(int nbRoues, String model, int essence, boolean marche) {
		this.nbRoues = nbRoues;
		this.model = model;
		this.essence = essence;
		this.marche = marche;
	}







	public int getNbRoues() {
		return nbRoues;
	}

	public void setNbRoues(int nbRoues) {
		this.nbRoues = nbRoues;
	}
	
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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
		return "Voiture [nbRoues=" + nbRoues + ", model=" + model + ", essence=" + essence + ", marche=" + marche + "]";
	}

	
}
