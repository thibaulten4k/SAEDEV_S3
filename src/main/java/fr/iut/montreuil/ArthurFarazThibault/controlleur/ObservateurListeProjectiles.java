package fr.iut.montreuil.ArthurFarazThibault.controlleur;

import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import fr.iut.montreuil.ArthurFarazThibault.vue.vueProjectile;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public class ObservateurListeProjectiles implements ListChangeListener<Projectile> {

    private Pane vueMap;

    public ObservateurListeProjectiles(Pane vueMap) {
        super();
        this.vueMap = vueMap;
    }

    private void enleverSprite (Projectile mort) {
        this.vueMap.getChildren().remove(this.vueMap.lookup("#"+mort.getId()));
    }

    @Override
    public void onChanged(javafx.collections.ListChangeListener.Change<? extends Projectile> p) {
        while(p.next()){

            for (Projectile nouveau: p.getAddedSubList()){
                vueProjectile.creerSprite(nouveau, vueMap);
            }

            for (Projectile mort: p.getRemoved()){
                enleverSprite(mort);
            }
        }
    }

}
