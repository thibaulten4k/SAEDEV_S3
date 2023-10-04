module com.example.towerdefense_sprint1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
   // requires org.junit.jupiter.api;
    //requires org.testng;
    requires javafx.base;
    //requires org.testng;

    opens fr.iut.montreuil.ArthurFarazThibault to javafx.fxml;
    exports fr.iut.montreuil.ArthurFarazThibault;
    exports fr.iut.montreuil.ArthurFarazThibault.controlleur;
    opens fr.iut.montreuil.ArthurFarazThibault.controlleur to javafx.fxml;
}