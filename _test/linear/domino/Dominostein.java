package _test.linear.domino;

import java.util.Random;

import baeume.ComparableContent;

public class Dominostein implements Comparable<Dominostein>{
	private int zahl1;
	private int zahl2;
	private double zufallszahl;
	private static Random random;
	
	public Dominostein(int pZahl1, int pZahl2){
		zahl1 = pZahl1;
		zahl2 = pZahl2;
		if(random == null) random = new Random();
		zufallszahl = random.nextDouble();
	}
	
	public int gibZahl1(){
		return zahl1;
	}
	
	public int gibZahl2(){
		return zahl2;
	}
	
	public void umdrehen(){
		int hilfs = zahl1;
		zahl1 = zahl2;
		zahl2 = hilfs;
	}
	
	public double getZufallszahl() {
		return zufallszahl;
	}

	public String toString(){
		return zahl1+"-"+zahl2;
	}

	@Override
	public int compareTo(Dominostein d) {
		// TODO Auto-generated method stub
		if(this.zufallszahl > d.getZufallszahl()){
			return 1;
		}
		if(this.zufallszahl == d.getZufallszahl()){
			return 0;
		}
		return -1;
	}

}
