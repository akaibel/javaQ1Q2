package linear;

/**
 * @author: a. kaibel, a.kaibel@googlemail.com
 * 
 */
public class ListWithViewer<ContentType> extends List<ContentType> {
	private LViewer lViewer;
	
	public ListWithViewer(){
		lViewer = new LViewer(this);
	}

	public ListWithViewer(List<ContentType> pList){
		lViewer = new LViewer(this);
		// den aktuelle Knoten merken!
		List<ContentType>.ListNode currentNode = pList.getCurrentNode();
		// alle Elemente von pList uebertragen
		for(pList.toFirst(); pList.hasAccess(); pList.next()){
			super.append(pList.getContent());
		}
		// den aktuellen Knoten wieder herstellen:
		// sowohl fuer die Liste pList, als auch fuer den ListWithViewer
		pList.toFirst();
		this.toFirst();
		while(pList.hasAccess()){
			if(pList.getCurrentNode() == currentNode){
				return;
			}
			pList.next();
			this.next();
		}
		return;
	}

	public boolean isEmpty(){
		boolean isEmpty = false;
		try{
			isEmpty = super.isEmpty();
			if(lViewer != null) lViewer.anzeigen("isEmpty(): "+isEmpty, this);
		}
		catch(NullPointerException ne){
			lViewer.fehlerMeldung(ne,"isEmpty()");
		}
		return isEmpty;
	}

    public boolean hasAccess() {
		boolean hasAccess = false;
		try{
			hasAccess = super.hasAccess();
			if(lViewer != null) lViewer.anzeigen("hasAccess(): "+hasAccess, this);
		}
		catch(NullPointerException ne){
			lViewer.fehlerMeldung(ne,"hasAccess()");
		}
		return hasAccess;
    }
    
    public void next()
    {
		try{
			super.next();
			if(lViewer != null) lViewer.anzeigen("next()", this);
		}
		catch(Exception ne){
			lViewer.fehlerMeldung(ne,"next()");
		}
    }

    public void toFirst()
    {
		try{
			super.toFirst();
			if(lViewer != null) lViewer.anzeigen("toFirst()", this);
		}
		catch(NullPointerException ne){
			lViewer.fehlerMeldung(ne,"toFirst()");
		}
    }
  
    public void toLast()
    {
		try{
			super.toLast();
			if(lViewer != null) lViewer.anzeigen("toLast()", this);
		}
		catch(NullPointerException ne){
			lViewer.fehlerMeldung(ne,"toLast()");
		}
    }
  
    public ContentType getContent() {
		ContentType item = null;
		try{
			item = super.getContent();
			if(lViewer != null) lViewer.anzeigen("getContent(): "+item.toString(), this);
		}
		catch(Exception ne){
			lViewer.fehlerMeldung(ne,"getContent()");
		}
		return item;
    }

    public void insert(ContentType pObject)
    {
		try{
			super.insert(pObject);
			if(lViewer != null) lViewer.anzeigen("insert("+pObject.toString()+")", this);
		}
		catch(Exception ne){
			lViewer.fehlerMeldung(ne,"insert("+pObject.toString()+")");
		}
    }
    
    public void remove()
    {
		try{
			super.remove();
			if(lViewer != null) lViewer.anzeigen("remove()", this);
		}
		catch(Exception ne){
			lViewer.fehlerMeldung(ne,"remove()");
		}
    }

    public void concat(List<ContentType> pList)
    {
		try{
			super.concat(pList);
			if(lViewer != null) lViewer.anzeigen("concat()", this);
		}
		catch(NullPointerException ne){
			lViewer.fehlerMeldung(ne,"concat()");
		}
    }

    public void append(ContentType pObject)
    {
		try{
			super.append(pObject);
			if(lViewer != null) lViewer.anzeigen("append("+pObject.toString()+")", this);
		}
		catch(NullPointerException ne){
			lViewer.fehlerMeldung(ne,"append()");
		}
    }

}
