package _test.vererbung;

import gui.GUI;

public class QuadratTest {
	Quadrat q1;
	
	public QuadratTest() {
		q1 = new Quadrat(3);
	}
	
	public void aendereBreite(int pLaenge) {
		q1.aendereBreite(pLaenge);
	}
	
	public void aendereSeite(int pLaenge) {
		q1.aendereSeite(pLaenge);
	}
	
	public int gibFlaeche() {
		return q1.gibFlaeche();
	}

	public void zeichne() {
		q1.zeichne();
	}
	
	public static void main(String[] args) {
		new GUI(new QuadratTest());
	}
}
