package android.valarmorghulis.unica.it.uniapp.carriera;

/**
 * Created by Samsung on 31/01/2015.
 */
import android.content.Context;
import android.graphics.Typeface;
import android.valarmorghulis.unica.it.uniapp.R;
import android.valarmorghulis.unica.it.uniapp.dummy.DummyContent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter<DummyContent.DummyItem> {
    private List<DummyContent.DummyItem> values;

    public CustomArrayAdapter(Context context, List<DummyContent.DummyItem> values) {
        super(context, R.layout.custom_list_element, values);
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.custom_list_element, parent, false);
        TextView title = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView subtitle = (TextView) rowView.findViewById(R.id.label2);

        String toPrint = values.get(position).toString();
        title.setText(toPrint);
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(getContext().getResources().getColor(R.color.white));


        if(values.get(position).grade > 0){
            //String vote = String.valueOf(values.get(position).vote);
            //grade.setText("Test passed with " + vote);
            subtitle.setText("Passato");
        }else {
            if(values.get(position).getDateString() == null)
                subtitle.setText("Da dare");
            else
                subtitle.setText("Prenotato in data " + values.get(position).getDateString());
        }

        switch (values.get(position).year){
            case 1:
                imageView.setImageResource(R.drawable.year_1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.year_2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.year_3);
                break;
        }

        return rowView;
    }
}