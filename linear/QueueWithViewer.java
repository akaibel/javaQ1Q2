package linear;
/**
 * @author: a. kaibel, a.kaibel@googlemail.com
 * 
 */

public class QueueWithViewer<ContentType> extends Queue<ContentType> {
	private QViewer qViewer;
	
	public QueueWithViewer(){
		qViewer = new QViewer(this);
	}

	public boolean isEmpty(){
		boolean isEmpty = false;
		try{
			isEmpty = super.isEmpty();
			qViewer.anzeigen("isEmpty(): "+isEmpty, this);
		}
		catch(NullPointerException ne){
			qViewer.fehlerMeldung(ne,"isEmpty()");
		}
		return isEmpty;
	}

	public ContentType front(){
		ContentType front = null;
		try{
			front = super.front();
			String anzeigeString = null;
			if(front != null){
				anzeigeString = front.toString();
			}
			qViewer.anzeigen("front(): "+anzeigeString, this);
		}catch(NullPointerException ne){
			qViewer.fehlerMeldung(ne, "front()");
		}
		return front;
		
	}

	public void enqueue(ContentType pObject){
		try{
			super.enqueue(pObject);
			String anzeigeString = null;
			if(pObject != null){
				anzeigeString = pObject.toString();
			}
			qViewer.anzeigen("enqueue("+anzeigeString+")", this);
		}
		catch(NullPointerException ne){
			qViewer.fehlerMeldung(ne,"enqueue()");
		}
	}

	public void dequeue(){
		try{
			super.dequeue();
			qViewer.anzeigen("dequeue()", this);
		}catch(NullPointerException ne){
			qViewer.fehlerMeldung(ne,"dequeue()");
		}
	}

}
