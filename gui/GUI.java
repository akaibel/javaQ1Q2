package gui;



/**
 * (c) Andreas Kaibel
 * Siebengebirgsgymnasium Bad Honnef
 * a.kaibel@googlemail.com
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BoxLayout;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import _config.Configuration;

/**
 * eine Benutzeroberflaeche fuer Objekte beliebiger Klassen.
 * @author akaibel
 *
 */
public class GUI extends JFrame {
    private static final long serialVersionUID = 4380161375242238507L;
    private static final int maxAnzahlBuchstaben = 30;
    private static final int maxAnzahlZeilen = 20;
    
    public static Vector<GUI> alleGUIs = new Vector<>();

    protected Object dasObjekt;
    protected String klassenNameMitPackage;
    protected SchriftgroessenLabel[] fieldLabels;
    private Field[] fields;
    
    private Vector<SchriftgroessenLabel> labelVector;
    
    private static String linie = "-----------------------";
    
    /**
     * x-Position des ersten GUI Fensters
     */
    private static int xPositionFirst=-1;
    
    /**
     * x-Position des naechsten GUI Fenster, das erzeugt wird
     */
    private static int xPosition;
    /**
     * y-Position von allen GUI-Fenstern
     */
    private static int yPosition;
    
    private boolean methodeInAusfuehrung;

    private JSlider speedSlider;
	private static final int WARTEZEITSLIDER_PREFERRED_WIDTH = 50;

	/**
	 * Name der Variablen aus Configuration.java, deren Wert mit dem Slider angepasst werden kann.
	 */
    private String configurationWaitingTimeVariable;
    
    public GUI(Object pObject) {
        super();
        dasObjekt = pObject;
        labelVector = new Vector<>();
        methodeInAusfuehrung = false;
        initGUI();
        alleGUIs.addElement(this);
    }

    /**
     * erzeugt eine GUI fuer ein Objekt und zeigt einen Slider für die Variable aus Configuration.java an.
     * @param pObject
     * @param configurationWaitingTimeVariable die Variable aus Configuration.java, die im Slider angezeigt wird und veraendert werden kann.
     */
    public GUI(Object pObject, String configurationWaitingTimeVariable) {
        super();
        this.configurationWaitingTimeVariable = configurationWaitingTimeVariable;
        dasObjekt = pObject;
        labelVector = new Vector<>();
        methodeInAusfuehrung = false;
        initGUI();
        initSpeedSlider();
        alleGUIs.addElement(this);
    }

    private void initGUI() {
        Configuration.READ_AND_START_UPDATING_CONFIGURATION();
    	if(xPositionFirst == -1) {
    		xPositionFirst = Configuration.GUI_POS_X;
    		xPosition = Configuration.GUI_POS_X;
    		yPosition = Configuration.GUI_POS_Y;
    	}
        try {
            BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS);
            getContentPane().setLayout(thisLayout);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            getContentPane().setBackground(Color.white);

            klassenNameMitPackage = dasObjekt.getClass().getName();
            String klassenName = this.packageBezeichnungEntfernen(klassenNameMitPackage);
            String classNameForLabel = "public class " + klassenName;
            SchriftgroessenLabel classNameLabel = new SchriftgroessenLabel(classNameForLabel);
            this.getContentPane().add(classNameLabel);
            SchriftgroessenLabel linieLabel1 = new SchriftgroessenLabel(linie);
            this.getContentPane().add(linieLabel1);

            fields = dasObjekt.getClass().getDeclaredFields();

            this.fieldLabels = new SchriftgroessenLabel[fields.length];

            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                fieldLabels[i] = new SchriftgroessenLabel("---");
                this.getContentPane().add(fieldLabels[i]);
            }
            attributeUpdaten();

            SchriftgroessenLabel linieLabel2 = new SchriftgroessenLabel(linie);
            this.getContentPane().add(linieLabel2);

            Constructor<?>[] constructors = dasObjekt.getClass().getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                String constructorSignatur = this.methodenSignaturVereinfachen(constructor.toGenericString());
                SchriftgroessenLabel constructorLabel = new SchriftgroessenLabel(constructorSignatur);
                this.getContentPane().add(constructorLabel);
            }

            Method[] methods = dasObjekt.getClass().getDeclaredMethods();
            Vector<MethodLabel> methodLabelVector = new Vector<>();
            for (Method method : methods) {
                method.setAccessible(true);
                MethodLabel methodLabel = new MethodLabel(method);
                methodLabelVector.add(methodLabel);
            }
            java.util.Collections.sort(methodLabelVector);
            for (MethodLabel methodLabel : methodLabelVector) {
                this.getContentPane().add(methodLabel);
            }

            schriftgroesseSetzen(Configuration.FONT_SIZE);
            pack();

            this.setLocation(xPosition, yPosition);
            xPosition += (this.getWidth() + 10);
            setVisible(true);
            this.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    System.exit(0);
                }
            });

            this.addWindowFocusListener(new WindowFocusListener() {
                public void windowGainedFocus(WindowEvent arg0) {
                    attributeMeineUpdaten();
                }

                @Override
                public void windowLostFocus(WindowEvent arg0) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        
     // Inside your JFrame or main panel setup
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getRootPane().getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, InputEvent.CTRL_DOWN_MASK), "increaseFont");
        actionMap.put("increaseFont", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
				Configuration.FONT_SIZE++;
                schriftgroesseSetzen(Configuration.FONT_SIZE);
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, InputEvent.CTRL_DOWN_MASK), "decreaseFont");
        actionMap.put("decreaseFont", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
				Configuration.FONT_SIZE--;
                schriftgroesseSetzen(Configuration.FONT_SIZE);
            }
        });
        
	    this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
            	// nur die Position der ersten GUI wird in Configuration gespeichert.
            	GUI currentGUI = GUI.this;
            	GUI firstGUI = currentGUI;
            	if(!alleGUIs.isEmpty())
            		firstGUI = alleGUIs.get(0);
            	if(firstGUI == currentGUI) {
	                Configuration.GUI_POS_X = getLocation().x;
	                Configuration.GUI_POS_Y = getLocation().y;          	
            	}
            }
        });			


    }

    private void initSpeedSlider() {
    	int wartezeit = 50;  
    	try {
    	        // Use reflection to update the specified static field in Configuration
    	        Field configField = Configuration.class.getDeclaredField(configurationWaitingTimeVariable);
    	        configField.setAccessible(true);
    	        wartezeit = configField.getInt(null);
    	    } catch (Exception ex) {
    	        ex.printStackTrace();
    	    }    	
        speedSlider = new JSlider(0, Configuration.MAX_WARTEZEIT, Configuration.MAX_WARTEZEIT - wartezeit);
        speedSlider.setPreferredSize(new Dimension(WARTEZEITSLIDER_PREFERRED_WIDTH, speedSlider.getPreferredSize().height));
        speedSlider.addChangeListener(e -> {
            int newSpeed = speedSlider.getValue();
            updateWartezeit(Configuration.MAX_WARTEZEIT- newSpeed);
        });

        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new BorderLayout());
        sliderPanel.add(speedSlider, BorderLayout.CENTER);

        this.getContentPane().add(sliderPanel);
        this.pack(); // Ensure the JFrame resizes to fit the slider
    }

    private void updateWartezeit(int neueWartezeit) {
	  try {
	        // Use reflection to update the specified static field in Configuration
	        Field configField = Configuration.class.getDeclaredField(configurationWaitingTimeVariable);
	        configField.setAccessible(true);
	        configField.setInt(null, neueWartezeit); // Update static field
	        // falls die Wartezeit bei Baeumen oder Graphen geaendert wird
	        // dann auch die lineare Wartezeit veraendern.
	        if(configurationWaitingTimeVariable.equals("WARTEZEIT_BAEUME") ||
	        		configurationWaitingTimeVariable.equals("WARTEZEIT_GRAPH")) {
		        configField = Configuration.class.getDeclaredField("WARTEZEIT_LINEAR");
		        configField.setAccessible(true);
		        configField.setInt(null, neueWartezeit); // Update static field	        	
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }    
	  }


  /**
   * setzt die Schriftgroesse aller Label auf pFontSize
   * @param pFontSize
   */
  private void schriftgroesseSetzen(int pFontSize) {
    for(SchriftgroessenLabel sgl: labelVector){
      sgl.schriftgroesseSetzen(pFontSize);
    }
    this.pack();
  }

  /**
   * aktualisiert die Darstellung der Attribute
   */
  private void attributeUpdaten() {
    attributeMeineUpdaten();
    attributeAndereGUIsUpdaten();
  }

  private void attributeMeineUpdaten(){
    for(int i=0; i<fields.length; i++){
      Field field = fields[i];

      Class<?> fieldType = field.getType();
      String fieldTypeString = fieldType.getSimpleName();
      String fieldName = field.getName();
      Object fieldValue = null;
      String fieldValueString = "FEHLER!";
      try {
        fieldValue = field.get(dasObjekt);
      } catch (IllegalArgumentException | IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        continue;
      }

      String fieldString;
      try {
        if(fieldType.isArray()){
          fieldValueString = stringDarstellungVonArray(fieldValue);
        } // end if
        else{
          // einfacher Datentyp oder Objekt
            fieldValueString = stringDarstellung(fieldValue);
        } // end else
        int modifiers = field.getModifiers();
        String modifierString = "public";
        if(Modifier.isPrivate(modifiers)){
          modifierString = "private";
        }
        else if(Modifier.isProtected(modifiers)){
          modifierString = "protected";
        }
        fieldString = methodenSignaturVereinfachen(modifierString+" "+fieldTypeString +" "+ fieldName)+"= "+fieldValueString;
      } catch (NullPointerException npe) {
        // TODO Auto-generated catch block
        fieldString = "null";
      }
      fieldLabels[i].setText(fieldString);

    }

  }

  private void attributeAndereGUIsUpdaten(){
    for(GUI g: alleGUIs){
      if(g != this){
        g.attributeMeineUpdaten();
      }
    }
  }

  private String stringDarstellung(Object object) {
    if(object == null){
      return "null";
    }
    String ergebnis = object.toString();
    try {
      if(object instanceof String){
        ergebnis = "\""+ergebnis+"\"";
      }
      else if(object instanceof Character){
        ergebnis = "'"+ergebnis+"'";
      }
      else if(object instanceof Object[] || ergebnis.getClass().isArray()){
        //System.out.println("Array");
      }
    } catch (Exception e) {
      e.printStackTrace();
      return "FEHLER!";
    }
    if(ergebnis.length() > GUI.maxAnzahlBuchstaben){
      ergebnis = aufMaximalLaengeBringen(ergebnis);
    }
    return ergebnis;
  }

  /**
   * stellt ein Array als String dar.
   * @param object muss ein Array sein.
   * @return eine String-Darstellung
   */
  private String stringDarstellungVonArray(Object object) {
    String fieldValueString = "{";
    int length = -1;
        if(object instanceof Object[])
        {
            length = ((Object[])object).length;
        }
        else{
          length = Array.getLength(object);
        }
    for(int j=0; j<length; j++){
      Object element = null;
      if(object instanceof Object[]){
        element = ((Object[])object)[j];
      }
      else{
        element = Array.get(object,  j);
      }
      fieldValueString += this.stringDarstellung(element)+",";
    }
    if(fieldValueString.endsWith(",")){
      fieldValueString = fieldValueString.substring(0,fieldValueString.length()-1);
    }
    fieldValueString += "}";
    if(fieldValueString.length() > GUI.maxAnzahlBuchstaben){
        fieldValueString = aufMaximalLaengeBringen(fieldValueString);
    }
    return fieldValueString;
  }

  /**
   * schneidet ggf. von string ab, wenn er zu lang ist.
   * Am Ende wird stattdessen ... eingesetzt.
   * @param string
   * @return
   */
  private String aufMaximalLaengeBringen(String string) {
    String result = "";
    int i=0;
    while(string.length() > maxAnzahlBuchstaben && i < maxAnzahlZeilen){
      
      result += string.substring(0, maxAnzahlBuchstaben);
      result += "\n";
      string = string.substring(maxAnzahlBuchstaben,string.length());
      i++;
    }
    if(i<maxAnzahlZeilen){
    	result += string;
    }
    else{
    	result += ".....\"";
    }
    
    return result;
  }


  /**
   * entfernt aus einer Bezeichnung mit package (z.B. java.lang.String) das package
   * (als Rest bliebe String)
   * @param bezeichnungMitPackage
   * @return
   */
  protected String packageBezeichnungEntfernen(String bezeichnungMitPackage){
    int positionPunkt = bezeichnungMitPackage.lastIndexOf(".");
    String bezeichnung = bezeichnungMitPackage.substring(positionPunkt + 1);
    return bezeichnung;
  }

  protected void fehlerMeldung(String pFehlerBeschreibung) {
    JOptionPane.showMessageDialog(this, pFehlerBeschreibung, "Fehler!", JOptionPane.ERROR_MESSAGE);

  }

  /**
   * Wandelt einen String in ein Objekt um.
   * @param pString der String, der umgewandelt werden soll.
   * @param pType der Typ des Objektes, in das der String umgewandelt werden soll.
   * @return ein Objekt bzw. null bei Misserfolg
   */
  protected Object inPrimitivenTypUmwandeln(String pString, Class<?> pType) {
    try {
      if(pType == Double.TYPE){
        return Double.parseDouble(pString);
      }
      if(pType == Integer.TYPE){
        return Integer.parseInt(pString);
      }
      if(pType == Long.TYPE){
        return Long.parseLong(pString);
      }
      if(pType == Short.TYPE){
        return Short.parseShort(pString);
      }
      if(pType == Float.TYPE){
        return Float.parseFloat(pString);
      }
      if(pType == Boolean.TYPE){
        return Boolean.parseBoolean(pString);
      }
      if(pType == Character.TYPE){
        if(isCharDarstellung(pString)){
          return pString.charAt(1);
        }
      }
    } catch (NumberFormatException e) {
      e.printStackTrace();
      this.fehlerMeldung("Konnte "+pString+ " nicht in "+pType.getSimpleName()+" umwandeln");
      return null;
    }
    return null;
  }


  private String methodenSignaturVereinfachen(String pSignatur) {
    String vereinfachung1 = pSignatur.replace(GUI.this.klassenNameMitPackage+".", "");
    vereinfachung1 = vereinfachung1.replace("(", " ( ");
    vereinfachung1 = vereinfachung1.replace(",", ", ");
    // jetzt die Packages beim RueckgabeTyp und bei Parametern raushauen
    String[] splits = vereinfachung1.split(" ");
    String ergebnis = "";
    for(String split:splits){
      if(split.contains(".")){
        String s = packageBezeichnungEntfernen(split);
        ergebnis += s+ " ";
      }
      else{
        ergebnis += split+" ";
      }
    }
    ergebnis = ergebnis.replace("( ", "(");
    return ergebnis;
  }


  /**
   * ueberprueft, ob ein String ein char (mit zwei Hochkommas!) darstellt.
   * z.B. "'a'" ist Darstellung eines char
   * @param pString
   * @return
   */
  public boolean isCharDarstellung(String pString) {
    if(!pString.startsWith("'")||!pString.endsWith("'")){
      return false;
    }
    if(pString.length() != 3){
      return false;
    }
    return true;
  }

  /**
   * ueberprueft, ob pString eine double-Zahl darstellt
   * @param pString
   * @return
   */
  public boolean isDoubleDarstellung(String pString) {
    try {
      Double.parseDouble(pString);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  /**
   * ueberprueft, ob pString eine int-Zahl darstellt
   * @param pString
   * @return
   */
  public boolean isIntDarstellung(String pString) {
    try {
      Integer.parseInt(pString);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  /**
   * ueberprueft, ob der Parameter einen String (mit Anfuehrungszeichen) darstellt.
   * z.B. "Hallo"
   * @param pString
   * @return
   */
  public boolean isStringDarstellung(String pString) {
    if (pString.startsWith("\"") && pString.endsWith("\"")) {
      return true;
    }
    return false;
  }

  /**
   * fuegt ein SchriftGroessenLabel zum labelVector hinzu
   * @param pLabel
   */
  public void addLabel(SchriftgroessenLabel pLabel) {
    this.labelVector.add(pLabel);
  }



  /**
   * Jede Methode wird durch ein eigenes MethodLabel dargestellt.
   * @author akaibel
   *
   */
  private class MethodLabel extends SchriftgroessenLabel implements Comparable<MethodLabel>{
    private static final long serialVersionUID = -6381312183487108280L;

    /**
     * die Methode, die dargestellt werden soll
     */
    private Method myMethod;

    private String methodenSignatur;

    public MethodLabel(Method pMethod) {
      super();
      myMethod = pMethod;
      methodenSignatur = methodenSignaturVereinfachen(pMethod.toString());

      super.setText(methodenSignatur);

      this.addMouseListener(new MouseListener(){
        public void mouseClicked(MouseEvent arg0) {
          if(!methodeInAusfuehrung){
            new MethodenAusfuehrer(myMethod).start();
          }
        }

        public void mouseEntered(MouseEvent arg0) {
          setForeground(Color.BLUE);
        }

        public void mouseExited(MouseEvent arg0) {
          setForeground(Color.black);
        }

        public void mousePressed(MouseEvent arg0) {}

        public void mouseReleased(MouseEvent arg0) {}
      });
    }

    @Override
    public int compareTo(MethodLabel ml) {
      return this.myMethod.getName().compareTo(ml.myMethod.getName());
    }
  }



  private class SchriftgroessenLabel extends JLabel{
    private static final long serialVersionUID = -6882806631390354293L;

    public SchriftgroessenLabel(){
      super();
      GUI.this.addLabel(this);
    }

    public SchriftgroessenLabel(String pString){
      super(pString);
      GUI.this.addLabel(this);
    }

    public void schriftgroesseSetzen(int pGroesse){
      this.setFont(new Font("Arial", Font.BOLD, pGroesse));
    }
  }

  private class MethodenAusfuehrer extends Thread{
    private Method myMethod;

    public MethodenAusfuehrer(Method myMethod) {
      this.myMethod = myMethod;
    }

    public void run() {
      methodeInAusfuehrung = true;
      methodeAusfuehren();
      methodeInAusfuehrung = false;
    }

    private void methodeAusfuehren(){
      Class<?>[] parameterTypes = myMethod.getParameterTypes();
      Object[] parameters = null;
      String input = "";
      if(parameterTypes.length != 0){
        // die Parameter abfragen
        String erklaerung = "";
        for(Class<?> parameterType:parameterTypes){
          String typStringMitPackage = parameterType.getCanonicalName();
          String parameterTypSimple = GUI.this.packageBezeichnungEntfernen(typStringMitPackage);
          erklaerung += parameterTypSimple + ",";
        }
        // das letzte Komma loeschen
        erklaerung = erklaerung.substring(0, erklaerung.length()-1);

        input = JOptionPane.showInputDialog(GUI.this, erklaerung);
        if(input == null){
          return;
        }

        // ggf. Leerzeichen vor und nach den Kommas wegnehmen
        input = input.replace(", ", ",");
        input = input.replace(" ,", ",");

        // die eingegebenen Parameter auswerten
        String[] parameterStrings = this.parameterStringZerlegen(input);
        if(parameterStrings == null){
          return;
        }
        if(parameterStrings.length != parameterTypes.length){
          GUI.this.fehlerMeldung("Es werden "+parameterTypes.length+" Parameter benoetigt.");
          return;
        }
        parameters = new Object[parameterTypes.length];
        for(int i=0; i<parameterTypes.length; i++){
          Object parameterImRichtigenTyp;
          Class<?> parameterType = parameterTypes[i];
          String split = parameterStrings[i];
          // nachschauen, ob es ein Attribut ist
          parameterImRichtigenTyp = attributAuslesen(split, parameterType);

          if(parameterImRichtigenTyp == null && parameterType.isPrimitive()){
            parameterImRichtigenTyp = inPrimitivenTypUmwandeln(split, parameterType);
          }
          if(parameterImRichtigenTyp == null && parameterType.isArray()){
            parameterImRichtigenTyp = inArrayMitTypUmwandeln(split, parameterType);
          }
          if(parameterImRichtigenTyp == null){
            parameterImRichtigenTyp = inObjektMitTypUmwandeln(split);
          }
          if(parameterImRichtigenTyp == null){
            fehlerMeldung("Parameter konnte nicht gelesen werden");
            return;
          }
          parameters[i] = parameterImRichtigenTyp;
        }
      }

      // die Methode aufrufen
      Object result = null;
      try {
    	  // KB: alte Implementierung
          // es werden nur max. 5 Parameter unterstuetzt.
//        if(parameters == null || parameters.length == 0){
//          result = myMethod.invoke(GUI.this.dasObjekt);
//        }
//        else if (parameters.length == 1){
//          result = myMethod.invoke(GUI.this.dasObjekt,
//              parameters[0]);
//        }
//        else if (parameters.length == 2){
//          result = myMethod.invoke(GUI.this.dasObjekt,
//              parameters[0],
//              parameters[1]);
//        }
//        else if (parameters.length == 3){
//          result = myMethod.invoke(GUI.this.dasObjekt,
//              parameters[0],
//              parameters[1],
//              parameters[2]);
//        }
//        else if (parameters.length == 4){
//          result = myMethod.invoke(GUI.this.dasObjekt,
//              parameters[0],
//              parameters[1],
//              parameters[2],
//              parameters[3]);
//        }
//        else if (parameters.length == 5){
//          result = myMethod.invoke(GUI.this.dasObjekt,
//              parameters[0],
//              parameters[1],
//              parameters[2],
//              parameters[3],
//              parameters[4]);
//        }
    	
    	// KB: neue Implementierung: 
    	// Pass the object and the parameters array directly to invoke
    	result = myMethod.invoke(GUI.this.dasObjekt, parameters);        if(result == null){
          if(myMethod.getReturnType().toString().equals("void")){
            result = "void";
          }
          else{
            result = "null";
          }
        }
        attributeUpdaten();
        if(!result.equals("void")){
          String resultDarstellung = "FEHLER!";
          if(result instanceof Object[] || result.getClass().isArray()){
            resultDarstellung = GUI.this.stringDarstellungVonArray(result);
          }
          else{
            resultDarstellung = GUI.this.stringDarstellung(result);
          }

          GUI.this.aufMaximalLaengeBringen(resultDarstellung);
          JOptionPane.showMessageDialog(GUI.this, resultDarstellung, myMethod.getName()+"("+input+")", JOptionPane.INFORMATION_MESSAGE);
        }
      } catch (IllegalArgumentException e) {
        GUI.this.fehlerMeldung("Die Parameter haben nicht den richtigen Typ.");
        return;
      }
      catch (IllegalAccessException e) {
        e.printStackTrace();
        GUI.this.fehlerMeldung("Fehler beim Methodenaufruf.");
        return;
      }
      catch (InvocationTargetException e) {
        Throwable eTarget = e.getTargetException();
        eTarget.printStackTrace();
        GUI.this.fehlerMeldung("Fehler beim Methodenaufruf.");
        return;
      }
    }

    /**
     * zerlegt den String mit den Parametern in einzelne Parameter.
     * Wenn ein Parameter ein Array ist,
     * dann wird das Array mit {...} als ein Parameter eingetragen.
     * @param input
     * @return bei einem Fehler: null
     */
    private String[] parameterStringZerlegen(String input){
      Vector<String> ergebnisVector = new Vector<String>();
      String parameter = "";
      while(!input.isEmpty()){
        if(input.startsWith("{")){
          // Array
          if(!input.contains("}")){
            GUI.this.fehlerMeldung("Das Parameter-Array muss mit \n\"}\" geschlossen werden!");
            return null;
          }
          parameter = input.substring(0, input.indexOf('}')+1);
        }
        else{
          // einfacher Parameter
          parameter = input.split(",")[0];
        }
        ergebnisVector.add(parameter);
        input = input.substring(parameter.length());
        if(input.startsWith(",")){
          input = input.substring(1);
        }
      }
      String[] type = new String[ergebnisVector.size()];
      return ergebnisVector.toArray(type);
    }

    private Object inObjektMitTypUmwandeln(String split) {
      Object object = null;
      if(isCharDarstellung(split)){
        object = split.charAt(1);
        return object;
      }
      if (isStringDarstellung(split)) {
        object = split.substring(1,split.length() - 1);
        return object;
      }
      if(isIntDarstellung(split)){
        object = Integer.parseInt(split);
        return object;
      }
      if(isDoubleDarstellung(split)){
        object = Double.parseDouble(split);
        return object;
      }
      if(split.equals("true")){
        object = true;
        return object;
      }
      if(split.equals("false")){
        object = false;
        return object;
      }
      return null;
    }

    /**
     * wandelt einen String in ein Array mit vorgegebenem Typ um.
     * string muss z.B. folgendes Aussehen haben: {"ab","bc","de"}
     * @param string
     * @param type
     * @return
     */
    private Object inArrayMitTypUmwandeln(String string, Class<?> type) {
      // die geschweiften Klammern wegnehmen
      string = string.substring(1, string.length()-1);
      // in einzelne Strings zerlegen
      String[] splits = string.split(",");
      // ein Array des richtigen Typs erzeugen
      Object result = Array.newInstance(type.getComponentType(), splits.length);
      // das Array bevoelkern
      for(int i=0; i<splits.length; i++){
        try {

          Array.set(result, i, this.inObjektMitTypUmwandeln(splits[i]));
        } catch (IllegalArgumentException e) {
          GUI.this.fehlerMeldung("Falscher Parametertyp beim Index "+i+":\n"+splits[i]);
          return null;
        }
      }
      return result;
    }

//    private JFrame arrayInFrameDarstellen(Object result) {
//      JFrame arrayFrame = null;
//      if(result instanceof Object[]){
//        // Arrays mit Objekten darstellen
//        JTextArea textArea = new JTextArea();
//        Object[] resultArray = (Object[])result;
//        for(Object o:resultArray){
//          textArea.append(o+"\n");
//        }
//        arrayFrame = new JFrame();
//        arrayFrame.setLocation(GUI.this.getX(), GUI.this.getY()+GUI.this.getHeight()+5);
//        arrayFrame.getContentPane().add(textArea);
//        arrayFrame.pack();
//        arrayFrame.setVisible(true);
//      }
//      else if(result.getClass().isArray()){
//        // Arrays mit einfachen Datentypen darstellen
//        JTextArea textArea = new JTextArea();
//        if(result.getClass().getCanonicalName().equals("int[]")){
//          int[] iArray = (int[])result;
//          for(int i: iArray){
//            textArea.append(i+"\n");
//          }
//        }
//        else if(result.getClass().getCanonicalName().equals("double[]")){
//          double[] iArray = (double[])result;
//          for(double i: iArray){
//            textArea.append(i+"\n");
//          }
//        }
//        else if(result.getClass().getCanonicalName().equals("float[]")){
//          float[] iArray = (float[])result;
//          for(float i: iArray){
//            textArea.append(i+"\n");
//          }
//        }
//        else if(result.getClass().getCanonicalName().equals("boolean[]")){
//          boolean[] iArray = (boolean[])result;
//          for(boolean i: iArray){
//            textArea.append(i+"\n");
//          }
//        }
//        else if(result.getClass().getCanonicalName().equals("char[]")){
//          char[] iArray = (char[])result;
//          for(char i: iArray){
//            textArea.append(i+"\n");
//          }
//        }
//        arrayFrame = new JFrame();
//        arrayFrame.setLocation(GUI.this.getX(), GUI.this.getY()+GUI.this.getHeight()+5);
//        arrayFrame.getContentPane().add(textArea);
//        arrayFrame.pack();
//        arrayFrame.setVisible(true);
//      }
//      return arrayFrame;
//    }


  }

  /**
   * liest aus allen Attributen den Wert des gesuchten Attributes aus.
   * @param gesuchtesAttributName der Name des gesuchten Attributes.
   * @param parameterType der Parametertyp des gesuchten Attributes.
   * @return den Wert
   */
  private Object attributAuslesen(String gesuchtesAttributName, Class<?> parameterType) {
    for(Field field:fields){
      String einfacherAttributName = methodenSignaturVereinfachen(field.getName());
      einfacherAttributName = einfacherAttributName.replace(" ", "");
      if(einfacherAttributName.equals(gesuchtesAttributName)){
        try {
          return field.get(dasObjekt);
        } catch (Exception e) {
          e.printStackTrace();
          fehlerMeldung("Attribut "+field.getName()+" kann nicht ausgelesen werden.");
          return null;
        }
      }
    }
    // nichts gefunden!
    return null;
  }
}
