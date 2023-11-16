package fr.iut.montreuil.ArthurFarazThibault.modele;

public class Obstacle extends Acteur {

    private int resistance;

    public Obstacle(int x, int y, int taille) {
        super(( (x * Case.tailleCase) + 16), ( (y * Case.tailleCase) + 16), taille);

        this.resistance = resistance;
    }

    @Override
    public void actionUnTour() {}

    public int getResistance() {
        return resistance;
    }
}
