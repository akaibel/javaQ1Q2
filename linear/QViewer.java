package linear;
import java.awt.Font;
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

import _config.Configuration;



/**
 * @author: a. kaibel, a.kaibel@googlemail.com
 * 
 */
public class QViewer extends javax.swing.JFrame {

	private static Vector<QViewer> ALLFRAMES = new Vector<QViewer>();
	
	
	private static int LOCATION_X = 0;
	private static int LOCATION_Y = 0;
	private int FRAMEWIDTH = Configuration.LISTEN_ANZEIGE_BREITE;
	
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
			Thread.sleep(Configuration.WARTEZEIT_LINEAR);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		queueInhaltAnzeigen(queue);
		try {
			Thread.sleep(Configuration.WARTEZEIT_LINEAR);
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
		Configuration.READ_AND_START_UPDATING_CONFIGURATION();
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
			}
			{
				frontLabel = new JLabel();
				frontLabel.setFont(fontBold);
				getContentPane().add(frontLabel);
				frontLabel.setText("front: null");
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
		            textArea.setFont(fontPlain);
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
