package fr.iut.montreuil.ArthurFarazThibault.modele.poissons;

import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;

public class Saumon extends Poisson {

    public Saumon (int x, int y, Environnement terrain) {
        super(x, y, terrain, 3, 13, 10, 5);
    }

}
