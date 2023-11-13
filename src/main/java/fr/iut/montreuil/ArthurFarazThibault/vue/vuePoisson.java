package fr.iut.montreuil.ArthurFarazThibault.vue;

import fr.iut.montreuil.ArthurFarazThibault.modele.Case;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Alose;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Lamproie;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Saumon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class vuePoisson {

    private static Image saumon = new Image((vuePoisson.class.getResource( "/saumon.png").toExternalForm()));
    private static Image alose = new Image((vuePoisson.class.getResource( "/alose.png").toExternalForm()));
    private static Image lamproie = new Image((vuePoisson.class.getResource( "/lamproie.png").toExternalForm()));
    private static Image esturgeon = new Image((vuePoisson.class.getResource( "/esturgeon.png").toExternalForm()));



    public static void creerSprite(Pane vueMap, Poisson p){
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
