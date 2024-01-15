package _config;

public class Configuration {

	/**
	 * Wartezeit, damit lineare Datenstrukturen 
	 * (StackWithViewer, QueueWithViewer, ListWithViewer)
	 * langsam ablaufen 
	 */
	public static final int WARTEZEIT_LINEAR = 100;
	/**
	 * Wartezeit, damit Binaerbaeume 
	 * (TreeViewer)
	 * langsam ablaufen 
	 */
	public static final int WARTEZEIT_BAEUME = 300;
	/**
	 * Wartezeit, damit Graphen 
	 * (GraphWithViewer) 
	 * langsam ablaufen.
	 */
	public static final int WARTEZEIT_GRAPH = 50;

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
