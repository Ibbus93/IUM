package android.valarmorghulis.unica.it.uniapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.valarmorghulis.unica.it.uniapp.carriera.AddExam;
import android.valarmorghulis.unica.it.uniapp.pianostudi.AddEvent;
import android.view.Menu;
import android.view.MenuItem;


import java.util.Calendar;


public class PianoStudi extends Activity {

    public final static String TAG_LOG = PianoStudi.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano_studi);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.piano_studi, menu);
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
        if (id == R.id.add_event) {
            addEvent();
        }
        return super.onOptionsItemSelected(item);
    }

    private void addEvent() {
        Log.d(TAG_LOG, "Aggiungi esame");
        final Intent addEventIntent = new Intent(this, AddEvent.class);
        startActivity(addEventIntent);
    }
}
