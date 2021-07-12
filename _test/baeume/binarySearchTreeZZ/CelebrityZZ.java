package _test.baeume.binarySearchTreeZZ;

import sonstiges.Person;
import baeume.ComparableContent;

public class CelebrityZZ extends Person implements ComparableContent<CelebrityZZ> {
	private int einkommen;
	
	public CelebrityZZ(String pName, String pVorname, int pEinkommen){
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

	public boolean istAlphabetischNach(CelebrityZZ pPerson) {
		if(this.getName().compareTo(pPerson.getName()) > 0){
			return true;
		}
		return false;
	}


	@Override
	public boolean isGreater(CelebrityZZ pContent) {
		return this.getName().compareTo(pContent.getName()) > 0;
	}


	@Override
	public boolean isEqual(CelebrityZZ pContent) {
		return this.getName().compareTo(pContent.getName()) == 0;
	}


	@Override
	public boolean isLess(CelebrityZZ pContent) {
		return this.getName().compareTo(pContent.getName()) < 0;
	}
}
