package linear;

public class PriorityQueue<ContentType> {
	private List<ContentType> contentList;
	private List<Integer> priorityList;
	
	public PriorityQueue(){
		contentList = new ListWithViewer<ContentType>();
		priorityList = new ListWithViewer<Integer>();
	}
	
	public boolean isEmpty(){
		//TODO
		return false;
	}
	
	public void insert(ContentType pContent, int pPriority){
		//TODO
	}
	
	public ContentType front(){
		return null;
	}
	
	public void dequeue(){
		//TODO
	}
}
