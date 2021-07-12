package _test.automaten.hervorheber;

import gui.GUI;

/**
 * Siehe Abi 2015 LK HT 3 (Automaten)
 * Aufgabe c)
 * Es geht um den Hervorheber für Kommentare der 
 * Programmiersprache 'Bali' 
 * @author KB
 *
 */
public class Hervorheber {
	public Hervorheber(){
		//do nothing
	}
	
	public void bearbeiteZeichenfolge(String pZeichenfolge){
		//TODO
	}
	
	/**
	 * hervorgehoben wird, indem vor jedes
	 * Zeichen ein Dach gestellt wird, z.B. ^z
	 * @param pZeichen
	 */
	private void ausgebenHervorgehoben(char pZeichen){
		if(pZeichen == '#'){
			System.out.println();
		}
		else{
			System.out.print('^');
			System.out.print(pZeichen);
		}
	}
	
	private void ausgebenNormal(char pZeichen){
		if(pZeichen == '#'){
			System.out.println();
		}
		else{
			System.out.print(pZeichen);
		}
	}
	
	public static void main(String[] args) {
		new GUI(new Hervorheber());
	}
}
