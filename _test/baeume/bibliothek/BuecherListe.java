package _test.baeume.bibliothek;

import linear.List;
import linear.ListWithViewer;

public class BuecherListe {
	public static String[] titel = {"Herr der Ringe", "Hobbit", "Game of Thrones", "Sakrileg", "Illuminati", "Snow Crash", "Lied der Dunkelheit", "Rumo"};  
	public static int[] regalNummern = {1           , 1       ,          3       ,     4     ,      4      ,    6        ,          3           ,    5  };
	
	public static List<Buch> getListe() {
		List<Buch> ergebnis = new ListWithViewer<Buch>();
		for(int i=0; i<titel.length; i++){
			ergebnis.append(new Buch(titel[i], regalNummern[i]));
		}
		return ergebnis;
	}

}
