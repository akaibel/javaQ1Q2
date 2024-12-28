package _test.netz.chat;

import gui.GUI;

//TODO muss von Server erben!
//TODO abstrakte Methoden von Server ueberschreiben!
public class ChatServer {
	
	private int port = 4242;
	
	public ChatServer() {
		//TODO
	}
	
	public static void main(String[] args) {
		new GUI(new ChatServer());
	}
}
