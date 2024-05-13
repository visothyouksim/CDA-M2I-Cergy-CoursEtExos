package model;

public class Media {

	int id;
	String nom;
	String emplacement;
	boolean disponible;
	
	public Media(int id, String nom, String emplacement) {
		this.id=id;
		this.nom=nom;
		this.emplacement=emplacement;
		this.disponible=true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public void invertDisponible() {
		disponible = !disponible;
	}

	
	
	
}
