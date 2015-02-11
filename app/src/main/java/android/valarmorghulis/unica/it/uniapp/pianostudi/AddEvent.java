package android.valarmorghulis.unica.it.uniapp.pianostudi;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.valarmorghulis.unica.it.uniapp.carriera.DFragment;
import android.valarmorghulis.unica.it.uniapp.dummy.DummyContent;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.valarmorghulis.unica.it.uniapp.R;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddEvent extends FragmentActivity {

    public List<String> toPass;
    public static int gg, mm, aa;
    public static String examChoice;
    public static String aux;
    public static String dateToCheck;
    FragmentManager fm = getSupportFragmentManager();
    public static boolean isBusy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        toPass = new ArrayList<String>();
        examsToPass();

        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner_exams);

        Calendar calendar = Calendar.getInstance();

        // Setting datepicker minDate to tomorrow
        datePicker.setMinDate(calendar.getTimeInMillis() + (1000 * 60 * 60 * 24));

        // Setting spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        for(int i=0;i<toPass.size();i++)
            spinnerAdapter.add(toPass.get(i));
        spinnerAdapter.notifyDataSetChanged();

        // Setting confirm button
        final Button confirm = (Button) findViewById(R.id.confirm_button);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save the exam day from datePicker and the exam
                gg = datePicker.getDayOfMonth();
                mm = datePicker.getMonth() + 1;
                aa = datePicker.getYear();
                dateToCheck = gg+"/"+mm+"/"+aa;
                examChoice = (String) spinner.getSelectedItem();
                aux = DummyContent.getDateOfExam(examChoice);
                //isBusy = true; "yyyy-MM-dd"

                DFragment dFragment = new DFragment();
                dFragment.show(fm, "Alert Dialog Fragment");

            }
        });

    }

    @Override
    public void finish() {
        //PianoStudi parent = (PianoStudi)
        super.finish();
    }

    private void examsToPass() {
        for(int i=0;i<DummyContent.ITEMS.size();i++){
            if(DummyContent.ITEMS.get(i).done == 0)
                toPass.add(DummyContent.ITEMS.get(i).completeNameExam);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.actions, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_event, menu);
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
