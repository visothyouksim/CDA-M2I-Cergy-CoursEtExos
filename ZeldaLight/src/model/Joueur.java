package model;

public class Joueur extends Personnage{

	private int pdv;
	
	public Joueur(int x, int y, String sprite, int pdv) {
		super(x, y, sprite);
		this.pdv = pdv;
	}

	public int getPdv() {
		return pdv;
	}

	public void setPdv(int pdv) {
		this.pdv = pdv;
	}	
	
}
