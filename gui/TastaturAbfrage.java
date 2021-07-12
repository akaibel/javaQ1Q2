package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;



public class TastaturAbfrage extends KeyAdapter {
	private HashMap<Integer, Boolean> keyCodes;
	private HashMap<Character, Boolean> keyCharacters;
	
	public TastaturAbfrage(){
		keyCodes = new HashMap<Integer, Boolean>(); 
		keyCharacters = new HashMap<Character, Boolean>();
	}

	public void keyPressed(KeyEvent evt) {
		int keyCode = evt.getKeyCode();
		this.keyCodes.put(keyCode, true);
		char keyCharacter = evt.getKeyChar();
		this.keyCharacters.put(keyCharacter, true);
		System.out.println("keyPressed: "+keyCode);
	}
	
	public void keyReleased(KeyEvent evt) {
		int keyCode = evt.getKeyCode();
		this.keyCodes.put(keyCode, false);
		char keyCharacter = evt.getKeyChar();
		this.keyCharacters.put(keyCharacter, false);
		//System.out.println("keyReleased: "+keyCode);
	}
	
	private boolean istGedrueckt(int keyCode){
		if(this.keyCodes.containsKey(keyCode) == false){
			return false;
		}
		return this.keyCodes.get(keyCode);
	}
	
	public boolean istGedrueckt(char keyCharacter){
		if(this.keyCharacters.containsKey(keyCharacter) == false){
			return false;
		}
		return this.keyCharacters.get(keyCharacter);
	}
	
	public boolean enter(){
		return this.istGedrueckt(10);
	}
	
	public boolean leertaste(){
		return this.istGedrueckt(32);
	}	
	
	public boolean esc(){
		return this.istGedrueckt(27);
	}
	
	public boolean links(){
		return this.istGedrueckt(37);
	}

	public boolean oben(){
		return this.istGedrueckt(38);
	}

	public boolean rechts(){
		return this.istGedrueckt(39);
	}

	public boolean unten(){
		return this.istGedrueckt(40);
	}

	
}
