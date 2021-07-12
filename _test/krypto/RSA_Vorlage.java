package _test.krypto;
import java.math.BigInteger;
    
/**
 * Die Klasse RSA_fertig passt zum Anhang E 
 * des Buches "Simon Singh: Codes" (S. 282-283) 
 * @author akaibel
 */
public class RSA_Vorlage{
   private static final BigInteger eins      = BigInteger.ONE;
   private static final BigInteger zwei = new BigInteger("2");

   /**
    * erzeugt eine zufaellige Zahl mit stellenzahl Stellen und 
    * sucht von da ausgehend die naechstgroesste Primzahl.
    * fuer den Primzahltest wird isProbablePrime(certainty) verwendet. 
    * @param stellenzahl
    * @param certainty
    * @return
    */
   public static BigInteger findePrimzahl(int stellenzahl, int certainty) {
		// TODO implementieren!
	   BigInteger ergebnis = new BigInteger("-1");
		return ergebnis;
	}

   /**
    * verschluessele eine Nachricht mit RSA_vorlage
    * @param M die Nachricht
    * @param N der oeffentliche Schluessel
    * @param e die zusaetzliche Zahl e mit e und (p-1)x(q-1) teilerfremd
    * @return
    */
   public static BigInteger verschluessele(BigInteger M, BigInteger N,
			int e) {
	    // TODO
		BigInteger C = new BigInteger("-9999");
		return C;
   }
   
   /**
    * entschluessele eine Nachricht mit RSA_vorlage
    * @param C verschluesselte nachricht
    * @param p privater schluessel
    * @param q privater schluessel
    * @param e teil des oeffentlichen schluessels
    * @return
    */
   public static BigInteger entschluessele(BigInteger C, BigInteger p,
			BigInteger q, int e) {
	    //TODO
	    BigInteger Mentschluesselt = new BigInteger("-11111");
	   	return Mentschluesselt;
	}
   
   public static void testEinfach(){
	   // die Nachricht
	   BigInteger M = new BigInteger("88");
	   System.out.println("*** Originalnachricht: "+M);
	   System.out.println("M: "+M);
	   
	   // der private Schluessel 
	   BigInteger p = new BigInteger("17");
	   System.out.println("p: "+p);
	   // die andere Primzahl, so dass pxq = N
	   BigInteger q = new BigInteger("11");
	   System.out.println("q: "+q);

	   // der oeffentliche Schluessel (=pxq)
	   BigInteger N = p.multiply(q);
	   System.out.println("N: "+N);
	   
	   
	   // eine Zahl, so dass e und (p-1)x(q-1) teilerfremd sind
	   // ein ueblicher Wert ist 65537.
	   int e = 7;
	   System.out.println("e: "+e);

	   
	   BigInteger verschluesselteNachricht = verschluessele(M, N, e);
	   System.out.println("*** Die verschluesselte Nachricht ist: "+verschluesselteNachricht);
	   
	   BigInteger entschluesselteNachricht = entschluessele(verschluesselteNachricht, p, q, e);
	   System.out.println("*** Die entschluesselte Nachricht ist: "+entschluesselteNachricht);
	   
   }
   
   public static void testMitGrossenPrimzahlen(){
	   // eine Primzahl finden
	   BigInteger p = findePrimzahl(100, 10);
	   System.out.println("*** p: ");
	   System.out.println(p);
	   BigInteger q = findePrimzahl(100, 10);
	   System.out.println("*** q: ");
	   System.out.println(q);
	   BigInteger N = p.multiply(q);
	   System.out.println("*** N: ");
	   System.out.println(N);
	   BigInteger M = new BigInteger("1234567890123456789012345678901234567890");
	   System.out.println("*** M: ");
	   System.out.println(M);
	   int e = 65537;
	   System.out.println("*** e:");
	   System.out.println(e);
	   BigInteger C = verschluessele(M, N, e);
	   System.out.println("*** C: ");
	   System.out.println(C);
	   BigInteger Mentschluesselt = entschluessele(C, p, q, e);
	   System.out.println("*** Mentschluesselt:");
	   System.out.println(Mentschluesselt);
   }
   
   

   public static void main(String[] args) {
	   testEinfach();
	   //testMitGrossenPrimzahlen();
   }




}