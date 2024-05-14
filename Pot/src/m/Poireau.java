package m;

public class Poireau extends Legume{

	
	
	public Poireau() {
		super("Poireau", 5, 2, 3, 2);
		
	}

	@Override
    public void grow() {
		incrementNiveauDeMaturite();
    }

    @Override
    public boolean isMature() {
        return niveauDeMaturite >= dureePoussePourMaturite;
    }


	@Override
	public String toString() {
		return "Poireau [nom=" + nom + ", dureeDeLaPoussePourMaturite=" + dureePoussePourMaturite
				+ ", quantiteObtenuLorsDeLaRecolte=" + quantiteObtenuLorsDeLaRecolte + ", niveauDeMaturite="
				+ niveauDeMaturite + ", prixDeVente=" + prixDevente + ", prixPourPlanter=" + prixPourPlanter + "]";
	}

	

	
	
	
}
