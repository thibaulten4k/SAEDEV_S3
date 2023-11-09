package fr.iut.montreuil.ArthurFarazThibault.modele.bonus;

import fr.iut.montreuil.ArthurFarazThibault.modele.BonusPecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;

public abstract class BonusTypeAttaque extends BonusPecheur {

    public BonusTypeAttaque(Pecheur pecheur, int delai, int portee, int coût) {
        super(pecheur, delai, portee, coût);
    }

    @Override
    public abstract void attaquer(Poisson p);

}
