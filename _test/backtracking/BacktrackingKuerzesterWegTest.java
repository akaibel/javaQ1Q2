package _test.backtracking;


import graph.Edge;
import graph.Vertex;
import graph.GraphWithViewer;
import gui.GUI;
import linear.List;
import linear.ListWithViewer;


public class BacktrackingKuerzesterWegTest {

	// Attribute
	public GraphWithViewer graph;

	// Attribute fuer das Backtracking
	public ListWithViewer<Vertex> besterWeg;
	public ListWithViewer<Vertex> aktuellerWeg;
	public int besteLaenge;
	public int aktuelleLaenge;
	public Vertex start;
	public Vertex ziel;


	public BacktrackingKuerzesterWegTest(){
		initDeutschlandkarte();
	}


	//Methoden

	/**
	 * Kopiert den Inhalt einer Liste in eine andere Liste.
	 * Der Inhalt der Ziel-Liste wird dabei ersetzt.
	 * @param herkunftsListe
	 * @param zielListe
	 */
	private void kopiereListeIn(List herkunftsListe, List zielListe){
		// besterWeg leeren
		for(zielListe.toFirst();!zielListe.isEmpty();){
			zielListe.remove();
		}
		// aktuellerWeg in besterWeg kopieren
		for(herkunftsListe.toFirst();herkunftsListe.hasAccess();herkunftsListe.next()){
			zielListe.append(herkunftsListe.getContent());
		}

	}

	public ListWithViewer<Vertex> kuerzestenWegFinden(String pStart, String pZiel){
		graph.setAllEdgeMarks(false);

		start = graph.getVertex(pStart);
		ziel = graph.getVertex(pZiel);

		besterWeg = new ListWithViewer<>();
		aktuellerWeg = new ListWithViewer<>();

		besteLaenge = 10000000;
		aktuelleLaenge = 0;

		start.setMark(true);
		aktuellerWeg.append(start);

		kuerzestenWegFindenBacktracking(start);

		return besterWeg;
	}

	private void kuerzestenWegFindenBacktracking(Vertex pNode) {
		//TODO
	}


	private void initDeutschlandkarte() {
		System.out.println("***** Deutschlandkarte *****");

		graph = new GraphWithViewer();
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

		// auf ein geeignetes Layout umstellen
		graph.switchToISOMLayout();
	}

	public static void main(String[] args) {
		BacktrackingKuerzesterWegTest gt = new BacktrackingKuerzesterWegTest();
		new GUI(gt);
	}

}
