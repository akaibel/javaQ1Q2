package _test;
import linear.ListWithViewer;
import linear.List;
import sonstiges.Person;
import datenbank.sqlite.DatabaseConnector;
import datenbank.sqlite.QueryResult;
//import datenbank.mysql.DatabaseConnector;
//import datenbank.mysql.QueryResult;
import gui.GUI;

/**
 * DatenbankTest
 * Damit diese Klasse sinnvoll gestartet werden kann, 
 * muss man erst eine MariaDB (oder MySQL-DB) gestartet haben.
 * Auf der muss es eine Datenbank demo geben, die die Beispieldatenbank schule enthaelt.
 * Weitere Infos dazu im Package datenbank.schuleBeispieldatenbank
 * Ausserdem muss der mysql-driver in der Bibliothek enthalten sein.
 * Weitere Infos dazu im package __readme in notwendige_libraries.odt
 * @author akaib
 *
 */
public class DatenbankTest {
	private DatabaseConnector connector;
	
	public DatenbankTest() {
		// ******* sqlite database *******
		//                                ip  port database                                  user  password
		connector = new DatabaseConnector("", -1, "datenbank/beispieldatenbank/schule.sqlite", "", "");

		// ******* mysql Database *******
		// WICHTIG: Dafuer auch die import-statements anpassen!
		//                                    ip       port database  user   password
		//connector = new DatabaseConnector("127.0.0.1", 3306, "schule", "root", "");
		
		String errorMessage = connector.getErrorMessage();
		if(errorMessage != null) System.err.println(errorMessage);
	}
	

	/**
	 * Beispielmethode
	 * gibt eine Liste zurueck, in der fuer jede Klasse angegeben ist,
	 * wie viel Unterricht die Klasse in dem Fach hat.
	 * @param pFach das Fach. Z.B. "Deutsch"
	 * @return
	 */
	public ListWithViewer<String> klassenUnterricht(String pFach){
		ListWithViewer<String> ergebnis = new ListWithViewer<String>();
		String sqlStatement = 
		  " SELECT k.name AS klasse, SUM(u.stunden) AS stunden "+
	      " FROM klasse k LEFT JOIN unterricht u "+
		  " ON k.id = u.klasse_id " +
          " AND u.fach = '"+pFach+"'"+
	      " GROUP BY k.name ";
		System.out.println(sqlStatement);

		connector.executeStatement(sqlStatement);

		String errorMessage = connector.getErrorMessage();
		if(errorMessage != null)
		{
			System.err.println(errorMessage);
			return null;
		}
		
		QueryResult queryResult = connector.getCurrentQueryResult();

		String[][] data = queryResult.getData();
		for (int i = 0; i < data.length; i++) {
			String klasse = data[i][0];
			String stundenString = data[i][1];
			int stunden = -1;
			if(stundenString == null || stundenString.toLowerCase().equals("null")) {
				stunden = 0;
			}
			else {
				stunden = Integer.parseInt(stundenString);
			}
			String zeile = klasse+": "+stunden+" "+pFach;
			System.out.println(zeile);
			ergebnis.append(zeile);
		}
		return ergebnis;
	}
	
	public static void main(String[] args) {
		new GUI(new DatenbankTest());
	}
}
