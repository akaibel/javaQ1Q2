package formenBlueJ;


import java.awt.Polygon;

/**
 * eine Linie
 */

public class Linie {
	private int x1;
	private int y1;
	
	private int x2;
	private int y2;

	private String farbe;

	private boolean istSichtbar;

	/**
	 * Erzeuge ein Linie mit einer Standardfarbe an einer Standardposition.
	 */
	public Linie() {
		x1 = 50;
		y1 = 15;
		x2 = 100;
		y2 = 45;
		farbe = "schwarz";
		istSichtbar = false;
	}

	/**
	 * Mache dieses Linie sichtbar. Wenn es bereits sichtbar ist, tue nichts.
	 */
	public void sichtbarMachen() {
		istSichtbar = true;
		zeichnen();
	}

	/**
	 * Mache dieses Linie unsichtbar. Wenn es bereits unsichtbar ist, tue
	 * nichts.
	 */
	public void unsichtbarMachen() {
		loeschen();
		istSichtbar = false;
	}

    /**
	 * Bewege dieses Linie einige Bildschirmpunkte nach rechts.
	 */
	public void nachRechtsBewegen() {
		horizontalBewegen(20);
	}

	/**
	 * Bewege dieses Linie einige Bildschirmpunkte nach links.
	 */
	public void nachLinksBewegen() {
		horizontalBewegen(-20);
	}

	/**
	 * Bewege dieses Linie einige Bildschirmpunkte nach oben.
	 */
	public void nachObenBewegen() {
		vertikalBewegen(-20);
	}

	/**
	 * Bewege dieses Linie einige Bildschirmpunkte nach unten.
	 */
	public void nachUntenBewegen() {
		vertikalBewegen(20);
	}

	/**
	 * Bewege dieses Linie horizontal um 'entfernung' Bildschirmpunkte.
	 */
	public void horizontalBewegen(int entfernung) {
		loeschen();
		x1 += entfernung;
		x2 += entfernung;
		zeichnen();
	}

	/**
	 * Bewege dieses Linie vertikal um 'entfernung' Bildschirmpunkte.
	 */
	public void vertikalBewegen(int entfernung) {
		loeschen();
		y1 += entfernung;
		y2 += entfernung;
		zeichnen();
	}

	/**
	 * 
	 */
	public void bewegeZuPosition(int x1, int y1, int x2, int y2) {
		loeschen();
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		zeichnen();
	}

	/**
	 * aendere die Farbe dieses Linies in 'neueFarbe'. Gueltige Angaben sind
	 * "rot", "gelb", "blau", "gruen", "lila" und "schwarz".
	 */
	public void farbeAendern(String neueFarbe) {
		farbe = neueFarbe;
		zeichnen();
	}

	/**
	 * Zeichne dieses Linie mit seinen aktuellen Werten auf den Bildschirm.
	 */
	private void zeichnen() {
		if (istSichtbar) {
			Leinwand leinwand = Leinwand.gibLeinwand();
			int[] xpoints = { x1, x2};
			int[] ypoints = { y1, y2};
			leinwand.zeichne(this, farbe, new Polygon(xpoints, ypoints, 2));
			leinwand.warte();
		}
	}

	/**
	 * Loesche dieses Linie vom Bildschirm.
	 */
	private void loeschen() {
		if (istSichtbar) {
			Leinwand leinwand = Leinwand.gibLeinwand();
			leinwand.entferne(this);
		}
	}
}
