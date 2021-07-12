package zauberwuerfel;

import java.awt.Color;

public class ZFeld {
	private int seite;
	private int feld;
	
	public ZFeld(int seite, int feld) {
		this.feld = feld;
		this.seite = seite;
	}
	
	public int getSeite() {
		return seite;
	}

	public int getFeld() {
		return feld;
	}

	public Color getFarbe(ZModel model){
		return model.getFarbe(model.getFelder()[seite][feld]);
	}
	
	public boolean equals(ZFeld zf){
		return (this.seite ==zf.seite && this.feld == zf.feld);
	}
}
