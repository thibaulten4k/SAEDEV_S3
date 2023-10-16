package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Lamproie;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Saumon;

public class FabriqueLamproie extends ForgePoisson {
    public FabriqueLamproie(){
        super();
    }

    @Override
    public Poisson creerPoissons(int x, int y) {
        return new Lamproie(x, y);
    }
}
