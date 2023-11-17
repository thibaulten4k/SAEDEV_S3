package fr.iut.montreuil.ArthurFarazThibault.vue;

import fr.iut.montreuil.ArthurFarazThibault.modele.projectiles.Filet;
import fr.iut.montreuil.ArthurFarazThibault.modele.projectiles.Fleche;
import fr.iut.montreuil.ArthurFarazThibault.modele.projectiles.Harpon;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class vueProjectile {

    public static void creerSprite (Projectile p, Pane vueMap) {

        Shape forme;

        if (p instanceof Harpon) {
            forme= new Circle(6);
            forme . setFill (Color.YELLOW);
        }
        else if (p instanceof Fleche) {
            forme= new Circle(4);
            forme . setFill (Color.BROWN);
        }
        else if (p instanceof Filet){
            forme= new Circle(8);
            forme . setFill (Color.GRAY);
        } else {
            forme = new Rectangle(12, 12);
            forme . setFill(Color.ROSYBROWN);
        }

        forme.translateXProperty().bind(p.getXproperty());
        forme.translateYProperty().bind(p.getYproperty());

        forme.setId(p.getId());

        vueMap.getChildren().add(forme);
    }
}
