package m;

public class Fruit extends Aliment{

	public Fruit(String nom, int dureePousse, int recoltePousse, float prix, float prixPourPlanter) {
		super(nom, dureePousse, recoltePousse, prix, prixPourPlanter);
	}

	@Override
    public void grow() {
		incrementNiveauDeMaturite();
    }

    @Override
    public boolean isMature() {
        return niveauDeMaturite >= dureePoussePourMaturite;
    }
}
