/**
 * @author: a. kaibel (a.kaibel@googlemail.com), n.seeliger (niklas_seeliger@icloud.com)
 * @acknowledgements: Niklas substantially improved this class by fixing bugs that always showed up when starting this class!
 *
 */

package graph;



 
public class GraphWithViewer extends Graph{
	private GViewer viewer;

	
    /**
     * Ein neuer Graph wird erzeugt. 
     * Er enthaelt noch keine Knoten.
     */
    public GraphWithViewer() {
    	super();
    	viewer = new GViewer();
    }
    

    /**
     * Der Knoten pVertex wird dem Graphen hinzugefuegt. 
     * Falls bereits ein Knoten mit gleichem Namen im 
     * Graphen existiert, wird dieser Knoten nicht eingefuegt. 
     * Falls pVertex null ist, veraendert sich der Graph nicht. 
     * @param pVertex neuer Knoten
     */
    public void addVertex(Vertex pVertex) {
    	super.addVertex(pVertex);
    	viewer.addVertex(pVertex.getID());
    	pVertex.setGraphVertexListener(viewer);
    }  

    /**
     * Falls pVertex ein Knoten des Graphen ist, so werden er und alle 
     * mit ihm verbundenen Kanten aus dem Graphen entfernt. 
     * Sonst wird der Graph nicht veraendert.
     * @param pVertex Knoten
     */   
    public void removeVertex(Vertex pVertex) {
    	super.removeVertex(pVertex);
    	viewer.removeVertex(pVertex.getID());
    }

    /**
     * fuegt die Kante pEdge in den Graphen ein, 
     * sofern beide durch die Kante verbundenen Knoten im Graphen enthalten sind, 
     * nicht identisch sind und noch keine Kante zwischen den beiden Knoten existiert.
     * Ansonsten passiert nichts. 
     */
    public void addEdge(Edge pEdge) {       
    	super.addEdge(pEdge);
    	viewer.addEdge(pEdge);
    	pEdge.setGraphEdgeListener(viewer);
    }

    /**
     * Entfernt die Kante pEdge aus dem Graphen. 
     * Ist die Kante nicht im Graphen, passiert nichts. 
     * @param pEdge
     */
    public void removeEdge(Edge pEdge) {
    	super.removeEdge(pEdge);
    	viewer.removeEdge(pEdge.getVertices()[0].getID(), pEdge.getVertices()[1].getID());
    }

    public void switchToCircleLayout(){
    	viewer.switchToCircleLayout();
    }
    
    public void switchToISOMLayout(){
    	viewer.switchToISOMLayout();
    }


}