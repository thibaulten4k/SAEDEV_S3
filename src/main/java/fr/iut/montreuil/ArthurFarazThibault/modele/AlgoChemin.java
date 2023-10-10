package fr.iut.montreuil.ArthurFarazThibault.modele;

import java.util.ArrayList;
import java.util.LinkedList;

public class AlgoChemin {

    private Environnement environnement;
    private Case source ;
    private ArrayList<Case> parcours ;
    private LinkedList<Case> fifo ;

    public AlgoChemin (Environnement environnement) {
        this.environnement = environnement;
        this.source = trouverSource() ;
        this.parcours = new ArrayList<Case>() ;
        this.fifo = new LinkedList<Case>() ;

    }

    public Case trouverSource () {
        for (int i = 0; i < environnement.getNbLignes() ; i++) {

            for (int j = 0; j < environnement.getNbColonnes() ; j++){
                if (environnement.getPoidsCase(i, j) == 9)
                    return this.getCase(i, j);
            }
        }

        return null;
    }

    public ArrayList<Case> trouverParcours () {

        Case CaseTraite ;
        fifo.addFirst(source);

        while ( ! fifo.isEmpty() ) {
            CaseTraite = fifo.pollLast();
            System.out.println(CaseTraite);
            parcours.add(CaseTraite) ;
            CaseTraite = this.getAdjacent(CaseTraite, parcours) ;
            if (CaseTraite != null)
            fifo.addFirst(CaseTraite);


        }

        return parcours ;
    }

    public Case getCase(int x, int y) {
        if (x < 0 || x >= environnement.getNbLignes() || y < 0 || y >= environnement.getNbColonnes())
            return null;
        else
            return environnement.getTerrain()[x][y];

    }

    public Case getAdjacent (Case traite, ArrayList<Case> parcours ) {

        Case testé;
        int[] modif = {1, -1};

        //Ici c'est les X
        for (int i = 0; i < modif.length; i++) {
            testé = this.getCase(traite.getY() + modif[i], traite.getX());

            if (testé != null && testé.getPoids() == 0 && !parcours.contains(testé))
                return testé;
        }

        //Ici c'est les Y
        for (int i = 0; i < modif.length; i++) {
            testé = this.getCase(traite.getY(), traite.getX() + modif[i]);

            if ( testé != null && testé.getPoids() == 0 && ! parcours.contains(testé) )
                return testé ;
        }
        return null;
    }

}
