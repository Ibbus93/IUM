package android.valarmorghulis.unica.it.uniapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button carrieraButton = (Button) findViewById(R.id.carriera_button);
        carrieraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goCarriera();
            }
        });

        final Button pianoStudiButton = (Button) findViewById(R.id.piano_studi_button);
        pianoStudiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goPianoStudi();
            }
        });

        final Button stimaButton = (Button) findViewById(R.id.stima_button);
        stimaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goStima();
            }
        });

        final Button statisticheButton = (Button) findViewById(R.id.statistiche_button);
        statisticheButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goStatistiche();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    private void goCarriera(){
        final Intent carrieraIntent = new Intent(this, Carriera.class);
        startActivity(carrieraIntent);
    }

    private void goPianoStudi(){
        final Intent pianoStudiIntent = new Intent(this, PianoStudi.class);
        startActivity(pianoStudiIntent);
    }

    private void goStima(){
        final Intent stimaIntent = new Intent(this, Stima.class);
        startActivity(stimaIntent);
    }

    private void goStatistiche(){
        final Intent statisticheIntent = new Intent(this, Statistiche.class);
        startActivity(statisticheIntent);
    }
}
