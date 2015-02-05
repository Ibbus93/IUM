package android.valarmorghulis.unica.it.uniapp.statistiche;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.valarmorghulis.unica.it.uniapp.dummy.DummyContent;
import android.view.Menu;
import android.view.MenuItem;
import android.valarmorghulis.unica.it.uniapp.R;
import android.widget.TextView;

public class GeneralStat extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_stat);

        // Crediti conseguiti
        TextView crediti = (TextView) findViewById(R.id.crediti_conseguiti_textview);
        crediti.setText(crediti.getText() + " " + DummyContent.totCrediti);

        // Media aritmetica
        TextView mediaAritmetica = (TextView) findViewById(R.id.media_aritmetica_textview);
        mediaAritmetica.setText(mediaAritmetica.getText() + " " + String.format("%.2f", DummyContent.mediaAritmetica));

        // Media ponderata
        TextView mediaPonderata = (TextView) findViewById(R.id.media_ponderata_textview);
        mediaPonderata.setText(mediaPonderata.getText() + " " + String.format("%.2f", DummyContent.mediaPonderata));

        // Voto di laurea di partenza
        TextView votoPartenza = (TextView) findViewById(R.id.voto_partenza_textview);
        votoPartenza.setText(votoPartenza.getText() + " " + String.format("%.2f", DummyContent.votoPartenza));

        // Esami svolti
        TextView esamiDati = (TextView) findViewById(R.id.esami_svolti_textview);
        esamiDati.setText(esamiDati.getText() + " " + DummyContent.esamiPassatiConIdo);

        //Esami da fare
        TextView esamiDaFare = (TextView) findViewById(R.id.esami_da_fare_textview);
        esamiDaFare.setText(esamiDaFare.getText() + " " + (DummyContent.ITEMS.size() - DummyContent.esamiPassatiConIdo));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.general_stat, menu);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
