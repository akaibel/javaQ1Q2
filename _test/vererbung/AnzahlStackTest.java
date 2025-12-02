package _test.vererbung;


import gui.GUI;
import linear.Stack;
import linear.StackWithViewer;
import sonstiges.Celebrity;
import sonstiges.Person;

public class AnzahlStackTest {
	private AnzahlStack<Person> personenStack;
	
	public AnzahlStackTest(){
		personenStack = new AnzahlStack<>();
		Celebrity c1 = new Celebrity("Lopez", "Jennifer",400);
		Celebrity c2 = new Celebrity("Neuer", "Manuel",40); 
		Celebrity c3 = new Celebrity("Rowling", "JK",1000); 
		personenStack.push(c1);
		personenStack.push(c2);
		personenStack.push(c3);
	}

	public void personHinzufuegen() {
		Person p = new Person("Musterfrau", "Erika");
		personenStack.push(p);
	}
	
	public void schuelerHinzufuegen() {
		//TODO im package sonstiges die Klasse Schueler implementieren
		//TODO die folgenden Zeile einkommentieren
		//Schueler s = new Schueler("Busch", "Max", "5C");
		//personenStack.push(s);
	}
	
	public void denVorderstenWegNehmen() {
		personenStack.pop();
	}
	
	public int gibAnzahl() {
		return personenStack.getAnzahl();
	}
	
	public void alleAusgeben() {
		AnzahlStack<Person> hilfs = new AnzahlStack<>();
		while(personenStack.isEmpty() == false) {
			Person p = personenStack.top();
			System.out.println(p.toString());
			hilfs.push(p);
			personenStack.pop();
		}
		personenStack = hilfs;
	}

	public static void main(String[] args) {
		AnzahlStackTest qt = new AnzahlStackTest();
		new GUI(qt, "WARTEZEIT_LINEAR");
	}
}
