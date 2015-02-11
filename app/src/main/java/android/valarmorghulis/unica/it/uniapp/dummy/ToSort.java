package android.valarmorghulis.unica.it.uniapp.dummy;

import java.util.Comparator;

/**
 * Created by Samsung on 11/02/2015.
 */
public class ToSort implements Comparator<DummyContent.DummyItem> {
    
    @Override
    public int compare(DummyContent.DummyItem d1, DummyContent.DummyItem d2){
        int result = 0;

        if (d1.year > d2.year)
            result = 1;
        else if(d1.year < d2.year)
            result = -1;
        else if(d1.year == d2.year){
            if(d1.semestre > d2.semestre)
                result = 1;
            else if(d1.semestre == d2.semestre)
                result = 0;
            else
                result = -1;
        }
        
        return result;
    }
}

