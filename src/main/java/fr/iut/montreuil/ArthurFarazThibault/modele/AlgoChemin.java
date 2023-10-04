package fr.iut.montreuil.ArthurFarazThibault.modele;

import java.util.ArrayList;
import java.util.LinkedList;

public class AlgoChemin {

    private Environnement terrain;
    private Case source ;
    private ArrayList<Case> parcours ;
    private LinkedList<Case> fifo ;

    public AlgoChemin (Environnement terrain) {

        this.terrain = terrain;
        this.source = trouverSource() ;
        this.parcours = new ArrayList<Case>() ;
        this.fifo = new LinkedList<Case>() ;

    }

    public Case trouverSource () {
        for (int i = 0; i < terrain.getNbLignes() ; i++) {

            for (int j = 0; j < terrain.getNbColonnes() ; j++){
                if (terrain.getPoidsCase(i, j) == 9)
                    return terrain.getCase(i, j);
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
            CaseTraite = terrain.getAdjacent(CaseTraite, parcours) ;
            if (CaseTraite != null)
            fifo.addFirst(CaseTraite);


        }

        return parcours ;
    }

}
