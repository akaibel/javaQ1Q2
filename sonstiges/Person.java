package sonstiges;

public class Person {
	private String name;
	private String vorname;
	
	public Person(String pName, String pVorname){
		this.name = pName;
		this.vorname = pVorname;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String pName) {
		this.name = pName;
	}
	
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String pVorname) {
		this.vorname = pVorname;
	}
	
	public String toString(){
		return this.name+", "+this.vorname;
	}
}
