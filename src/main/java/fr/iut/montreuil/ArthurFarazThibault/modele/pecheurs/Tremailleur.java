package fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs;

import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;
import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import fr.iut.montreuil.ArthurFarazThibault.modele.projectiles.Filet;

public class Tremailleur extends Pecheur {
    public Tremailleur(int x, int y) {
        super(x, y, 180, 3, 200);
    }

    @Override
    public void attaquer(Poisson p) {
        Projectile proj = new Filet(this.getXpropertyValue(), this.getYpropertyValue(), p);
        Environnement.getInstance().getListeProjectiles().add(proj);
    }

}
