package fr.iut.montreuil.ArthurFarazThibault.modele;

public abstract class ActeurMobile extends Acteur {

    protected int vitesse, degat;
    protected ComportementDeplacement comportement;

    public ActeurMobile(int x, int y, int taille, int vitesse, int degat) {
        super(x, y, taille);
        this.vitesse = vitesse;
        this.degat = degat;
    }

    public ComportementDeplacement getComportement() { return comportement; }
    public void setComportement(ComportementDeplacement comportement) { this.comportement = comportement; }

    public int getVitesse() { return vitesse; }
    public int getDegat() { return degat; }

    public void setVitesse(int vitesse) { this.vitesse = vitesse; }
    public void setDegat(int degat) { this.degat = degat; }
}
