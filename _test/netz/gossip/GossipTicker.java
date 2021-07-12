package _test.netz.gossip;

import netz.Client;

public class GossipTicker extends Client{

	
	public GossipTicker(String pClientIP, int pClientPort){
		super(pClientIP, pClientPort);
	}

	
	public void processMessage(String pMessage) {
		//TODO
		
	}
	
	public static void main(String[] args) {
		GossipTicker gt = new GossipTicker("127.0.0.1", 5555);
	}
}
