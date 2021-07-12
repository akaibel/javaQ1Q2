package _test.automaten.bergungGefahrgut;

import gui.GUI;

public class Fahrzeugsteuerung extends Akzeptor {
	private char[] alphabet = {'g','r','l','h','z','a','v','w'};
	
	
	@Override
	public void zustandsuebergang(char pEingabe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean imAlphabet(char pEingabe) {
		for(char buchstabe: alphabet){
			if(pEingabe == buchstabe){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean imEndzustand() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean teste(String pEingabeString){
		//TODO
		return false;
	}
	
	
	
	public static void main(String[] args) {
		new GUI(new Fahrzeugsteuerung());
	}

}
