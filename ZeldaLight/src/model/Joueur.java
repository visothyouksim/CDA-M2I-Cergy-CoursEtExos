package model;

public class Joueur extends Personnage{

	private int pdv;
	private int nbItem;
	
	public Joueur(int x, int y, String sprite, int pdv, int nbItem) {
		super(x, y, sprite);
		this.pdv = pdv;
		this.nbItem = nbItem;
	}

	public int getPdv() {
		return pdv;
	}

	public void setPdv(int pdv) {
		this.pdv = pdv;
	}

	public int getNbItem() {
		return nbItem;
	}

	public void setNbItem(int nbItem) {
		this.nbItem = nbItem;
	}	
	
	
	
}
