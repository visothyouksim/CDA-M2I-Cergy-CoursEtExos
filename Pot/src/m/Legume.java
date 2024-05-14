package m;

public class Legume extends Aliment {

    public Legume(String nom, int dureePousse, int recoltePousse, float prix, float prixPourPlanter) {
        super(nom, dureePousse, recoltePousse, prix, prixPourPlanter);
    }

    @Override
    public boolean isReadyToHarvest() {
        // Example condition: Legume is ready to be harvested if its growthStage is 5 or more
        return super.growthStage >= 5;
    }
}
