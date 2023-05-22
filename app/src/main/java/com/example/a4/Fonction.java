package com.example.a4;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Fonction {
    public static String url=""; //mettre le lien de la BDD mySQL
    public String user = "votre_user";
    public String pass = "votre_pass";
    public static Statement connexionBDDSQL;

    public Statement connexionBDDSQL() {
        try {

            Class.forName("com.mysql.jdbc.driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement st = conn.createStatement();
            return st;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
