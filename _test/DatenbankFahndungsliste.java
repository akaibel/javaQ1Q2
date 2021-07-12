package _test;
import linear.ListWithViewer;
import linear.List;
import sonstiges.Person;
import datenbank.DatabaseConnector;
import datenbank.QueryResult;
import gui.GUI;


public class DatenbankFahndungsliste {
	private DatabaseConnector connector;
	// die Fahndungsliste - hier abgekuerzt durch fL
	private List<Person> fL;


	public DatenbankFahndungsliste() {
		// die Fahndungsliste erzeugen
		fL = new ListWithViewer<>();
		// 2x in DB
		fL.append(new Person("Kallert", null));
		// nicht in DB
		fL.append(new Person("Amann", null));
		// 4x in DB
		fL.append(new Person("Budig", null));
		// 5x in DB
		fL.append(new Person("Armknecht", null));
		//                                    ip                       port database  user   password
		connector = new DatabaseConnector("sibi-rh01.schule.sibi.tsc", 3306, "demo", "demo", "sibiif12");
		String errorMessage = connector.getErrorMessage();
		if(errorMessage != null) System.err.println(errorMessage);
	}


	public ListWithViewer<Person> inDBEnthalten(List<Person> pList){
		ListWithViewer<Person> ergebnis = new ListWithViewer<Person>();
		// TODO
		return ergebnis;
	}

	public static void main(String[] args) {
		new GUI(new DatenbankFahndungsliste());
	}
}
