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
    public static int esamiPassati = 0;
    public static int esamiPassatiConIdo = 0;
    public static int totCrediti = 0;
    public static int totCreditiSenzaIdo = 0;
    public static int sumArt = 0;
    public static int sumPond = 0;
    public static double mediaAritmetica;
    public static double mediaPonderata;
    public static double votoPartenza;

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add items.
        // ANNO 1 SEMESTRE 1
        addItem(new DummyItem("1", "Programmazione 1", "PR1", "Riccardo Scateni", "01/01/2013", 29, 12, 1, false));
        addItem(new DummyItem("2", "Fondamenti di Informatica", "FDI", "Barbara Pes", "02/01/2013", 29, 6, 1, false));
        addItem(new DummyItem("3", "Matematica Discreta", "MD", "Michela Zedda", "03/01/2013", 30, 9, 1, true));
        addItem(new DummyItem("4", "Inglese", "ENG", "No prof", "04/01/2013", 10, 3, 1, false));

        // ANNO 1 SEMESTRE 2
        addItem(new DummyItem("5", "Algoritmi e Strutture Dati", "AST", "Cecilia Di Ruberto", "01/06/2013", 28, 9, 1, false));
        addItem(new DummyItem("6", "Calcolo Differenziale e Integrale", "CDI", "Vasilis Todor", "02/06/2013", 23, 9, 1, false));
        addItem(new DummyItem("7", "Arichitettura degli Elaboratori", "ARE", "Fabrizio Mulas", "03/06/2013", 24, 6, 1, false));
        addItem(new DummyItem("8", "Fisica e Metodo Scientifico", "FIS", "Alessandro Riggio", "04/06/2013", 24, 6, 1, false));

        // ANNO 2 SEMESTRE 1
        addItem(new DummyItem("9", "Sistemi Operativi 1", "SO1", "Salvatore Carta", "01/01/2014", 22, 12, 2, false));
        addItem(new DummyItem("10", "Automi e Linguaggi Formali", "ALF", "Massimo Bartoletti", "02/01/2014", 23, 6, 2, false));
        addItem(new DummyItem("11", "Calcolo Scientifico e Metodi Numerici", "CSMN", "Marco Gaviano", "03/01/2014", 22, 6, 2, false));
        addItem(new DummyItem("12", "Economia e Diritto", "EDI", "Zedda Botta", "04/01/2014", 23, 6, 2, false));

        // ANNO 2 SEMESTRE 2
        addItem(new DummyItem("13", "Reti di Calcolatori", "RC", "Gianni Fenu", "01/06/2014", 27, 9, 2, false));
        addItem(new DummyItem("14", "Programmazione 2", "PR2", "Maurizio Atzori", null, 0, 9, 2, false));
        addItem(new DummyItem("15", "Statistica", "STI", "Massimo Di Francesco", "02/06/2014", 30, 6, 2, true));
        addItem(new DummyItem("16", "Amministrazione di Sistema", "AMM", "Davide Spano", "03/06/2014", 0, 6, 2, false));

        // ANNO 3 SEMESTRE 1
        addItem(new DummyItem("17", "Linguaggi di Programmazione", "LIP", "G.M.Pinna", "24/02/2015", 26, 9, 3, false));
        addItem(new DummyItem("18", "Basi di Dati 1", "BD1", "Nicoletta Dessì", "25/02/2015", 0, 9, 3, false));
        addItem(new DummyItem("19", "Interazione Uomo Macchima", "IUM", "Davide Spano", null, 0, 6, 3, false));
        addItem(new DummyItem("20", "Progettazione di Sistemi Informatici", "PSI", "Gianni Fenu", null, 0, 6, 3, false));

        // ANNO 3 SEMESTRE 2
        addItem(new DummyItem("21", "Ingegneria del Software", "ISW", "Andrea Casanova", null, 0, 9, 3, false));
    }



    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
        calcEsamiPassati(item);
        addCrediti(item);

        if(item.grade > 0 && item.grade != 10) {
            sumArt += item.grade;
            sumPond += item.crediti * item.grade;
        }
        calcMedie();
        calcVotoPartenza();
    }

    private static void calcVotoPartenza() {
        votoPartenza = mediaPonderata * 11 / 3;
    }

    private static void calcMedie() {
        mediaAritmetica = (double) sumArt / esamiPassati;
        mediaPonderata = (double) sumPond / totCreditiSenzaIdo;
    }

    private static void addCrediti(DummyItem item) {
        if(item.done == 1) {
            if (item.grade != 10)
                totCreditiSenzaIdo += item.crediti;
            totCrediti += item.crediti;
        }
    }

    private static void calcEsamiPassati(DummyItem item) {
        if (item.grade > 0){
            if(item.grade != 10)
                esamiPassati++;
            esamiPassatiConIdo++;
        }
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
        public int year;
        public boolean lode;

        public DummyItem(String id, String completeNameExam, String nameExam, String nameProf,
                         String dateExam, int grade, int crediti, int year, boolean lode) {
            this.id = id;
            this.completeNameExam = completeNameExam;
            this.nameExam = nameExam;
            this.nameProf = nameProf;
            this.dateExam = dateExam;
            this.grade = grade;
            this.crediti = crediti;
            this.year = year;
            this.lode = lode;

            if(this.grade >= 10) // 10 idoneità
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
