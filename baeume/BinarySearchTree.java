package baeume;



public class BinarySearchTree<ContentType extends ComparableContent<ContentType>>{
	private BinaryTree<ContentType> myTree;

	public BinarySearchTree(){
		myTree = new BinaryTree<>();		
	}

	private BinarySearchTree(BinaryTree<ContentType> pTree){
		myTree = pTree;
	}

	/**
	 * NUR FUER DARSTELLUNGSZWECKE !!!!
	 * nicht verwenden!!!
	 * @return
	 */
	public BinaryTree<ContentType> getBinaryTree(){
		return myTree;
	}

	public boolean isEmpty(){
		return myTree.isEmpty();
	}

	public ContentType getContent() {
		return myTree.getContent();
	}

	private BinarySearchTree<ContentType> getLeftTree() {
		if(myTree.getLeftTree() == null) return null;
		return new BinarySearchTree<>(this.myTree.getLeftTree());
	}

	private BinarySearchTree<ContentType> getRightTree() {
		if(myTree.getRightTree() == null) return null;
		return new BinarySearchTree<>(this.myTree.getRightTree());
	}

	public ContentType search(ContentType pContent) {
		BinaryTree<ContentType> b = myTree;
		while( ! b.isEmpty()){
			ContentType wurzel = b.getContent();
			if(pContent.isEqual(wurzel)){
				// gefunden!
				return wurzel;
			}
			if(pContent.isLess(wurzel)){
				// links abbiegen
				b = b.getLeftTree();
			}
			else{
				// rechts abbiegen
				b = b.getRightTree();
			}
		}
		// nicht gefunden!
		return null;
	}

	public void insert(ContentType pContent) {
		BinaryTree<ContentType> b = myTree;
		while(!b.isEmpty()){
			ContentType wurzel = b.getContent();
			// UPDATE von b
			if(pContent.isLess(wurzel)){
				b = b.getLeftTree();
			}
			else{
				b = b.getRightTree();
			}
		}
		// jetzt ist man beim richtigen leeren Knoten angekommen!
		b.setContent(pContent);
		TreeViewer.showTree();
	}

	public void remove(ContentType pContent){
		remove(this, pContent);
		TreeViewer.showTree();
	}

	private BinarySearchTree<ContentType> remove(BinarySearchTree<ContentType> pBSTree, ContentType pContent) {

		if(pBSTree.isEmpty()) return pBSTree;

		if(pContent.isLess(pBSTree.getContent()) && ! pContent.isEqual(pBSTree.getContent())) {
			pBSTree.getBinaryTree().setLeftTree(remove(pBSTree.getLeftTree(), pContent).getBinaryTree());
		} else if(pContent.isGreater(pBSTree.getContent()) && ! pContent.isEqual(pBSTree.getContent())) {
			pBSTree.getBinaryTree().setRightTree(remove(pBSTree.getRightTree(), pContent).getBinaryTree());
		} else {
			// node with no leaf nodes
			if(pBSTree.getLeftTree().isEmpty()&& pBSTree.getRightTree().isEmpty()) {
				System.out.println("deleting "+pContent);
				return new BinarySearchTree<ContentType>();
			} else if(pBSTree.getLeftTree().isEmpty()) {
				// node with one node (no left node)
				System.out.println("deleting "+pContent);
				return pBSTree.getRightTree();
			} else if(pBSTree.getRightTree().isEmpty()) {
				// node with one node (no right node)
				System.out.println("deleting "+pContent);
				return pBSTree.getLeftTree();
			} else {
				// nodes with two nodes
				// search for min number in right sub tree
				ContentType minValue = minValue(pBSTree.getRightTree());
				pBSTree.getBinaryTree().setContent(minValue);
				pBSTree.getBinaryTree().setRightTree(remove(pBSTree.getRightTree(), minValue).getBinaryTree());
				System.out.println("deleting "+pContent);
			}
		}

		return pBSTree;
	}

	private ContentType minValue(BinarySearchTree<ContentType> node) {

		if(! node.getLeftTree().isEmpty()) {
			return minValue(node.getLeftTree());
		}
		return node.getContent();
	}

}
