package mathe;

import java.awt.Color;

import javax.swing.JFrame;

public class SaeulenDiagramm {
	static int xPosition = 0;
	static int yPosition = 0;
	static final int xSize = 400;

	/**
	 * 
	 * @param values
	 * @param labels may be null, then default value will be taken
	 * @param colors may be null, then default value will be taken
	 * @param title may be null, then will remain empty
	 */
	public SaeulenDiagramm(double[] values, String[] labels, Color[] colors, String title){
		
		JFrame frame = new JFrame("Saeulendiagramm");
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(xSize, 300);
	    frame.setLocation(xPosition, yPosition);
	    xPosition += (xSize+20);
	    if(xPosition >= 1000){
	    	xPosition = 0;
	    	yPosition += 340;
	    }
	    SaeulenDiagrammJPanel sdjp = new SaeulenDiagrammJPanel(values, labels, colors, title);
	 
	    frame.add(sdjp);
	    frame.setVisible(true);
		
	}
	
	/**
	 * Stellt Haeufigkeiten als Saeulendiagramm dar.
	 * @param haeufigkeiten
	 */
	public SaeulenDiagramm(int[] haeufigkeiten) {
		// die Nullen rausschmeissen!
		int links = 0;
		while(haeufigkeiten[links] == 0) links++;
		int rechts = haeufigkeiten.length - 1;
		while(haeufigkeiten[rechts] == 0) rechts--;

		double[] values = new double[rechts - links + 1];
		for(int i=links; i<=rechts; i++){
			values[i-links] = haeufigkeiten[i];
		}
		
		String[] labels = new String[rechts - links + 1];
		for(int i=links; i<=rechts; i++){
			int index = i-links;
			labels[index] = ""+i;
		}
		
		//ausgeben(labels, values);
		new SaeulenDiagramm(values, labels, null, null);
	}

	private void ausgeben(String[] labels, double[] values) {
		for(int i=0; i<labels.length; i++){
			System.out.println(labels[i]+": "+values[i]);
		}
		
	}

	public static void main(String[] args) {
	    String title = "My Title";
	    double[] values = new double[]{1,2,3,4,5};
	    String[] labels = new String[]{"A","B","C","D","E"};
	    Color[] colors = new Color[]{
	        Color.red,
	        Color.orange,
	        Color.yellow,
	        Color.green,
	        Color.blue
	    };
	    //SaeulenDiagramm sd = new SaeulenDiagramm(values, labels, colors, title);
	    //SaeulenDiagramm sd = new SaeulenDiagramm(values, null, null, null);
		int[] haeufigkeiten = {0,0,0,3,7,11,0,6,0,0};
		SaeulenDiagramm sd = new SaeulenDiagramm(haeufigkeiten);
	}
}
