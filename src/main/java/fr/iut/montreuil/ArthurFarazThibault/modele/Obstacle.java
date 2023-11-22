package fr.iut.montreuil.ArthurFarazThibault.modele;

public class Obstacle extends Acteur {

    protected static int compteurObstacle = 0;

    public Obstacle(int x, int y, int taille) {
        super(( (x * Case.tailleCase) + 16), ( (y * Case.tailleCase) + 16), taille);
    }

    @Override
    public String genererId() {
        compteurObstacle++;
        return "Obst" + compteurObstacle;
    }

    @Override
    public void actionUnTour() {}
}
