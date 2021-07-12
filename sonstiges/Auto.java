package sonstiges;

public class Auto {
	private String marke;
	private String farbe;
	private int ps;
	private int preis;
	private double tankStand;
	private double tankGroesse;
	private boolean klimaAn;
	
	public Auto(String marke, String farbe, int ps, int preis, double tankGroesse) {
		super();
		this.marke = marke;
		this.farbe = farbe;
		this.ps = ps;
		this.preis = preis;
		this.tankGroesse = tankGroesse;
		this.tankStand = 0.0;
		this.klimaAn = false;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}
	
	public String getMarke() {
		return marke;
	}

	public int getPs() {
		return ps;
	}

	public double getTankGroesse() {
		return tankGroesse;
	}

	public int getPreis() {
		return preis;
	}

	public void setPreis(int preis) {
		this.preis = preis;
	}

	public double getTankStand() {
		return tankStand;
	}

	public void tanken(double pMenge) {
		if(tankStand + pMenge < tankGroesse){
			tankStand += pMenge;
		}
	}
	
	public void fahren(){
		if(tankStand >= 1.0){
			tankStand--;
		}
		else{
			System.out.println("Tank leer.");
		}
	}

	public boolean isKlimaAn() {
		return klimaAn;
	}

	public void machKlimaAn() {
		this.klimaAn = true;
	}
	
	public void machKlimaAus(){
		this.klimaAn = false;
	}

	@Override
	public String toString() {
		String an;
		if(klimaAn == false){
			an = "aus";
		}
		else{
			an = "an";
		}
		return marke + ", " + ps + " PS," + preis + " Euro, " + tankStand + " von " + tankGroesse + " Liter, Klima " + an;
	}
	
	
	
	
	
}
