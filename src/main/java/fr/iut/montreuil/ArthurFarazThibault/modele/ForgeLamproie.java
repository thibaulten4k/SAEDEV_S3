package fr.iut.montreuil.ArthurFarazThibault.modele;

public class ForgeLamproie extends FabriquePoisson {
    public ForgeLamproie(Environnement terrain){
        super(terrain);
    }


    @Override
    public void creerPoissons(int typePoisson, fr.iut.montreuil.ArthurFarazThibault.modele.Environnement terrain) {
        return new Lamproie(newX, newY, terrain);


    }
}
