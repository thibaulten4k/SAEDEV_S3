package fr.iut.montreuil.ArthurFarazThibault.modele;

import javafx.beans.property.SimpleListProperty;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement ;

public class ForgePecheur {

    private Environnement env ;
    private SimpleFabriquePecheur fabriquePecheur ;

    public ForgePecheur ( Environnement env, SimpleFabriquePecheur fabriquePecheur ) {
        this.env = env ;
        this.fabriquePecheur = fabriquePecheur ;
    }

    public Pecheur creerPecheur ( double x, double y, String nom  ) {
        return fabriquePecheur.creerPecheur(x,y,env,nom);
    }

    /*
    public Pecheur creerHarponneur ( double x, double y ) {
        return fabriquePecheur.creerPecheur(x,y,env,"harponneur");
    }

    public Pecheur creerArcher ( double x, double y ) {
        return fabriquePecheur.creerPecheur(x,y,env,"archer");
    }

    public Pecheur creerLanceur ( double x, double y ) {
        return fabriquePecheur.creerPecheur(x,y,env,"lanceur");
    }

    public Pecheur creerTremailleur ( double x, double y ) {
        return fabriquePecheur.creerPecheur(x,y,env,"tremailleur");
    }

*/


}
