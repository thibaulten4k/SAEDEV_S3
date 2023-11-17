module com.example.towerdefense_sprint1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires org.controlsfx.controls;




    opens fr.iut.montreuil.ArthurFarazThibault to javafx.fxml;
    exports fr.iut.montreuil.ArthurFarazThibault;
    exports fr.iut.montreuil.ArthurFarazThibault.controlleur;
    opens fr.iut.montreuil.ArthurFarazThibault.controlleur to javafx.fxml;
    exports fr.iut.montreuil.ArthurFarazThibault.modele;
    opens fr.iut.montreuil.ArthurFarazThibault.modele to javafx.fxml;
    exports fr.iut.montreuil.ArthurFarazThibault.modele.bonus;
    opens fr.iut.montreuil.ArthurFarazThibault.modele.bonus to javafx.fxml;
    exports fr.iut.montreuil.ArthurFarazThibault.modele.forge;
    opens fr.iut.montreuil.ArthurFarazThibault.modele.forge to javafx.fxml;
}