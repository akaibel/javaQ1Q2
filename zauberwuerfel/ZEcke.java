package zauberwuerfel;

import java.awt.Color;

public class ZEcke {
	private ZFeld zf1;
	private ZFeld zf2;
	private ZFeld zf3;
	
	public static final ZEcke vorneObenLinks = new ZEcke(1,0,0,6,4,2);
	public static final ZEcke vorneObenRechts = new ZEcke(1,2,0,8,5,0);
	public static final ZEcke vorneUntenLinks = new ZEcke(1,6,2,0,4,8);
	public static final ZEcke vorneUntenRechts = new ZEcke(1,8,2,2,5,6);
	public static final ZEcke hintenObenLinks = new ZEcke(3,6,0,0,4,0);
	public static final ZEcke hintenObenRechts = new ZEcke(3,8,0,2,5,2);
	public static final ZEcke hintenUntenLinks = new ZEcke(3,0,2,6,4,6);
	public static final ZEcke hintenUntenRechts = new ZEcke(3,2,2,8,5,8);

	public static ZEcke[] alleEcken = {
		vorneObenLinks,
		vorneObenRechts,
		vorneUntenLinks,
		vorneUntenRechts,
		hintenObenLinks,
		hintenObenRechts,
		hintenUntenLinks,
		hintenUntenRechts
	};
	
	private ZEcke(ZFeld zf1, ZFeld zf2, ZFeld zf3) {
		this.zf1 = zf1;
		this.zf2 = zf2;
		this.zf3 = zf3;
	}
	
	private ZEcke(int s1, int f1, int s2, int f2, int s3, int f3){
		this(new ZFeld(s1,f1), new ZFeld(s2,f2), new ZFeld(s3,f3));
	}

	public ZFeld getZFeld1() {
		return zf1;
	}

	public ZFeld getZFeld2() {
		return zf2;
	}

	public ZFeld getZFeld3() {
		return zf3;
	}
	
	public int getFeld(int seite){
		if(zf1.getSeite() == seite) return zf1.getFeld();
		if(zf2.getSeite() == seite) return zf2.getFeld();
		if(zf3.getSeite() == seite) return zf3.getFeld();
		return -1;
	}
	
	public boolean equals(ZEcke ze){
		return this.contains(ze.zf1) && this.contains(ze.zf2) && this.contains(ze.zf3);
	}
	
	public boolean contains(ZFeld zf){
		return zf.equals(zf1) || zf.equals(zf2) || zf.equals(zf3);
	}
	
	private boolean enthaeltFarbe(ZModel model, Color c){
		return 
				zf1.getFarbe(model).equals(c) || 
				zf2.getFarbe(model).equals(c) ||
				zf3.getFarbe(model).equals(c);
	}
	
	public boolean hatFarben(ZModel model, Color c1, Color c2, Color c3) {
		return (enthaeltFarbe(model, c1) && enthaeltFarbe(model,c2) && enthaeltFarbe(model,c3));
	}
	
	
	public Color[] getFarben(ZModel model){
		Color[] farben = {
				zf1.getFarbe(model),
				zf2.getFarbe(model),
				zf3.getFarbe(model)
		};
		return farben;
	}
	
	public static ZEcke findeEcke(ZModel model, Color c1, Color c2, Color c3){
		for(ZEcke ze: alleEcken){
			if(ze.enthaeltFarbe(model, c1) &&
			   ze.enthaeltFarbe(model, c2) &&
			   ze.enthaeltFarbe(model, c3)){
				return ze;
			}
		}
		return null;
	}

	public boolean istOben() {
		return
				this == vorneObenLinks ||
				this == vorneObenRechts ||
				this == hintenObenLinks ||
				this == hintenObenRechts;
	}
	
	public boolean istUnten(){
		return !istOben();
	}

	public Color getFarbeAufSeite(ZModel model, int seite) {
		if(zf1.getSeite() == seite) return zf1.getFarbe(model);
		if(zf2.getSeite() == seite) return zf2.getFarbe(model);
		if(zf3.getSeite() == seite) return zf3.getFarbe(model);
		return null;		
	}
	

}
