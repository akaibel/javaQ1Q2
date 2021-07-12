package zauberwuerfel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZFrame extends JFrame {

	private JPanel mainPanel;
	private JPanel zauberwuerfelPanel;
	private JPanel buttonsPanel;
	
	private JButton verdrehenButton;
	private JButton loesenButton;
	private JButton einstellenButton;
	
	private ZButton[][] farbFelder;
	
	private ZLogik zLogik;
	
	private boolean wirdEingestellt;
	
	

	/**
	 * Create the frame.
	 */
	public ZFrame(ZLogik zLogik) {
		wirdEingestellt = false;
		this.zLogik = zLogik;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 500, 720);
		
		zauberwuerfelPanel = new JPanel();
		zauberwuerfelPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		zauberwuerfelPanel.setLayout(new GridLayout(12, 9, 1, 1));

		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());
		verdrehenButton = new JButton("verdrehen");
		verdrehenButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				verdrehen();
			}
		});
		loesenButton = new JButton("loesen");
		loesenButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				loesen();
			}
		});
		einstellenButton = new JButton("einstellen");
		einstellenButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				einstellen();
			}
		});
		
		buttonsPanel.add(einstellenButton);
		buttonsPanel.add(verdrehenButton);
		buttonsPanel.add(loesenButton);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		setContentPane(mainPanel);
		mainPanel.add(zauberwuerfelPanel, BorderLayout.CENTER);
		mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		
		farbFelder = new ZButton[12][9];
		int zeileNr = 0;
		int spalteNr = 0;
		for(ZButton[] zeile: farbFelder){
			spalteNr = 0;
			for(ZButton feld: zeile){
				feld = new ZButton("");
				farbFelder[zeileNr][spalteNr] = feld;
				//feld.setText(""+spalteNr+","+zeileNr);
				feld.setOpaque(true);
				feld.setBackground(Color.BLACK);
				zauberwuerfelPanel.add(feld);
				spalteNr++;
			}
			zeileNr++;
		}
		setVisible(true);
	}
	
	public void updateGUI(ZModel m){
		int[][] modelFelder = m.getFelder(); 
		for(int seiteNr=0; seiteNr<6; seiteNr++){
			int zeileStart = -1;
			int spalteStart = -1;
			if(seiteNr<4){
				// das ist die mittlere Spalte!
				zeileStart = 3*seiteNr;
				spalteStart = 3;
			}
			else if(seiteNr == 4){
				// das ist links!
				zeileStart = 3;
				spalteStart = 0;
			}
			else if(seiteNr == 5){
				// das ist rechts!
				zeileStart = 3;
				spalteStart = 6;				
			}
			else{
				System.err.println("ZauberwuerfelFeld.updateGUI():");
				System.err.println("unbekannte SeitenNr.:"+seiteNr);
			}
			for(int feldNr=0; feldNr<9; feldNr++){
				Color farbe = m.getFarbe(modelFelder[seiteNr][feldNr]);
				int zeile = zeileStart + feldNr/3;
				int spalte = spalteStart + feldNr%3;
				updateFeld(zeile, spalte, farbe, seiteNr, feldNr);
			}

		}
	}
	
	private void setButtonsEnabled(boolean value){
		this.verdrehenButton.setEnabled(value);
		this.loesenButton.setEnabled(value);
	}
	
	private void einstellen(){
		wirdEingestellt = !wirdEingestellt;
		if(wirdEingestellt){
			this.setButtonsEnabled(false);
			this.einstellenButton.setText("fertig");
			for(ZButton[] zbZeile: farbFelder){
				for(ZButton zb: zbZeile){
					zb.setEnabled(true);
				}
			}
			JOptionPane.showMessageDialog(this, "Felder anklicken, um die Farbe zu aendern.\nDanach fertig klicken.");
		}
		else{
			this.einstellenButton.setText("einstellen");
			for(ZButton[] zbZeile: farbFelder){
				for(ZButton zb: zbZeile){
					zb.setEnabled(false);
				}
			}
			updateModelAusFarbFeldern();
			this.setButtonsEnabled(true);
		}
	}
	
	private void updateModelAusFarbFeldern() {
		ZModel m = this.zLogik.getModel();
		for(int seiteNr=0; seiteNr<6; seiteNr++){
			int zeileStart = -1;
			int spalteStart = -1;
			if(seiteNr<4){
				// das ist die mittlere Spalte!
				zeileStart = 3*seiteNr;
				spalteStart = 3;
			}
			else if(seiteNr == 4){
				// das ist links!
				zeileStart = 3;
				spalteStart = 0;
			}
			else if(seiteNr == 5){
				// das ist rechts!
				zeileStart = 3;
				spalteStart = 6;				
			}
			else{
				System.err.println("ZauberwuerfelFeld.updateGUI():");
				System.err.println("unbekannte SeitenNr.:"+seiteNr);
			}
			for(int feldNr=0; feldNr<9; feldNr++){
				int zeile = zeileStart + feldNr/3;
				int spalte = spalteStart + feldNr%3;
				Color farbe = this.getFarbe(zeile, spalte);
				m.getFelder()[seiteNr][feldNr] = m.getFarbNr(farbe);
			}
		}
		
	}

	private void verdrehen(){
		new Thread(){
			public void run() {
				setButtonsEnabled(false);
				zLogik.verdrehen();
				setButtonsEnabled(true);
			}
		}.start();
	}
	
	private void loesen(){
		new Thread(){
			public void run() {
				setButtonsEnabled(false);
				zLogik.loesen();
				setButtonsEnabled(true);
			}
		}.start();
	}
	
	private void updateFeld(int zeile, int spalte, Color farbe, int seiteNr, int feldNr) {
		this.farbFelder[zeile][spalte].setBackground(farbe);
		this.farbFelder[zeile][spalte].setText(seiteNr+"|"+feldNr);
	}
	
	private Color getFarbe(int zeile, int spalte){
		return this.farbFelder[zeile][spalte].getBackground();
	}
}
