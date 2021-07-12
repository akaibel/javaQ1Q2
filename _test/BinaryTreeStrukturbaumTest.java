package _test;
import linear.List;
import gui.GUI;
import baeume.BinaryTree;
import baeume.TreeViewer;


public class BinaryTreeStrukturbaumTest {
	public BinaryTree<Character>strukturbaum;
	
	public BinaryTreeStrukturbaumTest(){
		strukturbaum = new BinaryTree('+');
		BinaryTree b1 = new BinaryTree('/');
		BinaryTree b2 = new BinaryTree('*');
		strukturbaum.setLeftTree(b1);
		strukturbaum.setRightTree(b2);
		BinaryTree b3 = new BinaryTree(12);
		BinaryTree b4 = new BinaryTree(4);
		b1.setLeftTree(b3);
		b1.setRightTree(b4);
		BinaryTree b5 = new BinaryTree('-');
		BinaryTree b6 = new BinaryTree(3);
		b2.setLeftTree(b5);
		b2.setRightTree(b6);
		BinaryTree b7 = new BinaryTree(7);
		BinaryTree b8 = new BinaryTree(5);
		b5.setLeftTree(b7);
		b5.setRightTree(b8);
        TreeViewer.showTree(strukturbaum, 600,400);
	}
	

	public double berechne(){
		//TODO
		return -1;
	}

	public static void main(String[] args) {
		new GUI(new BinaryTreeStrukturbaumTest());
	}
}
