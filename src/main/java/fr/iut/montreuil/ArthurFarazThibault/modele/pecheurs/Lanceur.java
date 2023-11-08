package fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs;

import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import fr.iut.montreuil.ArthurFarazThibault.modele.deplacements.SuivreParcours;
import fr.iut.montreuil.ArthurFarazThibault.modele.projectiles.Poing;

public class Lanceur extends Pecheur {

    public Lanceur(int x, int y) {
        super(x, y, 420, 1, 400);
    }

    @Override
    public Projectile creerProjectile(int x, int y, Poisson cible) {
        return new Poing(x, y, cible);
    }

}
