package _test.backtracking;


public class MagischesQuadrat {

	// wenn keine Zahl eingetragen ist: das hat den Wert 0.
    private int[][] quadrat = new int[3][3];

    public void findeLoesung() {
        boolean gefunden = findeLoesungMitBacktracking(0);
        if (!gefunden) {
            System.out.println("Keine Loesung gefunden.");
        }
    }

    private boolean findeLoesungMitBacktracking(int pStufe) {
        //TODO Abbruchbedingungen
    	
    	int x = getX(pStufe);
        int y = getY(pStufe);
        // jetzt kann man mit 
        // quadrat[x][y] 
        // das zur Stufe passende Feld ansprechen.
        
        //TODO
        
        return false;
    }

    // Hilfsmethoden

    private boolean istSchonEingetragen(int pZahl) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (quadrat[i][j] == pZahl) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean istMagisch() {
        // pruefen, dass jede Zahl von 1 bis 9 genau einmal vorkommt
        boolean[] vorhanden = new boolean[10]; // Index 0 wird nicht genutzt
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int zahl = quadrat[i][j];
                if (zahl < 1 || zahl > 9 || vorhanden[zahl]) {
                    return false;
                }
                vorhanden[zahl] = true;
            }
        }
 
        int summe = quadrat[0][0] + quadrat[0][1] + quadrat[0][2];
 
        // Zeilen und Spalten pruefen
        for (int i = 0; i < 3; i++) {
            int zeilensumme = 0;
            int spaltensumme = 0;
            for (int j = 0; j < 3; j++) {
                zeilensumme += quadrat[i][j];
                spaltensumme += quadrat[j][i];
            }
            if (zeilensumme != summe || spaltensumme != summe) {
                return false;
            }
        }
 
        // Diagonalen pruefen
        int diagonale1 = quadrat[0][0] + quadrat[1][1] + quadrat[2][2];
        int diagonale2 = quadrat[0][2] + quadrat[1][1] + quadrat[2][0];
        if (diagonale1 != summe || diagonale2 != summe) {
            return false;
        }
 
        return true;
    }
 
    private void ausgeben() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(quadrat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // die x-Koordinate (0..2) fuer eine Stufe ermitteln
    private int getX(int pStufe) {
        return pStufe / 3;
    }

    // die y-Koordinate (0..2) fuer eine Stufe ermitteln
    private int getY(int pStufe) {
        return pStufe % 3;
    }

    public static void main(String[] args) {
        MagischesQuadrat m = new MagischesQuadrat();
        m.findeLoesung();
    }
}