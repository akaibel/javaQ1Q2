package _test.krypto;

public class Caesar {

	public static String verschluesseln(String pText, int pCode){
		pText = pText.toLowerCase();
		String ergebnis = "";
		for(int i=0; i<pText.length(); i++){
			char buchstabe = pText.charAt(i);
			buchstabe += pCode;
			if(buchstabe > 'z'){
				buchstabe -= 26;
			}
			ergebnis += buchstabe;
		}
		return ergebnis;
	}
	
	public static String entschluesseln(String pText, int pCode){
		// statt pCode Buchstaben nach rechts zu gehen...
		// ... kann man auch (26-pCode) Buchstaben nach links gehen!
		String ergebnis = verschluesseln(pText, 26 - pCode);
		return ergebnis;
	}
	
	public static void main(String[] args) {
		int schluessel = 13;
		String nachricht = "hallo";
		System.out.println("nachricht: "+nachricht);
		String verschluesselt = verschluesseln(nachricht, schluessel);
		System.out.println("verschluesselt: "+verschluesselt);
		String entschluesselt = entschluesseln(verschluesselt, schluessel);
		System.out.println("entschluesselt: "+entschluesselt);
	}
}
