package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Esturgeon;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Saumon;

public class FabriqueSaumon extends FabriquePoisson {

    public FabriqueSaumon(Environnement terrain) {
        super(terrain);
    }


    @Override
    public Poisson creerPoissons(Environnement terrain) {
        return new Saumon(newX, newY, terrain);


    }
}
