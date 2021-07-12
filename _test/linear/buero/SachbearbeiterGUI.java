package _test.linear.buero;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;



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
public class SachbearbeiterGUI extends javax.swing.JFrame {
//	private JScrollPane jScrollPane1;

	private Sachbearbeiter sachbearbeiter;
	private JButton auftragButton;
	private JTextArea alleAuftraegeTextArea;
	private JScrollPane alleAuftraegeScrollPane;
	
	private static int xPosition = 630;
	private static int yPosition;

	
	public SachbearbeiterGUI(Sachbearbeiter sachbearbeiter){
		this.sachbearbeiter = sachbearbeiter;
		this.initGUI();
	}
	
	
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				auftragButton = new JButton();
				auftragButton.setText("Auftrag holen");
				auftragButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						auftragButtonActionPerformed(evt);
					}
				});
			}
			{
				alleAuftraegeScrollPane = new JScrollPane();
				{
					alleAuftraegeTextArea = new JTextArea();
					alleAuftraegeScrollPane.setViewportView(alleAuftraegeTextArea);
				}
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(auftragButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(alleAuftraegeScrollPane, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addGap(6)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGap(0, 0, Short.MAX_VALUE)
				        .addComponent(alleAuftraegeScrollPane, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(82)
				        .addComponent(auftragButton, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
				        .addGap(87)))
				.addContainerGap());
			pack();
			this.setSize(376, 185);
			this.setTitle("Sachbearbeiter: "+sachbearbeiter.getName());
			this.setLocation(xPosition, yPosition);
			yPosition+=(this.getHeight()+20);
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void auftragButtonActionPerformed(ActionEvent evt) {
		sachbearbeiter.holeUndBearbeiteAuftrag();
		
	}

	public void append(String text){
		alleAuftraegeTextArea.append(text+"\n");
	}

}
