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



public class SachbearbeiterGUI extends javax.swing.JFrame {

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
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
		String auftragText = sachbearbeiter.holeUndBearbeiteAuftrag();
		this.append(auftragText);
		
	}

	public void append(String text){
		alleAuftraegeTextArea.append(text+"\n");
	}

}
