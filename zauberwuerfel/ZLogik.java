package zauberwuerfel;

import java.awt.Color;

import javax.swing.JOptionPane;

import gui.GUI;

/**
 * in diese Klasse wird die ganze LOGIK zum loesen des Zauberwuerfels gepackt!
 * @author akaibel
 *
 */
public class ZLogik {
	private ZModel model;

	public ZLogik() {
		model = new ZModel(this);
	}
	
	public ZModel getModel(){
		return model;
	}
	
	public void setWartezeit(int wartezeit){
		model.setWartezeit(wartezeit);
	}

	public void verdrehen(){
		System.out.println("*** verdrehen()");
		int echteWartezeit = model.getWartezeit();
		setWartezeit(1);
		for(int i=0; i<100; i++){
			int zufallszahl = (int)(Math.random() * 9);
			switch (zufallszahl){
			case 0: model.drehenXLinks(1); continue;
			case 1: model.drehenXMitte(1); continue;
			case 2: model.drehenXRechts(1); continue;
			case 3: model.drehenYOben(1); continue;
			case 4: model.drehenYMitte(1); continue;
			case 5: model.drehenYUnten(1); continue;
			case 6: model.drehenZHinten(1); continue;
			case 7: model.drehenZMitte(1); continue;
			case 8: model.drehenZVorne(1); continue;
			}
		}
		model.setWartezeit(echteWartezeit);
	}


	public void loesen(){
		System.out.println("*** loesen()");
		roteMitteNachOben();
		roteKantenNachOben();
		//TODO
	}

	private void roteKantenNachOben() {
		System.out.println("*** roteKantenNachOben()");
		//TODO
	}

	private void roteMitteNachOben() {
		System.out.println("*** roteMitteNachOben()");
		//TODO
	}

	public static void main(String[] args) {
		ZLogik zl = new ZLogik();
		zl.setWartezeit(10);
		GUI gui = new GUI(zl);
		gui.setLocation(800, 100);
//		zl.verdrehen();
//		zl.loesen();
	}
}
