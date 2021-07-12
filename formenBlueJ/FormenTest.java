package formenBlueJ;

import gui.GUI;

public class FormenTest {

	public FormenTest() {
	}
	
	class BewegungsThread extends Thread{
		private Kreis kreis;
		private int distanz;

		public BewegungsThread(Kreis k, int distanz){
			this.kreis = k;
			this.distanz = distanz;
		}
		
		public void run(){
			kreis.langsamHorizontalBewegen(distanz);
		}
	}
	
	public void bewegungstest(){
		Kreis k1 = new Kreis();
		k1.bewegeZuPosition(10, 10);
		k1.sichtbarMachen();
		Kreis k2 = new Kreis();
		k2.bewegeZuPosition(400, 400);
		k2.sichtbarMachen();
		new BewegungsThread(k1,390).start();
		new BewegungsThread(k2,-390).start();
	}
	
	public void formenTest(){
		Kreis k1 = new Kreis();
		k1.bewegeZuPosition(0, 0);
		for(int i=20; i<300; i = i+10){
			Quadrat q = new Quadrat();
			q.bewegeZuPosition(400-i, 2*i);
			q.groesseAendern(i);
			q.sichtbarMachen();
		}
		for(int i=20; i<300; i = i+10){
			Kreis k = new Kreis();
			k.bewegeZuPosition(i, 2*i);
			k.groesseAendern(i);
			k.sichtbarMachen();
		}
		for(int i=100; i<300; i = i+10){
			Linie l = new Linie();
			l.bewegeZuPosition(i, 10, i, 50+i);
			l.sichtbarMachen();
		}
	}


	public static void main(String[] args) {
		new GUI(new FormenTest());
	}
}
