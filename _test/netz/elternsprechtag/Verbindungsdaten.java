package _test.netz.elternsprechtag;

public class Verbindungsdaten {
	private String ip;
	private int port;
	private Elternteil elternteil;
	
	public Verbindungsdaten(String pIP, int pPort, Elternteil pElternteil) {		
		super();
		this.ip = pIP;
		this.port = pPort;
		this.elternteil = pElternteil;
	}

	public String gibIp() {
		return ip;
	}

	public int gibPort() {
		return port;
	}

	public Elternteil gibElternteil() {
		return elternteil;
	}
	
	public String toString(){
		return "V:: "+elternteil.gibName()+":"+port;
	}

}
