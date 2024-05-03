package model;

public class Personnage {
    // Assuming these are the fields you're trying to initialize
    private int x;
    private int y;
    private String sprite;
    private int vie;

    // Constructor that matches the parameters you're using
    public Personnage(int x, int y, String sprite, int vie) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.vie = vie;
    }

    // Getters and setters for the fields
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public int getVie() {
        return vie;
    }

    public void setHealth(int vie) {
        this.vie = vie;
    }
}
