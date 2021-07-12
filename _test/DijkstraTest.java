package _test;

import linear.List;
import graph.DijkstraInfo;
import graph.Edge;
import graph.Vertex;
import gui.GUI;
import graph.GraphWithViewer;
import linear.ListWithViewer;

public class DijkstraTest {
   private GraphWithViewer graph;
   private List<DijkstraInfo> gelbeListe;
   private List<DijkstraInfo> roteListe;
  
   public DijkstraTest(){
       initMap();
   }
  
   public List<DijkstraInfo> dijkstraAlgorithmus(String sStart){
       roteListe = new ListWithViewer<DijkstraInfo>();
       gelbeListe = new ListWithViewer<DijkstraInfo>();
       Vertex vStart = graph.getVertex(sStart);
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
            graph = new GraphWithViewer();
            Vertex kiel = new Vertex("Kiel");
            graph.addVertex(kiel);
            Vertex luebeck = new Vertex("Luebeck");
            graph.addVertex(luebeck);
            Vertex hamburg = new Vertex("Hamburg");
            graph.addVertex(hamburg);
            Vertex berlin = new Vertex("Berlin");
            graph.addVertex(berlin);
            Vertex bremen = new Vertex("Bremen");
            graph.addVertex(bremen);
            Vertex hannover = new Vertex("Hannover");
            graph.addVertex(hannover);
            Vertex dortmund = new Vertex("Dortmund");
            graph.addVertex(dortmund);
            Vertex bochum = new Vertex("Bochum");
            graph.addVertex(bochum);
            Vertex koeln = new Vertex("Koeln");
            graph.addVertex(koeln);
            Vertex bonn = new Vertex("Bonn");
            graph.addVertex(bonn);
            Vertex mainz = new Vertex("Mainz");
            graph.addVertex(mainz);
            Vertex frankfurt = new Vertex("Frankfurt");
            graph.addVertex(frankfurt);
            Vertex kassel = new Vertex("Kassel");
            graph.addVertex(kassel);
            Vertex wuerzburg = new Vertex("Wuerzburg");
            graph.addVertex(wuerzburg);
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
           
            graph.addEdge(new Edge(kiel, hamburg, 97));
            graph.addEdge(new Edge(kiel, luebeck, 84));
            graph.addEdge(new Edge(luebeck, hamburg, 74));
            graph.addEdge(new Edge(luebeck, berlin, 284));
            graph.addEdge(new Edge(berlin, hamburg, 289));
            graph.addEdge(new Edge(hamburg, bremen, 119));
            graph.addEdge(new Edge(bremen, hannover, 122));
            graph.addEdge(new Edge(hannover, hamburg, 150));
            graph.addEdge(new Edge(berlin, hannover, 290));
            graph.addEdge(new Edge(berlin, leipzig, 188));
            graph.addEdge(new Edge(hannover, kassel, 167));
            graph.addEdge(new Edge(leipzig, kassel, 250));
            graph.addEdge(new Edge(kassel, dortmund, 160));
            graph.addEdge(new Edge(dortmund, bremen, 234));
            graph.addEdge(new Edge(dortmund, hannover, 210));
            graph.addEdge(new Edge(dortmund, bochum, 22));
            graph.addEdge(new Edge(dortmund, koeln, 107));
            graph.addEdge(new Edge(koeln, bochum, 82));
            graph.addEdge(new Edge(koeln, bonn, 29));
            graph.addEdge(new Edge(bonn, mainz, 169));
            graph.addEdge(new Edge(frankfurt, mainz, 45));
            graph.addEdge(new Edge(frankfurt, kassel, 193));
            graph.addEdge(new Edge(leipzig, nuernberg, 278));
            graph.addEdge(new Edge(kassel, wuerzburg, 209));
            graph.addEdge(new Edge(wuerzburg, nuernberg, 110));
            graph.addEdge(new Edge(wuerzburg, frankfurt, 119));
            graph.addEdge(new Edge(nuernberg, muenchen, 166));
            graph.addEdge(new Edge(muenchen, stuttgart, 223));
            graph.addEdge(new Edge(nuernberg, stuttgart, 208));
            graph.addEdge(new Edge(stuttgart, karlsruhe, 82));
            graph.addEdge(new Edge(karlsruhe, frankfurt, 147));
            graph.addEdge(new Edge(frankfurt, koeln, 189));
            graph.switchToISOMLayout();
         }
    
    public static void main(String[] args) {
       DijkstraTest dt = new DijkstraTest();
       new GUI(dt);
    }
}