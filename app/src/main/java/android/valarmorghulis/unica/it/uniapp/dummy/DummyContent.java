package android.valarmorghulis.unica.it.uniapp.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample nameExam for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "Automi e Linguaggi Formali", "ALF", "Massimo Bartoletti", "12/11/13", 30));
        addItem(new DummyItem("2", "Calcolo Differenziale e Integrale", "CDI", "Vasilis Todor", "07/06/2012", 29));
        addItem(new DummyItem("3", "Linguaggi di Programmazione", "LIP", "G.M.Pinna", "28/02/2014", 0));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of nameExam.
     */
    public static class DummyItem {
        public String id;
        public String completeNameExam;
        public String nameExam;
        public String nameProf;
        public String dateExam;
        public int grade;

        public DummyItem(String id, String completeNameExam, String nameExam, String nameProf, String dateExam, int grade) {
            this.id = id;
            this.completeNameExam = completeNameExam;
            this.nameExam = nameExam;
            this.nameProf = nameProf;
            this.dateExam = dateExam;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return nameExam;
        }
    }
}
