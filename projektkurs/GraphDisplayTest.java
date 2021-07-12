package projektkurs;

import formenBlueJ.Position;

import java.util.Vector;

import formenBlueJ.Kreis;
import formenBlueJ.Leinwand;
import graph.Edge;
import graph.Graph;
import graph.Vertex;
import linear.List;


public class GraphDisplayTest {

	private Graph graph;
	private Vector<Kreis> kreiseVector;

	public GraphDisplayTest(){
		graph = getDeutschlandkarte();
		kreiseVector = new Vector<Kreis>();
		
		// Nodes zaehlen
		int anzahl = 0;
		List allNodes = graph.getVertices();
		for(allNodes.toFirst(); allNodes.hasAccess(); allNodes.next()){
			anzahl++;
		}
		
		// Kreise platzieren
		int i = 0;
		for(allNodes.toFirst(); allNodes.hasAccess(); allNodes.next()){
			Vertex gn = (Vertex)allNodes.getContent();
			Kreis k = new Kreis();
			String name = gn.getID();
			k.setzeName(name);

			// Position des Kreise k festlegen
			Position p = getKreisPosition(i, anzahl);
			k.bewegeZuPosition(p.getX(), p.getY());

			k.farbeAendern("gelb");
			k.sichtbarMachen();
			
			// den neuen Kreis k zum kreiseVector hinzufuegen
			kreiseVector.add(k);
			
			i++;
		}
	}
	
	/**
	 * bewegt alle Kreise 
	 * @param xDistanz
	 * @param yDistanz
	 */
	public void bewegenAlle(int xDistanz, int yDistanz){
		for (int i = 0; i < kreiseVector.size(); i++) {
			Kreis aktuell = kreiseVector.elementAt(i);
			aktuell.langsamHorizontalBewegen(xDistanz);
			aktuell.langsamVertikalBewegen(yDistanz);
		}
	}
	
	/**
	 * gibt Objekte auf einer Kreisbahn an
	 * @param nr
	 * @param anzahl
	 * @return
	 */
	public Position getKreisPosition(int nr, int anzahl){
		int mitteX = Leinwand.width() / 2;
		int mitteY = Leinwand.height() / 2;
		int radius = mitteX - 40;
		if(radius > mitteY - 40){
			radius = mitteY - 40;
		}

		int x = (int) Math.round(radius*Math.cos(2*Math.PI*nr/anzahl) + mitteX);
		int y = (int) Math.round(radius*Math.sin(2*Math.PI*nr/anzahl) + mitteY);

		return new Position(x, y); 
	}
	
	private static Graph getDeutschlandkarte() {
		Graph graph = new Graph();
		Vertex dortmund = new Vertex("Dortmund");
		graph.addVertex(dortmund);
		Vertex koeln = new Vertex("Koeln");
		graph.addVertex(koeln);
		Vertex frankfurt = new Vertex("Frankfurt");
		graph.addVertex(frankfurt);
		Vertex kassel = new Vertex("Kassel");
		graph.addVertex(kassel);
		Vertex wuerzburg = new Vertex("Wuerzburg");
		graph.addVertex(wuerzburg);

		Edge kassel_dortmund = new Edge(kassel, dortmund, 160);
		graph.addEdge(kassel_dortmund);
		Edge dortmund_koeln = new Edge(dortmund, koeln, 93);
		graph.addEdge(dortmund_koeln);
		Edge frankfurt_kassel = new Edge(frankfurt, kassel, 193);
		graph.addEdge(frankfurt_kassel);
		Edge kassel_wuerzburg = new Edge(kassel, wuerzburg, 209);
		graph.addEdge(kassel_wuerzburg);
		Edge wuerzburg_frankfurt = new Edge(wuerzburg, frankfurt, 119);
		graph.addEdge(wuerzburg_frankfurt);
		Edge frankfurt_koeln = new Edge(frankfurt, koeln, 189);
		graph.addEdge(frankfurt_koeln);

		// *** weitere Vertices und Edges! ***
		
		Vertex hamburg = new Vertex("Hamburg");
		graph.addVertex(hamburg);
		Vertex berlin = new Vertex("Berlin");
		graph.addVertex(berlin);
		Vertex bremen = new Vertex("Bremen");
		graph.addVertex(bremen);
		Vertex hannover = new Vertex("Hannover");
		graph.addVertex(hannover);
		Vertex leipzig = new Vertex("Leipzig");
		graph.addVertex(leipzig);
		Vertex nuernberg = new Vertex("Nuernberg");
		graph.addVertex(nuernberg);
		Vertex stuttgart = new Vertex("Stuttgart");
		graph.addVertex(stuttgart);
		Vertex muenchen = new Vertex("Muenchen");
		graph.addVertex(muenchen);
		Vertex karlsruhe = new Vertex("Karlsruhe");
		graph.addVertex(karlsruhe);
		Vertex aachen = new Vertex("Aachen");
		graph.addVertex(aachen);

		Edge e = new Edge(berlin, hamburg, 289);
		graph.addEdge(e);
		Edge hamburg_bremen = new Edge(hamburg, bremen, 119);
		graph.addEdge(hamburg_bremen);
		Edge bremen_hannover = new Edge(bremen, hannover, 122);
		graph.addEdge(bremen_hannover);
		Edge hannover_hamburg = new Edge(hannover, hamburg, 150);
		graph.addEdge(hannover_hamburg);
		Edge berlin_hannover = new Edge(berlin, hannover, 290);
		graph.addEdge(berlin_hannover);
		Edge berlin_leipzig = new Edge(berlin, leipzig, 188);
		graph.addEdge(berlin_leipzig);
		Edge hannover_kassel = new Edge(hannover, kassel, 167);
		graph.addEdge(hannover_kassel);
		Edge leipzig_kassel = new Edge(leipzig, kassel, 250);
		graph.addEdge(leipzig_kassel);
		Edge dortmund_bremen = new Edge(dortmund, bremen, 234);
		graph.addEdge(dortmund_bremen);
		Edge dortmund_hannover = new Edge(dortmund, hannover, 210);
		graph.addEdge(dortmund_hannover);
		Edge leipzig_nuernberg = new Edge(leipzig, nuernberg, 278);
		graph.addEdge(leipzig_nuernberg);
		Edge wuerzburg_nuernberg = new Edge(wuerzburg, nuernberg, 110);
		graph.addEdge(wuerzburg_nuernberg);
		Edge nuernberg_muenchen = new Edge(nuernberg, muenchen, 166);
		graph.addEdge(nuernberg_muenchen);
		Edge muenchen_stuttgart = new Edge(muenchen, stuttgart, 223);
		graph.addEdge(muenchen_stuttgart);
		Edge nuernberg_stuttgart = new Edge(nuernberg, stuttgart, 208);
		graph.addEdge(nuernberg_stuttgart);
		Edge stuttgart_karlsruhe = new Edge(stuttgart, karlsruhe, 82);
		graph.addEdge(stuttgart_karlsruhe);
		Edge karlsruhe_frankfurt = new Edge(karlsruhe, frankfurt, 147);
		graph.addEdge(karlsruhe_frankfurt);
		Edge aachen_koeln = new Edge(aachen, koeln, 68);
		graph.addEdge(aachen_koeln);
		
		return graph;
	}
	
	public static void main(String[] args) {
		GraphDisplayTest ft = new GraphDisplayTest();
		ft.bewegenAlle(10, 20);
	}
	

	
}
