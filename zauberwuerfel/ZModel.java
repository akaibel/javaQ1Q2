package zauberwuerfel;

import gui.GUI;

import java.awt.Color;


public class ZModel {
	private ZGUI zgui;
	
	public ZModel(ZLogik zLogik){
		// den fertigen ZModel belegen:
		for(int seite=0; seite<6; seite++){
			int farbNr = 11+seite;
			for(int feldNr=0; feldNr<9; feldNr++){
				felder[seite][feldNr] = farbNr;
			}
		}
		zgui = new ZGUI(zLogik);
		zgui.updateGUI(this);
	}
	
	public void setWartezeit(int wartezeitInMillis){
		zgui.setWartezeit(wartezeitInMillis);
	}
	
	public int getWartezeit(){
		return zgui.getWartezeit();
	}
	

	/*
	 * Die Datenstruktur besteht aus 6 2-dim. Arrays fuer die Seiten 
	 * mit jeweils 9 Feldern.
	 * Die 6 Seiten sind wie folgt angeordnet (s.u.). 
	 * Dabei ist Seite 0 oben und Seite 1 vorne.
	 *           ---
	 *          | 0 |
	 *       --- --- ---  
	 *      | 4 | 1 | 5 |
	 *       --- --- ---  
	 *          | 2 |
	 *           ---
	 *          | 3 |
	 *           ---
	 *          
	 * Innerhalb jeder Seite sind die Felder wie folgt angeordnet:
	 *   -----
	 *  |0|1|2|          
	 *  |-----|
	 *  |3|4|5|          
	 *  |-----|
	 *  |6|7|8|          
	 *   -----
	 *   
	 *   Die Drehachsen sind wie folgt:
	 *   x-Achse: links <-> rechts
	 *   y-Achse: oben <-> unten
	 *   z-Achse: vorne <-> hinten
	 *   
	 *   
	 *   Die Farben sind von 11 bis 16 - 
	 *   das vereinfacht die Unterscheidung mit den Indizes.
	 *   
	 *   
	 */
	private int felder[][] = new int[6][9];

	public static final int oben = 0;
	public static final int vorne = 1;
	public static final int unten = 2;
	public static final int hinten = 3;
	public static final int links = 4;
	public static final int rechts = 5;
	
	
	public static final Color[] farben = {Color.RED, Color.BLUE, Color.GREEN, Color.WHITE, Color.GRAY, Color.ORANGE};
	private static final String[] farbStrings =  {"rot"    , "blau"    , "gruen"    , "weiss"    , "grau"    , "orange"    };
	
	/**
	 * farbNr muss zwischen 11 und 16 (inklusive) liegen.
	 * @param farbNr
	 * @return
	 */
	public Color getFarbe(int farbNr){
		if(farbNr <11 || farbNr >11+5){
			return Color.BLACK;
		}
		return this.farben[farbNr- 11];
	}
	
	public String getFarbString(Color farbe){
		for(int i=0; i<farben.length; i++){
			if(farbe == farben[i]){
				return farbStrings[i];
			}
		}
		return "ungueltige Farbe";
	}
	
	public int getFarbNr(Color farbe){
		int ergebnis = 11;
		for(Color c: this.farben){
			if(c == farbe){
				return ergebnis;
			}
			ergebnis++;
		}
		return -1;
	}
	
	public int[][] getFelder(){
		return this.felder;
	}
	
	/**
	 * dreht nur die Seite, aber nicht die Kante!
	 * @param seiteNr
	 */
	private void seiteDrehen(int seiteNr){
		int[] seiteAlt = this.felder[seiteNr];
		int[] seiteNeu = new int[9];
		seiteNeu[0] = seiteAlt[6];
		seiteNeu[1] = seiteAlt[3];
		seiteNeu[2] = seiteAlt[0];
		seiteNeu[3] = seiteAlt[7];
		seiteNeu[4] = seiteAlt[4];
		seiteNeu[5] = seiteAlt[1];
		seiteNeu[6] = seiteAlt[8];
		seiteNeu[7] = seiteAlt[5];
		seiteNeu[8] = seiteAlt[2];
		this.felder[seiteNr] = seiteNeu;
	}
	
	/**
	 * dreht nur die ebene, aber nicht eine Seite!
	 * dreht gegen den Uhrzeigersinn
	 * @param vonUnten
	 */
	private void ebeneUmYAchseDrehen(int vonUnten){
		int f0 = felder[1][0+3*vonUnten];
		int f1 = felder[1][1+3*vonUnten];
		int f2 = felder[1][2+3*vonUnten];
		
		felder[1][0+3*vonUnten] = felder[4][0+3*vonUnten];
		felder[1][1+3*vonUnten] = felder[4][1+3*vonUnten];
		felder[1][2+3*vonUnten] = felder[4][2+3*vonUnten];
		
		felder[4][0+3*vonUnten] = felder[3][8-3*vonUnten];
		felder[4][1+3*vonUnten] = felder[3][7-3*vonUnten];
		felder[4][2+3*vonUnten] = felder[3][6-3*vonUnten];
		
		felder[3][8-3*vonUnten] = felder[5][0+3*vonUnten];
		felder[3][7-3*vonUnten] = felder[5][1+3*vonUnten];
		felder[3][6-3*vonUnten] = felder[5][2+3*vonUnten];

		felder[5][0+3*vonUnten] = f0;
		felder[5][1+3*vonUnten] = f1;
		felder[5][2+3*vonUnten] = f2;
	}
	
	/**
	 * dreht nur die ebene, aber nicht eine Seite!
	 * dreht oben nach hinten
	 * @param vonLinks
	 */
	private void ebeneUmXAchseDrehen(int vonLinks){
		int f0 = felder[1][0+vonLinks];
		int f3 = felder[1][3+vonLinks];
		int f6 = felder[1][6+vonLinks];
		
		felder[1][0+vonLinks] = felder[2][0+vonLinks];
		felder[1][3+vonLinks] = felder[2][3+vonLinks];
		felder[1][6+vonLinks] = felder[2][6+vonLinks];
		
		felder[2][0+vonLinks] = felder[3][0+vonLinks];
		felder[2][3+vonLinks] = felder[3][3+vonLinks];
		felder[2][6+vonLinks] = felder[3][6+vonLinks];
		
		felder[3][0+vonLinks] = felder[0][0+vonLinks];
		felder[3][3+vonLinks] = felder[0][3+vonLinks];
		felder[3][6+vonLinks] = felder[0][6+vonLinks];
		
		felder[0][0+vonLinks] = f0;
		felder[0][3+vonLinks] = f3;
		felder[0][6+vonLinks] = f6;
	}
	
	/**
	 * dreht nur die ebene, aber nicht eine Seite!
	 * dreht (von vorne gesehen) gegen den Uhrzeigersinn
	 * @param vonVorne
	 */
	private void ebeneUmZAchseDrehen(int vonVorne){
		int f6 = felder[0][6-3*vonVorne];
		int f7 = felder[0][7-3*vonVorne];
		int f8 = felder[0][8-3*vonVorne];
		
		felder[0][6-3*vonVorne] = felder[5][0+vonVorne];
		felder[0][7-3*vonVorne] = felder[5][3+vonVorne];
		felder[0][8-3*vonVorne] = felder[5][6+vonVorne];
		
		felder[5][0+vonVorne] = felder[2][2+3*vonVorne];
		felder[5][3+vonVorne] = felder[2][1+3*vonVorne];
		felder[5][6+vonVorne] = felder[2][0+3*vonVorne];
		
		felder[2][0+3*vonVorne] = felder[4][2-vonVorne];
		felder[2][1+3*vonVorne] = felder[4][5-vonVorne];
		felder[2][2+3*vonVorne] = felder[4][8-vonVorne];
		
		felder[4][2-vonVorne] = f8;
		felder[4][5-vonVorne] = f7;
		felder[4][8-vonVorne] = f6;
	}
	
	public void drehenXLinks(int anzahl){
		System.out.println("drehenXLinks("+anzahl+")");
		for(int i=0; i<anzahl; i++){
			seiteDrehen(4);
			seiteDrehen(4);
			seiteDrehen(4);
			ebeneUmXAchseDrehen(0);
		}
		zgui.updateGUI(this);				
	}
	
	public void drehenXMitte(int anzahl){
		System.out.println("drehenXMitte("+anzahl+")");
		for(int i=0; i<anzahl; i++){
			ebeneUmXAchseDrehen(1);
		}
		zgui.updateGUI(this);						
	}

	public void drehenXRechts(int anzahl){
		System.out.println("drehenXRechts("+anzahl+")");
		for(int i=0; i<anzahl; i++){
			seiteDrehen(5);
			ebeneUmXAchseDrehen(2);
		}
		zgui.updateGUI(this);				
	}
		
	public void drehenYOben(int anzahl){
		System.out.println("drehenYOben("+anzahl+")");
		for(int i=0; i<anzahl; i++){
			seiteDrehen(0);
			seiteDrehen(0);
			seiteDrehen(0);
			ebeneUmYAchseDrehen(0);
		}
		zgui.updateGUI(this);
	}
	
	public void drehenYMitte(int anzahl){
		System.out.println("drehenYMitte("+anzahl+")");
		for(int i=0; i<anzahl; i++){
			ebeneUmYAchseDrehen(1);
		}
		zgui.updateGUI(this);
	}
	
	public void drehenYUnten(int anzahl){
		System.out.println("drehenYUnten("+anzahl+")");
		for(int i=0; i<anzahl; i++){
			seiteDrehen(2);
			ebeneUmYAchseDrehen(2);
		}
		zgui.updateGUI(this);		
	}
	
	public void drehenZVorne(int anzahl){
		System.out.println("drehenZVorne("+anzahl+")");
		for(int i=0; i<anzahl; i++){
			seiteDrehen(1);
			seiteDrehen(1);
			seiteDrehen(1);
			ebeneUmZAchseDrehen(0);
		}
		zgui.updateGUI(this);				
	}
	
	public void drehenZMitte(int anzahl){
		System.out.println("drehenZMitte("+anzahl+")");
		for(int i=0; i<anzahl; i++){
			ebeneUmZAchseDrehen(1);
		}
		zgui.updateGUI(this);						
	}

	public void drehenZHinten(int anzahl){
		System.out.println("drehenYUnten("+anzahl+")");
		for(int i=0; i<anzahl; i++){
			seiteDrehen(3);
			ebeneUmZAchseDrehen(2);
		}
		zgui.updateGUI(this);				
	}
		
	
	private void updateGUI(){
		zgui.updateGUI(this);		
	}

}
