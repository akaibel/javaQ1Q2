package _test.netz.gossip;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Nachricht {
	private String text;
	private String zeit;
	
	public Nachricht(String pText){
		text = pText;
        Date dasDatum = new Date();
        zeit = dasDatum.toString();
	}
	
	public String getText() {
		return text;
	}
	
	public String getZeit() {
		return zeit;
	}
	
	public String toString(){
		return text+" "+zeit;
	}
}
