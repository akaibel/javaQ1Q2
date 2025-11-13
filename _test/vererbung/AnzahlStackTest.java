package _test.vererbung;


import gui.GUI;
import linear.Stack;
import linear.StackWithViewer;
import sonstiges.Celebrity;
import sonstiges.Person;

public class AnzahlStackTest {
	private AnzahlStack<Person> celebritiesStack;
	
	public AnzahlStackTest(){
		celebritiesStack = new AnzahlStack<>();
		Celebrity c1 = new Celebrity("Lopez", "Jennifer",400);
		Celebrity c2 = new Celebrity("Neuer", "Manuel",40); 
		Celebrity c3 = new Celebrity("Rowling", "JK",1000); 
		celebritiesStack.push(c1);
		celebritiesStack.push(c2);
		celebritiesStack.push(c3);
	}

	public void personHinzufuegen() {
		Person p = new Person("Musterfrau", "Erika");
		celebritiesStack.push(p);
	}
	
	public void schuelerHinzufuegen() {
		//TODO im package sonstiges die Klasse Schueler implementieren
		//TODO die folgenden Zeile einkommentieren
		//Schueler s = new Schueler("Busch", "Max", "5C");
		//celebritiesStack.push(s);
	}
	
	public void denVorderstenWegNehmen() {
		celebritiesStack.pop();
	}
	
	public int gibAnzahl() {
		return celebritiesStack.getAnzahl();
	}

	public static void main(String[] args) {
		AnzahlStackTest qt = new AnzahlStackTest();
		new GUI(qt, "WARTEZEIT_LINEAR");
	}
}
