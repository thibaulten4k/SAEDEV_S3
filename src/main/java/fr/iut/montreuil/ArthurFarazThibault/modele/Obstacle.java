package fr.iut.montreuil.ArthurFarazThibault.modele;

public class Obstacle extends Acteur {

    private int resistance;
    protected static int compteurObstacle = 0;

    public Obstacle(int x, int y, int taille) {
        super(( (x * Case.tailleCase) + 16), ( (y * Case.tailleCase) + 16), taille);

        this.resistance = resistance;
    }

    @Override
    public String genererId() {
        compteurObstacle++;
        return "Obst" + compteurObstacle;
    }

    @Override
    public void actionUnTour() {}

    public int getResistance() {
        return resistance;
    }
}
