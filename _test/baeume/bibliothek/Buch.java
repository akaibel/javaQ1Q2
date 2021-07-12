package _test.baeume.bibliothek;

import baeume.ComparableContent;

public class Buch {
	  private String titel;
	  private int regalNr;
	  
	  public Buch(String pTitel, int pRegalNr){
	     titel = pTitel;
	     regalNr = pRegalNr;
	  }

	  public int getRegalNr() {
	     return regalNr;
	  }

	  public void setRegalNr(int regalNr) {
	     this.regalNr = regalNr;
	  }

	  public String getTitel() {
	     return titel;
	  }
	  
	  public String toString(){
		  return titel+", "+regalNr;
	  }
}