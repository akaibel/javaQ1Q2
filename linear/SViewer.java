package linear;
/**
 * @author: a. kaibel, a.kaibel@googlemail.com
 * 
 */


import java.awt.BorderLayout;
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
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class SViewer extends javax.swing.JFrame {
	private static final long WARTEZEIT = Configuration.WARTEZEIT_LINEAR;

	private static Vector<SViewer> ALLFRAMES = new Vector<SViewer>();
	
	
	private static int LOCATION_X = 0;
	private static int LOCATION_Y = 0;
	private static int FRAMEWIDTH = 165;
	
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
				Thread.sleep(SViewer.WARTEZEIT);
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
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			{
				scrollPane = new JScrollPane();
				getContentPane().add(scrollPane, BorderLayout.CENTER);
				{
					textArea = new JTextArea();
					scrollPane.setViewportView(textArea);
				}
			}
			{
				befehlLabel = new JLabel();
				getContentPane().add(befehlLabel, BorderLayout.NORTH);
				befehlLabel.setText("***");
				befehlLabel.setPreferredSize(new java.awt.Dimension(155, 19));
			}
			pack();
			this.setSize(FRAMEWIDTH, 300);
			this.setLocation(SViewer.LOCATION_X, SViewer.LOCATION_Y);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			LOCATION_X += (FRAMEWIDTH+10);
			LOCATION_Y += 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void thisWindowClosing(WindowEvent evt) {
		System.exit(0);
	}

}
