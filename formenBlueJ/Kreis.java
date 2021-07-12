package formenBlueJ;
import java.awt.geom.Ellipse2D;

/**
 * Ein Kreis, der manipuliert werden kann und sich selbst auf einer Leinwand
 * zeichnet.
 * 
 * @author Michael Koelling und David J. Barnes
 * @version 2006.03.30
 */

public class Kreis implements GrafikObjekt {
	private int durchmesser;

	private int xPosition;

	private int yPosition;

	private String farbe;

	private boolean istSichtbar;

	private String name;
	
	private boolean istAusgefuellt;
	
	/**
	 * Erzeuge einen neuen Kreis an einer Standardposition mit einer
	 * Standardfarbe.
	 */
	public Kreis() {
		durchmesser = 30;
		xPosition = 20;
		yPosition = 60;
		farbe = "blau";
		istSichtbar = false;
		istAusgefuellt = false;
	}

	/**
	 * Mache diesen Kreis sichtbar. Wenn es bereits sichtbar ist, tue nichts.
	 */
	public void sichtbarMachen() {
		istSichtbar = true;
		zeichnen();
	}

	/**
	 * Mache diesen Kreis unsichtbar. Wenn es bereits unsichtbar ist, tue
	 * nichts.
	 */
	public void unsichtbarMachen() {
		loeschen();
		istSichtbar = false;
	}

    /**
     * Bewege den Kreis an eine bestimmte Position.
     */
    public void bewegeZuPosition(int x, int y){
        //loeschen();
        xPosition = x;
        yPosition = y;
        zeichnen();
    }
    
    /**
	 * Bewege diesen Kreis einige Bildschirmpunkte nach rechts.
	 */
	public void nachRechtsBewegen() {
		horizontalBewegen(20);
	}

	/**
	 * Bewege diesen Kreis einige Bildschirmpunkte nach links.
	 */
	public void nachLinksBewegen() {
		horizontalBewegen(-20);
	}

	/**
	 * Bewege diesen Kreis einige Bildschirmpunkte nach oben.
	 */
	public void nachObenBewegen() {
		vertikalBewegen(-20);
	}

	/**
	 * Bewege diesen Kreis einige Bildschirmpunkte nach unten.
	 */
	public void nachUntenBewegen() {
		vertikalBewegen(20);
	}

	/**
	 * Bewege diesen Kreis horizontal um 'entfernung' Bildschirmpunkte.
	 */
	public void horizontalBewegen(int entfernung) {
		loeschen();
		xPosition += entfernung;
		zeichnen();
	}

	/**
	 * Bewege diesen Kreis vertikal um 'entfernung' Bildschirmpunkte.
	 */
	public void vertikalBewegen(int entfernung) {
		loeschen();
		yPosition += entfernung;
		zeichnen();
	}

	/**
	 * Bewege diesen Kreis langsam horizontal um 'entfernung' Bildschirmpunkte.
	 */
	public void langsamHorizontalBewegen(int entfernung) {
		int delta;

		if (entfernung < 0) {
			delta = -1;
			entfernung = -entfernung;
		} else {
			delta = 1;
		}

		for (int i = 0; i < entfernung; i++) {
			xPosition += delta;
			zeichnen();
		}
	}

	/**
	 * Bewege diesen Kreis langsam vertikal um 'entfernung' Bildschirmpunkte.
	 */
	public void langsamVertikalBewegen(int entfernung) {
		int delta;

		if (entfernung < 0) {
			delta = -1;
			entfernung = -entfernung;
		} else {
			delta = 1;
		}

		for (int i = 0; i < entfernung; i++) {
			yPosition += delta;
			zeichnen();
		}
	}

	/**
	 * �ndere den Durchmesser dieses Kreises in 'neuerDurchmesser' (Angabe in
	 * Bildschirmpunkten). 'neuerDurchmesser' muss gr��er gleich Null sein.
	 */
	public void groesseAendern(int neuerDurchmesser) {
		loeschen();
		durchmesser = neuerDurchmesser;
		zeichnen();
	}

	/**
	 * �ndere die Farbe dieses Kreises in 'neueFarbe'. G�ltige Angaben sind
	 * "rot", "gelb", "blau", "gruen", "lila" und "schwarz".
	 */
	public void farbeAendern(String neueFarbe) {
		farbe = neueFarbe;
		zeichnen();
	}

	/**
	 * Zeichne diesen Kreis mit seinen aktuellen Werten auf den Bildschirm.
	 */
	private void zeichnen() {
		if (istSichtbar) {
			Leinwand leinwand = Leinwand.gibLeinwand();
			int radius = durchmesser/2;
			NamedEllipse2D kr = new NamedEllipse2D(xPosition-radius,
					yPosition-radius, durchmesser, durchmesser);
			kr.setName(name);
			leinwand.zeichne(this, farbe, kr);
			leinwand.warte();
		}
	}

	/**
	 * L�sche diesen Kreis vom Bildschirm.
	 */
	private void loeschen() {
		if (istSichtbar) {
			Leinwand leinwand = Leinwand.gibLeinwand();
			leinwand.entferne(this);
		}
	}

	public int gibXPosition() {
		return xPosition;
	}

	public int gibYPosition() {
		return yPosition;
	}

	
	public int gibGroesse() {
		return durchmesser;
	}

	
	public String getName() {
		if(name != null) return name;
		return "";
	}

	
	public void setzeName(String pName) {
		this.name = pName;
		
	}

}
