package _test.linear.buero;



public class Buero {

	private Chef[] dieChefs;
	private Sachbearbeiter[] dieSachbearbeiter;

	public Buero() {
	}
	
	public void setzeChefs(Chef[] pChefs) {
		dieChefs = pChefs;
	}
	
	public void setzeSachbearbeiter(Sachbearbeiter[] pSachbearbeiter) {
		dieSachbearbeiter = pSachbearbeiter;		
	}
}
