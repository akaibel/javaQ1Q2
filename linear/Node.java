package linear;

public class Node<ContentType> { 
	private ContentType value;
	private Node<ContentType> next;
	private Node<ContentType> previous;

	public Node(ContentType pValue) { 
		value = pValue;
		next = null;
	}

	public void setValue(ContentType pValue) { 
		value = pValue; 
	}

	public ContentType getValue() { 
		return value; 
	}

	public void setNext(Node<ContentType> pNext) { 
		next = pNext; 
	}

	public Node<ContentType> getNext() { 
		return next; 
	}

	public Node<ContentType> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<ContentType> pNode) {
		this.previous = pNode;
	}

} 
