package _test.netz.gossip;

import gui.GUI;
import netz.Server;

public class GossipServer extends Server {

	private static int port = 5555;
	
	public GossipServer() {
		super(port);
	}
	
    public void processNewConnection(String pClientIP, int pClientPort)
    {
    	//TODO
    }
    
    public void processClosingConnection(String pClientIP, int pClientPort)
    {
    	//TODO
    }
    
    public void processMessage(String pClientIP, int pClientPort, String pMessage)
    {
    	//TODO
    }

    private void nachrichtHinzufuegen(String pClientIP, int pClientPort, String pMessage){
    	//TODO
    }
    
    private void sendeNachrichten(String pClientIP, int pClientPort, String pDatumVon, String pDatumBis){
    	//TODO
    }
    
    private void abonnentHinzufuegen(String pClientIP, int pClientPort){
    	//TODO
    }
    
    private void abonnentEntfernen(String pClientIP, int pClientPort){
    	//TODO
    }
    
    private void nachrichtAnAbonnentenWeiterleiten(String pMessage){
    	//TODO
    }
	
    public static void main(String[] args) {
		new GUI(new GossipServer());
	}
}
