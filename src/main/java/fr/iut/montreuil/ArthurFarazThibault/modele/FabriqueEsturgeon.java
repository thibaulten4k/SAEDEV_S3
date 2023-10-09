package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Esturgeon;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Saumon;

public class FabriqueEsturgeon extends ForgePoisson {
    public FabriqueEsturgeon(){
        super();
    }

    @Override
    public Poisson creerPoissons(int x, int y) {
        return new Esturgeon(x, y);
    }
}
