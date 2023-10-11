package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Archer;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Harponneur;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Lanceur;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Tremailleur;

public class SimpleFabriquePecheur {

        public Pecheur creerPecheur ( double x , double y, Environnement environnement, String nomPecheur ) {
            int newX = (int)(x / Case.tailleCase) * Case.tailleCase + Case.tailleCase/2;
            int newY = (int)(y / Case.tailleCase) * Case.tailleCase + Case.tailleCase/2;
            Pecheur p = null ;
            switch (nomPecheur){
                case "archer":
                    p = new Archer(newX,newY,environnement) ;
                    environnement.ajouterPecheur(p);
                    break ;
                case "harponneur" :
                    p = new Harponneur(newX,newY,environnement) ;
                    environnement.ajouterPecheur(p);
                    break ;
                case "lanceur"  :
                    p = new Lanceur(newX,newY,environnement) ;
                    environnement.ajouterPecheur(p);
                    break ;
                case "tremailleur" :
                    p = new Tremailleur(newX,newY,environnement) ;
                    environnement.ajouterPecheur(p);
                    break ;
            }
            return p ;
        }


}
