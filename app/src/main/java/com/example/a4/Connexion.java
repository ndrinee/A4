package com.example.a4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;

import java.sql.ResultSet;
import java.sql.Statement;

public class Connexion extends AppCompatActivity {

    private static Button btn_send;
    private static EditText pseudo,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        pseudo = (EditText) findViewById (R. id. pseudo) ;
        pass = (EditText) findViewById (R. id. pass) ;
        btn_send = (Button) findViewById (R. id. btn_send) ;

        btn_send.setOnClickListener((view) -> {connexion();});

        if (android.os.Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            //StrictMode.ThreadPolicy(policy);  //what?
        }

    }

    private void connexion(){

        try{
            Fonction fonc = new Fonction ();
            Statement st= fonc.connexionBDDSQL();

            String SQL="SELECT pass FROM Utilisateur WHERE pseudo='"+pseudo.getText().toString()+"'";

            final ResultSet rs=st.executeQuery(SQL);
            rs.next();

            if (rs.getString(1).equals(pass.getText().toString())){
                NextActivity();

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void NextActivity(){
        Intent intent= new Intent(Connexion.this,MainActivity.class);
        startActivity(intent);
        finish();

    }
}