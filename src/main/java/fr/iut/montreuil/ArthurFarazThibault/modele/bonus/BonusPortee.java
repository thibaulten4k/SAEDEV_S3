package fr.iut.montreuil.ArthurFarazThibault.modele.bonus;

import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;

public class BonusPortee extends BonusStat {

    public BonusPortee(double x, double y, int cout, int bonus) {
        super(x, y, cout, bonus);
    }

    @Override
    public void appliquerBonus() {
        this.pecheur.setPortee(pecheur.getPortee() + this.bonus);
    }

}
