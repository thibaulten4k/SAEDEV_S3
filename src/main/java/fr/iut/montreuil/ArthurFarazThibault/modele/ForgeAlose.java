package fr.iut.montreuil.ArthurFarazThibault.modele;


public class ForgeAlose extends FabriquePoisson {
    public ForgeAlose(Environnement terrain){
        super(terrain);
    }

    @Override
    public void creerPoissons(int typePoisson, Environnement terrain) {
        return new Alose(newX, newY, terrain);

    }
}
