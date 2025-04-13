package _config;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
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
	 * diese Konstante kann NICHT von Werten in configuration.txt ueberschrieben werden.
	 */
	private static final String CONFIG_FILE = "_config/configuration.txt";


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
	public static int MAX_WARTEZEIT = 200;

	/**
	 * die Schriftgroesse in den grafischen Oberflaechen
	 */
	public static int FONT_SIZE = 12;


	/**
	 * die Breite und Hoehe der angezeigten Listen 
	 * fuer ListWithViewer, QueueWithViewer, StackWithViewer
	 */
	public static int LISTEN_ANZEIGE_BREITE = 200;
	public static int LISTEN_ANZEIGE_HOEHE = 300;

	/**
	 * die Breite Hoehe und Position des angezeigten Baums
	 */
	public static int BAUM_ANZEIGE_BREITE = 600;
	public static int BAUM_ANZEIGE_HOEHE = 300;
	public static int BAUM_ANZEIGE_POS_X = 250;
	public static int BAUM_ANZEIGE_POS_Y = 0;

	/**
	 * die Breite Hoehe und Position der angezeigten Graphen
	 */
	public static int GRAPH_ANZEIGE_BREITE = 600;
	public static int GRAPH_ANZEIGE_HOEHE = 600;
	public static int GRAPH_ANZEIGE_POS_X = 250;
	public static int GRAPH_ANZEIGE_POS_Y = 0;

	/**
	 * Liest die Properties aus CONFIG_FILE 
	 * und speichert sie in den Variablen dieser Klasse
	 * sorgt dafuer, dass die Variablen dieser Klasse 
	 * regelmaessig in CONFIG_FILE geschrieben werden.
	 * (fuer den Fall, dass sie sich aendern.)
	 */
	public static void READ_AND_START_UPDATING_CONFIGURATION() {
		CREATE_CONFIG_FILE_IF_DOESNT_EXIST();
		Map<String,String> propertiesFromFile = Properties.readAllProperties(CONFIG_FILE);
		for (Field field : Configuration.class.getDeclaredFields()) {
			// Check if the field is static and of type int
			if (Modifier.isStatic(field.getModifiers()) && field.getType() == int.class) {
				try {
					field.setAccessible(true); // In case it's private
					//System.out.println(field.getName() + " = " + field.get(null));
					String key = field.getName();
					int value_from_config_file = Integer.parseInt(propertiesFromFile.get(key));
					field.setInt(null, value_from_config_file); // Set static int field to 42
				} catch (Exception e) {
					System.err.println("Configuration.java: Cannot access field: " + field.getName());
				}
			}
		}

		//Dafuer sorgen, dass die Eigenschaften regelmaessig gespeichert werden, wenn sie geaendert werden.

		// Create a ScheduledExecutorService
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		// Schedule the storeProperties method to be called every 5 seconds
		scheduler.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				SAVE_PROPERTIES();
			}
		}, 2, 2, TimeUnit.SECONDS); // Initial delay of 2 seconds, then 2-second interval
	}

	private static void CREATE_CONFIG_FILE_IF_DOESNT_EXIST() {
		File file = new File(CONFIG_FILE);
		if (!file.exists()) {
			try {
				boolean created = file.createNewFile();
				if (created) {
					System.err.println("Configuration.java: Created file: " + CONFIG_FILE);
				} else {
					System.err.println("Configuration.java: File "+CONFIG_FILE+" cannnot be created!");
				}
			} catch (IOException e) {
				System.err.println("Configuration.java: An error occurred while creating file: "+CONFIG_FILE);
				e.printStackTrace();
			}
		}
	}

	/**
	 * schreibt die Werte von allen Variablen dieser Klasse in CONFIG_FILE
	 */
	public static void SAVE_PROPERTIES() {
		// properties aus den Variablen sammeln
		Map<String,String> propertiesFromVariables = new HashMap<>();
		for (Field field : Configuration.class.getDeclaredFields()) {
			// Check if the field is static
			if (Modifier.isStatic(field.getModifiers())) {
				try {
					field.setAccessible(true); // in case it's private
					Object value = field.get(null); // null because it's static
					//System.out.println(field.getName() + " = " + value);
					String key = field.getName();
					propertiesFromVariables.put(key, value.toString());
				} catch (IllegalAccessException e) {
					System.err.println("Configuration.java: Cannot access field: " + field.getName());
				}
			}
		}
		// jetzt die properties schreiben.
		Properties.saveProperties(propertiesFromVariables, CONFIG_FILE);
	}

}
