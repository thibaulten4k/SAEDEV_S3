package fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs;

import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;
import fr.iut.montreuil.ArthurFarazThibault.modele.deplacements.SuivreParcours;

public class Lanceur extends Pecheur {

    public Lanceur(int x, int y) {
        super(x, y, 420, 1, 400);
    }

    @Override
    public void attaquer(Poisson p) {
        ((SuivreParcours)(p.getComportement())).setIndiceParcours(0);
        ((SuivreParcours)(p.getComportement())).setCompteur(0);
    }
}
