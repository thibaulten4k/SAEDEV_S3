package fr.iut.montreuil.ArthurFarazThibault.modele;

public abstract class Pecheur extends Acteur{

    private int delai, portee, cout;

    private int compteurDelai;
    protected static long compteurPecheur = 0;

    public Pecheur (int x, int y, int delai, int portee, int cout) {
        super(x, y, 16);

        this.delai = delai;
        this.portee = portee;
        this.compteurDelai = 0;
        this.cout = cout;
    }

    public int getCout() { return cout; }

    public int getPortee() { return portee; }
    public void setPortee(int nouvPortee) { portee = nouvPortee; }
    public int getDelai() {
        return delai;
    }
    public void setDelai(int nouvDelai) {
        delai = nouvDelai;
        compteurDelai = 0;
    }

    @Override
    public String genererId() {
        compteurPecheur++;
        return "Pech" + compteurPecheur;
    }

    public void actionUnTour() {
        Environnement environnement = Environnement.getInstance();

        if (compteurDelai == delai) {
            for (Poisson p : environnement.getListePoissons()) {
                if ( aPorterDuPecheur(p) && compteurDelai == delai)  {
                    attaquer(p);
                    compteurDelai = 0;
                }
            }
        }
        else {
            compteurDelai++;

        }

    }

    public boolean aPorterDuPecheur(Poisson p) {
        return ( ( Math.abs(p.getXpropertyValue() - this.getXpropertyValue()) + Math.abs(p.getYpropertyValue() - this.getYpropertyValue()) ) <= this.portee * Case.tailleCase + (Case.tailleCase/2) );
    }

    public String toString() { return "Pecheur : " + this.id; }

    public abstract Projectile creerProjectile(int x, int y, Poisson cible);

    public void attaquer(Poisson p) {
        Projectile proj = creerProjectile(this.getXpropertyValue(), this.getYpropertyValue(), p);
        Environnement.getInstance().ajouterAListeProjectiles(proj);
    }
}
