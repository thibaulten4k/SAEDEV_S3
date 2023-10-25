package fr.iut.montreuil.ArthurFarazThibault.modele.bonus;

import fr.iut.montreuil.ArthurFarazThibault.modele.BonusPecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;

public class BonusStat extends BonusPecheur {
    public BonusStat(Pecheur pecheur, int delai, int portee, int coût) {
        super(pecheur, delai, portee, coût);
    }

    @Override
    public Projectile creerProjectile(int x, int y, Poisson cible) {
        return pecheur.creerProjectile(x, y, cible);
    }

    @Override
    public void attaquer(Poisson p) {
        pecheur.attaquer(p);
    }
}
