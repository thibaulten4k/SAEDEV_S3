package fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs;

import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;

public class Lanceur extends Pecheur {

    public Lanceur(int x, int y) {
        super(x, y, 420, 1, 400);
    }

    @Override
    public void attaquer(Poisson p) {
        p.setIndiceParcours(0);
        p.setCompteur(0);
    }
}
