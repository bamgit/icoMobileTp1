package bammou.oualid.premiereapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DeuxiemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deuxieme);

        // Récupérer les données à partir de l'activité précédante :
        String nomValeur = getIntent().getExtras().getString("nomValue");
        String prenomValeur = getIntent().getExtras().getString("prenomValue");
        String ageValeur = getIntent().getExtras().getString("ageValue");
        String domaineValeur = getIntent().getExtras().getString("domaineValue");
        String numeroValeur = getIntent().getExtras().getString("numeroValue");

        // Changer les TextView par les valeur récupérées :
        TextView nomText = (TextView) findViewById(R.id.textViewNomValue);
        nomText.setText(nomText.getText() + " " + nomValeur);
        TextView prenomText = (TextView) findViewById(R.id.textViewPrenomValue);
        prenomText.setText(prenomText.getText() + " " + prenomValeur);
        TextView ageText = (TextView) findViewById(R.id.textViewAgeValue);
        ageText.setText(ageText.getText() + " " + ageValeur);
        TextView domaineText = (TextView) findViewById(R.id.textViewDomaineValue);
        domaineText.setText(domaineText.getText() + " " + domaineValeur);
        TextView numeroText = (TextView) findViewById(R.id.textViewNumeroTelValue);
        numeroText.setText(numeroText.getText() + " " + numeroValeur);

        // Retrouver les buttons OK et RETOUR :
        Button btn_ok = (Button) findViewById(R.id.buttonOk);
        Button btn_retour = (Button) findViewById(R.id.buttonRetour);

        // Evenement onClick pour "OK" :
        btn_ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Lancer une nouvelle (3ème) activité :
                Intent myIntent = new Intent(DeuxiemeActivity.this, TroisiemeActivity.class);
                myIntent.putExtra("numeroValue", numeroValeur.toString()); // envoyer le num de tel => 3eme activity
                DeuxiemeActivity.this.startActivity(myIntent);
            }
        });

        // Evenement onClick pour "RETOUR" :
        btn_retour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Revenir à l'activité précédante :
                Intent myIntent = new Intent(DeuxiemeActivity.this, MainActivity.class);
                DeuxiemeActivity.this.startActivity(myIntent);
                finish(); // finish l'activité actuelle
                // On peut aussi revenir avec : onBackPressed();
            }
        });
    }
}