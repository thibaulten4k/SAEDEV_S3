package fr.iut.montreuil.ArthurFarazThibault.modele.projectiles;

import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import fr.iut.montreuil.ArthurFarazThibault.modele.deplacements.LigneDroite;

public class Harpon extends Projectile {

    public Harpon (int x, int y, Poisson poisson) {
        super(x, y, 10, 12, 14, 60, 30, poisson, null);
        this.setComportement(new LigneDroite(this, poisson));
    }

}
