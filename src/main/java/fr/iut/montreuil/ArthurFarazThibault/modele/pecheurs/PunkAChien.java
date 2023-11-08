package fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs;

import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import fr.iut.montreuil.ArthurFarazThibault.modele.projectiles.Chien;

public class PunkAChien extends Pecheur {

    public PunkAChien(int x, int y) {
        super(x, y, 120, 5, 250);
    }

    @Override
    public Projectile creerProjectile(int x, int y, Poisson cible) {
        return new Chien(x, y, cible);
    }
}
