package fr.iut.montreuil.ArthurFarazThibault.modele;


import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Alose;

public class FabriqueAlose extends FabriquePoisson {
    public FabriqueAlose(Environnement terrain){
        super(terrain);
    }

    @Override
    public Poisson creerPoissons( Environnement terrain) {
        return new Alose(newX, newY, terrain);

    }
}
