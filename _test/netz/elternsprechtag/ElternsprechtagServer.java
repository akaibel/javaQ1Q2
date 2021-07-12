package _test.netz.elternsprechtag;

import gui.GUI;
import linear.List;
import linear.ListWithViewer;
import netz.Server;

public class ElternsprechtagServer extends Server {
	private static final int SERVER_PORT = 12345;

	private List<Elternteil> alleElternteile;
	private List<Lehrkraft> alleLehrkraefte;
	private List<Verbindungsdaten> alleVerbindungsdaten;

	private int h = 14;
	private int m = 40;
	private int d = 10;

	public static final int MAX_TERMINNUMMER = 10;

	public ElternsprechtagServer(int pPort) {
		super(pPort);
		alleLehrkraefte = new ListWithViewer<>();
		alleElternteile = new ListWithViewer<>();
		alleVerbindungsdaten = new ListWithViewer<>();

		Lehrkraft lMueller = new Lehrkraft("Mueller","MD",6);
		Lehrkraft lMeier = new Lehrkraft("Meier","MR",6);
		Lehrkraft lSkroer = new Lehrkraft("Skroer","SR",4);
		Elternteil eKipp = new Elternteil("Kipp", "Kip", "p");
		Elternteil eMertens = new Elternteil("Mertens", "Merten", "s");
		Elternteil eFrieso = new Elternteil("Frieso", "Fries", "o");
		Elternteil eKrause = new Elternteil("Krause", "Kraus", "e");
		Elternteil eStrehl = new Elternteil("Strehl", "Streh", "l");
		Elternteil eFehlhaber = new Elternteil("Fehlhaber", "Fehlhabe", "r");
		Elternteil eKaradag = new Elternteil("Karadag", "Karada", "g");
		Elternteil eWindhuis = new Elternteil("Windhuis", "Windhui", "s");
		Elternteil eSprenger = new Elternteil("Sprenger", "Sprenge", "r");
		Elternteil eLoos= new Elternteil("Loos", "Loo", "s");
		Elternteil eHoti = new Elternteil("Hoti", "Hot", "i");

		lMueller.trageTerminEin(eKipp, 0);
		lMueller.trageTerminEin(eMertens, 2);
		lMueller.trageTerminEin(eFrieso, 4);
		lMueller.trageTerminEin(eKrause, 6);

		eKipp.trageTerminEin(lMueller, 0);
		eMertens.trageTerminEin(lMueller, 2);
		eFrieso.trageTerminEin(lMueller, 4);
		eKrause.trageTerminEin(lMueller, 6);

		lMeier.trageTerminEin(eStrehl, 0);
		lMeier.trageTerminEin(eFehlhaber, 2);
		lMeier.trageTerminEin(eKaradag, 4);
		lMeier.trageTerminEin(eWindhuis, 5);

		eStrehl.trageTerminEin(lMeier, 0);
		eFehlhaber.trageTerminEin(lMeier, 2);
		eKaradag.trageTerminEin(lMeier, 4);
		eWindhuis.trageTerminEin(lMeier, 5);

		lSkroer.trageTerminEin(eKipp, 1);
		lSkroer.trageTerminEin(eSprenger, 2);
		lSkroer.trageTerminEin(eLoos, 3);
		lSkroer.trageTerminEin(eHoti, 4);

		eKipp.trageTerminEin(lSkroer, 1);
		eSprenger.trageTerminEin(lSkroer, 2);
		eLoos.trageTerminEin(lSkroer, 3);
		eHoti.trageTerminEin(lSkroer, 4);

		this.alleLehrkraefte.append(lMueller);
		this.alleLehrkraefte.append(lMeier);
		this.alleLehrkraefte.append(lSkroer);

		this.alleElternteile.append(eKipp);
		this.alleElternteile.append(eMertens);
		this.alleElternteile.append(eFrieso);
		this.alleElternteile.append(eKrause);
		this.alleElternteile.append(eStrehl);
		this.alleElternteile.append(eFehlhaber);
		this.alleElternteile.append(eKaradag);
		this.alleElternteile.append(eWindhuis);
		this.alleElternteile.append(eSprenger);
		this.alleElternteile.append(eLoos);
		this.alleElternteile.append(eHoti);



	}

	@Override
	public void processNewConnection(String pClientIP, int pClientPort) {
		send(pClientIP, pClientPort, "+OK Willkommen beim Elternsprechtag-Server");

	}

	@Override
	public void processMessage(String pClientIP, int pClientPort,
			String pMessage) {
		synchronized(this){
			if(pMessage.toLowerCase().startsWith("anmelden")){
				// pMessage aufspalten
				String[] splits = pMessage.split(" ");
				// schauen, ob es genug Parameter gibt
				if(splits.length < 3){
					this.send(pClientIP, pClientPort, "-ERR Fehler bei der Anmeldung");
					return;
				}
				Verbindungsdaten v = gibVerbindungsdaten(pClientIP, pClientPort);
				if(v != null){
					this.send(pClientIP, pClientPort, "-ERR schon angemeldet");
					return;
				}
				String benutzerkennung = splits[1];
				String passwort = splits[2];
				//TODO

				return;
			}
			if(pMessage.toLowerCase().equals("abmelden")){
				this.send(pClientIP, pClientPort, "+OK abgemeldet");
				this.closeConnection(pClientIP, pClientPort);
				return;
			}
			if(pMessage.toLowerCase().startsWith("buchen")){
				//TODO
				return;
			}
			if(pMessage.toLowerCase().startsWith("loeschen")){
				//TODO 
				return;
			}
			if(pMessage.toLowerCase().startsWith("ausgelastete")){
				// pMessage aufspalten
				String[] splits = pMessage.split(" ");
				// schauen, ob es genug Parameter gibt
				if(splits.length < 2){
					this.send(pClientIP, pClientPort, "-ERR ausgelastete: Parameter fehlt");
					return;
				}
				String quoteString = splits[1];
				double quote = -1;
				try {
					quote = Double.parseDouble(quoteString);
				} catch (NumberFormatException e) {
					this.send(pClientIP, pClientPort, "-ERR ausgelastete: Parameter ist nicht double");
					return;
				}
				Verbindungsdaten v = gibVerbindungsdaten(pClientIP, pClientPort);
				if(v == null){
					this.send(pClientIP, pClientPort, "-ERR erst anmelden");
					return;
				}
				this.sendeAusgelastete(v, quote);
				return;
			}
			
			
			// anderer Text
			this.send(pClientIP, pClientPort, "-ERR unbekannter Befehl: "+pMessage);
		}
	}

	@Override
	public void processClosingConnection(String pClientIP, int pClientPort) {
		synchronized(this){
			Verbindungsdaten v = gibVerbindungsdaten(pClientIP, pClientPort);
			if(v != null){
				this.alleVerbindungsdaten.remove();
			}
		}


	}

	private Verbindungsdaten gibVerbindungsdaten(String pClientIP, int pClientPort){
		for(alleVerbindungsdaten.toFirst();alleVerbindungsdaten.hasAccess();alleVerbindungsdaten.next()){
			Verbindungsdaten v = alleVerbindungsdaten.getContent();
			if(v.gibIp().equals(pClientIP) && v.gibPort() == pClientPort){
				return v;
			}
		}
		return null;
	}

	private boolean istAutorisiert(String pBenutzerkennung, String pPasswort){
		for(alleElternteile.toFirst();alleElternteile.hasAccess();alleElternteile.next()){
			Elternteil e = alleElternteile.getContent();
			if(e.gibBenutzerkennung().equals(pBenutzerkennung)&& 
					e.istPasswortGueltig(pPasswort)){
				return true;
			}
		}
		return false;
	}

	private void anmelden(String pBenutzerkennug, String pClientIP, int pClientPort){
		//TODO
	}

	private void terminBuchen(Verbindungsdaten pVerbindungsdaten, String pKuerzel, int pTerminNr){
		//TODO
	}

	private void terminLoeschen(Verbindungsdaten pVerbindungsdaten, String pKuerzel, int pTerminNr){
		//TODO
	}

	private boolean istTerminFrei(Verbindungsdaten pVerbindungsdaten, String pKuerzel, int pTerminNr){
		//TODO
		return false;
	}

	private String ermittleEtwas(String pParameter) {
		String ergebnis = "";
		alleLehrkraefte.toFirst();
		Lehrkraft aktuell = null;
		while (alleLehrkraefte.hasAccess()) {
			if (alleLehrkraefte.getContent().gibKuerzel().equals(pParameter)) {
				aktuell = alleLehrkraefte.getContent();
			}
			alleLehrkraefte.next();
		}
		if (aktuell != null) {
			for (int i = 0; i <= aktuell.gibMaxTerminNr(); i++) {
				if (!aktuell.istTerminFrei(i)) {
					ergebnis = ergebnis+ aktuell.gibGespraechspartner(i).gibName()+ "-";
					ergebnis = ergebnis + (h + (i * d + m) / 60)+ ":";
					ergebnis = ergebnis + ((m + i* d) % 60) + "|";
				}
			}
		}
		System.out.println(ergebnis);
		return ergebnis;
	}
	
	private void sendeAusgelastete(Verbindungsdaten pVerbindungsdaten, double pQuote){
		//TODO
	}


	public static void main(String[] args) {

		GUI g = new GUI(new ElternsprechtagServer(SERVER_PORT));
		g.setLocation(100, 500);
	}

}
