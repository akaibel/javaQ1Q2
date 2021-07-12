package zauberwuerfel;

import java.awt.Color;

public class ZMitte {
	private int seite;
	
	public static final ZMitte oben = new ZMitte(0);
	public static final ZMitte vorne = new ZMitte(1);
	public static final ZMitte unten = new ZMitte(2);
	public static final ZMitte hinten = new ZMitte(3);
	public static final ZMitte links = new ZMitte(4);
	public static final ZMitte rechts = new ZMitte(5);
	
	public static ZMitte[] alleMitten = {
		oben,
		vorne,
		unten,
		hinten,
		links,
		rechts
	};
	
	public ZMitte(int seite) {
		this.seite = seite;
	}

	public int getSeite() {
		return seite;
	}
	
	public Color getFarbe(ZModel model){
		return model.getFarbe(model.getFelder()[seite][4]);
	}
	
	public boolean hatFarbe(ZModel model, Color farbe){
		return farbe.equals(getFarbe(model));
	}
	
	public static ZMitte findeMitte(ZModel model, Color farbe){
		for(ZMitte zm: alleMitten){
			if(zm.getFarbe(model).equals(farbe)){
				return zm;
			}
		}
		return null;
	}
	
	

}
