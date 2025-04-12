package linear;


import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
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
 * @author: a. kaibel, a.kaibel@googlemail.com
 * 
 */
public class LViewer extends javax.swing.JFrame {

	private static Vector<LViewer> ALLFRAMES = new Vector<LViewer>();
	
	
	private static int LOCATION_X = 0;
	private static int LOCATION_Y = 0;
	
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel befehlLabel;

	List list;
	private JLabel currentLabel;

	public LViewer(List list) {
		super();
		Configuration.READ_AND_START_UPDATING_CONFIGURATION();
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
			Thread.sleep(Configuration.WARTEZEIT_LINEAR);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		listInhaltAnzeigen(list);
		try {
			Thread.sleep(Configuration.WARTEZEIT_LINEAR);
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
		Font fontPlain = new Font("Arial", Font.PLAIN, Configuration.FONT_SIZE);
		Font fontBold = new Font("Arial", Font.BOLD, Configuration.FONT_SIZE);
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS);
			getContentPane().setLayout(thisLayout);
			{
				befehlLabel = new JLabel();			
				befehlLabel.setFont(fontBold);
				getContentPane().add(befehlLabel);
				befehlLabel.setText("***");
				//befehlLabel.setPreferredSize(new java.awt.Dimension(FRAMEWIDTH-5, 20));
			}
			{
				currentLabel = new JLabel();
				currentLabel.setFont(fontBold);
				getContentPane().add(currentLabel);
				currentLabel.setText("current: null");
				//currentLabel.setPreferredSize(new java.awt.Dimension(166, 14));
				
			}
			{
				scrollPane = new JScrollPane();
				getContentPane().add(scrollPane);
				{
					textArea = new JTextArea();
		            textArea.setFont(fontPlain);
					scrollPane.setViewportView(textArea);
				}
			}
			this.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent arg0) {
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
			pack();
			this.setSize(Configuration.LISTEN_ANZEIGE_BREITE, Configuration.LISTEN_ANZEIGE_HOEHE);
			this.setLocation(LViewer.LOCATION_X, LViewer.LOCATION_Y);
			LOCATION_X += (Configuration.LISTEN_ANZEIGE_BREITE+10);
			LOCATION_Y += 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
