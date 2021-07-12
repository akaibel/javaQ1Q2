package formenBlueJ;

import java.awt.Rectangle;

/**
 * Ein Quadrat, das manipuliert werden kann und sich selbst auf einer Leinwand
 * zeichnet.
 * Dafuer nutzt es ein Attribut vom Typ Rechteck, 
 * an welches die Auftraege delegiert werden.
 */

public class Quadrat {
    private Rechteck rechteck;

    /**
     * Erzeuge ein neues Quadrat mit einer Standardfarbe an einer
     * Standardposition.
     */
    public Quadrat() {
        rechteck = new Rechteck();
        rechteck.farbeAendern("rot");
        rechteck.groesseAendern(30,30);
        rechteck.bewegeZuPosition(60,50);
    }

    /**
     * Mache dieses Quadrat sichtbar. Wenn es bereits sichtbar ist, tue nichts.
     */
    public void sichtbarMachen() {
        rechteck.sichtbarMachen();
    }
    
    public int gibFlaeche(){
        return rechteck.gibFlaeche();
    }

    /**
     * Mache dieses Quadrat unsichtbar. Wenn es bereits unsichtbar ist, tue
     * nichts.
     */
    public void unsichtbarMachen() {
        rechteck.unsichtbarMachen();
    }
    
    /**
     * Bewege das Quadrat an eine bestimmte Position.
     */
    public void bewegeZuPosition(int x, int y){
        rechteck.bewegeZuPosition(x,y);
    }
    
    /**
     * Bewege dieses Quadrat einige Bildschirmpunkte nach rechts.
     */
    public void nachRechtsBewegen() {
        rechteck.nachRechtsBewegen();
    }

    /**
     * Bewege dieses Quadrat einige Bildschirmpunkte nach links.
     */
    public void nachLinksBewegen() {
        rechteck.nachLinksBewegen();
    }

    /**
     * Bewege dieses Quadrat einige Bildschirmpunkte nach oben.
     */
    public void nachObenBewegen() {
        rechteck.nachObenBewegen();
    }

    /**
     * Bewege dieses Quadrat einige Bildschirmpunkte nach unten.
     */
    public void nachUntenBewegen() {
        rechteck.nachUntenBewegen();
    }

    /**
     * Bewege dieses Quadrat horizontal um 'entfernung' Bildschirmpunkte.
     */
    public void horizontalBewegen(int entfernung) {
        rechteck.horizontalBewegen(entfernung);
    }

    /**
     * Bewege dieses Quadrat vertikal um 'entfernung' Bildschirmpunkte.
     */
    public void vertikalBewegen(int entfernung) {
        rechteck.vertikalBewegen(entfernung);
    }

    /**
     * Bewege dieses Quadrat langsam horizontal um 'entfernung'
     * Bildschirmpunkte.
     */
    public void langsamHorizontalBewegen(int entfernung) {
        rechteck.langsamHorizontalBewegen(entfernung);
    }

    /**
     * Bewege dieses Quadrat langsam vertikal um 'entfernung' Bildschirmpunkte.
     */
    public void langsamVertikalBewegen(int entfernung) {
        rechteck.langsamVertikalBewegen(entfernung);
    }

    /**
     * Aendere die Groesse dieses Quadrates in 'neueGroesse'. 'neueGroesse' muss
     * groesser gleich Null sein.
     */
    public void groesseAendern(int neueGroesse) {
        rechteck.groesseAendern(neueGroesse, neueGroesse);
    }

    /**
     * Aendere die Farbe dieses Quadrates in 'neueFarbe'. Gueltige Angaben sind
     * "rot", "gelb", "blau", "gruen", "lila" und "schwarz".
     */
    public void farbeAendern(String neueFarbe) {
        rechteck.farbeAendern(neueFarbe);
    }

}
