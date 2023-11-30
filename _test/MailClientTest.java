package _test;

import gui.GUI;
import netz.Connection;

public class MailClientTest {
	private String user = "anna";
	private String passwort = "geheim";
	private String server = "localhost";
	private int portPop3 = 110;
	
	public String getMail(int nr) {
		System.out.println("Connection("+server+","+portPop3);
		Connection co = new Connection(server,portPop3);
		String antwort1 = co.receive();
		System.out.println(antwort1);
		if(!antwort1.startsWith("+OK")) {
			co.close();
			return "Verbindung fehlgeschlagen";
		}
		//TODO
		return antwort1;
	}
	
	
	public static void main(String[] args) {
		MailClientTest mst = new MailClientTest();
		new GUI(mst);
	}
}
