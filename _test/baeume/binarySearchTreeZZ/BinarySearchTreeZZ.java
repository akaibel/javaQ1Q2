package _test.baeume.binarySearchTreeZZ;

import baeume.BinaryTree;
import baeume.ComparableContent;

public class BinarySearchTreeZZ<ContentType extends ComparableContent<ContentType>> {
	private BinaryTree<ContentType> myTree;

	/**
	 * Der Konstruktor erzeugt einen leeren Suchbaum.
	 */
	public BinarySearchTreeZZ() {
		myTree = new BinaryTree<ContentType>();
	}

	private BinarySearchTreeZZ(BinaryTree<ContentType> pTree) {
		myTree = pTree;
	}

	public boolean isEmpty() {
		return myTree.isEmpty();
	}

	
	public ContentType getContent() {
		return myTree.getContent();
	}

	public BinarySearchTreeZZ<ContentType> getLeftTree() {
		return new BinarySearchTreeZZ<ContentType>(myTree.getLeftTree());
	}

	public BinarySearchTreeZZ<ContentType> getRightTree() {
		return new BinarySearchTreeZZ<ContentType>(myTree.getRightTree());
	}

	public ContentType search(ContentType pContent) {
		//TODO
		return null;
	}

		
	public void insert(ContentType pContent){
		//TODO
	}

	
	public void remove(ContentType pContent) {
		//TODO
		// muss man im Zentralabitur nicht koennen!
	}

}
