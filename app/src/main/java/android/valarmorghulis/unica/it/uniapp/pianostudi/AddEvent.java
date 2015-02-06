package android.valarmorghulis.unica.it.uniapp.pianostudi;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.valarmorghulis.unica.it.uniapp.dummy.DummyContent;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.valarmorghulis.unica.it.uniapp.R;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddEvent extends Activity {

    public List<String> toPass;
    private int gg, mm, aa;
    private String examChoice;

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
        Button confirm = (Button) findViewById(R.id.confirm_button);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save the exam day from datePicker and the exam
                gg = datePicker.getDayOfMonth();
                mm = datePicker.getMonth() + 1;
                aa = datePicker.getYear();
                examChoice = (String) spinner.getSelectedItem();

                if(DummyContent.isBooked(gg, mm, aa, examChoice)) {
                    String aux = DummyContent.getDateOfExam(examChoice);
                    // se c'è già un'esame prenotato in quella data error dialog,
                    // altrimenti alertDialog per scegliere se cambiare data di prenotazione
                    //Toast.makeText(v.getContext(), "Hai selezionato: " + gg + "/" + mm + "/" + aa + " " + spinner.getSelectedItem() + " ma c'è già un altro esame prenotato per " + aux, Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(v.getContext(), "Hai selezionato: "+ gg+"/"+mm+"/"+aa + " " + spinner.getSelectedItem(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void examsToPass() {
        for(int i=0;i<DummyContent.ITEMS.size();i++){
            if(DummyContent.ITEMS.get(i).done == 0)
                toPass.add(DummyContent.ITEMS.get(i).completeNameExam);
        }
    }

    // onCreateAlertDialog crea una finestra che chide
    // "Sei sicuro di voler creare un evento per quell'esame in tale data?"
    // Ti chiede, se per quell'esame c'è già un esame prenotato, se vuoi spostarlo nella nuova data, altrimenti non fa niente

    public void onCreateAlertDialog(Button btn, View v, String date, final boolean already){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext())
                        .setPositiveButton("Yes", null)
                        .setNegativeButton("No", null);

                if(already)
                    builder.setTitle("Questo esame è già prenotato per un'altra data!");
                else
                    builder.setTitle("Vuoi aggiungere un evento in tale data?");

                builder.show();
            }
        });
    }

    public void onCreateErrorDialog(Button btn, View v, String date){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext())
                        .setTitle("Are you sure?")
                        .setPositiveButton("Yes", null)
                        .setNegativeButton("No", null);
                builder.show();
            }
        });
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
