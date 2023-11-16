package fr.iut.montreuil.ArthurFarazThibault.modele.bonus;

import fr.iut.montreuil.ArthurFarazThibault.modele.Acteur;
import fr.iut.montreuil.ArthurFarazThibault.modele.Case;

public abstract class Bonus extends Acteur {

    protected int cout;

    public Bonus(double x, double y, int cout) {
        super((int)(x / Case.tailleCase) * Case.tailleCase + Case.tailleCase/2,
                (int)(y / Case.tailleCase) * Case.tailleCase + Case.tailleCase/2, 1);
        this.cout = cout;
    }

    public abstract void appliquerBonus();
    public int getCout() { return cout; }

    @Override
    public void actionUnTour() {}
}
