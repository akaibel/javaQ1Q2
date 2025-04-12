package linear;
/**
 * @author: a. kaibel, a.kaibel@googlemail.com
 * 
 */


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.WindowConstants;

import _config.Configuration;



/**
 * @author: a. kaibel, a.kaibel@googlemail.com
 * 
 */
public class SViewer extends javax.swing.JFrame {

	private static Vector<SViewer> ALLFRAMES = new Vector<SViewer>();
	
	
	private static int LOCATION_X = 0;
	private static int LOCATION_Y = 0;
	
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel befehlLabel;

	
	private Stack stack;
	
	public SViewer(Stack stack) {
		super();
		initGUI();
		this.stack = stack;
		ALLFRAMES.add(this);
		setVisible(true);
	}
	
	void fehlerMeldung(Exception e, String befehl) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(this, "unzulaessiger Befehl:\n"+befehl);
		System.exit(0);
	}
	
	void anzeigen(String befehl) {
		this.disableAllFrames();
		this.toFront();
		this.setEnabled(true);
		this.befehlLabel.setText(befehl);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		stackInhaltAnzeigen();
			try {
				Thread.sleep(Configuration.WARTEZEIT_LINEAR);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private void disableAllFrames() {
		Iterator<SViewer> i = ALLFRAMES.iterator();
		SViewer current;
		while(i.hasNext()){
			current = i.next();
			current.setEnabled(false);
		}
	}

	private void stackInhaltAnzeigen() {
		linear.Stack.StackNode currentNode = stack.getTopNode();
		String anzeigeText = "";
		while(currentNode != null){
			String zeile = currentNode.getContent().toString();
			anzeigeText = anzeigeText+zeile+"\n";
			currentNode = currentNode.getNext();
		}
		this.textArea.setText(anzeigeText);
		
	}

	private void initGUI() {
		Configuration.READ_AND_START_UPDATING_CONFIGURATION();
		Font fontPlain = new Font("Arial", Font.PLAIN, Configuration.FONT_SIZE);
		Font fontBold = new Font("Arial", Font.BOLD, Configuration.FONT_SIZE);
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			{
				scrollPane = new JScrollPane();
				getContentPane().add(scrollPane, BorderLayout.CENTER);
				{
					textArea = new JTextArea();
		            textArea.setFont(fontPlain);
					scrollPane.setViewportView(textArea);
				}
			}
			{
				befehlLabel = new JLabel();
				befehlLabel.setFont(fontBold);
				getContentPane().add(befehlLabel, BorderLayout.NORTH);
				befehlLabel.setText("***");
			}
			pack();
			this.setSize(Configuration.LISTEN_ANZEIGE_BREITE, Configuration.LISTEN_ANZEIGE_HOEHE);
			this.setLocation(SViewer.LOCATION_X, SViewer.LOCATION_Y);

			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					System.exit(0);
				}
			});

		    this.addComponentListener(new ComponentAdapter() {
	            @Override
	            public void componentResized(ComponentEvent e) {
	                int width = getWidth();
	                int height = getHeight();
	                Configuration.LISTEN_ANZEIGE_BREITE = width;
	                Configuration.LISTEN_ANZEIGE_HOEHE = height;
	            }
	        });			
			
			LOCATION_X += (Configuration.LISTEN_ANZEIGE_BREITE+10);
			LOCATION_Y += 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
