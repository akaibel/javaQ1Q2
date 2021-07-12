package _test.krypto;

public class Vigenere {
	private static char[][] vigenereQuadrat;

	public static void vigenereQuadratErstellen(){
		if(vigenereQuadrat == null){
			vigenereQuadrat = new char['z'+1]['z'+1];
			int zahl = 0;
			for (char i = 'a'; i <= 'z'; i++) {
				for(char j='a'; j <= 'z'; j++){
					vigenereQuadrat[i][j] = j;
					vigenereQuadrat[i][j] += zahl;
					if(vigenereQuadrat[i][j] > 'z'){
						vigenereQuadrat[i][j] -= 26;
					}
				}
				zahl++;
			}
		}
	}

	public static void quadratDrucken(){
		System.out.println("*** Das Vigenere-Quadrat ***");
		if(vigenereQuadrat == null){
			vigenereQuadratErstellen();
		}
		for (char i = 'a'; i <= 'z'; i++) {
			for(char j='a'; j <= 'z'; j++){
				System.out.print(vigenereQuadrat[i][j]);
			}
			System.out.println();
		}
	}

	public static String entschluesseln(String pText,
			String pSchluessel) {
		vigenereQuadratErstellen();
		// alles auf Kleinbuchstaben bringen!
		pText = pText.toLowerCase();
		String ergebnis = "";
		int laengeSchluessel = pSchluessel.length();
		for(int i=0; i<pText.length(); i++){
			char verschluesseltBuchstabe = pText.charAt(i);
			int indexSchluessel = i%laengeSchluessel;
			int schluesselBuchstabe = pSchluessel.charAt(indexSchluessel);
			// den richtigen Buchstaben suchen!
			char[] zeile = vigenereQuadrat[schluesselBuchstabe];
			char textBuchstabe = 'a';
			while(zeile[textBuchstabe] != verschluesseltBuchstabe){
				textBuchstabe++;
			}
			ergebnis += textBuchstabe;
		}
		return ergebnis;
	}

	private static String verschluesseln(String pText, String pSchluessel) {
		vigenereQuadratErstellen();
		// Leerzeichen rausnehmen!
		pText = pText.replaceAll(" ", "");
		// alles auf Kleinbuchstaben bringen!
		pText = pText.toLowerCase();
		System.out.println("Nachricht ohne Leerzeichen und alles klein: "+pText);
		String ergebnis = "";
		int laengeSchluessel = pSchluessel.length();
		for(int i=0; i<pText.length(); i++){
			char textBuchstabe = pText.charAt(i);
			int indexSchluessel = i%laengeSchluessel;
			char schluesselBuchstabe = pSchluessel.charAt(indexSchluessel);
			char verschluesseltBuchstabe = vigenereQuadrat[textBuchstabe][schluesselBuchstabe];
			ergebnis += verschluesseltBuchstabe;
		}
		return ergebnis;
	}
	
	public char[][] gibVigenereQuadrat(){
		if(vigenereQuadrat == null){
			vigenereQuadratErstellen();
		}
		return vigenereQuadrat;
	}
	
	
	public static void main(String[] args) {
		//quadratDrucken();
		String schluessel = "test";
		System.out.println("Schluessel: "+schluessel);
		String nachricht = "Hallo zusammen wie gehts";
		System.out.println("Nachricht: "+nachricht);
		String verschluesselt = verschluesseln(nachricht, schluessel);
		System.out.println("verschluesselt: "+verschluesselt);
		String entschluesselt = entschluesseln(verschluesselt, schluessel);
		System.out.println("entschluesselt: "+entschluesselt);
	}

}
