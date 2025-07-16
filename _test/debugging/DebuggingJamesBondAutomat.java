package _test.debugging;

import javax.swing.*;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

public class DebuggingJamesBondAutomat extends JFrame {
	/**
	 * testWoerter bei Bedarf ergaenzen oder austauschen!
	 */
    private String[] testWoerter = {"8", "007", "07", "", "0700700", "3007"};

    /**
     * die folgende Methode funktioniert nicht richtig!
     * Finde mithilfe von Debugging die Fehler und korrigiere sie.
     * @param pWort
     * @return
     */
    private boolean enthaelt007(String pWort) {
	    int zustand = 0;
	    for(int i=0; i<pWort.length(); i++){
	        char zeichen = pWort.charAt(i);
	        if(zustand == '0'){
	            if(zeichen == 0) zustand = 1;
	            else zustand = 0;
	        }
	        if(zustand == 1){
	            if(zeichen == 0) zustand = 2;
	            else zustand = 0;
	        }
	        if(zustand == 2){
	            if(zeichen == '0') zustand = 2;
	            if(zeichen == '7') zustand = 3;
	            else zustand = 0;
	        }
	        zustand = 3;
	    }
	    //zurueckgeben, ob der Zustand 3 erreicht wurde.
	    // die folgende Zeile ist fehlerfrei!
	    return (zustand == 3);
    }

    private JList<String> wortListe;
    private JLabel ergebnisLabel;

    public DebuggingJamesBondAutomat() {
        setTitle("Test auf 007");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Schriftgröße 14
        Font font = new Font("SansSerif", Font.PLAIN, 14);

        // JList vorbereiten
        wortListe = new JList<>(testWoerter);
        wortListe.setFont(font);
        wortListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        wortListe.setVisibleRowCount(testWoerter.length);

        JScrollPane scrollPane = new JScrollPane(wortListe, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        scrollPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, wortListe.getPreferredSize().height));

        // Ergebnis-Label
        ergebnisLabel = new JLabel("Hier steht dann das Ergebnis.");
        ergebnisLabel.setFont(font);
        ergebnisLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Listener
        wortListe.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String ausgewaehlt = wortListe.getSelectedValue();
                boolean enthaelt = enthaelt007(ausgewaehlt);
                ergebnisLabel.setText("\"" + ausgewaehlt + "\" enthält 007? " + enthaelt);
            }
        });

        // Panel für volle Breite
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel hinweisLabel = new JLabel("Klicke ein Testwort an:");
        hinweisLabel.setFont(font);
        hinweisLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(hinweisLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        contentPanel.add(scrollPane);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        contentPanel.add(ergebnisLabel);

        setContentPane(contentPanel);
        pack();

        // Fensterbreite an Ergebnislabel anpassen
        int labelWidth = ergebnisLabel.getPreferredSize().width + 100;
        int currentWidth = getWidth();
        int finalWidth = Math.max(currentWidth, labelWidth);
        setSize(finalWidth, getHeight());

        setLocationRelativeTo(null); // zentrieren
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DebuggingJamesBondAutomat());
    }
}
