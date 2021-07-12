package formenBlueJ;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.TastaturAbfrage;


/**
 * Leinwand ist eine Klasse, die einfache Zeichenoperationen auf einer
 * leinwandartigen Zeichenfläche ermöglicht. Sie ist eine vereinfachte Version
 * der Klasse Canvas (englisch für Leinwand) des JDK und wurde speziell für das
 * Projekt "Figuren" geschrieben.
 * 
 * 
 * @author: Bruce Quig
 * @author: Michael Koelling (mik)
 * @author: Axel Schmolitzky
 * 
 * @version: 2006.03.30
 */
public class Leinwand {
	// Hinweis: Die Implementierung dieser Klasse (insbesondere die
	// Verwaltung der Farben und Identitäten der Figuren) ist etwas
	// komplizierter als notwendig. Dies ist absichtlich so, weil damit
	// die Schnittstellen und Exemplarvariablen der Figuren-Klassen
	// für den Lernanspruch dieses Projekts einfacher und klarer
	// sein können.

	private static Leinwand leinwandSingleton;
	
	private static int grafikUpdateIntervallInMs = Config.grafikUpdateIntervallInMs;
	private static int sizeX = Config.sizeX;
	private static int sizeY = Config.sizeY;

	/**
	 * Fabrikmethode, die eine Referenz auf das einzige Exemplar dieser Klasse
	 * zurückliefert. Wenn es von einer Klasse nur genau ein Exemplar gibt, wird
	 * dieses als 'Singleton' bezeichnet.
	 */
	public static Leinwand gibLeinwand() {
		if (leinwandSingleton == null) {
			leinwandSingleton = new Leinwand("", sizeX, sizeY,
					Color.white);
		}
		leinwandSingleton.setzeSichtbarkeit(true);
		return leinwandSingleton;
	}
	
	public static int width(){
		return sizeX;
	}
	
	public static int height(){
		return sizeY;
	}



	
	

	// ----- Exemplarvariablen -----

	private JFrame fenster;

	private Zeichenflaeche zeichenflaeche;

	private Graphics2D graphic;

	private Color hintergrundfarbe;

	private Image leinwandImage;

	private List<Object> figuren;

	private Map<Object, ShapeMitFarbe> figurZuShape;
	
	
	/**
	 * Erzeuge eine Leinwand.
	 * 
	 * @param titel
	 *            Titel, der im Rahmen der Leinwand angezeigt wird
	 * @param breite
	 *            die gewünschte Breite der Leinwand
	 * @param hoehe
	 *            die gewünschte Höhe der Leinwand
	 * @param grundfarbe
	 *            die Hintergrundfarbe der Leinwand
	 */
	private Leinwand(String titel, int breite, int hoehe, Color grundfarbe) {
		fenster = new JFrame();
		zeichenflaeche = new Zeichenflaeche();
		fenster.setContentPane(zeichenflaeche);
		fenster.setTitle(titel);
		zeichenflaeche.setPreferredSize(new Dimension(breite, hoehe));
		hintergrundfarbe = grundfarbe;
		fenster.addWindowListener(new WindowListener(){

			
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			
			public void windowClosed(WindowEvent arg0) {
				System.exit(0);
				
			}

			
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
				
			}

			
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		fenster.pack();
		figuren = new ArrayList<Object>();
		figurZuShape = new HashMap<Object, ShapeMitFarbe>();
		
		new ZeichneThread(grafikUpdateIntervallInMs).start();
	}
	
	public JFrame getFenster(){
		return this.fenster;
	}

	/**
	 * Setze, ob diese Leinwand sichtbar sein soll oder nicht. Wenn die Leinwand
	 * sichtbar gemacht wird, wird ihr Fenster in den Vordergrund geholt. Diese
	 * Operation kann auch benutzt werden, um ein bereits sichtbares
	 * Leinwandfenster in den Vordergrund (vor andere Fenster) zu holen.
	 * 
	 * @param sichtbar
	 *            boolean für die gewünschte Sichtbarkeit: true für sichtbar,
	 *            false für nicht sichtbar.
	 */
	public void setzeSichtbarkeit(boolean sichtbar) {
		if (graphic == null) {
			// erstmaliger Aufruf: erzeuge das Bildschirm-Image und fülle
			// es mit der Hintergrundfarbe
			Dimension size = zeichenflaeche.getSize();
			leinwandImage = zeichenflaeche.createImage(size.width, size.height);
			graphic = (Graphics2D) leinwandImage.getGraphics();
			graphic.setColor(hintergrundfarbe);
			graphic.fillRect(0, 0, size.width, size.height);
			graphic.setColor(Color.black);
		}
		fenster.setVisible(sichtbar);
	}

	/**
	 * Zeichne für das gegebene Figur-Objekt eine Java-Figur (einen Shape) auf
	 * die Leinwand.
	 * 
	 * @param figur
	 *            das Figur-Objekt, für das ein Shape gezeichnet werden soll
	 * @param farbe
	 *            die Farbe der Figur
	 * @param shape
	 *            ein Objekt der Klasse Shape, das tatsächlich gezeichnet wird
	 */
	public void zeichne(Object figur, String farbe, Shape shape) {
		synchronized(figuren){
			figuren.remove(figur); // entfernen, falls schon eingetragen
			figuren.add(figur); // am Ende hinzufügen
			figurZuShape.put(figur, new ShapeMitFarbe(shape, farbe));
		}
		//erneutZeichnen();
	}

	/**
	 * Entferne die gegebene Figur von der Leinwand.
	 * 
	 * @param figur
	 *            die Figur, deren Shape entfernt werden soll
	 */
	public void entferne(Object figur) {
		synchronized(figuren){
			figuren.remove(figur); // entfernen,falls schon eingetragen
		}
		figurZuShape.remove(figur);
		//erneutZeichnen();
	}

	/**
	 * Setze die Zeichenfarbe der Leinwand.
	 * 
	 * @param farbname
	 *            der Name der neuen Zeichenfarbe.
	 */
	public void setzeZeichenfarbe(String farbname) {
		if (farbname.equals("rot")) {
			graphic.setColor(Color.red);
		} else if (farbname.equals("schwarz")) {
			graphic.setColor(Color.black);
		} else if (farbname.equals("blau")) {
			graphic.setColor(Color.blue);
		} else if (farbname.equals("gelb")) {
			graphic.setColor(Color.yellow);
		} else if (farbname.equals("gruen")) {
			graphic.setColor(Color.green);
		} else if (farbname.equals("lila")) {
			graphic.setColor(Color.magenta);
		} else if (farbname.equals("weiss")) {
			graphic.setColor(Color.white);
		} else {
			graphic.setColor(Color.black);
		}
	}

	/**
	 * Warte für die angegebenen Millisekunden. Mit dieser Operation wird eine
	 * Verzögerung definiert, die für animierte Zeichnungen benutzt werden kann.
	 */
	public void warte() {
		try {
			Thread.sleep(Config.WARTEZEIT_FORMEN);
		} catch (Exception e) {
			// Exception ignorieren
		}
	}

	/**
	 * Zeichne erneut alle Figuren auf der Leinwand.
	 */
	private void erneutZeichnen() {
		loeschen();
		synchronized(figuren){
			Iterator<Object> i = figuren.iterator();
			while(i.hasNext()){
				Object figur = i.next();
				figurZuShape.get(figur).draw(graphic);
				
			}
		}
		zeichenflaeche.repaint();
	}

	/**
	 * Lösche die gesamte Leinwand.
	 */
	private void loeschen() {
		while(graphic == null){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Color original = graphic.getColor();
		graphic.setColor(hintergrundfarbe);
		Dimension size = zeichenflaeche.getSize();
		graphic.fill(new Rectangle(0, 0, size.width, size.height));
		graphic.setColor(original);
	}

	/***************************************************************************
	 * Interne Klasse Zeichenflaeche - die Klasse für die GUI-Komponente, die
	 * tatsächlich im Leinwand-Fenster angezeigt wird. Diese Klasse definiert
	 * ein JPanel mit der zusätzlichen Möglichkeit, das auf ihm gezeichnet Image
	 * aufzufrischen (erneut zu zeichnen).
	 */
	private class Zeichenflaeche extends JPanel {
		private static final long serialVersionUID = 20060330L;

		public void paint(Graphics g) {
			g.drawImage(leinwandImage, 0, 0, null);
		}
	}

	/***************************************************************************
	 * Interne Klasse ShapeMitFarbe - Da die Klasse Shape des JDK nicht auch
	 * eine Farbe mitverwalten kann, muss mit dieser Klasse die Verknüpfung
	 * modelliert werden.
	 */
	private class ShapeMitFarbe {
		private Shape shape;

		private String farbe;

		public ShapeMitFarbe(Shape shape, String farbe) {
			this.shape = shape;
			this.farbe = farbe;
		}

		public void draw(Graphics2D graphic) {
			setzeZeichenfarbe(farbe);
			if(Config.formenFuellen){
				graphic.fill(shape);
			}
			graphic.draw(shape);
			if(shape instanceof NamedShape){
				int x = (int) ((NamedShape) shape).getX();
				int y = (int) ((NamedShape) shape).getY();
				String name = ((NamedShape) shape).getName();
				if(name != null){
					setzeZeichenfarbe("schwarz");
					graphic.drawString(name, x, y);
				}
			}
		}
	}
	
	
	
	private class ZeichneThread extends Thread{
		private int intervallInMs;
		
		public ZeichneThread(int intervallInMs){
			this.intervallInMs = intervallInMs;
		}
		
		public void run(){
			while(true){
				erneutZeichnen();
				try {
					Thread.sleep(intervallInMs);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
