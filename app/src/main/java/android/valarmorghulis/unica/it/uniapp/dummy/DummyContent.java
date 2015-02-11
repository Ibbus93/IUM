package android.valarmorghulis.unica.it.uniapp.dummy;

import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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

    public static final String TAG_LOG = DummyContent.class.getName();
    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();
    public static List<DummyItem> ORDINARY_ITEMS = new ArrayList<DummyItem>();
    public static int esamiPassati = 0;
    public static int esamiPassatiConIdo = 0;
    public static int totCrediti = 0;
    public static int totCreditiSenzaIdo = 0;
    public static int sumArt = 0;
    public static int sumPond = 0;
    public static double mediaAritmetica;
    public static double mediaPonderata;
    public static double votoPartenza;
    public static int selected;
    public static String examWhoOccupyTheDate;
    public static final int contID = 0;

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {



        // Add items.
        // ANNO 1 SEMESTRE 1
        addItem(new DummyItem("1", "Programmazione 1", "PR1", "Riccardo Scateni", 15, 2, 2013, 29, 12, 1, 1, false));
        addItem(new DummyItem("2", "Fondamenti di Informatica", "FDI", "Barbara Pes", 16, 1, 2013, 29, 6, 1, 1, false));
        addItem(new DummyItem("3", "Matematica Discreta", "MD", "Michela Zedda", 18, 1, 2013, 30, 9, 1, 1, true));
        addItem(new DummyItem("4", "Inglese", "ENG", "No prof", 1, 10, 2013, 10, 3, 1, 1, false));

        // ANNO 1 SEMESTRE 2
        addItem(new DummyItem("5", "Algoritmi e Strutture Dati", "AST", "Cecilia Di Ruberto", 27, 6, 2013, 28, 9, 1, 2, false));
        addItem(new DummyItem("6", "Calcolo Differenziale e Integrale", "CDI", "Vasilis Todor", 29, 6, 2013, 23, 9, 1, 2, false));
        addItem(new DummyItem("7", "Arichitettura degli Elaboratori", "ARE", "Fabrizio Mulas", 22, 7, 2014, 24, 6, 1, 2, false));
        addItem(new DummyItem("8", "Fisica e Metodo Scientifico", "FIS", "Alessandro Riggio", 22, 7, 2013, 24, 6, 1, 2, false));

        // ANNO 2 SEMESTRE 1
        addItem(new DummyItem("9", "Sistemi Operativi 1", "SO1", "Salvatore Carta", 28, 1, 2014, 22, 12, 2, 1, false));
        addItem(new DummyItem("10", "Automi e Linguaggi Formali", "ALF", "Massimo Bartoletti", 24, 2, 2014, 23, 6, 2, 1, false));
        addItem(new DummyItem("11", "Calcolo Scientifico", "CSMN", "Marco Gaviano", 16, 7, 2014, 22, 6, 2, 1, false));
        addItem(new DummyItem("12", "Economia e Diritto", "EDI", "Zedda Botta", 22, 1, 2014, 23, 6, 2, 1, false));

        // ANNO 2 SEMESTRE 2
        addItem(new DummyItem("13", "Reti di Calcolatori", "RC", "Gianni Fenu", 2, 7, 2014, 27, 9, 2, 2, false));
        addItem(new DummyItem("14", "Programmazione 2", "PR2", "Maurizio Atzori", 0, 0, 0, 0, 9, 2, 2, false));
        addItem(new DummyItem("15", "Statistica", "STI", "Massimo Di Francesco", 6, 6, 2014, 30, 6, 2, 2, true));
        addItem(new DummyItem("16", "Amministrazione di Sistema", "AMM", "Davide Spano", 15, 1, 2015, 10, 6, 2, 2, false));

        // ANNO 3 SEMESTRE 1
        addItem(new DummyItem("17", "Linguaggi di Programmazione", "LIP", "G.M.Pinna", 24, 2, 2015, 26, 9, 3, 1, false));
        addItem(new DummyItem("18", "Basi di Dati 1", "BD1", "Nicoletta Dessì", 25, 2, 2015, 0, 9, 3, 1, false));
        addItem(new DummyItem("19", "Interazione Uomo Macchina", "IUM", "Davide Spano", 0, 0, 0, 0, 6, 3, 1, false));
        addItem(new DummyItem("20", "Progettazione Sistemi Informatici", "PSI", "Gianni Fenu", 0, 0, 0, 0, 6, 3, 1, false));

        // ANNO 3 SEMESTRE 2
        //addItem(new DummyItem("21", "Ingegneria del Software", "ISW", "Andrea Casanova", 0, 0, 0, 0, 9, 3, 2, false));
    }



    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);

        Collections.sort(ITEMS, new ToSort());

        calcEsamiPassati(item);
        addCrediti(item);

        if(item.grade > 0 && item.grade != 10) {
            sumArt += item.grade;
            sumPond += item.crediti * item.grade;
        }
        calcMedie();
        calcVotoPartenza();
    }

    public static boolean isPresent(int currentDayInYear, int year){
        boolean result = false;

        for(int i=0;i<ITEMS.size();i++){
            if(ITEMS.get(i).dateExam.get(Calendar.DAY_OF_YEAR) == currentDayInYear && ITEMS.get(i).aa == year) {
                result = true;
                selected = i;
                //System.out.println("E' presente il giorno " + ITEMS.get(i).getDateString());
            }
        }
        return result;
    }

    public static boolean isBooked(int gg, int mm, int aa, String exam){
        boolean result = false;

        for(int i=0;i<ITEMS.size();i++){
            if(exam.equals(ITEMS.get(i).completeNameExam))
                if(ITEMS.get(i).aa != 0 && ITEMS.get(i).mm != 0 && ITEMS.get(i).gg != 0)
                    result = true;

        }

        return result;
    }

    public static boolean isTheDateBusy(String exam){
        boolean result = false;

        for(int i=0;i<ITEMS.size();i++){
            //Log.d(TAG_LOG, ITEMS.get(i).nameExam + " " + ITEMS.get(i).getDateString());
            if(ITEMS.get(i).getDateString() != null) {
                if (exam.equals(ITEMS.get(i).getDateString())) {
                    result = true;
                    examWhoOccupyTheDate = ITEMS.get(i).completeNameExam;
                }
            }
        }

        return result;
    }

    private static void calcVotoPartenza() {
        votoPartenza = mediaPonderata * 11 / 3;
    }

    public static String getDateOfExam(String exam){
        for(int i=0;i<ITEMS.size();i++){
            if(exam.equals(ITEMS.get(i).completeNameExam))
                return  ITEMS.get(i).getDateString();

        }
        return null;
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

    public static String isPassed(DummyItem item){
        if(item.grade >= 10) // 10 idoneità
            return "passato"; //exam passed
        else
            return "prenotato";  //exam booked

    }

    public static void updateExam(String exam, int gg, int mm, int aa) {
        int f = 0;
        Log.d(TAG_LOG, "Devo fare l'aggiornamento della data d'esame");
        for (int i = 0; i < ITEMS.size(); i++) {
            if (exam.equals(ITEMS.get(i).completeNameExam)) {
                f = i;
                ITEMS.get(i).setDateExam(gg, mm, aa);
                ITEMS.get(i).mm = mm;
                ITEMS.get(i).aa = aa;
                ITEMS.get(i).gg = gg;
            }
            // ITEMS.get(f).gg + "/"+ITEMS.get(f).mm + "/"+ITEMS.get(f).aa
        }
        Log.d(TAG_LOG, "Data nuova: " + ITEMS.get(f).getDateString());
    }
    /**
     * A dummy item representing a piece of nameExam.
     */
    public static class DummyItem {
        public String id;
        public String completeNameExam;
        public String nameExam;
        public String nameProf;
        public Calendar dateExam;
        public int gg;
        public int mm;
        public int aa;
        public int grade;
        public int crediti;
        public int done;
        public int year;
        public int semestre;
        public boolean lode;

        public DummyItem(String id, String completeNameExam, String nameExam, String nameProf,
                         int gg, int mm, int aa, int grade, int crediti, int year, int semestre, boolean lode) {
            this.id = id;
            this.completeNameExam = completeNameExam;
            this.nameExam = nameExam;
            this.nameProf = nameProf;

            // Init date Exam
            this.dateExam = Calendar.getInstance();

            switch(mm) {
                case 1: dateExam.set(aa, Calendar.JANUARY, gg);
                    break;
                case 2: dateExam.set(aa, Calendar.FEBRUARY, gg);
                    break;
                case 3: dateExam.set(aa, Calendar.MARCH, gg);
                    break;
                case 4: dateExam.set(aa, Calendar.APRIL, gg);
                    break;
                case 5: dateExam.set(aa, Calendar.MAY, gg);
                    break;
                case 6: dateExam.set(aa, Calendar.JUNE, gg);
                    break;
                case 7: dateExam.set(aa, Calendar.JULY, gg);
                    break;
                case 8: dateExam.set(aa, Calendar.AUGUST, gg);
                    break;
                case 9: dateExam.set(aa, Calendar.SEPTEMBER, gg);
                    break;
                case 10: dateExam.set(aa, Calendar.OCTOBER, gg);
                    break;
                case 11: dateExam.set(aa, Calendar.NOVEMBER, gg);
                    break;
                case 12: dateExam.set(aa, Calendar.DECEMBER, gg);
                    break;
            }

            this.aa = aa;
            this.mm = mm;
            this.gg = gg;
            this.grade = grade;
            this.crediti = crediti;
            this.year = year;
            this.semestre = semestre;
            this.lode = lode;

            if(this.grade >= 10) // 10 idoneità
                this.done = 1; //exam passed
            else if(this.dateExam != null)
                this.done = 0;  //exam booked
            else
                this.done = -1; //exam not still done / booked
        }

        public String getDateString(){
            if( gg != 0 && mm != 0 && aa != 0)
                return gg + "/" + mm + "/" + aa;
            else
                return null;
        }

        public void setDateExam(int gg, int mm, int aa){
            this.dateExam = Calendar.getInstance();

            switch(mm) {
                case 1: dateExam.set(aa, Calendar.JANUARY, gg);
                    break;
                case 2: dateExam.set(aa, Calendar.FEBRUARY, gg);
                    break;
                case 3: dateExam.set(aa, Calendar.MARCH, gg);
                    break;
                case 4: dateExam.set(aa, Calendar.APRIL, gg);
                    break;
                case 5: dateExam.set(aa, Calendar.MAY, gg);
                    break;
                case 6: dateExam.set(aa, Calendar.JUNE, gg);
                    break;
                case 7: dateExam.set(aa, Calendar.JULY, gg);
                    break;
                case 8: dateExam.set(aa, Calendar.AUGUST, gg);
                    break;
                case 9: dateExam.set(aa, Calendar.SEPTEMBER, gg);
                    break;
                case 10: dateExam.set(aa, Calendar.OCTOBER, gg);
                    break;
                case 11: dateExam.set(aa, Calendar.NOVEMBER, gg);
                    break;
                case 12: dateExam.set(aa, Calendar.DECEMBER, gg);
                    break;
            }
        }

        @Override
        public String toString() {
            return completeNameExam;
        } //method toString describe the element on the fragment list


    }

}
