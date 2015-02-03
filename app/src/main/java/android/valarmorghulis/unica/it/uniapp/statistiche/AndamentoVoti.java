package android.valarmorghulis.unica.it.uniapp.statistiche;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.valarmorghulis.unica.it.uniapp.R;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.jjoe64.graphview.series.Series;

import android.valarmorghulis.unica.it.uniapp.dummy.DummyContent;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class AndamentoVoti extends Activity {

    private static final String TAG_LOG = AndamentoVoti.class.getName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andamento_voti);

        DataPoint[] points = new DataPoint[DummyContent.esamiPassati];
        final String[] labels = new String[DummyContent.esamiPassati];

        // Init DataPoint array and labels for tap
        for(int i=0, j=0;i<DummyContent.esamiPassati;j++){
            if(DummyContent.ITEMS.get(j).grade > 0 && DummyContent.ITEMS.get(j).grade != 10){
                if(DummyContent.ITEMS.get(j).lode)
                    points[i] = new DataPoint(i, 32);
                else
                    points[i] = new DataPoint(i, DummyContent.ITEMS.get(j).grade);

                labels[i] = DummyContent.ITEMS.get(j).nameExam;
                i++;
            }
        }

        GraphView graph = (GraphView) findViewById(R.id.graph);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(points);
        series.setDrawDataPoints(true);

        series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                int aux = (int) dataPoint.getX();
                if(dataPoint.getY() != 32)
                    Toast.makeText(getApplicationContext(), "Esame: " + labels[aux] + ", voto: " + (int) dataPoint.getY(), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Esame: " + labels[aux] + ", voto: 30 e lode", Toast.LENGTH_SHORT).show();
            }
        });

        // Set the X values
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMaxX(DummyContent.esamiPassati - 1);

        // Set the Y values
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(18);
        graph.getViewport().setMaxY(32);

        // Set number of vertical labels
        graph.getGridLabelRenderer().setNumVerticalLabels(8);

        // Init graph
        graph.addSeries(series);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.andamento_voti, menu);
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
