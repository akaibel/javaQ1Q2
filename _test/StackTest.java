package _test;


import gui.GUI;
import linear.Stack;
import linear.Stack;
import linear.StackWithViewer;
import sonstiges.Auto;
import sonstiges.Autos;
import sonstiges.Celebrities;
import sonstiges.Celebrity;

public class StackTest {
	private Stack<Celebrity> celebritiesStack;
	
	//private Stack<Auto> autoStack;
	
	public StackTest(){
		celebritiesStack = Celebrities.celebritiesStack();
		
		//autoStack = Autos.autoStack();
	}
	
	public void ausgeben() {
		System.out.println("*** ausgeben ***");
		//TODO
	}

	public static void main(String[] args) {
		StackTest st = new StackTest();
		new GUI(st);
	}
}
