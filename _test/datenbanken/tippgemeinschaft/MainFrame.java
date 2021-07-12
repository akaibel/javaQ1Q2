package _test.datenbanken.tippgemeinschaft;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
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
public class MainFrame extends javax.swing.JFrame {

	private CardLayout layout;


	// menubar
	private JMenuBar menuBar;

	// menus und panels muessen zusammenpassen
	private String[] menus = {"login", "tippen"};
	private JPanel[] panels = {new PanelLogin(), new PanelTippen()};

	public MainFrame() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			layout = new CardLayout();
			getContentPane().setLayout(layout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			addPanels();
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			addMenus();
			pack();
			setSize(400, 600);
			// das erste Panel anzeigen
			layout.show(getContentPane(), menus[0]);
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}

	private void addPanels() {
		for (int i = 0; i < panels.length; i++) {
			getContentPane().add(panels[i], menus[i]);
		}
	}

	private void addMenus() {
		for (int i = 0; i < menus.length; i++) {
			JMenu menu = new JMenu();
			menu.setText(menus[i]);
			menuBar.add(menu);
			menu.addMenuListener(new MenuListener() {
				public void menuDeselected(MenuEvent evt) {
					//nix
				}
				public void menuSelected(MenuEvent evt) {
					JMenu source = (JMenu) evt.getSource();
					layout.show(getContentPane(), source.getText());
				}
				public void menuCanceled(MenuEvent evt) {
					//nix
				}
			});
		}
	}
}
