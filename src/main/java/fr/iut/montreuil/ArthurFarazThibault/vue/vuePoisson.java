package fr.iut.montreuil.ArthurFarazThibault.vue;

import fr.iut.montreuil.ArthurFarazThibault.modele.Case;
import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Archer;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Harponneur;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Lanceur;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Alose;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Lamproie;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Saumon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class vuePoisson {

    private Pane vueMap;
    private Poisson p;

    private Image saumon = new Image((getClass().getResource( "/saumon.png").toExternalForm()));
    private Image alose = new Image((getClass().getResource( "/alose.png").toExternalForm()));
    private Image lamproie = new Image((getClass().getResource( "/lamproie.png").toExternalForm()));
    private Image esturgeon = new Image((getClass().getResource( "/esturgeon.png").toExternalForm()));

    public vuePoisson(Pane vueMap, Poisson p) {

        this.vueMap = vueMap;
        this.p = p;
        ImageView imV = new ImageView();

        if (p instanceof Saumon)
            imV.setImage(saumon);
        else if (p instanceof Alose)
            imV.setImage(alose);
        else if (p instanceof Lamproie)
            imV.setImage(lamproie);
        else
            imV.setImage(esturgeon);

        imV.setOpacity(0.75);

        imV.setX(p.getXpropertyValue() - Case.tailleCase/2);
        imV.setY(p.getYpropertyValue() - Case.tailleCase/2);

        p.getXproperty().addListener((obs, old, newValue) -> imV.setX(Double.parseDouble(newValue.toString()) - Case.tailleCase/2));
        p.getYproperty().addListener((obs, old, newValue) -> imV.setY(Double.parseDouble(newValue.toString()) - Case.tailleCase/2));

        imV.setId(p.getId());

        vueMap.getChildren().add(imV);
    }

}
