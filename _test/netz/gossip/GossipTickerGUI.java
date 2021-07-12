package _test.netz.gossip;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;

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
public class GossipTickerGUI extends javax.swing.JFrame {
	private JLabel nachrichtLabel;
	private JLabel zeitLabel;
	
	private static int nr;
	private static int xPosition = 300;
	private static int yPosition = 0;

	public GossipTickerGUI() {
		super();
		yPosition += 100;
		nr++;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			BorderLayout thisLayout = new BorderLayout();
			this.setTitle("GossipTicker "+nr);
			getContentPane().setLayout(thisLayout);
			{
				nachrichtLabel = new JLabel();
				getContentPane().add(nachrichtLabel, BorderLayout.CENTER);
				nachrichtLabel.setText("*** noch keine Nachricht ***");
				nachrichtLabel.setLayout(null);
				nachrichtLabel.setPreferredSize(new java.awt.Dimension(384, 46));
			}
			{
				zeitLabel = new JLabel();
				getContentPane().add(zeitLabel, BorderLayout.NORTH);
				zeitLabel.setText("aktuelle Nachricht:");
			}
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			pack();
			this.setSize(400, 80);
			this.setLocation(xPosition, yPosition);
			this.setVisible(true);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public void nachrichtAnzeigen(String pNachricht){
		this.nachrichtLabel.setText(pNachricht);
	}
	
	public void zeitAnzeigen(String pZeit){
		this.zeitLabel.setText(pZeit);
	}
	
	private void thisWindowClosing(WindowEvent evt) {
		//System.out.println("this.windowClosing, event="+evt);
		System.exit(0);
	}

}
