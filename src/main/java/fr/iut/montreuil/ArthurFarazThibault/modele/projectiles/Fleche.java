package fr.iut.montreuil.ArthurFarazThibault.modele.projectiles;

import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;

public class Fleche extends Projectile {

    public Fleche (int x, int y, Poisson p) {
        super(x, y, 16, 7, 12, 50, 0, p ,null);
    }

  /*  @Override
    public void attaquer() {

        if (Environnement.getInstance().estPresent(getCible())) {

            if (poissonToucher(getCible())) {
                getCible().subirDegat(this.getDegat());
                soustraireDureeDeVie(getDureeDeVie());
            }

        }
    }*/
}
