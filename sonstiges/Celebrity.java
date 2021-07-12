package sonstiges;

import baeume.ComparableContent;

public class Celebrity extends Person{
	private int einkommen;
	
	public Celebrity(String pName, String pVorname, int pEinkommen){
		super(pName, pVorname);
		this.einkommen = pEinkommen;
	}

	
	public int getEinkommen() {
		return einkommen;
	}

	public void setEinkommen(int pEinkommen) {
		this.einkommen = pEinkommen;
	}
	
	public String toString(){
		return (super.toString()+", "+this.einkommen);
	}

	public boolean istAlphabetischNach(Celebrity pPerson) {
		if(this.getName().compareTo(pPerson.getName()) > 0){
			return true;
		}
		return false;
	}


}
