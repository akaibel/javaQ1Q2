package sonstiges;
import linear.ListWithViewer;
import linear.QueueWithViewer;
import linear.StackWithViewer;

public class Autos {

	private static String[] marken       = { "VW"   , "Mercedes" , "Audi"  , "Tesla", "BWM"     , "Peugeot", "Nissan", "VW"   , "Toyota", "Porsche" };
	private static String[] farben       = { "blau" , "silbern"  , "gruen" , "grau" , "schwarz" , "gelb"   , "rot"   , "weiss", "rot"   , "schwarz" }; 
	private static int[] pss             = { 102    ,   130      ,   100   ,   320  ,   125     ,  75      ,   55    ,  141   ,  158    ,    370    };
	private static int[] preise          = { 6250   ,   87000    ,  54500  ,  80000 , 62000     , 34600    , 23800   , 52000  , 47000   ,   97000   };
	private static double[] tankGroessen = { 70.5   , 55.0       ,  45.6   ,   0    , 55.0      , 42.5     , 35.9    , 67.6   , 45.4    ,    65.0   };
	
	public static Auto[] autoArray(){
		Auto[] ergebnis = new Auto[marken.length];
		for (int i = 0; i < ergebnis.length; i++) {
			Auto aktuell = new Auto(marken[i], farben[i], pss[i], preise[i], tankGroessen[i]);
			ergebnis[i] = aktuell;
		}
		return ergebnis;
	}


	public static ListWithViewer<Auto> autoList() {
		Auto[] autos =  autoArray();
		ListWithViewer<Auto> dieListe = new ListWithViewer<Auto>();
		for (int i = 0; i < autos.length; i++) {
			dieListe.append(autos[i]);
		}
		return dieListe;
	}


	public static QueueWithViewer<Auto> autoQueue() {
		Auto[] autos =  autoArray();
		QueueWithViewer<Auto> derQueue = new QueueWithViewer<>();
		for (int i = 0; i < autos.length; i++) {
			derQueue.enqueue(autos[i]);
		}
		return derQueue;
	}

	public static StackWithViewer<Auto> autoStack() {
		Auto[] autos =  autoArray();
		StackWithViewer<Auto> derStack = new StackWithViewer<>();
		for (int i = 0; i < autos.length; i++) {
			derStack.push(autos[i]);
		}
		return derStack;
	}

}

