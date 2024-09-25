package _test.debugging;

public class DebuggingJamesBondAutomat {

	// das Testwort aendern!
	private static final String TEST_WORT = "8";
	// weitere Testwoerter: "007", "07", "3007"

	public boolean enthaelt007(String pWort){
	    int zustand = 0;
	    for(int i=0; i<pWort.length(); i++){
	        char zeichen = pWort.charAt(i);
	        if(zustand == '0'){
	            if(zeichen == 0) zustand = 1;
	            else zustand = 0;
	        }
	        if(zustand == 1){
	            if(zeichen == 0) zustand = 2;
	            else zustand = 0;
	        }
	        else if(zustand == 2){
	            if(zeichen == '0') zustand = 2;
	            else if(zeichen == '7') zustand = 3;
	            else zustand = 0;
	        }
	        zustand = 3;
	    }
	    //zurueckgeben, ob der Zustand 3 erreicht wurde.
	    // die folgende Zeile ist fehlerfrei!
	    return (zustand == 3);
	 }
	
	public static void main(String[] args) {
		DebuggingJamesBondAutomat jba = new DebuggingJamesBondAutomat();
		boolean ergebnis = jba.enthaelt007(TEST_WORT);
		System.out.println("Ergebnis fuer "+TEST_WORT);
		System.out.println(ergebnis);
	}
}
