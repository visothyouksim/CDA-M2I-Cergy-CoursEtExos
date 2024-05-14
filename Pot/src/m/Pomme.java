package m;

public class Pomme extends Fruit{
			
	public Pomme() {
		super("Pomme", 2, 2, 2, 3);
		
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
		return "Pomme [nom=" + nom + ", dureeDeLaPoussePourMaturite=" + dureePoussePourMaturite
				+ ", quantiteObtenuLorsDeLaRecolte=" + quantiteObtenuLorsDeLaRecolte + ", niveauDeMaturite="
				+ niveauDeMaturite + ", prixDeVente=" + prixDevente + ", prixPourPlanter=" + prixPourPlanter + "]";
	}

	
	
	
}
