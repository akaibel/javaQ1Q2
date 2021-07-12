package _test.netz.elternsprechtag;

public class Lehrkraft extends Gespraechsteilnehmer {

	private String kuerzel;
	private int maxTerminNr;

	public Lehrkraft(String pName, String pKuerzel, int pMaxTerminNr) {
		super(pName, pMaxTerminNr);
		this.kuerzel = pKuerzel;
		this.maxTerminNr = pMaxTerminNr;
	}

	public String gibKuerzel() {
		return kuerzel;
	}
	
	public int gibMaxTerminNr(){
		return maxTerminNr;
	}
	
	public boolean istTerminFrei(int pTerminNr){
		if(pTerminNr > maxTerminNr){
			return false;
		}
		return super.istTerminFrei(pTerminNr);
	}
	
	
	public String toString(){
		return "L:: ("+this.gibKuerzel()+") "+super.toString();
	}
}
