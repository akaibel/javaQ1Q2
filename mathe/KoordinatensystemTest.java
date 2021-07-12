package mathe;

import gui.GUI;

public class KoordinatensystemTest {
	private Koordinatensystem koordinatensystem;
	
	public KoordinatensystemTest(){
		koordinatensystem = new Koordinatensystem(-5, 5, -2, 2);
		koordinatensystem.aendereGitterAbstand(0.5, 0.2);
		koordinatensystem.setzeGroesseinPixeln(1000,600);
	}
	
	private void zeichneFunktion() {
		for(double x = -5; x <= 5; x+=0.01){
			koordinatensystem.zeichnePunkt(x, f(x));
		}
		
	}

	public double f(double x){
		return Math.sin(x);
	}
	
	public static void main(String[] args) {
		new GUI(new KoordinatensystemTest());
	}
	
}
