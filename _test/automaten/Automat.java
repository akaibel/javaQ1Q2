package _test.automaten;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.stream.Collectors;

public class Automat {
    private HashMap<String, HashMap<String, String>> data;
    private ArrayList<String> zustaendeArrayListe;
    private String startzustand;
    private ArrayList<String> endzustaende;
    private String trennzeichen = ",";

    public Automat() {
        data = new HashMap<>();
        zustaendeArrayListe = new ArrayList<>();
        endzustaende = new ArrayList<>();
    }
    
    public Automat(String trennzeichen) {
    	this();
    	this.trennzeichen= trennzeichen;
    }
    
    public void startzustandSetzen(String zustand) {
    	startzustand = zustand;
    	if(!zustaendeArrayListe.contains(startzustand)) zustaendeArrayListe.add(startzustand);
    	data.computeIfAbsent(startzustand, k -> new HashMap<>());
    }
    
    public String startzustand() {
    	return startzustand;
    }
    
    public void endzustaendeSetzen(String[] zustaende) {
    	endzustaende = new ArrayList<>();
    	for(String z:zustaende) {
    		endzustaende.add(z);
    	}
    }
    
    public void endzustandHinzufuegen(String endzustand) {
    	endzustaende.add(endzustand);
    }
    
    public String[] endzustaende() {
    	return endzustaende.toArray(new String[endzustaende.size()]);
    }

    public void uebergangHinzufuegen(String zustand, String zeichen, String neuerZustand) {
    	zustand = alphabetischOrdnenUndTrennzeichenSaeubern(zustand);
    	neuerZustand = alphabetischOrdnenUndTrennzeichenSaeubern(neuerZustand);
    	if(!zustaendeArrayListe.contains(zustand)) zustaendeArrayListe.add(zustand);
        data.computeIfAbsent(zustand, k -> new HashMap<>()).put(zeichen, neuerZustand);
    }

    /**
     * gibt die moeglichen Folgezustaende zurueck.
     * die Folgezustaende sind durch Komma getrennt.
     * wenn es keinen Folgezustand gibt, dann wird ein leerer String zurueckgegeben.
     * @param zustand
     * @param zeichen
     * @return
     */
    public String folgeZustaende(String zustand, String zeichen) {
        HashMap<String, String> innerMap = data.get(zustand);
        if (innerMap != null && innerMap.get(zeichen) != null) {
            return innerMap.get(zeichen);
        }
        else {
        	return "";
        }
    }
    
    public String[] aufteilen(String zustaende) {
    	return zustaende.split(trennzeichen);
    }
    
    /**
     * ordnet die Zustaende im String zustaende alphabetisch.
     * zustaende kann z.B. enthalten: q0,q1,,q0,
     * Das Ergebnis ist dann: q0,q1
     * entfernt Trennzeichen am Ende
     * und ersetzt mehrfache Trennzeichen in der Mitte durch einfache
     * @param zustaende
     * @return
     */
    public String alphabetischOrdnenUndTrennzeichenSaeubern(String zustaende) {
    	while(zustaende.contains(trennzeichen+trennzeichen)) {
    		zustaende = zustaende.replace(trennzeichen+trennzeichen, trennzeichen);
    	}
    	if(zustaende.endsWith(trennzeichen)) 
    		zustaende = zustaende.substring(0, zustaende.length()-1);
    	zustaende = this.getUniqueSortedValues(zustaende);
    	return zustaende;
    }

    public void zustandHinzufuegen(String zustand) {
    	zustand = alphabetischOrdnenUndTrennzeichenSaeubern(zustand);
        if (!data.containsKey(zustand)) {
            data.put(zustand, new HashMap<>());
            zustaendeArrayListe.add(zustand);
        }
    }
    
    public boolean zustandVorhanden(String zustand) {
    	return data.containsKey(alphabetischOrdnenUndTrennzeichenSaeubern(zustand));
    }

    public void print() {
    	printArray("Alphabet",alphabet());
    	System.out.println("Startzustand: "+startzustand);
    	printArray("Endzustaende",endzustaende());
        int maxZustandLength = 0;
        int maxValueLength = 0;
        int maxZeichenLength = 0;
        int zeichenCount = getUniqueZeichenValues().size();

        for (String zustand : zustaendeArrayListe) {
            maxZustandLength = Math.max(maxZustandLength, zustand.length());
            for (String zeichen : getUniqueZeichenValues()) {
                String value = data.get(zustand).get(zeichen);
                if (value != null) {
                    maxZeichenLength = Math.max(maxZeichenLength, zeichen.toString().length());
                    maxValueLength = Math.max(maxValueLength, value.length());
                }
            }
        }
        
        if(maxZeichenLength > maxValueLength) maxValueLength = maxZeichenLength;

        //System.out.println(maxZustandLength+"; "+maxZeichenLength+"; "+ zeichenCount);
        
        // Calculate the length of dividing lines
        int dividingLineLength = (maxZustandLength + 1) + (maxValueLength + 3) * zeichenCount ;
        //System.out.println(dividingLineLength);
        
        String dividingLine = "";
        for (int i = 0; i < dividingLineLength; i++) {
            dividingLine += "-";
        }

        System.out.println();
        System.out.println("Uebergangstabelle:");
        System.out.println();
        // Print the header row with zeichen values
        System.out.print(String.format("%-" + (maxZustandLength + 1) + "s", " "));
        for (String zeichen : getUniqueZeichenValues()) {
            System.out.print("| " + String.format("%-" + (maxValueLength) + "s", zeichen) + " ");
        }
        System.out.println();


        // Print data rows
        for (String zustand : zustaendeArrayListe) {
        	System.out.println(dividingLine);
            System.out.print(String.format("%-" + (maxZustandLength + 1) + "s", zustand + " "));
            HashMap<String, String> innerMap = data.get(zustand);
            for (String zeichen : getUniqueZeichenValues()) {
                String value = innerMap.get(zeichen);
                if (value == null) {
                    value = ""; // Fill with empty string for missing values
                }
                System.out.print("| " + String.format("%-" + (maxValueLength) + "s", value) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printArray(String was, String[] array) {
    	String ausgabe = was+" = { ";
    	ausgabe += String.join(trennzeichen + " ", array);
    	ausgabe += " }";
    	System.out.println(ausgabe);
    }
    
    // Helper method to get unique zeichen values
    private Set<String> getUniqueZeichenValues() {
        Set<String> uniqueZeichenValues = new TreeSet<>();
        for (HashMap<String, String> innerMap : data.values()) {
            uniqueZeichenValues.addAll(innerMap.keySet());
        }
        return uniqueZeichenValues;
    }

    
	public String[] alphabet() {
		String[] alphabet = new String[getUniqueZeichenValues().size()];
		int i=0;
		for(String s: getUniqueZeichenValues()) {
			alphabet[i] = s;
			i++;
		}
		return alphabet;
	}
	
	/**
	 * sortiert die durch trennzeichen getrennten, eventuell mehrfach vorkommenden Werte in input alphabetisch
	 * und entfernt doppelte
	 * 
	 * @param input
	 * @return
	 */
	private String getUniqueSortedValues(String input) {
	    if (input == null || input.isEmpty()) {
	        return "";
	    }

	    // Split the input string into an array of values
	    String[] values = input.split(trennzeichen);

	    // Convert the array to a list to take advantage of Java streams
	    List<String> valueList = Arrays.asList(values);

	    // Convert the list to a set to eliminate duplicates
	    HashSet<String> uniqueValues = new HashSet<>(valueList);

	    // Sort the unique values alphabetically
	    List<String> sortedUniqueValues = uniqueValues.stream()
	            .sorted()
	            .collect(Collectors.toList());

	    // Join the sorted unique values into a single string with commas
	    return String.join(",", sortedUniqueValues);
	}

	public boolean endzustandEnthalten(String zustaendeGetrenntMitTrennzeichen) {
		String[] zustaendeArray = zustaendeGetrenntMitTrennzeichen.split(trennzeichen);
		for(String z:zustaendeArray) {
			for(String e:endzustaende) {
				if(e.equals(z)) return true;
			}
		}
		return false;
	}

}
