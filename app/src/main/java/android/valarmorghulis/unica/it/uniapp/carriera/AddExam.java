package android.valarmorghulis.unica.it.uniapp.carriera;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.valarmorghulis.unica.it.uniapp.dummy.DummyContent;
import android.valarmorghulis.unica.it.uniapp.pianostudi.AddEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.valarmorghulis.unica.it.uniapp.R;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddExam extends Activity {


    //final Context context = this;
    private boolean isInDataSet = false;
    private boolean isGradeSet = false;
    private boolean validate = false;
    private final int MARGIN_TOP_BUTTON = 250;
    private final String TAG_LOG = AddExam.class.getName();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exam);


        // Creating ScrollView
        // final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);

        // Creating RelativeLayout
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.add_exam_layout);

        // Creating TextView "in data"
        final TextView inData = new TextView(this);
        RelativeLayout.LayoutParams mpwc= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mpwc.setMargins(0, 20, 0, 0);
        mpwc.addRule(RelativeLayout.BELOW, R.id.radiogroup);
        inData.setLayoutParams(mpwc);
        inData.setText(R.string.in_data_textView);
        inData.setId(R.id.in_data_textview);

        // DatePicker

        final DatePicker datePicker = new DatePicker(this);

        RelativeLayout.LayoutParams wcwc= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        datePicker.setId(R.id.exam_datePicker);
        wcwc.addRule(RelativeLayout.BELOW, R.id.in_data_textview);
        wcwc.addRule(RelativeLayout.CENTER_HORIZONTAL, R.id.exam_datePicker);
        wcwc.addRule(RelativeLayout.CENTER_VERTICAL, R.id.exam_datePicker);
        wcwc.setMargins(0, 5, 0, 0);
        datePicker.setLayoutParams(wcwc);
        datePicker.setCalendarViewShown(false);


        // Creating TextView "Voto: "
        final TextView voto = new TextView(this);
        voto.setId(R.id.grade_textView);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.BELOW, R.id.exam_datePicker);
        lp.setMargins(0, 15, 0, 0);
        voto.setLayoutParams(lp);
        voto.setText(R.string.voto_textView);

        // Spinner
        final Spinner spinner = new Spinner(this);
        RelativeLayout.LayoutParams wp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        spinner.setId(R.id.grade_spinner);
        wp.addRule(RelativeLayout.BELOW, R.id.exam_datePicker);
        wp.addRule(RelativeLayout.ALIGN_START, R.id.exam_datePicker);
        wp.setMargins(36, 0, 0, 0);
        spinner.setLayoutParams(wp);

        // Array Adapter for Spinner dates
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        // adding vote 18-30
        for(int i=18;i<=30;i++)
            spinnerAdapter.add(Integer.toString(i));
        spinnerAdapter.add("30 e lode");

        // Spinner update
        spinnerAdapter.notifyDataSetChanged();

        // Creating button Confirm
        final Button confirm = new Button(this);
        confirm.setId(R.id.confirm_button_add_exam);
        confirm.setText("Aggiungi");
        final RelativeLayout.LayoutParams bl = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bl.addRule(RelativeLayout.CENTER_HORIZONTAL, R.id.confirm_button_add_exam);
        bl.addRule(RelativeLayout.BELOW, R.id.radiogroup);
        bl.setMargins(0, MARGIN_TOP_BUTTON, 0, 0);
        confirm.setLayoutParams(bl);
        relativeLayout.addView(confirm);

        final RadioButton to_do_radioButton = (RadioButton) findViewById(R.id.esame_da_dare_radiobutton);
        final RadioButton booked_radioButton = (RadioButton) findViewById(R.id.esame_prenotato_radiobutton);
        final RadioButton passed_radioButton = (RadioButton) findViewById(R.id.esame_passato_radiobutton);

        // RadioButton "Da dare"
        to_do_radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    if(isInDataSet) {
                        relativeLayout.removeView(inData);
                        relativeLayout.removeView(datePicker);
                        bl.addRule(RelativeLayout.BELOW, R.id.radiogroup);
                        bl.setMargins(0, MARGIN_TOP_BUTTON, 0, 0);
                        isInDataSet = false;
                    }
                    if(isGradeSet){
                        relativeLayout.removeView(voto);
                        relativeLayout.removeView(spinner);
                        isGradeSet = false;
                    }
                }
            }
        });

        // RadioButton "Prenotato"
        booked_radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Calendar calendar = Calendar.getInstance();
                if (isChecked) {
                    if (!isInDataSet) {
                        relativeLayout.addView(inData);
                        relativeLayout.addView(datePicker);
                        bl.addRule(RelativeLayout.BELOW, R.id.exam_datePicker);
                        bl.setMargins(0, 0, 0, 0);
                        isInDataSet = true;
                    }
                    if(isGradeSet){
                        relativeLayout.removeView(voto);
                        relativeLayout.removeView(spinner);
                        bl.addRule(RelativeLayout.BELOW, R.id.exam_datePicker);
                        bl.setMargins(0, 0, 0, 0);
                        isGradeSet = false;
                    }
                }
            }
        });

        // RadioButton "Dato"
        passed_radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    if(!isInDataSet) {
                        relativeLayout.addView(inData);
                        relativeLayout.addView(datePicker);
                        isInDataSet = true;
                    }

                    if(!isGradeSet){
                        relativeLayout.addView(voto);
                        relativeLayout.addView(spinner);
                        bl.addRule(RelativeLayout.BELOW, R.id.grade_spinner);
                        bl.setMargins(0, 20, 0, 0);
                        isGradeSet = true;
                    }
                }
            }
        });

        // Set on click button
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int gg, mm, aa;
                String dateToCheck;
                int grade;
                boolean lode;

                EditText nameExamEdit = (EditText) findViewById(R.id.name_exam_editText);
                String nameExam = nameExamEdit.getText().toString().trim();

                EditText nameDocEdit = (EditText) findViewById(R.id.name_prof_editText);
                String nameDoc = nameDocEdit.getText().toString().trim();

                EditText siglaExamEdit = (EditText) findViewById(R.id.sigla_exam_editText);
                String siglaExam = siglaExamEdit.getText().toString().trim();

                EditText annoEdit = (EditText) findViewById(R.id.anno_edittext);
                String anno = annoEdit.getText().toString().trim();

                EditText semestreEdit = (EditText) findViewById(R.id.semestre_edittext);
                String semestre = semestreEdit.getText().toString().trim();

                EditText creditiEdit = (EditText) findViewById(R.id.crediti_edittext);
                String crediti = creditiEdit.getText().toString().trim();

                validate = true;

                if(nameExam.length() == 0) {
                    toast("Inserisci il nome dell'esame");
                    validate = false;
                } else if(nameDoc.length() == 0){
                    toast("Inserisci il nome del docente");
                    validate = false;
                } else if(siglaExam.length() == 0){
                    toast("Inserisci la sigla dell'esame");
                    validate = false;
                } else if(anno.length() == 0){
                    toast("Inserisci l'anno dell'esame");
                    validate = false;
                }else if(semestre.length() == 0) {
                    toast("Inserisci il semestre dell'esame");
                    validate = false;
                }else if(crediti.length() == 0) {
                    toast("Inserisci i crediti dell'esame");
                    validate = false;
                }

                    if(validate){
                    // Se ho scelto il voto, aggiungere il voto
                    if(isGradeSet){
                        gg = datePicker.getDayOfMonth();
                        mm = datePicker.getMonth() + 1;
                        aa = datePicker.getYear();
                        dateToCheck = gg+"/"+mm+"/"+aa;
                        if(((String) spinner.getSelectedItem()).equals("30 e lode")) {
                            grade = 30;
                            lode = true;
                        }else{
                            grade =  Integer.parseInt((String) spinner.getSelectedItem());
                            lode = false;
                        }

                        if(DummyContent.isTheDateBusy(dateToCheck)){
                            toast("La data scelta è già occupata");
                        }else {
                            toast("Aggiungo l'esame passato");
                        }
                    }else if(isInDataSet){
                        // Se l'esame è prenotato, aggiungerlo se la data è libera
                        gg = datePicker.getDayOfMonth();
                        mm = datePicker.getMonth();
                        aa = datePicker.getYear();
                        dateToCheck = aa+"/"+mm+"/"+gg;

                        Calendar dtc = Calendar.getInstance();
                        dtc.set(aa, mm, gg);
                        Calendar gc = Calendar.getInstance();
                        gc.add(Calendar.DATE, 1);

                        if(DummyContent.isTheDateBusy(dateToCheck)){
                            toast("La data scelta è già occupata");
                        }else {
                            if(dtc.before(gc))
                                toast("DateToCheck viene prima di domani");
                            if(dtc.after(gc) || dtc.equals(gc)) {
                                toast("DateToCheck viene dopo domani oppure e' domani!");
                                toast("Aggiungo l'esame prenotato");
                            }
                        }
                    }else {
                        toast("Aggiungo l'esame da dare");
                    }
                }
            }
        });
    }

    private void toast(String text){
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_exam, menu);
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
