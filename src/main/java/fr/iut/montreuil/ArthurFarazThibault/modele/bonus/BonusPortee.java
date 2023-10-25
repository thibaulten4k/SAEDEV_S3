package fr.iut.montreuil.ArthurFarazThibault.modele.bonus;

import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;

public class BonusPortee extends BonusStat {

    public BonusPortee(Pecheur pecheur, int portee) {
        super(pecheur, 0, portee, 0);
    }
}
