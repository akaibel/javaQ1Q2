package _test.backtracking;

public class MazeSolver {
	private Maze maze;
	
	public MazeSolver() {
		maze = new Maze(MazeWalls.field_20x20);
	    maze.playerX = 1; maze.playerY = 1;
	    maze.goalX = 15; maze.goalY = 16;
		maze.waitingTimeMilliSeconds = 1000;

	}

	private boolean findGoal() {
		System.out.println("findGoal()");
		//TODO
		maze.markPlayerFieldAsVisited(true);
		maze.move(2);
		maze.markPlayerFieldAsVisited(true);
		maze.move(2);
		System.out.println("isPlayerOnVisited(): "+maze.isPlayerOnVisited());
		maze.markPlayerFieldAsVisited(false);
		maze.moveBack(2);
		maze.markPlayerFieldAsVisited(false);		
		maze.moveBack(2);
		maze.markPlayerFieldAsVisited(true);
		// nach oben bewegen geht nicht - es passiert also nichts
		System.out.println("isWallInDirection(0): "+maze.isWallInDirection(0));
		maze.move(0);
		maze.move(1);
		System.out.println("isPlayerOnVisited(): "+maze.isPlayerOnVisited());
		System.out.println("isPlayerOnGoal(): "+maze.isPlayerOnGoal());
		return false;
	}
	
	
	public static void main(String[] args) {
		MazeSolver m = new MazeSolver();
		boolean success = m.findGoal();
		if(success) {
			System.out.println("Am Ziel angekommen :)");
		}
		else {
			System.out.println("Nicht angekommen :(");
		}
	}

}
