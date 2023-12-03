package _test.vererbung;


import javax.swing.JOptionPane;

import gui.GUI;
import linear.List;
import linear.ListWithViewer;
import sonstiges.Celebrity;

public class UniqueListTest {
	private UniqueList<Celebrity> uniqueCelebritiesList;
	private Celebrity c1;
	private Celebrity c2;
	private Celebrity c3;
	
	public UniqueListTest(){
		uniqueCelebritiesList = new UniqueList<>();
		c1 = new Celebrity("Lopez", "Jennifer",400);
		c2 = new Celebrity("Neuer", "Manuel",40); 
		c3 = new Celebrity("Rowling", "JK",1000); 
		uniqueCelebritiesList.append(c1);
		uniqueCelebritiesList.append(c2);
		uniqueCelebritiesList.append(c3);
		
		// Rowling sollte NICHT nochmal hinzugefuegt werden!
		uniqueCelebritiesList.append(c3);
		// Neuer sollte NICHT nochmal hinzugefuegt werden!
		uniqueCelebritiesList.toFirst();
		uniqueCelebritiesList.next();
		uniqueCelebritiesList.insert(c2);
		JOptionPane.showMessageDialog(null, "Jeder sollte nur einmal dabei sein!");
	}

	public void michHinzufuegen() {
		Celebrity ich = new Celebrity("ich", "selber",600);
		uniqueCelebritiesList.append(ich);
	}
	
	public void concatTest() {
		List<Celebrity> liste = new ListWithViewer<>();
		liste.append(c1);
		Celebrity cDuck = new Celebrity("Dagobert","Duck", 20000);
		liste.append(cDuck);
		liste.append(c2);
		JOptionPane.showMessageDialog(null, "Von der Liste sollte nur Duck hinzugefuegt werden!");		
		uniqueCelebritiesList.concat(liste);
	}
	

	public static void main(String[] args) {
		UniqueListTest qt = new UniqueListTest();
		new GUI(qt);
	}
}
