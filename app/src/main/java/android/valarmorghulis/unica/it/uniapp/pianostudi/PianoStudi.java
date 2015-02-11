package android.valarmorghulis.unica.it.uniapp.pianostudi;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.valarmorghulis.unica.it.uniapp.R;
import android.valarmorghulis.unica.it.uniapp.widget.CalendarChooser;
import android.view.Menu;
import android.view.MenuItem;


public class PianoStudi extends Activity {

    public final static String TAG_LOG = PianoStudi.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano_studi);
    }

    @Override
    protected void onResume() {
        super.onResume();
        CalendarChooser calendar = (CalendarChooser) findViewById(R.id.calendar);
        calendar.updateUI();
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
