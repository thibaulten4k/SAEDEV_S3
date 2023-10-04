package fr.iut.montreuil.ArthurFarazThibault.modele.projectiles;

import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;

public class Filet extends Projectile {
    public Filet (int x, int y, Environnement terrain, Poisson p) {
        super(x, y, terrain, 12, 5, 16, 100, p);
    }

    @Override
    public void attaquer() {

        for (Poisson p : environnement.getListePoissons()) {
            if (poissonToucher(p)) {
                p.subirDegat(this.getDegat());
                p.setVitesse(p.getVitesse() - (p.getVitesse() / 2) );
                soustraireDureeDeVie(getDureeDeVie());
            }
        }
    }

}
