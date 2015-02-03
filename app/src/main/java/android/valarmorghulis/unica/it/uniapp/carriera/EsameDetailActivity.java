package android.valarmorghulis.unica.it.uniapp.carriera;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.valarmorghulis.unica.it.uniapp.R;
import android.view.MenuItem;


/**
 * An activity representing a single Esame detail screen. This
 * activity is only used on handset devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link EsameListActivity}.
 * <p>
 * This activity is mostly just a 'shell' activity containing nothing
 * more than a {@link EsameDetailFragment}.
 */
public class EsameDetailActivity extends Activity {

    private static final String TAG_LOG = EsameDetailActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setTitle(DummyContent.ITEMS.toString());

        //setTitle("Nome Esame");
        setContentView(R.layout.activity_esame_detail);

//        TextView aux = (TextView) findViewById(R.id.exam_name_textView);
//        String auu = (String) aux.getText();
//        Log.d(TAG_LOG, auu);
        // Show the Up button in the action bar.
        getActionBar().setDisplayHomeAsUpEnabled(true);

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(EsameDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(EsameDetailFragment.ARG_ITEM_ID));
            EsameDetailFragment fragment = new EsameDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .add(R.id.esame_detail_container, fragment)
                    .commit();
        }
    }

    public void setActionBarTitle(String title){
        getActionBar().setTitle(title);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, EsameListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
