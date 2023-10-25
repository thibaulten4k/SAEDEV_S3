package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;

public abstract class BonusPecheur extends Pecheur {

    protected Pecheur pecheur;

    public BonusPecheur(Pecheur pecheur, int delai, int portee, int coût) {
        super(pecheur.getXpropertyValue(), pecheur.getYpropertyValue(), pecheur.getDelai() - delai, pecheur.getPortee() + portee, coût);
        this.pecheur = pecheur;
    }

    @Override
    public abstract void attaquer(Poisson p);

}
