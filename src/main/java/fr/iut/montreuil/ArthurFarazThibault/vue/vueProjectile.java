package fr.iut.montreuil.ArthurFarazThibault.vue;

import fr.iut.montreuil.ArthurFarazThibault.modele.projectiles.Fleche;
import fr.iut.montreuil.ArthurFarazThibault.modele.projectiles.Harpon;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class vueProjectile {

    public static void creerSprite (Projectile p, Pane vueMap) {

        Circle c;

        if (p instanceof Harpon) {
            c= new Circle(6);
            c . setFill (Color.YELLOW);
        }
        else if (p instanceof Fleche) {
            c= new Circle(4);
            c . setFill (Color.BROWN);
        }
        else {
            c= new Circle(8);
            c . setFill (Color.GRAY);
        }


        c.setId(p.getId());

        // c .setOnMouseClicked(e−> System.out.println("clic sur acteur"+ e.getSource()));
        c.translateXProperty().bind(p.getXproperty());
        c.translateYProperty().bind(p.getYproperty());
        vueMap.getChildren().add(c);
    }
}
