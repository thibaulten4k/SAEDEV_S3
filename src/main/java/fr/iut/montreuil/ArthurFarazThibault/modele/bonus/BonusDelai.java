package fr.iut.montreuil.ArthurFarazThibault.modele.bonus;

import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;

public class BonusDelai extends BonusStat {


    public BonusDelai(double x, double y, int cout, int bonus) {
        super(x, y, cout, bonus);
    }

    @Override
    public void appliquerBonus() {
        this.pecheur.setDelai(pecheur.getDelai()/ this.bonus);
    }

}
