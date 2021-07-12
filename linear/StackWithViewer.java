package linear;
/**
 * @author: a. kaibel, a.kaibel@googlemail.com
 * 
 */

public class StackWithViewer<ContentType> extends Stack<ContentType> {
	private SViewer sViewer;

	public StackWithViewer(){
		sViewer = new SViewer(this);
		sViewer.anzeigen("new Stack()");
	}

	/**
	 * 	Nachher: Die Anfrage liefert den Wert true, 
	 * wenn der Stapel keine Elemente enthält, sonst liefert sie den Wert false.
	 * @return
	 */
	public boolean isEmpty(){
		boolean isEmpty = super.isEmpty();
		sViewer.anzeigen("isEmpty(): "+isEmpty);
		return isEmpty;
	}

	/**
	 * Vorher Der Stapel ist erzeugt.
	 * Nachher pObject liegt oben auf dem Stack.
	 * @param pObject
	 * @return
	 */
	public void push (ContentType pObject){
		super.push(pObject);
		sViewer.anzeigen("push("+pObject.toString()+")");
	}

	/**
	 * Vorher: Der Stapel ist nicht leer.
	 * Nachher: Das zuletzt eingefügte Element ist aus dem Stapel entfernt.
	 */	
	public void pop(){
		try{
			super.pop();
			sViewer.anzeigen("pop()");
		}catch(NullPointerException ne){
			sViewer.fehlerMeldung(ne,"pop()");
		}
	}


	/**
	 * Vorher: Der Stapel ist nicht leer.
	 * Nachher: Die Anfrage liefert das oberste Stapelelement. Der Stapel ist unverändert.
	 * @return
	 */
	public ContentType top(){
		ContentType top = null;
		try{
			top = super.top();
			sViewer.anzeigen("top(): "+top.toString());
		}catch(NullPointerException ne){
			sViewer.fehlerMeldung(ne, "top()");
		}
		return top;
		
	}
	
	
}
