package zauberwuerfel;

import java.awt.Color;

public class ZKante {
	private ZFeld zf1;
	private ZFeld zf2;
	
	public static final ZKante vorneOben = new ZKante(1,1,0,7);
	public static final ZKante vorneUnten = new ZKante(1,7,2,1);
	public static final ZKante vorneLinks = new ZKante(1,3,4,5);
	public static final ZKante vorneRechts = new ZKante(1,5,5,3);
	public static final ZKante hintenOben = new ZKante(3,7,0,1);
	public static final ZKante hintenUnten = new ZKante(3,1,2,7);
	public static final ZKante hintenLinks = new ZKante(3,3,4,3);
	public static final ZKante hintenRechts = new ZKante(3,5,5,5);
	public static final ZKante linksOben = new ZKante(4,1,0,3);
	public static final ZKante linksUnten = new ZKante(4,7,2,3);
	public static final ZKante rechtsOben = new ZKante(5,1,0,5);
	public static final ZKante rechtsUnten = new ZKante(5,7,2,5);
	
	public static final ZKante[] alleKanten = {
		vorneOben,
		vorneUnten,
		vorneLinks,
		vorneRechts,
		hintenOben,
		hintenUnten,
		hintenLinks,
		hintenRechts,
		linksOben,
		linksUnten,
		rechtsOben,
		rechtsUnten
	};
	
	private ZKante(ZFeld zf1, ZFeld zf2) {
		this.zf1 = zf1;
		this.zf2 = zf2;
	}
	
	private ZKante(int seite1, int feld1, int seite2, int feld2){
		this(new ZFeld(seite1, feld1), new ZFeld(seite2, feld2));
	}

	public ZFeld getZFeld1() {
		return zf1;
	}

	public ZFeld getZFeld2() {
		return zf2;
	}

	public boolean contains(ZFeld zf){
		return zf.equals(zf1) || zf.equals(zf2);
	}
	
	public boolean equals(ZKante zk){
		return this.contains(zk.zf1) && this.contains(zk.zf2);
	}

	private boolean enthaeltFarbe(ZModel model, Color c){
		return 
				zf1.getFarbe(model).equals(c) || 
				zf2.getFarbe(model).equals(c);
				
	}
	
	public int getFeldAufSeite(int seite){
		if(zf1.getSeite() == seite) return zf1.getFeld();
		if(zf2.getSeite() == seite) return zf2.getFeld();
		return -1;
	}
	
	public Color getFarbeAufSeite(ZModel model, int seite){
		if(zf1.getSeite() == seite) return zf1.getFarbe(model);
		if(zf2.getSeite() == seite) return zf2.getFarbe(model);
		return null;		
	}
	
	public Color[] getFarben(ZModel model){
		Color[] farben = {
				zf1.getFarbe(model),
				zf2.getFarbe(model),
		};
		return farben;
	}
	
	public boolean istAnDerSeite(){
		return 
			this == linksOben ||
			this == linksUnten ||		
			this == rechtsOben ||
			this == rechtsUnten;					
	}
	
	public boolean istOben(){
		return 
				this == vorneOben ||
				this == hintenOben ||		
				this == linksOben ||
				this == rechtsOben;					
	}
	
	public boolean istInDerMittlerenEbene(){
		return
				this == vorneLinks ||
				this == vorneRechts ||		
				this == hintenLinks ||
				this == hintenRechts;					
	}
	
	public boolean istUnten(){
		return 
				this == vorneUnten ||
				this == hintenUnten ||		
				this == linksUnten ||
				this == rechtsUnten;					
	}
	
	public static ZKante findeKante(ZModel model, Color c1, Color c2 ){
		for(ZKante zk: alleKanten){
			if(zk.enthaeltFarbe(model, c1) && zk.enthaeltFarbe(model, c2)){
				return zk;
			}
		}
		return null;
	}

	public boolean hatFarben(ZModel model, Color c1, Color c2) {
		return (enthaeltFarbe(model, c1) && enthaeltFarbe(model,c2));
	}
}
