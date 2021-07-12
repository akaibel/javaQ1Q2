package _test.datenbanken.tippgemeinschaft;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

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
public class PanelTippen extends javax.swing.JPanel {
	private JLabel labelErklaerung;
	private JPanel panelAlleTipps;
	private JButton buttonEintragen;
	private JScrollPane scrollPaneAlleTipps;

	private PanelTipp[] tipps;

	public PanelTippen() {
		super();
		initTipps();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(400, 550));
			this.setLayout(null);
			{
				labelErklaerung = new JLabel();
				this.add(labelErklaerung);
				labelErklaerung.setText("Hier die Ergebnisse tippen!");
				labelErklaerung.setBounds(12, 21, 200, 16);
			}
			{
				scrollPaneAlleTipps = new JScrollPane();
				this.add(scrollPaneAlleTipps);
				scrollPaneAlleTipps.setBounds(12, 49, 363, 439);
				{
					panelAlleTipps = new JPanel();
					BoxLayout panelTippsLayout = new BoxLayout(panelAlleTipps, javax.swing.BoxLayout.Y_AXIS);
					panelAlleTipps.setLayout(panelTippsLayout);
					scrollPaneAlleTipps.setViewportView(panelAlleTipps);
				}
				for (int i = 0; i < tipps.length; i++) {
					panelAlleTipps.add(tipps[i]);
				}
			}
			{
				buttonEintragen = new JButton();
				this.add(buttonEintragen);
				buttonEintragen.setText("eintragen");
				buttonEintragen.setBounds(30, 500, 325, 23);
				buttonEintragen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						buttonEintragenActionPerformed(evt);
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * hier werden die PanelTipps ausgelesen!
	 * @return
	 */
	private void initTipps() {
		//TODO edit
		tipps = new PanelTipp[2];
		tipps[0] = new PanelTipp(1, "Muenchen", "Gladbach", "", "");
		tipps[1] = new PanelTipp(2, "Freiburg", "Dortmund", "", "");
	}
	
	private void buttonEintragenActionPerformed(ActionEvent evt) {
		//TODO 
		// tipps auslesen und in die DB packen
	}

}
