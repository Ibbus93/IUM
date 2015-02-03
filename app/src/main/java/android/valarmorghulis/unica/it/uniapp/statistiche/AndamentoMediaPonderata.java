package android.valarmorghulis.unica.it.uniapp.statistiche;

import android.app.Activity;
import android.os.Bundle;
import android.valarmorghulis.unica.it.uniapp.dummy.DummyContent;
import android.view.Menu;
import android.view.MenuItem;
import android.valarmorghulis.unica.it.uniapp.R;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

public class AndamentoMediaPonderata extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andamento_media_ponderata);


        DataPoint[] points = new DataPoint[DummyContent.esamiPassati];
        final String[] labels = new String[DummyContent.esamiPassati];
        double aux;
        int accPond = 0;
        int accCred = 0;

        // Init DataPoint array and labels for tap
        for(int i=0, j=0;i<DummyContent.esamiPassati;j++){

            if(DummyContent.ITEMS.get(j).grade > 0 && DummyContent.ITEMS.get(j).grade != 10){
                accPond += DummyContent.ITEMS.get(j).grade * DummyContent.ITEMS.get(j).crediti;
                accCred += DummyContent.ITEMS.get(j).crediti;
                aux = (double) accPond / accCred;
                points[i] = new DataPoint(i, aux);
                labels[i] = DummyContent.ITEMS.get(j).nameExam;
                i++;
            }
        }

        GraphView graph = (GraphView) findViewById(R.id.graph_pond);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(points);
        series.setDrawDataPoints(true);

        series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                int aux = (int) dataPoint.getX();
                Toast.makeText(
                        getApplicationContext(),
                        "Esame: " + labels[aux] + ", voto: " + getVoto(labels[aux]) + ", media: " + String.format("%.2f",dataPoint.getY()),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        // Set the X values
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMaxX(DummyContent.esamiPassati - 1);

        // Set the Y values
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(18);
        graph.getViewport().setMaxY(30);

        // Set number of vertical labels
        graph.getGridLabelRenderer().setNumVerticalLabels(7);

        // Init graph
        graph.addSeries(series);
    }

    private String getVoto(String label) {
        String result = null;

        for(int i=0;i<DummyContent.ITEMS.size();i++)
            if(DummyContent.ITEMS.get(i).nameExam.equals(label))
                if(!DummyContent.ITEMS.get(i).lode)
                    result = Integer.toString(DummyContent.ITEMS.get(i).grade);
                else
                    result = "30 e lode";

        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.andamento_media_ponderata, menu);
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
