package telnet;


import java.io.File;

import javax.swing.JOptionPane;

import file.FileReaderWriter;
import netz.Client;

public class Telnet extends TelnetGUI {
	private String ip = "127.0.0.1";
	private int port = 4000;
	private static final String TelnetConfigFileName = "telnet"+File.separator+"Telnet.config";
	
	private MyClient client;
	
	public Telnet(){
		init();
	}

	/**
	 * wird aufgerufen, wenn in TelnetGUI der senden-Button geklickt wird.
	 */
	public void neuerText(String pText) {
		this.textAnhaengen(">>> "+pText);
		try {
			this.client.send(pText);
		} catch (Exception e) {
			exceptionAusgeben(e);
		}
	}
	
	private void init() {
		String ipNeu = null;
		int portNeu = -1;
		try{
			String ipPort = (String)FileReaderWriter.readSerialized(TelnetConfigFileName);
			String[] splits = ipPort.split(" ");
			ip = splits[0];
			port = Integer.parseInt(splits[1]);
		}catch(Exception e){
			// do nothing
		}
		boolean success = false;
		while(!success){
			try{
				String serverIpPort = JOptionPane.showInputDialog(getFrame(), "Server-Adresse Server-Port", ip+" "+port);
				if(serverIpPort == null){
					System.exit(0);
				}
				String[] splits = serverIpPort.split(" ");
				ipNeu = splits[0];
				String portString = splits[1];
				portNeu = Integer.parseInt(portString);
				success = true;
			}catch(Exception e){
				success = false;
			}
		}
		ip = ipNeu;
		port = portNeu;
		FileReaderWriter.saveSerialized(ip+" "+port, TelnetConfigFileName);
		textLoeschen();
		textAnhaengen("verbinde mit: "+ipNeu+" "+portNeu);
		try {
			client = new MyClient(ip, port);
			this.setTitle(ip+" "+port);
		} catch (Exception e) {
			exceptionAusgeben(e);
			return;
		}
	}
	
	private void exceptionAusgeben(Exception e){
		textAnhaengen("< *** Exception ***");
		textAnhaengen("< "+e.getMessage());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		init();
	}
	
	private class MyClient extends Client{

		public MyClient(String pIPAdresse, int pPortNr) throws Exception {
			super(pIPAdresse, pPortNr);
		}

		@Override
		public void processMessage(String pMessage) {
			textAnhaengen("< "+pMessage);
			if(pMessage.equals("*** Exception ***")){
				init();
			}
		}
		
	}
	
	@Override
	public void reconnect() {
		textAnhaengen("*** reconnect ***");
		init();
	}

	public static void main(String[] args) {
		Telnet sgt = new Telnet();
	}






}
