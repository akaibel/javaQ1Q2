package _test.netz.elternsprechtag;

public abstract class Gespraechsteilnehmer {
	private String name;
	private Gespraechsteilnehmer[] termine; 
	
	public Gespraechsteilnehmer(String pName, int pMaxTerminNr) {
		this.name = pName;
		termine = new Gespraechsteilnehmer[pMaxTerminNr+1];
	}
	
	public String gibName(){
		return name;
	}
	
	public boolean istTerminFrei(int pTerminNr){
		if(pTerminNr < 0 || pTerminNr >=termine.length){
			return false;
		}
		return (termine[pTerminNr] == null);
	}
	
	public Gespraechsteilnehmer gibGespraechspartner(int pTerminNr){
		if(istTerminFrei(pTerminNr)){
			return null;
		}
		return termine[pTerminNr];
	}
	
	public void trageTerminEin(Gespraechsteilnehmer pTeilnehmer, int pTerminNr){
		termine[pTerminNr] = pTeilnehmer;
	}
	
	public void loescheTermin(int pTerminNr){
		termine[pTerminNr] = null;
	}
	
	public String toString(){
		String ergebnis = name+": ";
		for(Gespraechsteilnehmer g:termine){
			if(g != null){
				ergebnis+= "+";
			}
			else{
				ergebnis += "-";
			}
		}
		return ergebnis;
	}
}
