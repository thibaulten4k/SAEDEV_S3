package fr.iut.montreuil.ArthurFarazThibault.modele.effet;

import fr.iut.montreuil.ArthurFarazThibault.modele.Effet;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.deplacements.SuivreParcours;

public class RetourDebutParcours extends Effet {

    @Override
    public void appliquerEffet(Poisson p) {
        ((SuivreParcours)(p.getComportement())).setIndiceParcours(0);
        ((SuivreParcours)(p.getComportement())).setCompteur(0);
    }

}
