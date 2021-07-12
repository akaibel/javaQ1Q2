package _test.netz.gossip;
import javax.swing.JOptionPane;

import linear.ListWithViewer;

import netz.Connection;

public class GossipClient {
	private Connection verbindung;
	
	public GossipClient(String pIp, int pPort){
		// verbindung mit pIp und pPort initialisieren
		//TODO
		
		nachrichtenAbrufen();
		// verbindung schliessen
		//TODO
	}
	
	public void nachrichtenAbrufen(){
		String vonZeit = JOptionPane.showInputDialog("Start-Zeit: ", "2013-003-21 10:00:30");
		String bisZeit = JOptionPane.showInputDialog("End-Zeit: ", "2013-003-21 11:00:30");
		//TODO gemaess Protokoll an den Server schicken
		
		//TODO Antwort auslesen und an ergebnis anhängen packen
		ListWithViewer ergebnis = new ListWithViewer();
		
	}
	
	public static void main(String[] args) {
		new GossipClient("127.0.0.1", 5555);
	}
}
