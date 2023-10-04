package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Lamproie;

public class FabriqueLamproie extends FabriquePoisson {
    public FabriqueLamproie(Environnement terrain){
        super(terrain);
    }


    @Override
    public Poisson creerPoissons( Environnement terrain) {
        return new Lamproie(newX, newY, terrain);


    }
}
