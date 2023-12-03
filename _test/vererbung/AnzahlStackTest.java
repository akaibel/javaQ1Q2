package _test.vererbung;


import gui.GUI;
import linear.Stack;
import linear.Stack;
import linear.StackWithViewer;
import sonstiges.Auto;
import sonstiges.Autos;
import sonstiges.Celebrities;
import sonstiges.Celebrity;

public class AnzahlStackTest {
	private AnzahlStack<Celebrity> celebritiesStack;
	
	public AnzahlStackTest(){
		celebritiesStack = new AnzahlStack<>();
		Celebrity c1 = new Celebrity("Lopez", "Jennifer",400);
		Celebrity c2 = new Celebrity("Neuer", "Manuel",40); 
		Celebrity c3 = new Celebrity("Rowling", "JK",1000); 
		celebritiesStack.push(c1);
		celebritiesStack.push(c2);
		celebritiesStack.push(c3);
	}

	public void michHinzufuegen() {
		Celebrity ich = new Celebrity("ich", "selber",600);
		celebritiesStack.push(ich);
	}
	
	public void denVorderstenWegNehmen() {
		celebritiesStack.pop();
	}
	
	public int gibAnzahl() {
		//TODO
		return celebritiesStack.getAnzahl();
	}

	public static void main(String[] args) {
		AnzahlStackTest qt = new AnzahlStackTest();
		new GUI(qt);
	}
}
