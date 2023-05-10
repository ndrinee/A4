package com.example.a4;

import androidx.appcompat.app.AppCompatActivity;
import java.sql.SQLException;

public class Fonction {
    public static String url=""; //mettre le lien de la BDD mySQL
    public static Statement connexionBDDSQL;

    try{

        Class.forName("com.mysql.jdbc.driver");
        Connexion conn = DriverManager.getConnection(url,user,pass);
        Statement st= conn.createStatement();
        return st;

    }catch(ClassNotFoundException e){
        e.printStackTrace();
        return null;
    }catch (SQLException e){
        e.printStackTrace();
        return null;
    }
}
