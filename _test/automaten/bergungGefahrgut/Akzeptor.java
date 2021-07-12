package _test.automaten.bergungGefahrgut;

public abstract class Akzeptor {

	private int zustand;
	
	public Akzeptor(){
		
	}
	
	public void setzeAnfangszustand(){
		zustand = 0;
	}
	
	public int gibZustand(){
		return zustand;
	}
	
	public void setzeZustand(int pZustand){
		zustand = pZustand;
	}
	
	public abstract void zustandsuebergang(char pEingabe);
	public abstract boolean imAlphabet(char pEingabe);
	public abstract boolean imEndzustand();
	
}
