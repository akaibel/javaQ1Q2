package _test.netz.mail;

import gui.GUI;
import netz.Connection;

public class MailClientTest {
	private String user = "anna";
	private String passwort = "geheim";
	private String server = "localhost";
	private int portPop3 = 110;
	private int portSMTP = 25;
	private String mailadresse = "anna@kolleg.de";
	
	public void printMail(int nr) {
		String zumServer, antwort;
		System.out.println("Connection("+server+","+portPop3);

		Connection co = new Connection(server,portPop3);
		antwort = co.receive();
		System.out.println(antwort);
		if(!antwort.startsWith("+OK")) {
			co.close();
			System.err.println("Verbindung fehlgeschlagen");
		}

		zumServer = "USER "+user;
		System.out.println(zumServer);
		co.send(zumServer);
		antwort = co.receive();
		System.out.println(antwort);
		if(!antwort.startsWith("+OK")) {
			co.close();
			System.err.println("Verbindung fehlgeschlagen");
		}
		//TODO das Protokoll weiter abarbeiten
		
	}
	
	/**
	 * schreibt eine Mail gemaess SMTP-Protokoll
	 */
	public void writeMail(String pEmpfaenger, String pBetreff, String pText ) {
		String empfaenger = "anna@kolleg.de";
		String betreff = "Wie geht es dir?";
		String textzeile_1 = "Hallo Anna, ";
		String textzeile_2 = "Ich wollte mal hoeren, wie es dir geht?!";
		String textzeile_3 = "LG Bob";
		//TODO nach SMTP-Protokoll abarbeiten
	}
	
	
	
	
	public static void main(String[] args) {
		MailClientTest mst = new MailClientTest();
		new GUI(mst);
	}
}
