package android.valarmorghulis.unica.it.uniapp.carriera;

/**
 * Created by Samsung on 08/02/2015.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.valarmorghulis.unica.it.uniapp.dummy.DummyContent;
import android.valarmorghulis.unica.it.uniapp.pianostudi.AddEvent;

public class DFragment extends DialogFragment {

    public static final String TAG_LOG = DFragment.class.getName();

    private boolean isAnotherDaySet = false;
    private Activity act = this.getActivity();
    public static boolean yes = false;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog result;

        // Se la data è occupata, errore
        if (AddEvent.aux != null) { // se l'esame aveva già una data precedentemente prenotata
            Log.d(TAG_LOG, "L'esame ha già una data prenotata");
            if (DummyContent.isBooked(AddEvent.gg, AddEvent.mm, AddEvent.aa, AddEvent.examChoice)) {
                //onCreateAlertDialog(confirm, v, dateToCheck, false);
                Log.d(TAG_LOG, "quell'esame ha già una data prenotata");
                isAnotherDaySet = true;
                result = confirmDialog();
            } else {
                isAnotherDaySet = false;
                result = confirmDialog();
            }
        }else {
            if (DummyContent.isTheDateBusy(AddEvent.dateToCheck)) {
                Log.d(TAG_LOG, "La data scelta, " + AddEvent.dateToCheck + ", è prenotata");
                //Toast.makeText(v.getContext(), "Il giorno " + AddEvent.gg+"/"+AddEvent.mm+"/"+AddEvent.aa + " è già occupato da un altro esame", Toast.LENGTH_SHORT).show();
                result = errorDialog();
            }else{
                result = confirmDialog();
            }
        }
        return result;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        AddEvent parent = (AddEvent) getActivity();
        parent.finish();
        super.onDismiss(dialog);
    }

    private AlertDialog errorDialog() {
        return new AlertDialog.Builder(getActivity())
                // Set Dialog Icon
                //.setIcon(R.drawable.androidhappy)
                // Set Dialog Title
                .setTitle("Errore")
                // Set Dialog Message
                .setMessage("La data scelta, " + AddEvent.dateToCheck + ", è occupata da " + DummyContent.examWhoOccupyTheDate)

                // Negative Button
                .setNegativeButton("Ok", null)
                .create();
    }

    private AlertDialog confirmDialog(){

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity())
            // Set Dialog Icon
                //.setIcon(R.drawable.androidhappy)
            // Set Dialog Title
            .setTitle("Sei sicuro?");

             // Set Dialog Message
             if(isAnotherDaySet)
                dialog.setMessage(AddEvent.examChoice + " è stato prenotato precedentemente in data " + AddEvent.aux);
             else
                 dialog.setMessage("Vuoi prenotare " + AddEvent.examChoice + " per il " + AddEvent.dateToCheck + "?");

             // Positive button
             dialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Do something else
                    DummyContent.updateExam(AddEvent.examChoice, AddEvent.gg, AddEvent.mm, AddEvent.aa);
                    dismiss();

                    //Intent goBack = new Intent(getActivity(), PianoStudi.class);
                    //startActivity(goBack);

                    //finishActivity();
                }
             })

             // Negative Button
             .setNegativeButton("No", null);

        return dialog.create();
    }


}