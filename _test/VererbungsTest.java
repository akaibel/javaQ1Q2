package _test;
import gui.GUI;
import linear.List;
import linear.ListWithViewer;
import sonstiges.Celebrities;
import sonstiges.Celebrity;
import sonstiges.Person;

public class VererbungsTest {
	private List<Person> personenListe;
	
	public VererbungsTest(){
		personenListe = new ListWithViewer<Person>();
		List<Celebrity> cl = Celebrities.celebritiesList();
		for(cl.toFirst(); cl.hasAccess(); cl.next()){
			Celebrity c = cl.getContent();
			personenListe.append(c);
		}
	}
	
	public void schuelerHinzufuegen(String pName, String pVorname){
		//TODO die naechsten zwei Zeilen einkommentieren!!
		//TODO im Package sonstiges eine Klasse Schueler implementieren
		//TODO so dass das fehlerfrei funktioniert!
		//Schueler s = new Schueler(pName, pVorname, "5A");
		//personenListe.append(s);
	}
	
	public void ausgeben(){
		for(personenListe.toFirst();personenListe.hasAccess(); personenListe.next()){
			Person p = personenListe.getContent();
			System.out.println(p.toString());
		}
	}
	
	public static void main(String[] args) {
		VererbungsTest vt = new VererbungsTest();
		new GUI(vt);
	}
	
}
