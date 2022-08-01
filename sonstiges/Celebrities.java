/**
 * https://www.celebritynetworth.com
 * Stand: 2021
 */

package sonstiges;
import linear.ListWithViewer;
import linear.QueueWithViewer;
import linear.StackWithViewer;

public class Celebrities {
	
	
	private static String[] vornamen  = { "George" , "Steven"    , "Kanye" , "Oprah"   , "Rihanna"  , "Jay" , "JK"     , "Heidi"  , "Sebastian" , "Jennifer" , "Neuer"  , "Cristiano", "Keanu"  }; 
	private static String[] namen     = { "Lucas"  , "Spielberg" , "West"  , "Winfrey" , "Rihanna"  ,  "Z"  , "Rowling", "Klum"   , "Vettel"    , "Lopez", "Manuel", "Ronaldo"       , "Reeves" };
	private static int[]    vermoegen = { 10000    , 8000        , 6600    , 3500      , 1700       , 1300  , 1000     ,  160     , 140         , 400      , 40       , 500          , 380      };

	public static Celebrity[] celebritiesArray(){
		Celebrity[] ergebnis = new Celebrity[namen.length];
		for (int i = 0; i < ergebnis.length; i++) {
			Celebrity aktuell = new Celebrity(namen[i], vornamen[i], vermoegen[i]);
			ergebnis[i] = aktuell;
		}
		nachNamenSortieren(ergebnis);
		return ergebnis;
	}
	
	private static void nachNamenSortieren(Celebrity[] pList) {
		for(int i=0; i<pList.length-1; i++) {
			for(int j=0; j<pList.length-1;j++) {
				if(pList[j].getName().compareTo(pList[j+1].getName())>0) {
					Celebrity c = pList[j];
					pList[j] = pList[j+1];
					pList[j+1] = c;
				}
			}
		}
	}
	
	
	public static ListWithViewer<Celebrity> celebritiesList() {
		Celebrity[] celebrities =  celebritiesArray();
		ListWithViewer<Celebrity> dieListe = new ListWithViewer<Celebrity>();
		for (int i = 0; i < celebrities.length; i++) {
			dieListe.append(celebrities[i]);
		}
		return dieListe;
	}


	public static QueueWithViewer<Celebrity> celebritiesQueue() {
		Celebrity[] celebrities =  celebritiesArray();
		QueueWithViewer<Celebrity> derQueue = new QueueWithViewer<Celebrity>();
		for (int i = 0; i < celebrities.length; i++) {
			derQueue.enqueue(celebrities[i]);
		}
		return derQueue;
	}

	public static StackWithViewer<Celebrity> celebritiesStack() {
		Celebrity[] celebrities =  celebritiesArray();
		StackWithViewer<Celebrity> derStack = new StackWithViewer<Celebrity>();
		for (int i = 0; i < celebrities.length; i++) {
			derStack.push(celebrities[i]);
		}
		return derStack;
	}
	
}