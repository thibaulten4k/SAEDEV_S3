package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Alose;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Esturgeon;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Lamproie;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Saumon;

public class FabriquePoisson {

    public FabriquePoisson(Environnement terrain) {

    }

    public Poisson creerPoissons(Environnement terrain, String typePoisson){

        int newX = terrain.getParcours().get(0).getX() * Case.tailleCase + Case.tailleCase/2 ;
        int newY = terrain.getParcours().get(0).getX() * Case.tailleCase + Case.tailleCase/2 ;
        Poisson poisson ;

        switch (typePoisson) {
            case "Saumon":
                poisson = new Saumon( newX , newY, terrain ) ;
                break;

            case "Alose":
                poisson = new Alose( newX, newY, terrain ) ;
                break;

            case "Esturgeon":
                poisson = new Esturgeon( newX, newY, terrain ) ;
                break;

            case "Lamproie":
                poisson = new Lamproie( newX, newY, terrain ) ;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + typePoisson);
        }
        return poisson;
    }
}
