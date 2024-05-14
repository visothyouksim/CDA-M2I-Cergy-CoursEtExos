package m;

public class Pdt extends Legume{
	
	public Pdt() {
		super("Pdt", 3, 4, 8, 1);
	}

	@Override
	public String toString() {
		return "Pdt [nom=" + nom + ", dureeDeLaPoussePourMaturite=" + dureePoussePourMaturite
				+ ", quantiteObtenuLorsDeLaRecolte=" + quantiteObtenuLorsDeLaRecolte + ", niveauDeMaturite="
				+ niveauDeMaturite + ", prixDeVente=" + prixDevente + ", prixPourPlanter=" + prixPourPlanter + "]";
	}



	
}
