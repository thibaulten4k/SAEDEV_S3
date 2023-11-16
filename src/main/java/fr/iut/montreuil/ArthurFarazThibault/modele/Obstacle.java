package fr.iut.montreuil.ArthurFarazThibault.modele;

public class Obstacle extends Acteur {

    private int resistance;

    public Obstacle(int x, int y, int taille) {
        super(x, y, taille);

        this.resistance = resistance;
    }

    @Override
    public void actionUnTour() {}

    public int getResistance() {
        return resistance;
    }
}
