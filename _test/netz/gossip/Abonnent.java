package _test.netz.gossip;

public class Abonnent {
	private String ip;
	private int port;
	
	public Abonnent(String pIp, int pPort){
		this.ip = pIp;
		this.port = pPort;
	}
	
	public String getIp() {
		return ip;
	}
	
	public int getPort() {
		return port;
	}
	
	public String toString(){
		return ip+":"+port;
	}
}
