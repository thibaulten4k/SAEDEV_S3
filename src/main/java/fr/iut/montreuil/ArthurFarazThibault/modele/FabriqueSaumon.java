package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Saumon;

public class FabriqueSaumon extends ForgePoisson {
    public FabriqueSaumon() { super(); }

    @Override
    public Poisson creerPoissons(int x, int y) {
        return new Saumon(x, y);
    }
}
