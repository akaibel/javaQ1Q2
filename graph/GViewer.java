package graph;
/*
 * @author: a. kaibel, a.kaibel@googlemail.com
 * 
 * This project uses the JUNG library.
 * 
 * see either "license.txt"
 * or http://jung.sourceforge.net/license.txt for a description.
 *
 */

import _config.Configuration;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Hashtable;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.ISOMLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ScalingControl;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.layout.LayoutTransition;
import edu.uci.ics.jung.visualization.renderers.EdgeLabelRenderer;
import edu.uci.ics.jung.visualization.renderers.Renderer;
import edu.uci.ics.jung.visualization.renderers.VertexLabelRenderer;
import edu.uci.ics.jung.visualization.renderers.Renderer.Vertex;
import edu.uci.ics.jung.visualization.transform.shape.GraphicsDecorator;
import edu.uci.ics.jung.visualization.util.Animator;

public class GViewer extends JFrame implements VertexListener, EdgeListener {


	private static final int SIZE = 600;


	private static int FRAME_NUMBER = 1;
	private static int EDGE_NUMBER = 1;
	
	
	private String layoutType;
	Layout<String, Integer> layout;

	private static String CIRCLE_LAYOUT = "circlelayout";
	private static String ISOM_LAYOUT = "isomlayout";
	private static final long SWITCH_LAYOUT_SLEEP = 500;
	
	/**
	 * the graph
	 */
	Graph<String,Integer> graph;

	/**
	 * the visual component and renderer for the graph
	 */
	VisualizationViewer<String,Integer> vv;


	/**
	 */

	MyVertexRenderer<String, Integer> vertexRenderer;
	VertexLabelRenderer vertexLabelRenderer;

	Hashtable<String, Boolean> vertexMarked;

	EdgeLabelRenderer edgeLabelRenderer;
	Hashtable<Integer, Edge> edgesHashtable;

	ScalingControl scaler = new CrossoverScalingControl();
	
	String licenseText = "This project uses the JUNG library. See license.txt for details";


	/**
	 * create an instance of a simple graph with controls to
	 * demo the label positioning features
	 *
	 */
	@SuppressWarnings("serial")
	public GViewer() {
		this.getContentPane().setLayout(new BorderLayout());
		JLabel licenseLabel = new JLabel(licenseText);
		licenseLabel.setFont(new Font("Arial", 10, 10));
		this.getContentPane().add(licenseLabel, BorderLayout.SOUTH);
		
		edgesHashtable = new Hashtable<Integer, Edge>();

		vertexMarked = new Hashtable<String, Boolean>();

		// create a simple graph for the demo
		graph = new SparseMultigraph<String,Integer>();
		
		this.layoutType = GViewer.CIRCLE_LAYOUT;
		layout = new CircleLayout<String,Integer>(graph);

		vv =  new VisualizationViewer<String,Integer>(layout, new Dimension(SIZE,SIZE));
		vv.setBackground(Color.white);

		vertexRenderer = new MyVertexRenderer<String,Integer>();
		vv.getRenderer().setVertexRenderer(vertexRenderer);

		vertexLabelRenderer = vv.getRenderContext().getVertexLabelRenderer();
		edgeLabelRenderer = vv.getRenderContext().getEdgeLabelRenderer();
		edgeLabelRenderer.setRotateEdgeLabels(true);


		Transformer<Integer,String> stringer = new Transformer<Integer,String>(){
			public String transform(Integer e) {
				return getEdgeName(e);
			}

		};
		
        Transformer<Integer, Paint> edgeColorTransformer = new Transformer<Integer, Paint>()
        {
            @Override
            public Paint transform(Integer i)
            {
            	Edge e = edgesHashtable.get(i);  
                if (e.isMarked())
                {
                    return Color.RED;
                }
                return Color.BLACK;
            }
        };
        
        Transformer<Integer, Stroke> edgeStrokeTransformer = new Transformer<Integer, Stroke>() {
            float dash[] = { 10.0f };
            public Stroke transform(Integer i) {
            	Edge e = edgesHashtable.get(i);  
                if (e.isMarked())
                {
                	 return new BasicStroke(3.0f);                
                }
                else{
                	return new BasicStroke();                	
                }
            }
        };        
		
		vv.getRenderContext().setEdgeLabelTransformer(stringer);
        vv.getRenderContext().setEdgeDrawPaintTransformer(edgeColorTransformer);
        vv.getRenderContext().setEdgeStrokeTransformer(edgeStrokeTransformer);
        vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line<String,Integer>());

		vv.getRenderer().getVertexLabelRenderer().setPosition(Renderer.VertexLabel.Position.CNTR);
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<String>());


		// create a frame to hold the graph
		GraphZoomScrollPane panel = new GraphZoomScrollPane(vv);
		getContentPane().add(panel, BorderLayout.CENTER);


		final DefaultModalGraphMouse<String,Integer> graphMouse = new DefaultModalGraphMouse<String,Integer>();
		vv.setGraphMouse(graphMouse);
		graphMouse.setMode(ModalGraphMouse.Mode.PICKING);

		this.setTitle("Graph "+FRAME_NUMBER);
		this.setLocation(FRAME_NUMBER*10, FRAME_NUMBER*10);
		FRAME_NUMBER++;

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocation(450, 0);
		this.setVisible(true);
		this.toFront();
	}
	
	public void updateGraph(){
		if(this.layoutType == GViewer.CIRCLE_LAYOUT){
			layout = new CircleLayout<String,Integer>(graph);
		}
		else if(this.layoutType == GViewer.ISOM_LAYOUT){
			layout = new ISOMLayout<String,Integer>(graph);
		}
		else{
			System.err.println("GViewer.updateGraph(): unbekannter layoutType: "+layoutType);
			return;
		}
		LayoutTransition lt =
            new LayoutTransition(vv, vv.getGraphLayout(), layout);
        Animator animator = new Animator(lt);
        animator.start();
        vv.repaint();	
	}
	
	public void switchToCircleLayout(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		this.layoutType = GViewer.CIRCLE_LAYOUT;
		updateGraph();
	}
	
	public void switchToISOMLayout(){
		try {
			Thread.sleep(SWITCH_LAYOUT_SLEEP);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		this.layoutType = GViewer.ISOM_LAYOUT;
		updateGraph();
		try {
			Thread.sleep(SWITCH_LAYOUT_SLEEP);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		//JOptionPane.showMessageDialog(this, "weiter! (Veraenderung stoppen)");
		if(this.layoutType == GViewer.ISOM_LAYOUT){
			layout = new StaticLayout(graph, vv.getGraphLayout());
			LayoutTransition lt = new LayoutTransition(vv, vv.getGraphLayout(), layout);
			Animator animator = new Animator(lt);
			animator.start();
			vv.repaint();
		}
		try {
			Thread.sleep(SWITCH_LAYOUT_SLEEP);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	public static void warte() {
		try {
			Thread.sleep(Configuration.WARTEZEIT_GRAPH);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	public void addVertex(String name){
		graph.addVertex(name);
		updateGraph();
	}

	public void removeVertex(String name){
		graph.removeVertex(name);
		updateGraph();
		warte();
	}

	public void addEdge(Edge e){
		this.edgesHashtable.put(EDGE_NUMBER, e);
		graph.addEdge(EDGE_NUMBER, e.getVertices()[0].getID(), e.getVertices()[1].getID());
		EDGE_NUMBER++;
		vv.repaint();
	}

	public void removeEdge(String node1, String node2) { 
		int edgeNumber = graph.findEdge(node1, node2);
		graph.removeEdge(edgeNumber);
		edgesHashtable.remove(edgeNumber);
		vv.repaint();
	}


	private String getEdgeName(Integer edgeNumber) {
		return ""+edgesHashtable.get(edgeNumber).getWeight();
	}
	

	private void markVertex(String vertex, boolean value){
		this.vertexMarked.put(vertex, value);
		vv.repaint();
	}	

	private void markEdge(Edge pEdge, boolean value){
		vv.repaint();
	}

	private boolean isMarked(String vertex) {
		Boolean result = this.vertexMarked.get(vertex);
		if(result == null){
			return false;
		}
		return result;
	}
	
	private boolean isMarked(Edge edge) {
		return edge.isMarked();
	}
	

	

	private class MyVertexRenderer<S1,I1> implements Vertex<S1, I1> {
		
		public void paintVertex(RenderContext<S1, I1> rc,
				Layout<S1, I1> layout, S1 vertex) {
			GraphicsDecorator graphicsContext = rc.getGraphicsContext();
			Point2D center = layout.transform(vertex);
			Shape shape = new Ellipse2D.Double(center.getX()-30, center.getY()-15, 60, 30);
			Color color = Color.yellow;
			if(isMarked(vertex.toString())){
				color = Color.RED;
			}
			graphicsContext.setPaint(color);
			graphicsContext.fill(shape);			
		}

	}


	private class MyStringLabeller<T> extends ToStringLabeller<T>{
		public String transform(Object name){
			return (name.toString());
		}

	}

	
	public void vertexMarkChanged(String nodeName, boolean marked) {
		this.markVertex(nodeName, marked);
		warte();
	}
	
	public void edgeMarkChanged(Edge pEdge, boolean marked) {
		this.markEdge(pEdge, marked);
		warte();
	}
	
}