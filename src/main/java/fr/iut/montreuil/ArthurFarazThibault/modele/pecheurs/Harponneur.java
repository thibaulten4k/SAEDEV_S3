package fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs;

import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;
import fr.iut.montreuil.ArthurFarazThibault.modele.projectiles.Harpon;

public class Harponneur extends Pecheur {  // la légende raconte que le harpon à la même portée que les bras de Robin

    public Harponneur(int x, int y) {
        super(x, y, 60, 3, 300);
    }

    @Override
    public void attaquer(Poisson p) {
        Projectile proj = new Harpon(this.getXpropertyValue(), this.getYpropertyValue(), p);
        Environnement.getInstance().getListeProjectiles().add(proj);
    }
}
