package _test.automaten.hervorheber;

import gui.GUI;
import linear.Stack;
import linear.StackWithViewer;

public class Rechnung {
	private char[] ziffern = {'0','1','2'};
	
	private boolean istZiffer(char pZeichen){
		for(char z:ziffern){
			if(pZeichen == z){
				return true;
			}
		}
		return false;
	}
	
	public Rechnung(){
		//do nothing
	}
	
	public boolean parse(String pWort){
	       // ein € anhaengen
	       // erleichtert die Ueberpruefung des Endes!
	       pWort += '€';
	       Stack<Character> keller = new StackWithViewer<Character>();
	       keller.push('#');
	       int zustand = 0;
	       for(char zeichen:pWort.toCharArray()){
	           char kellerzeichen = keller.top();
	           switch(zustand){
	               case 0:
	                   if(zeichen=='a' && kellerzeichen == '#'){
	                       zustand = 0;
	                       keller.push('A');
	                   }
	                   else if(zeichen=='a' && kellerzeichen == 'A'){
	                       zustand = 0;
	                       keller.push('A');
	                   }
	                   else if(zeichen =='b' && kellerzeichen == 'A'){
	                       zustand = 1;
	                       keller.pop();
	                   }
	                   else{
	                       return false;
	                   }
	                   continue;                   
	                   // end case 0
	               case 1:
	                   if(zeichen=='b' && kellerzeichen == 'A'){
	                       zustand = 1;
	                       keller.pop();
	                   }
	                   else if(zeichen=='€' && kellerzeichen == '#'){
	                       zustand = 2;
	                   }
	                   else{
	                       return false;
	                   }
	                   continue;
	                   // end case 1
	           }    // end switch(zustand)
	       }    // end for
	    
	       // Das Wort ist abgearbeitet!
	       // Ueberpruefen, ob Endzustand erreicht
	       return (zustand == 2);
	   }	
	public static void main(String[] args) {
		new GUI(new Rechnung());
	}
}
