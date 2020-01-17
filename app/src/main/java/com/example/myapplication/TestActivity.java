package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {
    CheckBox male;
    CheckBox female;
    TextView Prenom;
    TextView Nom;
    TextView Email;
    Button Submit;
    Button Cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //Affectation des view :
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        Prenom = findViewById(R.id.Firstname);
        Nom = findViewById(R.id.Name);
        Email = findViewById(R.id.E_mail);
        Submit= findViewById(R.id.Submit);
        Cancel = findViewById(R.id.Cancel);


        //Gestion des checkboxes
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setChecked(true);
                female.setChecked(false);
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setChecked(false);
                female.setChecked(true);
            }
        });

        //Affiche les informations avec le onSubmit
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String rep = "Bonjour ";
                TextView Prenom = findViewById(R.id.Firstname);
                TextView Nom = findViewById(R.id.Name);
                TextView Email = findViewById(R.id.E_mail);
                CheckBox male = findViewById(R.id.male);
                CheckBox female = findViewById(R.id.female);
                if (male.isChecked() || female.isChecked()) {
                    if (male.isChecked()) {
                        rep += "M. ";
                    } else {
                        rep += "Me. ";
                    }
                    rep += Prenom.getText() + " ";
                    rep += Nom.getText() + "!";
                    rep += "\nemail: " + Email.getText() + ".";
                    Toast.makeText(getApplicationContext(),
                            rep
                            , Toast.LENGTH_LONG).show();
                }
            }
        });

        //Affiche les informations avec le onSubmit
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prenom.setText("");
                Nom.setText("");
                Email.setText("");
                male.setChecked(false);
                female.setChecked(false);
                Toast.makeText(getApplicationContext(), "Réinitilisation...", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
