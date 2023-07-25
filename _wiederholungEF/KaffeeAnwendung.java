package _wiederholungEF;

public class KaffeeAnwendung {

	public static void main(String[] args) {
		Kaffeekueche kueche = new Kaffeekueche();

		Kaffeetrinker[] kaffeetrinker = new Kaffeetrinker[2];
		kaffeetrinker[0] = new Kaffeetrinker("Lisa", kueche);
		kaffeetrinker[1] = new Kaffeetrinker("Anton", kueche);

		kueche.setzeKaffeetrinker(kaffeetrinker);
	}

}
