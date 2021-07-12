package _test.linear.buero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
public class ChefGUI extends javax.swing.JFrame {
	private JLabel neuerAuftragLabel;
	private JTextField neuerAuftragTextField;
	private JCheckBox dringendCheckBox;
	private JTextArea alleAuftraegeTextArea;
	private JScrollPane alleAuftraegeScrollPane;
	private JButton auftragButton;

	private Chef chef;
	
	private static int xPosition = 230;
	private static int yPosition = 0;

	
	public ChefGUI(Chef chef){
		this.chef= chef;
		this.initGUI();
	}
	
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				neuerAuftragLabel = new JLabel();
				neuerAuftragLabel.setText("neuer Auftrag");
			}
			{
				neuerAuftragTextField = new JTextField();
				neuerAuftragTextField.setText("Kaffee kochen");
			}
			{
				auftragButton = new JButton();
				auftragButton.setText("Auftrag ablegen");
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
			{
				dringendCheckBox = new JCheckBox();
				dringendCheckBox.setText("dringend");
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(neuerAuftragTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(neuerAuftragLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(auftragButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(dringendCheckBox, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
				.addGap(20)
				.addComponent(alleAuftraegeScrollPane, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(18, 18));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addGap(6)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(dringendCheckBox, 0, 158, Short.MAX_VALUE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 1, GroupLayout.PREFERRED_SIZE)
				        .addComponent(auftragButton, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(neuerAuftragLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
				        .addComponent(neuerAuftragTextField, 0, 259, Short.MAX_VALUE))
				    .addComponent(alleAuftraegeScrollPane, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
				.addContainerGap());
			pack();
			this.setSize(376, 239);
			this.setTitle("Chef: "+chef.getName());
			this.setLocation(xPosition, yPosition);
			yPosition+=(this.getHeight()+20);		
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void auftragButtonActionPerformed(ActionEvent evt) {
		String neuerAuftragText = this.neuerAuftragTextField.getText();
		if(neuerAuftragText == null || neuerAuftragText.equals("")){
			return;
		}
		chef.auftragAblegen(neuerAuftragText, istDringend());
		this.neuerAuftragTextField.setText("");
		this.alleAuftraegeTextArea.append(neuerAuftragText+"\n");
	}
	
	public boolean istDringend(){
		boolean dringend =  this.dringendCheckBox.isSelected();
		return dringend;
	}

}
