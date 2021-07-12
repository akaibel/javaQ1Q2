package _test.linear.buero;



public class Buero {

	private Chef[] dieChefs;
	private Sachbearbeiter[] dieSachbearbeiter;

	public Buero() {
		// die Chefs erzeugen
		dieChefs = new Chef[2];
		dieChefs[0] = new Chef("Sabine", this);
		dieChefs[1] = new Chef("Otto", this);
		
		
		// die Sachbearbeiter erzeugen
		dieSachbearbeiter = new Sachbearbeiter[3];
		dieSachbearbeiter[0] = new Sachbearbeiter("Georg", this);
		dieSachbearbeiter[1] = new Sachbearbeiter("Luise", this);
		dieSachbearbeiter[2] = new Sachbearbeiter("Christoph", this);
	}
}
