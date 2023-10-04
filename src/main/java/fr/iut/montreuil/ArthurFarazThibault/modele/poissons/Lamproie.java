package fr.iut.montreuil.ArthurFarazThibault.modele.poissons;

import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;

public class Lamproie extends Poisson {

    public Lamproie ( int x, int y, Environnement terrain ) {
        super( x, y, terrain, 6, 17,20, 7);
    }

}
