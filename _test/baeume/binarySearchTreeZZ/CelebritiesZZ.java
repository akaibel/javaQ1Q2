package _test.baeume.binarySearchTreeZZ;
import linear.ListWithViewer;
import linear.QueueWithViewer;
import linear.StackWithViewer;

public class CelebritiesZZ {
	private static String[] namen     = { "Winfrey" , "Gaga"  , "Spielberg" , "Knowles"  , "Madonna" , "Swift"   , "Bon Jovi"   , "Federer"   , "Bieber"   , "DeGeneres" };
	private static String[] vornamen  = { "Oprah"   , "Lady"  , "Steven"    , "Beyonce"  , ""        , "Taylor"  , "Jon"        , "Roger"     , "Justin"   , "Ellen"     }; 
	private static int[]    einkommen = { 77        , 80      , 100         , 53         , 125       , 55        , 79           , 71          , 58         , 56          };

	public static CelebrityZZ[] celebritiesArray(){
		CelebrityZZ[] ergebnis = new CelebrityZZ[namen.length];
		for (int i = 0; i < ergebnis.length; i++) {
			CelebrityZZ aktuell = new CelebrityZZ(namen[i], vornamen[i], einkommen[i]);
			ergebnis[i] = aktuell;
		}
		return ergebnis;
	}
	
	
	public static ListWithViewer<CelebrityZZ> celebritiesList() {
		CelebrityZZ[] celebrities =  celebritiesArray();
		ListWithViewer<CelebrityZZ> dieListe = new ListWithViewer<CelebrityZZ>();
		for (int i = 0; i < celebrities.length; i++) {
			dieListe.append(celebrities[i]);
		}
		return dieListe;
	}


	public static QueueWithViewer<CelebrityZZ> celebritiesQueue() {
		CelebrityZZ[] celebrities =  celebritiesArray();
		QueueWithViewer<CelebrityZZ> derQueue = new QueueWithViewer<CelebrityZZ>();
		for (int i = 0; i < celebrities.length; i++) {
			derQueue.enqueue(celebrities[i]);
		}
		return derQueue;
	}

	public static StackWithViewer<CelebrityZZ> celebritiesStack() {
		CelebrityZZ[] celebrities =  celebritiesArray();
		StackWithViewer<CelebrityZZ> derStack = new StackWithViewer<CelebrityZZ>();
		for (int i = 0; i < celebrities.length; i++) {
			derStack.push(celebrities[i]);
		}
		return derStack;
	}
	
}