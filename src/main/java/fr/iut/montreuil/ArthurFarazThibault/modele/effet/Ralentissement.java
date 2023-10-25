package fr.iut.montreuil.ArthurFarazThibault.modele.effet;

import fr.iut.montreuil.ArthurFarazThibault.modele.Effet;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;

public class Ralentissement extends Effet {

    @Override
    public void appliquerEffet(Poisson p) {
        p.setVitesse(p.getVitesse()/2);
        if (p.getVitesse() < 0)
            p.setVitesse(1);
    }

}
