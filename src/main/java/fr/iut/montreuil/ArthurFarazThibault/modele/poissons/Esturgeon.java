package fr.iut.montreuil.ArthurFarazThibault.modele.poissons;

import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;

public class Esturgeon extends Poisson {

    public Esturgeon ( int x, int y, Environnement terrain ) {

        super(x, y, terrain, 1,65,25, 10);

    }

}
