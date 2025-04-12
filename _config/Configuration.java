package _config;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Die Wartezeiten koennen vom User angepasst werden.
 * Sie werden dann in configuration.txt gespeichert 
 * und werden auch von dort geladen.
 * Das erspart dem User das staendige schneller-stellen.
 * @author akaib
 *
 */
public class Configuration {

	/**
	 * Wartezeit, damit lineare Datenstrukturen 
	 * (StackWithViewer, QueueWithViewer, ListWithViewer)
	 * langsam ablaufen 
	 */
	public static int WARTEZEIT_LINEAR = 100;
	/**
	 * Wartezeit, damit Binaerbaeume 
	 * (TreeViewer)
	 * langsam ablaufen 
	 */
	public static int WARTEZEIT_BAEUME = 100;
	/**
	 * Wartezeit, damit Graphen 
	 * (GraphWithViewer) 
	 * langsam ablaufen.
	 */
	public static int WARTEZEIT_GRAPH = 100;

	/**
	 * maximale Wartezeit, die vom Slider in GUI.java angezeigt werden kann.
	 */
	public static final int MAX_WARTEZEIT = 200;
	
	/**
	 * die Schriftgroesse in den grafischen Oberflaechen
	 */
	public static final int FONT_SIZE = 12;
	
	/**
	 * die Breite der angezeigten Listen 
	 * fuer ListWithViewer, QueueWithViewer, StackWithViewer
	 */
	public static final int LISTEN_ANZEIGE_BREITE = 200;
	
	/**
	 * Liest die Eigenschaften aus Configuration.txt
	 * und sorgt dafuer, dass die Eigenschaften regelmaessig upgedated werden.
	 */
	public static void READ_AND_START_UPDATING_CONFIGURATION() {
		String LINEAR = Properties.readProperty("WARTEZEIT_LINEAR");
		if(LINEAR != null) {
			WARTEZEIT_LINEAR = Integer.parseInt(LINEAR);
		}
		String BAEUME = Properties.readProperty("WARTEZEIT_BAEUME");
		if(BAEUME != null) {
			WARTEZEIT_BAEUME = Integer.parseInt(BAEUME);
		}
		String GRAPH = Properties.readProperty("WARTEZEIT_GRAPH");
		if(GRAPH != null) {
			WARTEZEIT_GRAPH = Integer.parseInt(GRAPH);
		}
		
		//Dafuer sorgen, dass die Eigenschaften regelmaessig gespeichert werden, wenn sie geaendert werden.
			
	    // Create a ScheduledExecutorService
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        // Schedule the storeProperties method to be called every 5 seconds
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                STORE_PROPERTIES();
            }
        }, 2, 2, TimeUnit.SECONDS); // Initial delay of 2 seconds, then 2-second interval

	}


	protected static void STORE_PROPERTIES() {
		Properties.saveProperty("WARTEZEIT_LINEAR", ""+WARTEZEIT_LINEAR);
		Properties.saveProperty("WARTEZEIT_BAEUME", ""+WARTEZEIT_BAEUME);
		Properties.saveProperty("WARTEZEIT_GRAPH", ""+WARTEZEIT_GRAPH);		
	}
}
