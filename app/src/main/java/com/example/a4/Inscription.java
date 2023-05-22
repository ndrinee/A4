package com.example.a4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.Statement;

public class Inscription extends AppCompatActivity {

    private static Button btn_valid;
    private static EditText pseudo, mail, pass, passC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription2);

        btn_valid = (Button) findViewById(R.id.btn_valid);
        pseudo = (EditText) findViewById(R.id.pseudo);
        mail = (EditText) findViewById(R.id.mail);
        pass = (EditText) findViewById(R.id.pass);
        passC = (EditText) findViewById(R.id.passCheck);

        btn_valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }


    public void register() {
        boolean Tpseudo = false;
        boolean Tmail = false;
        boolean Tmail2 = false;
        boolean Tpass = false;

        try {
            Fonction fonc = new Fonction();

            //Verifie Pseudo Existant

            Statement stPseudo = fonc.connexionBDDSQL();
            String sql = "SELECT * FROM Utilisateurs WHERE PSEUDO ='" + pseudo.getText().toString() + "';";

            final ResultSet resulPseudo = stPseudo.executeQuery(sql);
            //resultPseudo.next();

            if (!(resulPseudo.getRow() == 0)) {
                Tpseudo = true;
            }

            // VERIFIE MAIL

            Statement stMail = fonc.connexionBDDSQL();
            String sqlMail = "SELECT * FROM Utilisateurs WHERE mail ='" + mail.getText().toString() + "';";

            final ResultSet resultMail = stMail.executeQuery(sqlMail);
            resultMail.next();

            if (!(resultMail.getRow() == 0)) {
                Tmail = true;
            }

            String email = mail.getEditableText().toString().trim();
            if (!email.matches("^[_a-z0-9]+(\\.[a-z0-9]+)*@[esme]+(\\.[fr]+)+$")) {
                Tmail2 = true;
            }

            // Verif MDP
            if (!(pass.getText().toString().equals(passC.getText().toString()))) {
                Tpass = true;
            }

            //Hashage mdp ???
            byte[] password = pass.getText().toString().getBytes();
            BigInteger md5Data = new BigInteger(1, md5.encryptMD5(password));
            String hashed = md5Data.toString(16);

            // verif totale finale

            if ((Tpseudo == false) && (Tmail == false) && (Tmail2 == false) && (Tpass == false)) {
                Statement stInsert = fonc.connexionBDDSQL();
                stInsert.executeUpdate("INSERT INTO Utilisateurs (pseudo, password, mail) VALUES('" + pseudo.getText().toString() + "','" + hashed + "','" + mail.getText().toString() + "';");

            }

        } catch (Exception e) {
            Toast.makeText(this, "L'inscription a échoué", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}