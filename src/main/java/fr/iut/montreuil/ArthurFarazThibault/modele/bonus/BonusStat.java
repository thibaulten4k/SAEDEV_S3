package fr.iut.montreuil.ArthurFarazThibault.modele.bonus;

import fr.iut.montreuil.ArthurFarazThibault.modele.*;

public abstract class BonusStat extends Bonus {

    protected Pecheur pecheur;
    protected int bonus;

    public BonusStat(double x, double y, int cout, int bonus) {
        super(x, y, cout);
        this.pecheur = Environnement.getInstance().caseOccupeePecheur(this.getXpropertyValue(), this.getYpropertyValue());
        this.bonus = bonus;

        if(pecheur != null) {
            Environnement.getInstance().ajouterBonusAEnvironnement(this);
        }

    }

}
