package formenBlueJ;

import java.awt.Rectangle;

/**
 * Ein Rechteck, das manipuliert werden kann und sich selbst auf einer Leinwand
 * zeichnet.
 * 
 * @author Michael Koelling und David J. Barnes
 * @version 2006.03.30
 */

public class Rechteck {
    private int xGroesse;
    
    private int yGroesse;

    private int xPosition;

    private int yPosition;

    private String farbe;

    private boolean istSichtbar;

    /**
     * Erzeuge ein neues Rechteck mit einer Standardfarbe an einer
     * Standardposition.
     */
    public Rechteck() {
        xGroesse = 50;
        yGroesse = 30;
        xPosition = 100;
        yPosition = 15;
        farbe = "lila";
        istSichtbar = false;
    }

    /**
     * Mache dieses Rechteck sichtbar. Wenn es bereits sichtbar ist, tue nichts.
     */
    public void sichtbarMachen() {
        istSichtbar = true;
        zeichnen();
    }
    
    public int gibFlaeche(){
        return xGroesse*yGroesse;
    }

    /**
     * Mache dieses Rechteck unsichtbar. Wenn es bereits unsichtbar ist, tue
     * nichts.
     */
    public void unsichtbarMachen() {
        loeschen();
        istSichtbar = false;
    }
    
    /**
     * Bewege das Rechteck an eine bestimmte Position.
     */
    public void bewegeZuPosition(int x, int y){
        //loeschen();
        xPosition = x;
        yPosition = y;
        zeichnen();
    }
    
    /**
     * Bewege dieses Rechteck einige Bildschirmpunkte nach rechts.
     */
    public void nachRechtsBewegen() {
        horizontalBewegen(20);
    }

    /**
     * Bewege dieses Rechteck einige Bildschirmpunkte nach links.
     */
    public void nachLinksBewegen() {
        horizontalBewegen(-20);
    }

    /**
     * Bewege dieses Rechteck einige Bildschirmpunkte nach oben.
     */
    public void nachObenBewegen() {
        vertikalBewegen(-20);
    }

    /**
     * Bewege dieses Rechteck einige Bildschirmpunkte nach unten.
     */
    public void nachUntenBewegen() {
        vertikalBewegen(20);
    }

    /**
     * Bewege dieses Rechteck horizontal um 'entfernung' Bildschirmpunkte.
     */
    public void horizontalBewegen(int distance) {
        loeschen();
        xPosition += distance;
        zeichnen();
    }

    /**
     * Bewege dieses Rechteck vertikal um 'entfernung' Bildschirmpunkte.
     */
    public void vertikalBewegen(int entfernung) {
        loeschen();
        yPosition += entfernung;
        zeichnen();
    }

    /**
     * Bewege dieses Rechteck langsam horizontal um 'entfernung'
     * Bildschirmpunkte.
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
     * Bewege dieses Rechteck langsam vertikal um 'entfernung' Bildschirmpunkte.
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
     * aendere die Groesse dieses Rechteckes in 'neueXGroesse' und neueYGroesse. 
     */
    public void groesseAendern(int neueXGroesse, int neueYGroesse) {
        loeschen();
        xGroesse = neueXGroesse;
        yGroesse = neueYGroesse;
        zeichnen();
    }

    /**
     * aendere die Farbe dieses Rechteckes in 'neueFarbe'. Gueltige Angaben sind
     * "rot", "gelb", "blau", "gruen", "lila" und "schwarz".
     */
    public void farbeAendern(String neueFarbe) {
        farbe = neueFarbe;
        zeichnen();
    }

    /**
     * Zeichne dieses Rechteck mit seinen aktuellen Werten auf den Bildschirm.
     */
    private void zeichnen() {
        if (istSichtbar) {
            Leinwand leinwand = Leinwand.gibLeinwand();
            int rechts = xPosition - xGroesse/2;
            int oben = yPosition - yGroesse/2;
            leinwand.zeichne(this, farbe, new Rectangle(rechts, oben,
                    xGroesse, yGroesse));
            leinwand.warte();
        }
    }

    /**
     * Loesche dieses Rechteck vom Bildschirm.
     */
    private void loeschen() {
        if (istSichtbar) {
            Leinwand leinwand = Leinwand.gibLeinwand();
            leinwand.entferne(this);
        }
    }
    
}
