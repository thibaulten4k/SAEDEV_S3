package fr.iut.montreuil.ArthurFarazThibault.Connexion;
import java.sql.*;


public class Connexion {
    public static void main(String[] args) {
        try {
        Connection con = DriverManager.getConnection("jdbc:postgresql://database-etudiants.iut.univ-paris8.fr/localhost/dutinfopw201632", "dutinfopw201632", "jynuhuby");
        System.out.println("Connexion établie");
        }
        catch(SQLException e) {
        System.out.println("Erreur");
    }
}
}
