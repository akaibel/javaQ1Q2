package mathe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Koordinatensystemzeichner zum Visualisieren von Daten
 * 
 * @author Niklas Seeliger
 *
 */
public class Koordinatensystem {

	private static final long serialVersionUID = 1L;
	
	private JFrame jFrame;

	private DrawLabel dl;

	private List<Double> dots;
	private List<Double> lines;

	private boolean drawText = true;
	private boolean autoGrid = false;
	private boolean continuousDots = false;
	private boolean autoResize = false;

	private double gridX;
	private double gridY;

	private double minX;
	private double maxX;
	private double minY;
	private double maxY;

	/**
	 * erstellt ein Koordinatensystem.
	 * 
	 * @param minX
	 *            der Mindestwert auf der x-Achse
	 * @param maxX
	 *            der Maximalwert auf der x-Achse
	 * @param minY
	 *            der Mindestwert auf der y-Achse
	 * @param maxY
	 *            der Maximalwert auf der y-Achse
	 */
	public Koordinatensystem(double minX, double maxX, double minY, double maxY) {
		jFrame = new JFrame();
		gridX = .1;
		gridY = .1;

		this.minX = minX;
		this.maxX = maxX;

		this.minY = minY;
		this.maxY = maxY;

		dots = new ArrayList<>();
		lines = new ArrayList<>();

		jFrame.setSize(500, 500);
		jFrame.setTitle("Koordinatensystem");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);

		dl = new DrawLabel();
		dl.addMouseMotionListener(new MouseListener());
		jFrame.add(dl);

		jFrame.setVisible(true);
	}

	/**
	 * weist dem Koordinatensystem eine neue Groesse zu in Pixeln. der sichtbare
	 * Bereich (d.h. xMin bis xMax bzw. yMin bis yMax wird nicht veraendert.
	 * 
	 * @param neueBreite
	 *            die neue Fensterbreite
	 * @param neueHoehe
	 *            die neue Fensterhoehe
	 */
	public void aendereGroesse(int neueBreite, int neueHoehe) {
		jFrame.setSize(neueBreite, neueHoehe);
	}

	/**
	 * legt den Gitterabstand fest als Koordinatenabstand.
	 * 
	 * @param neuerAbstandX
	 *            der Abstand auf der x-Achse
	 * @param neuerAbstandY
	 *            der Abstand auf der y-Achse
	 */
	public void aendereGitterAbstand(double neuerAbstandX, double neuerAbstandY) {
		this.gridX = neuerAbstandX;
		this.gridY = neuerAbstandY;

		jFrame.repaint();
	}

	/**
	 * zeichnet einen Punkt ein.
	 * 
	 * @param x
	 *            x-Koordinate des neuen Punktes
	 * @param y
	 *            y-Kooridnate des neuen Punktes
	 */
	public void zeichnePunkt(double x, double y) {
		dots.add(x);
		dots.add(y);

		jFrame.repaint();
	}

	/**
	 * zeichnet eine Linie ein.
	 * 
	 * @param x1
	 *            x-Kooridnate des ersten Punktes
	 * @param y1
	 *            y-Koordinate des ersten Punktes
	 * @param x2
	 *            x-Koordinate des zweiten Punktes
	 * @param y2
	 *            y-Koordinate des zweiten Punktes
	 */
	public void zeichneLinie(double x1, double y1, double x2, double y2) {
		lines.add(x1);
		lines.add(y1);
		lines.add(x2);
		lines.add(y2);

		jFrame.repaint();
	}

	/**
	 * löscht gespeicherte Linien und Punkte, sodass das Koordinatensystem wieder
	 * leer ist.
	 */
	public void loeschen() {
		dots.clear();
		lines.clear();

		jFrame.repaint();
	}

	/**
	 * aendert ob eine Achsenbeschriftung gezeichnet werden soll oder nicht.
	 * 
	 * @param zeichneText ob die Beschriftung sichtbar ist oder nicht
	 */
	public void zeichneText(boolean zeichneText) {
		this.drawText = zeichneText;

		jFrame.repaint();
	}

	/**
	 * aendert ob das Gitter automatisch eingeteilt wird.
	 * 
	 * @param autoGitter
	 *            ob die Gitterabstände automatisch angepasst werden sollen
	 */
	public void autoGitterAbstand(boolean autoGitter) {
		this.autoGrid = autoGitter;

		jFrame.repaint();
	}

	/**
	 * aendert ob die Punkte als kontinuierliche Linie gezeichnet werden. Verbinded
	 * die einzelnen Punkte mit einer Linie.
	 * 
	 * @param kontinuierlich
	 *            ob die Punkte verbunden werden sollen
	 */
	public void kontinuierlichePunkte(boolean kontinuierlich) {
		continuousDots = kontinuierlich;

		jFrame.repaint();
	}

	/**
	 * aendert ob die Sichtgroesse des Fensters automatisch mit den Werten angepasst
	 * werden soll.
	 * 
	 * @param autoGroesse
	 *            ob das Sichtfenster automatisch angepasst werden soll.
	 */
	public void autoGroesse(boolean autoGroesse) {
		this.autoResize = autoGroesse;

		jFrame.repaint();
	}

	/**
	 * aendert die Minimal und Maximalwerte für die beiden Achsen
	 * 
	 * @param minX
	 *            der Mindestwert auf der x-Achse
	 * @param maxX
	 *            der Maximalwert auf der x-Achse
	 * @param minY
	 *            der Mindestwert auf der y-Achse
	 * @param maxY
	 *            der Maximalwert auf der y-Achse
	 */
	public void aendereExtreme(double minX, double maxX, double minY, double maxY) {
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;

		jFrame.repaint();
	}

	/*
	 * private Klasse die das Malen des Koordinatensystems beherbergt.
	 */
	private class DrawLabel extends JLabel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public double lastXStretch = 0;
		public double lastYStretch = 0;

		public double lastMinX = 0;
		public double lastMinY = 0;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			double lminX = 0;
			double lmaxX = 0;
			double lminY = 0;
			double lmaxY = 0;
			if (autoResize) {
				for (int i = 0; i < dots.size(); i++) {
					if (i % 2 == 0) {
						lminX = dots.get(i) < lminX ? dots.get(i) : lminX;
						lmaxX = dots.get(i) > lmaxX ? dots.get(i) : lmaxX;
					} else {
						lminY = dots.get(i) < lminY ? dots.get(i) : lminY;
						lmaxY = dots.get(i) > lmaxY ? dots.get(i) : lmaxY;
					}
				}
				for (int i = 0; i < lines.size(); i++) {
					if (i % 2 == 0) {
						lminX = lines.get(i) < lminX ? lines.get(i) : lminX;
						lmaxX = lines.get(i) > lmaxX ? lines.get(i) : lmaxX;
					} else {
						lminY = lines.get(i) < lminY ? lines.get(i) : lminY;
						lmaxY = lines.get(i) > lmaxY ? lines.get(i) : lmaxY;
					}
				}

			} else {
				lminX = minX;
				lmaxX = maxX;
				lminY = minY;
				lmaxY = maxY;
			}

			double xRange = lmaxX - lminX;
			double yRange = lmaxY - lminY;
			
			if (autoResize) {
				lminX -= 0.1 * xRange;
				lmaxX += 0.1 * xRange;
				lminY -= 0.1 * yRange;
				lmaxY += 0.1 * yRange;
				
				xRange = lmaxX - lminX;
				yRange = lmaxY - lminY;
			}

			final double xStretch = this.getWidth() / xRange;
			final double yStretch = this.getHeight() / yRange;

			lastXStretch = xStretch;
			lastYStretch = yStretch;
			lastMinX = lminX;
			lastMinY = lminY;

			double localGridX = 0;
			double localGridY = 0;
			if (autoGrid) {
				localGridX = Math.pow(10, (int) Math.log10(500.0 * xRange / (double) this.getWidth()) - 1);
				localGridY = Math.pow(10, (int) Math.log10(500.0 * yRange / (double) this.getHeight()) - 1);
			} else {
				localGridX = gridX;
				localGridY = gridY;
			}
			
			// Hintergrund
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());

			// 00-Translation
			g.translate((int) (-lminX * xStretch), this.getHeight() - (int) (-lminY * yStretch));

			g.setColor(Color.LIGHT_GRAY);
			// Gitter
			// horizontal
			if (localGridY != 0)
				for (double y = lminY - .00001; y < lmaxY + localGridY; y += localGridY) {
					double gY = y - (y % localGridY);
					gY = Math.round(gY * 100000) / 100000.0;
					drawLine(g, lminX, gY, lmaxX, gY, xStretch, yStretch);

					// Beschriftung
					if (drawText) {
						double textSize = .75 * localGridY;
						drawText(g, "" + gY, textSize, 0, gY, xStretch, yStretch, yStretch);
					}
				}
			// vertical
			if (localGridX != 0)
				for (double x = lminX - .00001; x < lmaxX + localGridX; x += localGridX) {
					double gX = x - (x % localGridX);
					gX = Math.round(gX * 100000) / 100000.0;
					drawLine(g, gX, lminY, gX, lmaxY, xStretch, yStretch);

					// Beschriftung
					if (drawText) {
						double textSize = .75 * localGridX;
						if (gX != 0)
							drawText(g, "" + gX, textSize, gX, 0, xStretch, yStretch, xStretch * .75);
					}
				}

			// Koordinatenkreuz
			g.setColor(Color.BLACK);
			drawLine(g, lminX, 0, lmaxX, 0, xStretch, yStretch);
			drawLine(g, 0, lminY, 0, lmaxY, xStretch, yStretch);

			// Funktion
			// lines
			for (int i = 0; i < lines.size(); i += 4)
				drawLine(g, lines.get(i), lines.get(i + 1), lines.get(i + 2), lines.get(i + 3), xStretch, yStretch);
			// dots
			if (continuousDots) {
				for (int i = 0; i < dots.size() - 2; i += 2)
					drawLine(g, dots.get(i), dots.get(i + 1), dots.get(i + 2), dots.get(i + 3), xStretch, yStretch);
			} else {
				for (int i = 0; i < dots.size(); i += 2)
					fillRect(g, dots.get(i), dots.get(i + 1), 2, 2, xStretch, yStretch);
			}
		}

		/**
		 * Methode zum erleichterten Malen von Linien auf dem Label. Direkte
		 * Transformation von Kooridnaten zu Pixel.
		 * 
		 * @param g
		 *            die Graphics mit denen gemalt wird
		 * @param x1
		 *            x-Koordinate des ersten Punktes
		 * @param y1
		 *            y-Koordinate des ersten Punktes
		 * @param x2
		 *            x-Koordinate des zweiten Punktes
		 * @param y2
		 *            y-Koordinate des zweiten Punktes
		 * @param xStretch
		 *            Streckfaktor auf der x-Achse zum Skalieren
		 * @param yStretch
		 *            Streckfaktor auf der y-Achse zum Skalieren
		 */
		private void drawLine(Graphics g, double x1, double y1, double x2, double y2, double xStretch,
				double yStretch) {
			g.drawLine((int) (x1 * xStretch), (int) (-y1 * yStretch), (int) (x2 * xStretch), (int) (-y2 * yStretch));
		}

		/**
		 * Methode zum erleichterten Malen von Rechtecken auf dem Label. Direkte
		 * Transformation von Kooridnaten zu Pixel.
		 * 
		 * @param g
		 *            die Graphics mit denen gemalt wird
		 * @param x
		 *            x-Koordinate (nicht Pixel)
		 * @param y
		 *            y-Koordinate (nicht Pixel)
		 * @param width
		 *            Breite des Rechtecks
		 * @param height
		 *            Hoehe des Rechtecks
		 * @param xStretch
		 *            Streckfaktor auf der x-Achse zum Skalieren
		 * @param yStretch
		 *            Streckfaktor auf der y-Achse zum Skalieren
		 */
		private void fillRect(Graphics g, double x, double y, double width, double height, double xStretch,
				double yStretch) {
			g.fillRect((int) (x * xStretch) - 1, (int) (-y * yStretch) - 1, (int) (width), (int) (height));
		}

		/**
		 * Methode zum erleichterten Malen von Text auf dem Label. Direkte
		 * Transformation von Kooridnaten zu Pixel.
		 * 
		 * @param g
		 *            die Graphics mit denen gemalt wird
		 * @param text
		 *            der Text der geschrieben wird
		 * @param size
		 *            die Textgröße in Koordinaten
		 * @param x
		 *            x-Koordinate des Textes
		 * @param y
		 *            y-Koordinate des Textes
		 * @param xStretch
		 *            Streckfaktor auf der x-Achse zum Skalieren
		 * @param yStretch
		 *            Streckfaktor auf der y-Achse zum Skalieren
		 * @param textScale
		 *            wie gross der Text gestreckt werden soll
		 */
		private void drawText(Graphics g, String text, double size, double x, double y, double xStretch,
				double yStretch, double textScale) {
			int castSize = (int) (size * textScale);
			castSize = castSize > 25 ? 25 : castSize;
			castSize = castSize < 5 ? 5 : castSize;
			g.setFont(new Font("Arial", Font.BOLD, castSize));
			g.drawString(text, (int) (x * xStretch), (int) (-y * yStretch));
		}
	}

	/*
	 * private Klasse, die den ToolTipText beherbergt.
	 */
	private class MouseListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent me) {
			mouseMoved(me);
		}

		@Override
		public void mouseMoved(MouseEvent me) {
			dl.setToolTipText(String.format("X: %.2f; Y: %.2f", (double) me.getX() / dl.lastXStretch + dl.lastMinX,
					(double) (dl.getHeight() - me.getY()) / dl.lastYStretch + dl.lastMinY));
		}

	}

	public void setzeGroesseinPixeln(int width, int height) {
		jFrame.setSize(width, height);
		
	}
}
