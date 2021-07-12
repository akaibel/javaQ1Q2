package graph;


public class DijkstraInfo{

   private Vertex vertex;
   private double distanz;
   private Vertex vorgaenger;
  
   public DijkstraInfo(Vertex pVertex, double pDistanz, Vertex pVorgaenger){
       this.vertex = pVertex;
       this.distanz = pDistanz;
       this.vorgaenger = pVorgaenger;
   }

   public Vertex getVertex(){
       return vertex;
   }
  
   public double getDistanz() {
       return distanz;
   }

   public void setDistanz(double distanz) {
       this.distanz = distanz;
   }

   public Vertex getVorgaenger() {
       return vorgaenger;
   }

   public void setVorgaenger(Vertex vorgaenger) {
       this.vorgaenger = vorgaenger;
   }

    public String toString() {
       if(vorgaenger != null){
           return vertex.getID() + ", " + distanz + ", Vorg.: "    + vorgaenger.getID();   
       }
       else{
           return vertex.getID() + ", " + distanz + ", Vorg.: ---";
       }  
   }
}