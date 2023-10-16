package fr.iut.montreuil.ArthurFarazThibault.modele;

public abstract class Pecheur extends Acteur{

    private int delai;
    private int portee;
    private int coût ;

    private int compteurDelai;

    public Pecheur (int x, int y, int delai, int portee, int coût) {
        super(x, y);

        this.delai = delai;
        this.portee = portee;
        this.compteurDelai = 0;
        this.coût = coût ;
    }

    public int getCoût() { return coût; }
    public int getPortee() { return portee; }

    public void actionUnTour() {
        Environnement environnement = Environnement.getInstance();

        if (compteurDelai == delai) {
            for (Poisson p : environnement.getListePoissons()) {
                if ( aPorteeDuPecheur(p) && compteurDelai == delai)  {
                    attaquer(p);
                    compteurDelai = 0;
                }
            }
        }
        else {
            compteurDelai++;
        }

    }

    public boolean aPorteeDuPecheur(Poisson p) {
        return ( ( Math.abs(p.getXpropertyValue() - this.getXpropertyValue()) + Math.abs(p.getYpropertyValue() - this.getYpropertyValue()) ) <= this.portee * Case.tailleCase + (Case.tailleCase/2) );
    }

    public String toString() { return "Pecheur : " + this.id; }

    public abstract void attaquer(Poisson p);
}
