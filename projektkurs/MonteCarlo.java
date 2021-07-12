package projektkurs;

import gui.GUI;

import java.util.Random;

public class MonteCarlo {
	private Random random;
	
	public MonteCarlo(){
		random = new Random();
	}
	
	public double zufallszahl(){
		return random.nextDouble();
	}
	
	public static void main(String[] args) {
		new GUI(new MonteCarlo());
	}
	
}
