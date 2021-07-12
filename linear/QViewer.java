package linear;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * @author: a. kaibel, a.kaibel@googlemail.com
 * 
 */

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
public class QViewer extends javax.swing.JFrame {
	private static final long WARTEZEIT = Configuration.WARTEZEIT_LINEAR;

	private static Vector<QViewer> ALLFRAMES = new Vector<QViewer>();
	
	
	private static int LOCATION_X = 0;
	private static int LOCATION_Y = 0;
	private static int FRAMEWIDTH = 200;
	
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel befehlLabel;

	Queue queue;
	private JLabel lastLabel;
	private JLabel frontLabel;

	public QViewer(Queue queue) {
		super();
		initGUI();
		this.queue = queue;
		ALLFRAMES.add(this);
		setVisible(true);
	}
	
	void fehlerMeldung(Exception e, String befehl) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(this, "unzulaessiger Befehl:\n"+befehl);
		System.exit(0);
	}
	
	void anzeigen(String befehl, Queue queue) {
		this.disableAllFrames();
		this.toFront();
		this.setEnabled(true);
		this.befehlLabel.setText(befehl);
		try {
			Thread.sleep(QViewer.WARTEZEIT);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		queueInhaltAnzeigen(queue);
		try {
			Thread.sleep(QViewer.WARTEZEIT);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void disableAllFrames() {
		Iterator<QViewer> i = ALLFRAMES.iterator();
		QViewer current;
		while(i.hasNext()){
			current = i.next();
			current.setEnabled(false);
		}
	}

	private void queueInhaltAnzeigen(Queue queue) {
		String frontText = "front: null";
		if(queue.getFrontNode() != null && queue.getFrontNode().getContent() != null){
			frontText = "front: "+ queue.getFrontNode().getContent();
		}
		frontLabel.setText(frontText);
		
		String lastText = "last: null";
		if(queue.getLastNode() != null && queue.getLastNode().getContent() != null){
			lastText = "last: "+ queue.getLastNode().getContent();
		}
		lastLabel.setText(lastText);

		String anzeigeText = "";
		
		linear.Queue.QueueNode currentNode = queue.getFrontNode();
		
		while(currentNode != null){
			Object inhalt = currentNode.getContent();
			anzeigeText = anzeigeText+inhalt.toString()+"\n";
			currentNode = currentNode.getNext();
		}
		
		// queueinhalt anzeigen
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
				frontLabel = new JLabel();
				getContentPane().add(frontLabel);
				frontLabel.setText("front: null");
				frontLabel.setPreferredSize(new java.awt.Dimension(FRAMEWIDTH-5, 20));
			}
			{
				lastLabel = new JLabel();
				getContentPane().add(lastLabel);
				lastLabel.setText("last: null");
				lastLabel.setPreferredSize(new java.awt.Dimension(FRAMEWIDTH-5, 20));
			}
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
			this.setLocation(QViewer.LOCATION_X, QViewer.LOCATION_Y);
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
