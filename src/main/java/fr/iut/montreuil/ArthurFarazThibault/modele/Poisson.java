package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.deplacements.SuivreParcours;

public class Poisson extends ActeurMobile {

    private int pv;
    private int recompense;

    public Poisson(int x, int y, int vitesse, int pv, int recompense, int degat) {
        super(x, y, vitesse, degat);

        this.pv = pv;
        this.recompense = recompense;
        this.setComportement(new SuivreParcours(this));
    }

    public int getPv() { return this.pv; }
    public int getRecompense() { return recompense ; }
    public void setRecompense(int nouvelleRecompense) { recompense = nouvelleRecompense; }

    public void setPv(int pv) { this.pv = pv; }
    public void subirDegat(int degat) {
        this.pv += -degat;
    }


    public void actionUnTour() {
        comportement.seDeplace();
        if(comportement.estSortieDuTerrain())
            this.meurt();
    }

    public void meurt() {
        this.setPv(0);
        this.setRecompense(0);
        Environnement.getInstance().subirDegat(degat);
    }

    public String toString() { return "Poisson : " + this.id; }

}
