package m;

public class Carotte extends Aliment{

	
	public Carotte() {
		super("Carotte", 4, 2, 10, 2);
		
	}

	@Override
	public String toString() {
		return "Carotte [nom=" + nom + ", dureeDeLaPoussePourMaturite=" + dureePoussePourMaturite
				+ ", quantiteObtenuLorsDeLaRecolte=" + quantiteObtenuLorsDeLaRecolte + ", niveauDeMaturite="
				+ niveauDeMaturite + ", prixDeVente=" + prixDevente + ", prixPourPlanter=" + prixPourPlanter + "]";
	}
	
	
}
