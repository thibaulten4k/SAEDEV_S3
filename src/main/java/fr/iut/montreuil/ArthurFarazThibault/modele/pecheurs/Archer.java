package fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs;

import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;
import fr.iut.montreuil.ArthurFarazThibault.modele.projectiles.Fleche;

public class Archer extends Pecheur {

    public Archer(int x, int y) {
        super(x, y, 30, 3, 150);
    }

    @Override
    public Projectile creerProjectile(int x, int y, Poisson cible) {
        return new Fleche(x, y, cible);
    }

}
