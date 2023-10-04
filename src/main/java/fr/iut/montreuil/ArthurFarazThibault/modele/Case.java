package fr.iut.montreuil.ArthurFarazThibault.modele;

public class Case {

    public final static int tailleCase = 32;
    private int y;
    private int x;
    private int poids;

    public Case(int x, int y, int poids) {

        this.y = x;
        this.x = y;
        this.poids = poids;
    }

    public int getY() {
        return this.y;
    }
    public int getX() {
        return this.x;
    }
    public int getPoids() {
        return this.poids;
    }

    public void setPoids(int poids) { this.poids = poids; }

    public String toString() {
        return "case " + y + "," + x;
    }
}
