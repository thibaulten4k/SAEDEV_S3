package fr.iut.montreuil.ArthurFarazThibault.modele.bonus;

import fr.iut.montreuil.ArthurFarazThibault.modele.*;

public abstract class BonusStat extends Acteur {

    protected Pecheur pecheur;
    protected int cout , bonus;

    public BonusStat(double x, double y, int cout, int bonus) {
        super((int)(x / Case.tailleCase) * Case.tailleCase + Case.tailleCase/2,
                (int)(y / Case.tailleCase) * Case.tailleCase + Case.tailleCase/2, 1);
        this.pecheur = Environnement.getInstance().caseOccupeePecheur(this.getXpropertyValue(), this.getYpropertyValue());
        this.cout = cout;
        this.bonus = bonus;

        if(pecheur != null) {
            Environnement.getInstance().ajouterBonusStatAPecheur(this);
        }

    }

    public abstract void appliquerBonus();

    @Override
    public void actionUnTour() {

    }

    public int getCout() {
        return cout;
    }
}
