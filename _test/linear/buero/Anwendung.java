package _test.linear.buero;


public class Anwendung {

	// main-Methode
	// erzeugt ein Buero
	public static void main(String[] args){
		Buero b1 = new Buero();

		// die Chefs erzeugen
		Chef[] dieChefs = new Chef[2];
		dieChefs[0] = new Chef("Sabine", b1);
		dieChefs[1] = new Chef("Otto", b1);
		
		
		// die Sachbearbeiter erzeugen
		Sachbearbeiter[] dieSachbearbeiter = new Sachbearbeiter[3];
		dieSachbearbeiter[0] = new Sachbearbeiter("Georg", b1);
		dieSachbearbeiter[1] = new Sachbearbeiter("Luise", b1);
		dieSachbearbeiter[2] = new Sachbearbeiter("Christoph", b1);

	}

}
