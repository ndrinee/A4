package com.example.a4;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Incription extends AppCompatActivity {
    private static Button btn_valid;
    private static EditText pseudo,mail,pass,passC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ inscription);

        btn_valid=(Button)findviewById(R.id.btn_valid);
        pseudo=(EditText)findviewById(R. id.pseudo);
        mail = (EditText)findviewById(R.id.mail);
        pass = (EditText)findViewById(R.id.pass);
        passC = (EditText)findViewById(R.id.passCheck);
    }


}
