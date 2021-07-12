package formenBlueJ;

import java.awt.geom.Ellipse2D;

public class NamedEllipse2D extends Ellipse2D.Double implements NamedShape {

		private String name;

		
		public NamedEllipse2D(double x, double y, double width, double height) {
			super(x, y, width, height);
			// TODO Auto-generated constructor stub
		}

		public String getName(){
			return name;
		}
		
		public void setName(String pName){
			this.name = pName;
		}

}
