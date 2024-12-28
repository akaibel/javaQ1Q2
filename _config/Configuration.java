package _config;

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
	public static int WARTEZEIT_BAEUME = 280;
	/**
	 * Wartezeit, damit Graphen 
	 * (GraphWithViewer) 
	 * langsam ablaufen.
	 */
	public static int WARTEZEIT_GRAPH = 150;

	/**
	 * maximale Wartezeit, die vom Slider in GUI.java angezeigt werden kann.
	 */
	public static final int MAX_WARTEZEIT = 300;
	
	/**
	 * die Schriftgroesse in den grafischen Oberflaechen
	 */
	public static final int FONT_SIZE = 12;
	
	/**
	 * die Breite der angezeigten Listen 
	 * fuer ListWithViewer, QueueWithViewer, StackWithViewer
	 */
	public static final int LISTEN_ANZEIGE_BREITE = 200;
}
