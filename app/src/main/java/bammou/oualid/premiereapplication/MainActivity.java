package bammou.oualid.premiereapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // fonction utilisée lors du click sur le button Valider :
    public void modifierCouleurDesChamps(String couleur) {

        // Retrouver les EditText
        EditText nom_champ = (EditText) findViewById(R.id.editTextNom);
        EditText prenom_champ = (EditText) findViewById(R.id.editTextPrenom);
        EditText age_champ = (EditText) findViewById(R.id.editTextAge);
        EditText domaine_champ = (EditText) findViewById(R.id.editTextDomaine);
        EditText num_champ = (EditText) findViewById(R.id.editTextNumeroTel);

        int bgCouleur = Color.GREEN; // par défaut (si on clique sur "confimer")
        if (couleur == "yellow") { // si "annuler"
            bgCouleur = Color.YELLOW;
        }

        // changer leur couleur :
        nom_champ.setBackgroundColor(bgCouleur);
        prenom_champ.setBackgroundColor(bgCouleur);
        age_champ.setBackgroundColor(bgCouleur);
        domaine_champ.setBackgroundColor(bgCouleur);
        num_champ.setBackgroundColor(bgCouleur);

    }

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
                // Changer la couleur des champs en vert en cas de click sur "confirmer"
                modifierCouleurDesChamps("green"); // voir la fct ci-dessus
            }
        })
        .setNegativeButton(R.string.annuler, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // ANNULER
                // Changer la couleur des champs en jaune en cas de click sur "confirmer"
                modifierCouleurDesChamps("yellow"); // voir la fct ci-dessus
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