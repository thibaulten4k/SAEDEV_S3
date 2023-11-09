package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.deplacements.LigneDroite;

public abstract class Projectile extends ActeurMobile {

    private int taille;
    private int dureeDeVie;
    private Poisson cible;

    public Projectile(int x, int y, int vitesse, int degat, int taille, int dureeDeVie, Poisson cible) {
        super(x, y, vitesse, degat);

        this.taille = taille;
        this.dureeDeVie = dureeDeVie;
        this.cible = cible;

        this.setComportement(new LigneDroite(this, cible));
    }

    public int getDureeDeVie() { return dureeDeVie; }
    public void soustraireDureeDeVie(int mallus) { dureeDeVie += -mallus; }
    public Poisson getCible() { return cible; }

    public boolean poissonToucher(Poisson p) {
        return ( ( Math.abs(p.getXpropertyValue() - this.getXpropertyValue()) + Math.abs(p.getYpropertyValue() - this.getYpropertyValue()) ) <= this.taille);
    }

    @Override
    public void actionUnTour() {
        comportement.seDeplace();
        attaquer();
        if(comportement.estSortieDuTerrain())
            this.dureeDeVie = 0;

    }

    public abstract void attaquer();

    public String toString() { return "Projectile : " + this.id; }

}
