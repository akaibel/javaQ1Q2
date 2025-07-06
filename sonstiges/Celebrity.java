package sonstiges;

import baeume.ComparableContent;

public class Celebrity extends Person{
	private int vermoegen;
	private String branche;
	
	public Celebrity(String pName, String pVorname, int pVermoegen){
		super(pName, pVorname);
		this.vermoegen = pVermoegen;
		this.branche = null;
	}

	
	public Celebrity(String pName, String pVorname, int pVermoegen, String pBranche) {
		super(pName, pVorname);
		this.vermoegen = pVermoegen;
		this.branche = pBranche;
	}


	public int getVermoegen() {
		return vermoegen;
	}

	public void setVermoegen(int pVermoegen) {
		this.vermoegen = pVermoegen;
	}
	
	public String getBranche() {
		return this.branche;
	}
	
	public void setBranche(String pBranche) {
		this.branche = pBranche;
	}
	
	public String toString(){
		return (super.toString()+", "+this.vermoegen);
	}

	public boolean istAlphabetischNach(Celebrity pPerson) {
		return this.getName().compareTo(pPerson.getName()) > 0;
	}


}
