package _test.baeume.bernoulli;

public class Bruch {
	private int zaehler;
	private int nenner;
	
	public Bruch(int pZaehler, int pNenner){
		zaehler = pZaehler;
		nenner = pNenner;
	}

	public int getZaehler() {
		return zaehler;
	}

	public int getNenner() {
		return nenner;
	}

	public Bruch multipliziereMit(int pZahl){
		int z = zaehler * pZahl;
		return new Bruch(z, nenner);
	}
	
	public Bruch multipliziereMit(Bruch pBruch){
		int z = zaehler * pBruch.zaehler;
		int n = nenner * pBruch.nenner;
		return new Bruch(z, n);
	}
	
	public Bruch addierenMit(Bruch pBruch){
		int z = zaehler*pBruch.nenner + pBruch.zaehler*nenner;
		int n = nenner * pBruch.nenner;
		Bruch ergebnis = new Bruch(z,n);
		return kuerzen(ergebnis);
	}
	
	private Bruch kuerzen(Bruch pBruch) {
		int n = pBruch.nenner;
		int z = pBruch.zaehler;
		for(int i=2; i<pBruch.zaehler; i++){
			if(n%i == 0 && z%i == 0){
				n /= i;
				z /= i;
			}
		}
		return new Bruch(z,n);
	}

	public String toString(){
		return ""+zaehler+"/"+nenner;
	}
}
