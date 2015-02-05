package android.valarmorghulis.unica.it.uniapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.valarmorghulis.unica.it.uniapp.statistiche.AndamentoMediaAritmetica;
import android.valarmorghulis.unica.it.uniapp.statistiche.AndamentoMediaPonderata;
import android.valarmorghulis.unica.it.uniapp.statistiche.AndamentoVoti;
import android.valarmorghulis.unica.it.uniapp.statistiche.GeneralStat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Statistiche extends Activity {

    public static final String TAG_LOG = Statistiche.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistiche);

        final Button general = (Button) findViewById(R.id.general_button);
        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goGenerali();
            }
        });

        final Button andamento_voti = (Button) findViewById(R.id.andamento_voti_button);
        andamento_voti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goAndamentoVoti();
            }
        });

        final Button andamento_ponderata = (Button) findViewById(R.id.andamento_media_ponderata_button);
        andamento_ponderata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goMediaPonderata();
            }
        });

        final Button andamento_aritmetica = (Button) findViewById(R.id.andamento_media_aritmetica_button);
        andamento_aritmetica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goMediaAritmetica();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.statistiche, menu);
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

    private void goGenerali(){
        Log.d(TAG_LOG, "Generali clicked");
        final Intent generalIntent = new Intent(this, GeneralStat.class);
        startActivity(generalIntent);
    }

    private void goAndamentoVoti(){
        Log.d(TAG_LOG, "Andamento voti clicked");
        final Intent andamentoVoti = new Intent(this, AndamentoVoti.class);
        startActivity(andamentoVoti);
    }

    private void goMediaPonderata(){
        Log.d(TAG_LOG, "Media ponderata clicked");
        final Intent andamentoMediaPonderata = new Intent(this, AndamentoMediaPonderata.class);
        startActivity(andamentoMediaPonderata);
    }
    private void goMediaAritmetica(){
        Log.d(TAG_LOG, "Media aritmetica clicked");
        final Intent andamentoMediaAritmetica = new Intent(this, AndamentoMediaAritmetica.class);
        startActivity(andamentoMediaAritmetica);
    }

}
