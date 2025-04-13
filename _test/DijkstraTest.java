package _test;

import linear.List;
import graph.DijkstraInfo;
import graph.Edge;
import graph.Vertex;
import gui.GUI;
import graph.GraphWithViewer;
import linear.ListWithViewer;

public class DijkstraTest {
   private GraphWithViewer karte;
   private List<DijkstraInfo> gelbeListe;
   private List<DijkstraInfo> roteListe;
  
   public DijkstraTest(){
       initMap();
   }
  
   public List<DijkstraInfo> dijkstraAlgorithmus(String sStart){
       roteListe = new ListWithViewer<DijkstraInfo>();
       gelbeListe = new ListWithViewer<DijkstraInfo>();
       Vertex vStart = karte.getVertex(sStart);
       DijkstraInfo dStart = new DijkstraInfo(vStart,0,null);
       dStart.setDistanz(0);
       gelbeListe.append(dStart);
       //TODO
       return roteListe;
   }
  
   /**
    * Sorgt dafuer, dass dInfo gemaess seiner Distanz
    * die richtige Position in der gelbe Liste bekommt.
    * Falls dInfo noch gar nicht in gelbeListe enthalten ist,
    * dann wird dInfo an der richtigen Stelle eingefuegt.
    */
   private void inGelbeListeUpdaten(DijkstraInfo dInfo) {
       boolean inserted = false;
       gelbeListe.toFirst();
       while(gelbeListe.hasAccess()){
           DijkstraInfo aktuell = gelbeListe.getContent();
           if(aktuell.getDistanz() >= dInfo.getDistanz()){
               gelbeListe.insert(dInfo);
               inserted = true;
               break;
           }
           if(aktuell.getVertex()== dInfo.getVertex()){
               // gibt es schon - mit kleinerer Distanz!
               gelbeListe.toFirst();
               return;
           }
           gelbeListe.next();
       }
       if(inserted){
           // ggf. taucht der Knoten nochmal in der Liste auf!
           // dann muss er entfernt werden!
           while(gelbeListe.hasAccess()){
               DijkstraInfo aktuell = gelbeListe.getContent();
               if(aktuell.getVertex() == dInfo.getVertex()){
                   gelbeListe.remove();
                   break;
               }
               gelbeListe.next();
           }
       }
       else{
           // der Knoten wurde noch nicht eingefuegt!
           gelbeListe.append(dInfo);
       }     
       gelbeListe.toFirst();
   }
   
    public void initMap(){
            karte = new GraphWithViewer();
            Vertex kiel = new Vertex("Kiel");
            karte.addVertex(kiel);
            Vertex luebeck = new Vertex("Luebeck");
            karte.addVertex(luebeck);
            Vertex hamburg = new Vertex("Hamburg");
            karte.addVertex(hamburg);
            Vertex berlin = new Vertex("Berlin");
            karte.addVertex(berlin);
            Vertex bremen = new Vertex("Bremen");
            karte.addVertex(bremen);
            Vertex hannover = new Vertex("Hannover");
            karte.addVertex(hannover);
            Vertex dortmund = new Vertex("Dortmund");
            karte.addVertex(dortmund);
            Vertex bochum = new Vertex("Bochum");
            karte.addVertex(bochum);
            Vertex koeln = new Vertex("Koeln");
            karte.addVertex(koeln);
            Vertex bonn = new Vertex("Bonn");
            karte.addVertex(bonn);
            Vertex mainz = new Vertex("Mainz");
            karte.addVertex(mainz);
            Vertex frankfurt = new Vertex("Frankfurt");
            karte.addVertex(frankfurt);
            Vertex kassel = new Vertex("Kassel");
            karte.addVertex(kassel);
            Vertex wuerzburg = new Vertex("Wuerzburg");
            karte.addVertex(wuerzburg);
            Vertex leipzig = new Vertex("Leipzig");
            karte.addVertex(leipzig);
            Vertex nuernberg = new Vertex("Nuernberg");
            karte.addVertex(nuernberg);
            Vertex stuttgart = new Vertex("Stuttgart");
            karte.addVertex(stuttgart);
            Vertex muenchen = new Vertex("Muenchen");
            karte.addVertex(muenchen);
            Vertex karlsruhe = new Vertex("Karlsruhe");
            karte.addVertex(karlsruhe);
           
            karte.addEdge(new Edge(kiel, hamburg, 97));
            karte.addEdge(new Edge(kiel, luebeck, 84));
            karte.addEdge(new Edge(luebeck, hamburg, 74));
            karte.addEdge(new Edge(luebeck, berlin, 284));
            karte.addEdge(new Edge(berlin, hamburg, 289));
            karte.addEdge(new Edge(hamburg, bremen, 119));
            karte.addEdge(new Edge(bremen, hannover, 122));
            karte.addEdge(new Edge(hannover, hamburg, 150));
            karte.addEdge(new Edge(berlin, hannover, 290));
            karte.addEdge(new Edge(berlin, leipzig, 188));
            karte.addEdge(new Edge(hannover, kassel, 167));
            karte.addEdge(new Edge(leipzig, kassel, 250));
            karte.addEdge(new Edge(kassel, dortmund, 160));
            karte.addEdge(new Edge(dortmund, bremen, 234));
            karte.addEdge(new Edge(dortmund, hannover, 210));
            karte.addEdge(new Edge(dortmund, bochum, 22));
            karte.addEdge(new Edge(dortmund, koeln, 107));
            karte.addEdge(new Edge(koeln, bochum, 82));
            karte.addEdge(new Edge(koeln, bonn, 29));
            karte.addEdge(new Edge(bonn, mainz, 169));
            karte.addEdge(new Edge(frankfurt, mainz, 45));
            karte.addEdge(new Edge(frankfurt, kassel, 193));
            karte.addEdge(new Edge(leipzig, nuernberg, 278));
            karte.addEdge(new Edge(kassel, wuerzburg, 209));
            karte.addEdge(new Edge(wuerzburg, nuernberg, 110));
            karte.addEdge(new Edge(wuerzburg, frankfurt, 119));
            karte.addEdge(new Edge(nuernberg, muenchen, 166));
            karte.addEdge(new Edge(muenchen, stuttgart, 223));
            karte.addEdge(new Edge(nuernberg, stuttgart, 208));
            karte.addEdge(new Edge(stuttgart, karlsruhe, 82));
            karte.addEdge(new Edge(karlsruhe, frankfurt, 147));
            karte.addEdge(new Edge(frankfurt, koeln, 189));
            karte.switchToISOMLayout();
         }
  
	/**
	 * ordnet die Knoten auf der Karte neu an.
	 * fuer den Fall, dass es da Ueberschneidungen gibt.
	 */
	public void _neuAnordnen() {
		karte.switchToISOMLayout();
	}
	

    public static void main(String[] args) {
       DijkstraTest dt = new DijkstraTest();
       new GUI(dt);
    }
}