package _test.datenbanken.tippgemeinschaft;


import java.awt.Dimension;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class PanelTipp extends javax.swing.JPanel {
	private JLabel labelHeim;
	private JTextField textFieldToreGast;
	private JTextField textFieldToreHeim;
	private JLabel labelGast;
	private int spielId;

	/**
	 * 
	 * @param spielId die ID des Spiels
	 * @param heim die Heimmmannschaft
	 * @param gast die Gastmannschaft
	 * @param toreHeim ggf. leer
	 * @param toreGast ggf. leer
	 */
	public PanelTipp(int spielId, String heim, String gast, String toreHeim, String toreGast) {
		super();
		initGUI();
		this.spielId = spielId;
		this.labelHeim.setText(heim);
		this.labelGast.setText(gast);
		this.textFieldToreHeim.setText(toreHeim);
		this.textFieldToreGast.setText(toreGast);
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(300, 30));
			this.setLayout(null);
			{
				labelHeim = new JLabel();
				this.add(labelHeim);
				labelHeim.setText("heim");
				labelHeim.setBounds(7, 6, 95, 16);
			}
			{
				labelGast = new JLabel();
				this.add(labelGast);
				labelGast.setText("gast");
				labelGast.setBounds(114, 6, 102, 16);
			}
			{
				textFieldToreHeim = new JTextField();
				this.add(textFieldToreHeim);
				textFieldToreHeim.setBounds(228, 3, 24, 23);
			}
			{
				textFieldToreGast = new JTextField();
				this.add(textFieldToreGast);
				textFieldToreGast.setBounds(264, 3, 24, 23);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getHeim(){
		return this.labelHeim.getText();
	}
	
	public String getGast(){
		return this.labelGast.getText();
	}
	
	public int getToreHeim(){
		int toreHeim = getInteger(textFieldToreHeim);
		return toreHeim;
	}

	public int getToreGast(){
		int toreGast = getInteger(textFieldToreGast);
		return toreGast;
	}
	
	public int getSpielId(){
		return spielId;
	}

	private int getInteger(JTextField textField) {
		int zahl = -1;
		try{
			String text = textField.getText();
			zahl = Integer.parseInt(text);
		}catch(Exception ex){
			//nix
		}
		return zahl;
	}

}
