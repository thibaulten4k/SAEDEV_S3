package fr.iut.montreuil.ArthurFarazThibault.modele.projectiles;

import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;

public class Harpon extends Projectile {

    public Harpon (int x, int y, Poisson p) {
        super(x, y, 12, 13, 8, 100, p);
    }

    public void attaquer() {

        for (Poisson p : Environnement.getInstance().getListePoissons()) {
            if (poissonToucher(p)) {
                p.subirDegat(this.getDegat());
                soustraireDureeDeVie(getDureeDeVie());
            }
        }

    }

}
