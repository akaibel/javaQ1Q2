package netz;

import gui.GUI;

public class MailClientTest {
	private String user = "anna";
	private String passwort = "geheim";
	private String server = "localhost";
	private int portPop3 = 110;
	private int portSMTP = 25;
	private String mailadresse = "anna@kolleg.de";
	
	public String getMail(int nr) {
		String zumServer, antwort, mailtext;
		System.out.println("Connection("+server+","+portPop3);

		Connection co = new Connection(server,portPop3);
		antwort = co.receive();
		System.out.println(antwort);
		if(!antwort.startsWith("+OK")) {
			co.close();
			return "Verbindung fehlgeschlagen";
		}

		zumServer = "USER "+user;
		System.out.println(zumServer);
		co.send(zumServer);
		antwort = co.receive();
		System.out.println(antwort);
		if(!antwort.startsWith("+OK")) {
			co.close();
			return "Verbindung fehlgeschlagen";
		}
		
		//TODO
		mailtext = "TODO";
		return mailtext;
	}
	
	
	
	
	public static void main(String[] args) {
		MailClientTest mst = new MailClientTest();
		new GUI(mst);
	}
}
