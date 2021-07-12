package _test.datenbanken.tippgemeinschaft;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
public class PanelLogin extends javax.swing.JPanel {
	private JLabel labelName;
	private JLabel labelPasswort;
	private JTextField textFieldName;
	private JPasswordField textFieldPasswort;
	private JButton buttonLogin;
	
	public PanelLogin() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(400, 300));
			this.setLayout(null);
			{
				labelName = new JLabel();
				this.add(labelName);
				labelName.setText("Name: ");
				labelName.setBounds(28, 66, 65, 16);
			}
			{
				labelPasswort = new JLabel();
				this.add(labelPasswort);
				labelPasswort.setText("Passwort:");
				labelPasswort.setBounds(28, 113, 65, 16);
			}
			{
				textFieldName = new JTextField();
				this.add(textFieldName);
				textFieldName.setBounds(121, 66, 97, 23);
			}
			{
				textFieldPasswort = new JPasswordField();
				this.add(textFieldPasswort);
				textFieldPasswort.setBounds(121, 110, 97, 23);
			}
			{
				buttonLogin = new JButton();
				this.add(buttonLogin);
				buttonLogin.setText("anmelden");
				buttonLogin.setBounds(28, 178, 190, 23);
				buttonLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						buttonLoginActionPerformed(evt);
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void buttonLoginActionPerformed(ActionEvent evt) {
		String name = this.textFieldName.getText();
		String passwort = new String(this.textFieldPasswort.getPassword());
		login(name, passwort);
	}

	private void login(String pName, String pPasswort) {
		System.out.println("PanelLogin.login("+pName+", "+pPasswort+")");
		//TODO		
	}

}
