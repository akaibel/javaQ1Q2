package linear;


import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BoxLayout;
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
public class LViewer extends javax.swing.JFrame {
	private static final long WARTEZEIT = Configuration.WARTEZEIT_LINEAR;

	private static Vector<LViewer> ALLFRAMES = new Vector<LViewer>();
	
	
	private static int LOCATION_X = 0;
	private static int LOCATION_Y = 0;
	private static int FRAMEWIDTH = 200;
	
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel befehlLabel;

	List list;
	private JLabel currentLabel;

	public LViewer(List list) {
		super();
		initGUI();
		this.list = list;
		ALLFRAMES.add(this);
		setVisible(true);
	}
	
	void fehlerMeldung(Exception e, String befehl) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(this, "unzulaessiger Befehl:\n"+befehl);
		System.exit(0);
	}
	
	void anzeigen(String befehl, List list) {
		this.disableAllFrames();
		this.toFront();
		this.setEnabled(true);
		this.befehlLabel.setText(befehl);
		try {
			Thread.sleep(LViewer.WARTEZEIT);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		listInhaltAnzeigen(list);
		try {
			Thread.sleep(LViewer.WARTEZEIT);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void disableAllFrames() {
		Iterator<LViewer> i = ALLFRAMES.iterator();
		LViewer current;
		while(i.hasNext()){
			current = i.next();
			current.setEnabled(false);
		}
	}

	private void listInhaltAnzeigen(List list) {
//		String hasAccessText = "hasAccess: false";
//		if(list.hasAccess()){
//			hasAccessText = "hasAccess: true";
//		}
//		hasAccessLabel.setText(hasAccessText);
		
		linear.List.ListNode firstNode = list.getFirstNode();
		linear.List.ListNode currentNode = list.getCurrentNode();
		linear.List.ListNode tailNode = list.getLastNode();
		
		String currentText = "current: null";
		if(currentNode != null && currentNode.getContentObject() != null ){
			currentText = "current: "+ currentNode.getContentObject();
		}
		currentLabel.setText(currentText);

		
		String anzeigeText = "";
		linear.List.ListNode theNode = firstNode;
		while(theNode != null){
			Object inhalt = theNode.getContentObject();
			if (theNode == currentNode) {
				anzeigeText = anzeigeText + "-> " + inhalt.toString()
						+ "\n";
			} else {
				anzeigeText = anzeigeText + "    " + inhalt.toString()
						+ "\n";
			}
			theNode = theNode.getNextNode();
		}
		
		// listinhalt anzeigen
		this.textArea.setText(anzeigeText);
		
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS);
			getContentPane().setLayout(thisLayout);
			{
				befehlLabel = new JLabel();
				getContentPane().add(befehlLabel);
				befehlLabel.setText("***");
				befehlLabel.setPreferredSize(new java.awt.Dimension(FRAMEWIDTH-5, 20));
			}
			{
				currentLabel = new JLabel();
				getContentPane().add(currentLabel);
				currentLabel.setText("current: null");
				currentLabel.setPreferredSize(new java.awt.Dimension(166, 14));
			}
			{
				scrollPane = new JScrollPane();
				getContentPane().add(scrollPane);
				{
					textArea = new JTextArea();
					scrollPane.setViewportView(textArea);
				}
			}
			this.addWindowListener(new WindowListener(){

				
				public void windowActivated(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				
				public void windowClosed(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
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
			pack();
			this.setSize(FRAMEWIDTH, 400);
			this.setLocation(LViewer.LOCATION_X, LViewer.LOCATION_Y);
			LOCATION_X += (FRAMEWIDTH+10);
			LOCATION_Y += 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
