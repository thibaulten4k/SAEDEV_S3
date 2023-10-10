package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;
import fr.iut.montreuil.ArthurFarazThibault.modele.FabriquePoisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Esturgeon;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Lamproie;

public class FabriqueEsturgeon extends FabriquePoisson {
    public FabriqueEsturgeon(Environnement terrain){
        super(terrain);
    }


    @Override
    public Poisson creerPoissons(Environnement terrain) {
        return new Esturgeon(newX, newY, terrain);


    }
}
