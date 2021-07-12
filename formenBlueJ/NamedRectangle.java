package formenBlueJ;

import java.awt.Rectangle;

public class NamedRectangle extends Rectangle implements NamedShape {

	private String name;

	
	
	public NamedRectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	
	public String getName() {
		return this.name;
	}
	
	public void setName(String pName){
		this.name = pName;
	}

}
