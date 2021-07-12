package mathe;

import java.awt.*;
import javax.swing.*;
 
public class SaeulenDiagrammJPanel extends JPanel {
  private double[] values;
  private String[] labels;
  private Color[] colors;
  private String title;
  private double minValue;
  private double maxValue;
  private int anzahlAngezeigteLabels = 8;
 
  public SaeulenDiagrammJPanel(double[] values, String[] labels, Color[] colors, String title) {
	this.values = values;
    this.labels = labels;
    if(this.labels == null){
    	this.labels = new String[values.length];
    	for(int i=0; i<this.labels.length; i++){
    		this.labels[i] = ".";
    	}
    }
    this.colors = colors;
    if(this.colors == null){
    	this.colors = new Color[values.length];
    	for(int i=0; i<this.colors.length; i++){
    		this.colors[i] = Color.DARK_GRAY;
    	}
    }
    this.title = title;
    if(this.title == null){
    	this.title = "";
    }
    if(this.title.length() > 0){
    	this.title += "; ";
    }

	minValue = 0;
	maxValue = 0;
    for (int i = 0; i < values.length; i++) {
      if (minValue > values[i]) {
        minValue = values[i];
      }
      if (maxValue < values[i]) {
        maxValue = values[i];
      }
    }
    
    
    this.title += ("MinValue: "+minValue+"; MaxValue: "+maxValue);
  }
 
  public double getMinValue(){
	  return minValue;
  }
  
  public double getMaxValue(){
	  return maxValue;
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (values == null || values.length == 0) {
      return;
    }
 
 
    Dimension dim = getSize();
    int panelWidth = dim.width;
    int panelHeight = dim.height;
    int barWidth = panelWidth / values.length;
 
    Font titleFont = new Font("Book Antiqua", Font.BOLD, 15);
    FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
 
    Font labelFont = new Font("Book Antiqua", Font.PLAIN, 14);
    FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);
 
    int titleWidth = titleFontMetrics.stringWidth(title);
    int stringHeight = titleFontMetrics.getAscent();
    int stringWidth = (panelWidth - titleWidth) / 2;
    g.setFont(titleFont);
    g.drawString(title, stringWidth, stringHeight);
 
    int top = titleFontMetrics.getHeight();
    int bottom = labelFontMetrics.getHeight();
    if (maxValue == minValue) {
      return;
    }
    double scale = (panelHeight - top - bottom) / (maxValue - minValue);
    stringHeight = panelHeight - labelFontMetrics.getDescent();
    g.setFont(labelFont);
    for (int j = 0; j < values.length; j++) {
      int valueP = j * barWidth + 1;
      int valueQ = top;
      int height = (int) (values[j] * scale);
      if (values[j] >= 0) {
        valueQ += (int) ((maxValue - values[j]) * scale);
      } else {
        valueQ += (int) (maxValue * scale);
        height = -height;
      }
 
      g.setColor(colors[j]);
      g.fillRect(valueP, valueQ, barWidth - 2, height);
      g.setColor(Color.black);
      g.drawRect(valueP, valueQ, barWidth - 2, height);
 
      int labelAbstand = labels.length/this.anzahlAngezeigteLabels;
      if(labelAbstand == 0) labelAbstand = 1;
      
      if(j % (labelAbstand) == 0){
	      int labelWidth = labelFontMetrics.stringWidth(labels[j]);
	      stringWidth = j * barWidth + (barWidth - labelWidth) / 2;
	      g.drawString(labels[j], stringWidth, stringHeight);
      }
    }
  }
 
}
