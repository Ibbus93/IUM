package android.valarmorghulis.unica.it.uniapp;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import android.valarmorghulis.unica.it.uniapp.dummy.DummyContent;

/**
 * A fragment representing a single Esame detail screen.
 * This fragment is either contained in a {@link EsameListActivity}
 * in two-pane mode (on tablets) or a {@link EsameDetailActivity}
 * on handsets.
 */
public class EsameDetailFragment extends Fragment{
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy nameExam this fragment is presenting.
     */
    protected DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EsameDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy nameExam specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load nameExam from a nameExam provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_esame_detail, container, false);

        // Show the dummy nameExam as text in a TextView.
        if (mItem != null) {
           // ((TextView) rootView.findViewById(R.id.to_do_textView)).setText("Ciao");
            ((TextView) rootView.findViewById(R.id.exam_name_textView)).setText(mItem.completeNameExam);
            ((TextView) rootView.findViewById(R.id.prof_name_textView)).setText(mItem.nameProf);
         /*   final TextView nameExam = (TextView) getView().findViewById(R.id.exam_name_textView);
            nameExam.setText(mItem.nameExam);

            final TextView nameProf = (TextView) getView().findViewById(R.id.prof_name_textView);
            nameExam.setText(mItem.nameProf);

            final TextView toDo = (TextView) getView().findViewById(R.id.to_do_textView);
            if(mItem.grade >= 18)
                toDo.setText("Esame sostenuto");
            else
                toDo.setText("Esame da sostenere");

            final TextView dataExam = (TextView) getView().findViewById(R.id.exam_date_textView);
            nameExam.setText(mItem.dateExam);

            final TextView grade = (TextView) getView().findViewById(R.id.grade_textView);
            if(mItem.grade > 0)
                nameExam.setText(mItem.grade);*/

        }

        return rootView;
    }
}
