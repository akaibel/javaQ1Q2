package _test.backtracking;

public class BacktrackingSudoku {

	   // Das "schwerste Sudoku der Welt"   
	   // https://www.oe24.at/welt/Das-ist-das-schwierigste-Sudoku-der-Welt/1597831   
	   int[][] zahlen = {
	           {0,0,5,3,0,0,0,0,0},
	           {8,0,0,0,0,0,0,2,0},
	           {0,7,0,0,1,0,5,0,0},
	           {4,0,0,0,0,5,3,0,0},
	           {0,1,0,0,7,0,0,0,6},
	           {0,0,3,2,0,0,0,8,0},
	           {0,6,0,5,0,0,0,0,9},
	           {0,0,4,0,0,0,0,3,0},
	           {0,0,0,0,0,9,7,0,0}
	   };
	   
	   public static void main(String[] args) {
	       BacktrackingSudoku s = new BacktrackingSudoku();
	       System.out.println("*** Aufgabe ***");
	       s.ausgeben();
	       int belegteFelder = s.belegteFelder();
	       boolean erfolg = s.loesenMitBacktracking(belegteFelder);
	       if(erfolg == true){
	           System.out.println("Loesung gefunden!");
	       }
	       else{
	           System.out.println("keine Loesung");
	       }
	   }
	   
	   public boolean loesenMitBacktracking(int pStufe){
	       if(pStufe >= 81){
	    	   return true;
	       }
	       int[] bestesFeld = feldMitDenWenigstenMoeglichkeiten();
	       int zeile = bestesFeld[0];
	       int spalte = bestesFeld[1];
	       // 
	       return false;
	   }

	   private void ausgeben() {
	       String trennlinie = "+---+---+---+";
	       for(int zeile = 0; zeile<9; zeile++){
	           if(zeile%3 == 0){
	               System.out.println(trennlinie);
	           }
	           for(int spalte=0; spalte<9; spalte++){
	               if(spalte%3 == 0){
	                   System.out.print("|");
	               }
	               System.out.print(zahlen[zeile][spalte]);
	           }
	           System.out.println("|");
	       }
	       System.out.println(trennlinie);
	       System.out.println();
	   }

	   public boolean istOkZeile(int pZeilenNr){
	       boolean[] verwendeteZahlen = new boolean[10];
	       for(int spalte = 0; spalte<9; spalte++){
	           int z= zahlen[pZeilenNr][spalte];
	           if(z!=0){
	               if(verwendeteZahlen[z] == true){
	                   return false;
	               }
	               verwendeteZahlen[z] = true;
	           }
	       }
	       return true;
	   }

	   public boolean istOkSpalte(int pSpaltenNr){
	       boolean[] verwendeteZahlen = new boolean[10];
	       for(int zeile = 0; zeile<9; zeile++){
	           int z= zahlen[zeile][pSpaltenNr];
	           if(z!=0){
	               if(verwendeteZahlen[z] == true){
	                   return false;
	               }
	               verwendeteZahlen[z] = true;
	           }
	       }
	       return true;
	   }
	   
	   /**
	    * ueberprueft, ob das Quadrat ok ist,
	    * in dem (pZeilenNr|pSpaltenNr) liegt.
	    * @param pZeilenNr
	    * @param pSpaltenNr
	    * @return
	    */
	   public boolean istOkQuadrat(int pZeilenNr, int pSpaltenNr){
	       boolean[] verwendeteZahlen = new boolean[10];
	       int startZeile = pZeilenNr - pZeilenNr%3;
	       int startSpalte = pSpaltenNr - pSpaltenNr%3;
	       //System.out.println("Start: ("+startZeile+"|"+startSpalte+")");
	        for(int zeile = startZeile; zeile<startZeile+3; zeile++){
	           for(int spalte = startSpalte; spalte<startSpalte+3; spalte++){
	               int z= zahlen[zeile][spalte];
	               if(z!=0){
	                   if(verwendeteZahlen[z] == true){
	                       return false;
	                   }
	                   verwendeteZahlen[z] = true;
	               }
	           }
	       }
	       return true;
	   }
	      
	   /**
	    * prueft, ob pZahl an der Position moeglich ist.
	    * Veraendert zahlen aber nicht!
	    * @param pZahl
	    * @param pZeilenNr
	    * @param pSpaltenNr
	    * @return
	    */
	   public boolean istMoeglich(int pZahl, int pZeilenNr, int pSpaltenNr){
	       // den Wert auslesen, um ihn hinterher wieder herstellen zu koennen.
	       int z = zahlen[pZeilenNr][pSpaltenNr];
	       zahlen[pZeilenNr][pSpaltenNr] = pZahl;
	       if(!istOkZeile(pZeilenNr)){
	           zahlen[pZeilenNr][pSpaltenNr] = z;
	           return false;
	       }
	       if(!istOkSpalte(pSpaltenNr)){
	           zahlen[pZeilenNr][pSpaltenNr] = z;
	           return false;
	       }
	       if(!istOkQuadrat(pZeilenNr, pSpaltenNr)){
	           zahlen[pZeilenNr][pSpaltenNr] = z;
	           return false;
	       }
	       zahlen[pZeilenNr][pSpaltenNr] = z;       
	       return true;
	   }
	   
	   public int belegteFelder(){
	       int ergebnis = 0;
	       for(int zeile=0; zeile<9; zeile++){
	           for(int spalte=0; spalte<9; spalte++){
	               if(zahlen[zeile][spalte] != 0){
	                   ergebnis++;
	               }
	           }
	       }
	       return ergebnis;
	   }
	   
	   /**
	    * berechnet, wie viele Moeglichkeiten es fuer dieses Feld gibt.
	    * Wenn in dem Feld eine Zahl > 0 steht, dann wird sofort 0 zurueckgegeben.
	    * @param pZeilenNr
	    * @param pSpaltenNr
	    * @return
	    */
	   public int wievieleMoeglichkeiten(int pZeilenNr, int pSpaltenNr){
	       int ergebnis = 0;
	       if(zahlen[pZeilenNr][pSpaltenNr] > 0){
	           return 0;
	       }
	       for(int z=1; z<=9; z++){
	           if(istMoeglich(z, pZeilenNr, pSpaltenNr)){
	               //System.out.print(z);
	               ergebnis++;
	           }
	       }
	       //System.out.println();
	       return ergebnis;
	   }
	   
	   /**
	    * bestimmt das Feld mit den wenigsten Moeglichkeiten.
	    * Wenn es kein Feld mit Moeglichkeiten mehr gibt, wird {-1,-1} zurueckgegeben.
	    * @return ein Array mit 2 Eintraegen: Index 0: zeile; Index 1: spalte
	    */
	   public int[] feldMitDenWenigstenMoeglichkeiten(){
	       int[] minFeld = {-1,-1};
	       int minMoeglichkeiten = 1000;
	       for(int zeile=0; zeile<9; zeile++){
	           for(int spalte=0; spalte<9; spalte++){
	               int moeglichkeiten = wievieleMoeglichkeiten(zeile, spalte);
	               // es werden nur Felder beruecksichtigt,
	               // fuer die es mindestens eine Moeglichkeit gibt.
	               if(moeglichkeiten > 0 && moeglichkeiten < minMoeglichkeiten){
	                   minMoeglichkeiten = moeglichkeiten;
	                   minFeld[0] = zeile;
	                   minFeld[1] = spalte;
	               }
	           }
	       }
	       return minFeld;
	   }
	   
	   /**
	    *
	    * @param zahl
	    * @param zeile
	    * @param spalte
	    */
	   public void eintragen(int zahl, int zeile, int spalte){
	       zahlen[zeile][spalte] = zahl;
	   }
	}