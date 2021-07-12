package gui;

import javax.swing.JOptionPane;

public class SimpleGUITest extends SimpleGUI {

	/**
	 * wird aufgerufen, wenn in SimpleGUI der senden-Button geklickt wird.
	 */
	public void neuerText(String pText) {
		System.out.println(pText);
		this.textAnhaengen(pText);
	}
	
	
	public static void main(String[] args) {
		
		SimpleGUITest sgt = new SimpleGUITest();
		
		String serverIpPort = JOptionPane.showInputDialog(sgt.getFrame(), "ServerIP::ServerPort", "127.0.0.1::5555");
		String[] splits = serverIpPort.split("::");
		String serverIP = splits[0];
		String portString = splits[1];
		int serverPort = Integer.parseInt(portString);
		sgt.textAnhaengen("verbinde mit: "+serverIP+"::"+serverPort);
	}



}
