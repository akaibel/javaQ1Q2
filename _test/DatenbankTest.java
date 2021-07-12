package _test;
import linear.ListWithViewer;
import datenbank.DatabaseConnector;
import datenbank.QueryResult;
import gui.GUI;


public class DatenbankTest {
	private DatabaseConnector connector;
	
	public DatenbankTest() {
		//                                    ip                       port database  user   password
		connector = new DatabaseConnector("sibi-rh01.schule.sibi.tsc", 3306, "demo", "demo", "sibiif12");
		String errorMessage = connector.getErrorMessage();
		if(errorMessage != null) System.err.println(errorMessage);
	}
	

	public ListWithViewer<String> zehnFilmeMit(String pDarsteller){
		ListWithViewer<String> ergebnis = new ListWithViewer<String>();
		String sqlStatement = 
		  " SELECT h.name AS hauptdarstellername, f.name AS filmname, f.oscars AS oscars "+
	      " FROM film f, film_has_hauptdarsteller fh, hauptdarsteller h "+
          " WHERE f.id = fh.film_id "+
	      " AND h.id = fh.hauptdarsteller_id "+
		  " AND h.name LIKE '%"+pDarsteller+"%' "+
	      " LIMIT 10 ";
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
			String hauptdarsteller = data[i][0];
			String filmName = data[i][1];
			String oscarsString = data[i][2];
			int oscars = Integer.parseInt(oscarsString);
			String zeile = hauptdarsteller+": "+filmName+" ("+oscars+" Oscars)";
			System.out.println(zeile);
			ergebnis.append(zeile);
		}
		return ergebnis;
	}
	
	public static void main(String[] args) {
		new GUI(new DatenbankTest());
	}
}
