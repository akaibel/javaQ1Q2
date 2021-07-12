package _test;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import graph.GraphWithViewer;


public class GraphTestMatrix {

	public GraphWithViewer karte;

	private String[] staedte = {
			   "Koeln",
			   "Bonn",
			   "Koenigswinter",
			   "Bad Honnef",
			   "Unkel",
			   "Godesberg",
			   "Avalon"
	};

	private int[][] entfernungen = {
			{ 0,29,40,-1,-1,-1,-1},  //Koeln
			{29, 0,10,-1,-1, 6,-1},  //Bonn
			{40,10, 0, 5,-1, 4,-1},  //Koenigswinter
			{-1,-1, 5, 0, 8,-1,-1},  //Bad Honnef
			{-1,-1,-1, 8, 0,-1,-1},  //Unkel
			{-1, 6, 4,-1,-1, 0,-1},  //Godesberg
			{-1,-1,-1,-1,-1,-1, 0}	 //Avalon
	};
	
	public GraphTestMatrix(){
		karte = new GraphWithViewer();
		// TODO Graph aus adjMatrix und staedte erstellen
		karte.switchToISOMLayout();
	}

	public static void main(String[] args) {
		GraphTestMatrix gtm = new GraphTestMatrix();
	}

}
