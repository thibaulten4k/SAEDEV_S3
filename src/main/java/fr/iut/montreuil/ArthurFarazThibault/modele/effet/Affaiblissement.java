package fr.iut.montreuil.ArthurFarazThibault.modele.effet;

import fr.iut.montreuil.ArthurFarazThibault.modele.Effet;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;

public class Affaiblissement extends Effet {

    @Override
    public void appliquerEffet(Poisson p) {
        p.setDegat(p.getDegat()/2);
        if(p.getDegat() < 0)
            p.setDegat(1);
    }

}
