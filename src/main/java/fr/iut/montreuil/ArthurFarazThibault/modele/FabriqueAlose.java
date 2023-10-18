package fr.iut.montreuil.ArthurFarazThibault.modele;


import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Alose;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Saumon;

public class FabriqueAlose extends ForgePoisson {
    public FabriqueAlose() { super(); }

    @Override
    public Poisson creerPoissons(int x, int y) {
        return new Alose(x, y);
    }

}
