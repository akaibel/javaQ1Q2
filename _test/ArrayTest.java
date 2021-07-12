package _test;

import gui.GUI;
import array.ArrayViewer;
import sonstiges.Celebrities;
import sonstiges.Celebrity;


public class ArrayTest {
	public Celebrity[] celebrities;
	
	public ArrayTest(){
		celebrities = Celebrities.celebritiesArray();
	}
	
	public void bubblesort() {
		System.out.println("bubblesort");
		ArrayViewer.zeigeArray(celebrities, 0, "unsortiert");
		//TODO
		ArrayViewer.zeigeArray(celebrities, 1, "sortiert");
		
		return;
	}

	public Celebrity[] sortiereDurchEinfuegen() {
		System.out.println("sortiereDurchEinfuegen");
		ArrayViewer.zeigeArray(celebrities, 0, "unsortiert");
		Celebrity[] ergebnis = new Celebrity[celebrities.length];
		//TODO
		ArrayViewer.zeigeArray(ergebnis, 1, "sortiert");
		return ergebnis;
	}

	public Celebrity[] sortiereDurchAuswaehlen() {
		System.out.println("sortiereDurchEinfuegen");
		ArrayViewer.zeigeArray(celebrities, 0, "unsortiert");
		Celebrity[] ergebnis = new Celebrity[celebrities.length];
		//TODO
		ArrayViewer.zeigeArray(ergebnis, 1, "sortiert");
		return ergebnis;
	}

	
	public static void main(String[] args) {
		ArrayTest at = new ArrayTest();
		new GUI(at);
	}

}
