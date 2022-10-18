package bammou.oualid.premiereapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Créer une AlertDialog (fenêtre de dialogue) pour confirmer ou annuler
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setMessage(R.string.confirmation_message) // voir la valeur dans strings.xml
        .setTitle(R.string.confirmation_titre) // voir la valeur dans strings.xml
        .setPositiveButton(R.string.confirmer, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // CONFIRMER
            }
        })
        .setNegativeButton(R.string.annuler, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // ANNULER
            }
        });

        AlertDialog fenetreDeConfirmation = alertBuilder.create();

        // Retrouver le button de validation :
        Button btn_valider = (Button) findViewById(R.id.buttonValider);
        // Evenement onClick pour le button de validation :
        btn_valider.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Afficher la fenetre qu'on a créé aprés le click :
                fenetreDeConfirmation.show();
            }
        });
    }
}