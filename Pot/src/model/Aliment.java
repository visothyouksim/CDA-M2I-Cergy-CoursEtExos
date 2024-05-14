package model;

public class Aliment {

	String Nom;
	int dureeDeLaPoussePourMaturite;
	int quantiteObtenuLorsDeLaRecolte;
	int niveauDeMaturite;
	float prixdevente;
	float prixpourplanter;

	public Aliment(String nom, int dureePousse, int recoltePousse, float prix, float prixPourPlanter) {
		super();
		this.Nom = nom;
		this.dureeDeLaPoussePourMaturite = dureePousse;
		this.quantiteObtenuLorsDeLaRecolte = recoltePousse;
		this.prixdevente = prix;
		this.prixpourplanter = prixPourPlanter;
		this.niveauDeMaturite = 0;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		this.Nom = nom;
	}

	public int getDureePousse() {
		return dureeDeLaPoussePourMaturite;
	}

	public void setDureePousse(int dureePousse) {
		this.dureeDeLaPoussePourMaturite = dureePousse;
	}

	public int getRecoltePousse() {
		return quantiteObtenuLorsDeLaRecolte;
	}

	public void setRecoltePousse(int recoltePousse) {
		this.quantiteObtenuLorsDeLaRecolte = recoltePousse;
	}

	public int getMomentPousse() {
		return niveauDeMaturite;
	}

	public void setMomentPousse(int momentPousse) {
		this.niveauDeMaturite = momentPousse;
	}

	public int getDureeDeLaPoussePourMaturite() {
		return dureeDeLaPoussePourMaturite;
	}

	public void setDureeDeLaPoussePourMaturite(int dureeDeLaPoussePourMaturite) {
		this.dureeDeLaPoussePourMaturite = dureeDeLaPoussePourMaturite;
	}

	public int getQuantiteObtenuLorsDeLaRecolte() {
		return quantiteObtenuLorsDeLaRecolte;
	}

	public void setQuantiteObtenuLorsDeLaRecolte(int quantiteObtenuLorsDeLaRecolte) {
		this.quantiteObtenuLorsDeLaRecolte = quantiteObtenuLorsDeLaRecolte;
	}

	public int getNiveauDeMaturite() {
		return niveauDeMaturite;
	}

	public void setNiveauDeMaturite(int niveauDeMaturite) {
		this.niveauDeMaturite = niveauDeMaturite;
	}

	public float getPrixdevente() {
		return prixdevente;
	}

	public void setPrixdevente(float prixdevente) {
		this.prixdevente = prixdevente;
	}

	public float getPrixpourplanter() {
		return prixpourplanter;
	}

	public void setPrixpourplanter(float prixpourplanter) {
		this.prixpourplanter = prixpourplanter;
	}
	
	
	
	
}
