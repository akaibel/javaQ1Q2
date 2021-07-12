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
	public static final int WARTEZEIT_BAEUME = 500;
	/**
	 * Wartezeit, damit Graphen 
	 * (GraphWithViewer) 
	 * langsam ablaufen.
	 */
	public static final int WARTEZEIT_GRAPH = 50;

}
