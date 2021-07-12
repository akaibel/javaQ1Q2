package array;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.BoxLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.WindowConstants;



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
public class ArrayViewer extends javax.swing.JFrame {
	private static final long WARTEZEIT = 100;

	private static ArrayViewer[] ALLARRAYVIEWER = new ArrayViewer[10];
	
	
	private static int LOCATION_X = 0;
	private static int LOCATION_Y = 0;
	private static int FRAMEWIDTH = 200;
	
	private JScrollPane scrollPane;
	private JTextArea textArea;

	private int nummer;

	private ArrayViewer(int nummer) {
		super();
		this.nummer = nummer;
		initGUI();
		this.setTitle("Nummer: "+nummer);
		ALLARRAYVIEWER[nummer] = this;
		setVisible(true);
	}
	
	void fehlerMeldung(Exception e, String befehl) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(this, "unzulaessiger Befehl:\n"+befehl);
		System.exit(0);
	}
	
	private void disableAllFrames() {
		for (int i = 0; i < ALLARRAYVIEWER.length; i++) {
			ALLARRAYVIEWER[i].setEnabled(false);
		}
	}

	private void arrayAnzeigen(Object[] array) {
		String anzeigeText = "";
		if(array == null){
			anzeigeText = "null";
		}
		else if(array.length == 0){
			anzeigeText = "*** leer ***";
		}
		else{
			for (int i = 0; i < array.length; i++) {
				anzeigeText+=i;
				anzeigeText+=": ";
				if(array[i] == null){
					anzeigeText+="null";
				}
				else{
					anzeigeText+= array[i].toString();					
				}
				anzeigeText+="\n";
			}
		}
		this.textArea.setText(anzeigeText);
		try {
			Thread.sleep(WARTEZEIT);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS);
			getContentPane().setLayout(thisLayout);
			{
				scrollPane = new JScrollPane();
				getContentPane().add(scrollPane);
				{
					textArea = new JTextArea();
					scrollPane.setViewportView(textArea);
				}
			}
			pack();
			this.setSize(FRAMEWIDTH, 300);
			this.setLocation(ArrayViewer.LOCATION_X, ArrayViewer.LOCATION_Y);
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

	public static void zeigeArray(Object[] array, int nummer, String ueberschrift) {
		if(ALLARRAYVIEWER[nummer] == null){
			new ArrayViewer(nummer);
		}
		ArrayViewer av = ALLARRAYVIEWER[nummer];
		av.arrayAnzeigen(array);
		av.setTitle(""+nummer+": "+ueberschrift);
	}

	public int getNummer() {
		return nummer;
	}
	
	private void thisWindowClosing(WindowEvent evt) {
		System.exit(0);
	}
}
