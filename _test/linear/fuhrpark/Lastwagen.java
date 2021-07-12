package _test.linear.fuhrpark;

public class Lastwagen {
	private String kennzeichen;
	private double beladung;
	private double maxBeladung;

	public Lastwagen(String pKennzeichen, double pMaxBeladung){
		this.kennzeichen = pKennzeichen;
		this.beladung = 0;
		this.maxBeladung = pMaxBeladung;
	}

	public String getKennzeichen() {
		return kennzeichen;
	}

	public double getBeladung() {
		return beladung;
	}

	public double getMaxBeladung(){
		return maxBeladung;
	}

	public boolean zuladen(double pGewicht){
		if(beladung + pGewicht > maxBeladung){
				return false;
		}
		beladung += pGewicht;
		return true;
	}

	public void abladen(){
		beladung = 0;
	}

	public boolean hatMehrGeladenAls(Lastwagen pLastwagen) {
		return (this.getBeladung() > pLastwagen.getBeladung());
	}
	
	public String toString(){
		return "("+kennzeichen+": "+beladung+"/"+maxBeladung+")";
	}
}