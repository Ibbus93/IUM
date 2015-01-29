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
        // Add items.
        // ANNO 1 SEMESTRE 1
        addItem(new DummyItem("1", "Programmazione 1", "PR1", "Riccardo Scateni", "01/01/2013", 29, 12));
        addItem(new DummyItem("2", "Fondamenti di Informatica", "FDI", "Barbara Pes", "02/01/2013", 29, 6));
        addItem(new DummyItem("3", "Matematica Discreta", "MD", "Michela Zedda", "03/01/2013", 31, 9));
        addItem(new DummyItem("4", "Inglese", "ENG", "No prof", "04/01/2013", 10, 3));

        // ANNO 1 SEMESTRE 2
        addItem(new DummyItem("5", "Algoritmi e Strutture Dati", "AST", "Cecilia Di Ruberto", "01/06/2013", 28, 9));
        addItem(new DummyItem("6", "Calcolo Differenziale e Integrale", "CDI", "Vasilis Todor", "02/06/2013", 0, 9));
        addItem(new DummyItem("7", "Arichitettura degli Elaboratori", "ARE", "Fabrizio Mulas", "03/06/2013", 24, 6));
        addItem(new DummyItem("8", "Fisica e Metodo Scientifico", "FIS", "Alessandro Riggio", "04/06/2013", 24, 6));

        // ANNO 2 SEMESTRE 1
        addItem(new DummyItem("9", "Sistemi Operativi 1", "SO1", "Salvatore Carta", "01/01/2014", 22, 12));
        addItem(new DummyItem("10", "Automi e Linguaggi Formali", "ALF", "Massimo Bartoletti", "02/01/2014", 30, 6));
        addItem(new DummyItem("11", "Calcolo Scientifico e Metodi Numerici", "CSMN", "Marco Gaviano", "03/01/2014", 22, 6));
        addItem(new DummyItem("12", "Economia e Diritto", "EDI", "Zedda Botta", "04/01/2014", 23, 6));

        // ANNO 2 SEMESTRE 2
        addItem(new DummyItem("13", "Reti di Calcolatori", "RC", "Gianni Fenu", "01/06/2014", 27, 9));
        addItem(new DummyItem("14", "Programmazione 2", "PR2", "Maurizio Atzori", null, 0, 9));
        addItem(new DummyItem("15", "Statistica", "STI", "Massimo Di Francesco", "02/06/2014", 31, 6));
        addItem(new DummyItem("16", "Amministrazione di Sistema", "AMM", "Davide Spano", "03/06/2014", 0, 6));

        // ANNO 3 SEMESTRE 1
        addItem(new DummyItem("17", "Linguaggi di Programmazione", "LIP", "G.M.Pinna", null, 0, 9));
        addItem(new DummyItem("18", "Basi di Dati 1", "BD1", "Nicoletta Dessì", "25/02/2015", 0, 9));
        addItem(new DummyItem("19", "Interazione Uomo Macchima", "IUM", "Davide Spano", null, 0, 6));
        addItem(new DummyItem("20", "Progettazione di Sistemi Informatici", "PSI", "Gianni Fenu", null, 0, 6));

        // ANNO 3 SEMESTRE 2
        addItem(new DummyItem("21", "Ingegneria del Software", "ISW", "Andrea Casanova", null, 0, 9));
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
        public int crediti;
        public int done;

        public DummyItem(String id, String completeNameExam, String nameExam, String nameProf, String dateExam, int grade, int crediti) {
            this.id = id;
            this.completeNameExam = completeNameExam;
            this.nameExam = nameExam; //TODO decide if the name of the exam in the List will be the acronym or the complete name
            this.nameProf = nameProf;
            this.dateExam = dateExam;
            this.grade = grade;
            this.crediti = crediti;

            if(this.grade >= 18)
                this.done = 1; //exam passed
            else if(this.dateExam != null)
                this.done = 0;  //exam booked
            else
                this.done = -1; //exam not still done / booked
        }

        @Override
        public String toString() {
            return completeNameExam;
        } //method toString describe the element on the fragment list
    }
}