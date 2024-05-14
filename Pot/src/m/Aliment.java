package m;

public abstract class Aliment {

    String nom;
    int dureePoussePourMaturite;
    int quantiteObtenuLorsDeLaRecolte;
    int niveauDeMaturite;
    float prixDevente;
    float prixPourPlanter;

    public Aliment(String nom, int dureePousse, int recoltePousse, float prix, float prixPourPlanter) {
        this.nom = nom;
        this.dureePoussePourMaturite = dureePousse;
        this.quantiteObtenuLorsDeLaRecolte = recoltePousse;
        this.prixDevente = prix;
        this.prixPourPlanter = prixPourPlanter;
        this.niveauDeMaturite = 0;
    }

	// Assuming there are properties like 'growthStage' or 'maturityLevel'
    // that determine if the Aliment is ready to be harvested.
    protected int growthStage;

    public Aliment(int growthStage) {
        this.growthStage = growthStage;
    }

    public abstract boolean isReadyToHarvest();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDureePoussePourMaturite() {
        return dureePoussePourMaturite;
    }

    public void setDureePoussePourMaturite(int dureePoussePourMaturite) {
        this.dureePoussePourMaturite = dureePoussePourMaturite;
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

    public float getPrixDevente() {
        return prixDevente;
    }

    public void setPrixDevente(float prixDevente) {
        this.prixDevente = prixDevente;
    }

    public float getPrixPourPlanter() {
        return prixPourPlanter;
    }

    public void setPrixPourPlanter(float prixPourPlanter) {
        this.prixPourPlanter = prixPourPlanter;
    }

    public boolean isMature() {
        return niveauDeMaturite >= dureePoussePourMaturite;
    }

    public float getValeur() {
        return prixDevente;
    }

    public void grow() {
        niveauDeMaturite++;
    }
}