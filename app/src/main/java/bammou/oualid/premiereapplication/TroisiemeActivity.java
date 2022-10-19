package bammou.oualid.premiereapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TroisiemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troisieme);

        // Récupérer le numéro de tel à partir de l'activité précédante :
        String numeroValeur = getIntent().getExtras().getString("numeroValue");

        // Changer les TextView par les valeur récupérées :
        TextView numToCallText = (TextView) findViewById(R.id.textViewNumToCall);
        numToCallText.setText(numToCallText.getText() + " " + numeroValeur);

        // Retrouver le button "Lancer un appel" :
        Button btn_LancerAppel = (Button) findViewById(R.id.buttonLancerAppel);

        // Evenement onClick pour "Lancer un appel" button :
        btn_LancerAppel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Lancer un appel :
                Uri appel = Uri.parse("tel:" + numeroValeur);
                Intent appelIntent = new Intent(Intent.ACTION_DIAL, appel);
                TroisiemeActivity.this.startActivity(appelIntent);
                // On peut également utiliser "Intent.ACTION_CALL" mais on aura besoin d'ajouter une permission.
            }
        });
    }
}