package gui;

import javax.swing.JFrame;

public class TastaturAbfrageTest {
	private TastaturAbfrage tastatur;
	
	
	public TastaturAbfrageTest(){
		JFrame frame = new JFrame();
		frame.setSize(200, 300);
		frame.setVisible(true);
		tastatur = new TastaturAbfrage();
		frame.addKeyListener(tastatur);
		new TastaturAbfrageThread().start();
	}
	
	public void leertasteGedrueckt() {
		System.out.println("**** leertaste gedrueckt! ****");
	}
	
	private class TastaturAbfrageThread extends Thread{
		
		public void run(){
			while(true){
				if(tastatur.leertaste()){
					leertasteGedrueckt();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new TastaturAbfrageTest();
	}
	
}
