package fr.iut.montreuil.ArthurFarazThibault.modele.bonus;

import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;

public class BonusBombe extends BonusTerrain {

    public BonusBombe(double x, double y, int cout) {
        super(x, y, cout);
    }

    @Override
    public void appliquerBonus() {
        Environnement.getInstance().getListeObstacles().remove(obstacle);
    }

}
