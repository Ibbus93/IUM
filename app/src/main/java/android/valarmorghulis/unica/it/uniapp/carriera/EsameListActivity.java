package android.valarmorghulis.unica.it.uniapp.carriera;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.valarmorghulis.unica.it.uniapp.R;
import android.view.Menu;
import android.view.MenuItem;


/**
 * An activity representing a list of Esami. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link EsameDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link EsameListFragment} and the item details
 * (if present) is a {@link EsameDetailFragment}.
 * <p>
 * This activity also implements the required
 * {@link EsameListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class EsameListActivity extends Activity
        implements EsameListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    public static final String TAG_LOG = EsameListActivity.class.getName();
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esame_list);

        if (findViewById(R.id.esame_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((EsameListFragment) getFragmentManager()
                    .findFragmentById(R.id.esame_list))
                    .setActivateOnItemClick(true);
        }

        // TODO: If exposing deep links into your app, handle intents here.
    }

    /**
     * Callback method from {@link EsameListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(EsameDetailFragment.ARG_ITEM_ID, id);
            EsameDetailFragment fragment = new EsameDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .replace(R.id.esame_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, EsameDetailActivity.class);
            detailIntent.putExtra(EsameDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.esame_list, menu);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.add_exam) {
            addExam();
        }
        return super.onOptionsItemSelected(item);
    }

    private void addExam() {
        Log.d(TAG_LOG, "Aggiungi esame");
        final Intent addExamIntent = new Intent(this, AddExam.class);
        startActivity(addExamIntent);
    }
}
