package _test.linear.fuhrpark;

public class Fahrt {
	private String fahrer;
	private Lastwagen lastwagen;
	private int km;
	
	public Fahrt(String fahrer, Lastwagen lastwagen, int km) {
		super();
		this.fahrer = fahrer;
		this.lastwagen = lastwagen;
		this.km = km;
	}

	public String getFahrer() {
		return fahrer;
	}

	public Lastwagen getLastwagen() {
		return lastwagen;
	}

	public int getKm() {
		return km;
	}

	@Override
	public String toString() {
		return "("+fahrer + ", "+lastwagen.getKennzeichen() + ": "+ km+")";
	}
	
	
	
	
	

}
