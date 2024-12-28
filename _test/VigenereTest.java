package _test;

import gui.GUI;

public class VigenereTest {
	
    private char[][] vigenereQuadrat;

    public VigenereTest() {
        vigenereQuadrat = new char[26][26]; // 26x26 Matrix für das Vigenère-Quadrat
        quadratErstellen();
    }

    // Methode zum Erstellen des Vigenère-Quadrats
    private void quadratErstellen() {
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                vigenereQuadrat[i][j] = (char) ('A' + (i + j) % 26); // Zyklisches Alphabet
            }
        }
    }

    // Methode, um das Vigenère-Quadrat zu drucken
    public void printQuadrat() {
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                System.out.print(vigenereQuadrat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Zugriffsmethode für ein bestimmtes Zeichen im Quadrat
    public char gibBuchstaben(int zeile, int spalte) {
        if (zeile < 0 || zeile >= 26 || spalte < 0 || spalte >= 26) {
            throw new IllegalArgumentException("Reihe und Spalte müssen zwischen 0 und 25 liegen.");
        }
        return vigenereQuadrat[zeile][spalte];
    }
    
    public String verschluesseln(String wort, String passwort) {
    	//TODO
    	return "TODO";
    }

    public String entschluesseln(String verschluesseltesWort, String passwort) {
    	//TODO
    	return "TODO";
    }

    public static void main(String[] args) {
        VigenereTest vt = new VigenereTest();
        new GUI(vt);
    }
}
