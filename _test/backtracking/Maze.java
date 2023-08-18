package _test.backtracking;
import gui.GUI;

public class Maze {
    public static int empty= 0;
    public static int wall = 1;
    public static int player = 2;
    public static int goal = 3;
    public static int visited = 4;
    public int[][] field;
    

    public int playerX = 1, playerY = 1;
    public int goalX = 15, goalY = 16;

    private MazeDisplay display;
	public long waitingTimeMilliSeconds = 100;
    
    public Maze(int[][] field) {
    	field = this.field = field;
    	field[goalX][goalY] = goal;
    	

    	display = new MazeDisplay(this);
        display.updatePlayer(playerX, playerY);
    }
    
    /**
     * moves the player and sets a mark, where the player comes from
     * @param direction 0:up, 1: right, 2: down, 3: left
     * @return true: move was successful; false: there was a wall
     */    
    public boolean move(int direction) {
    	return move(direction, true);
    }
    
    /**
     * makes a BACK-move in the direction
     * @param direction 0:up, 1: right, 2: down, 3: left
     * @return  true: move was successful; false: there was a wall
     */    
    public boolean moveBack(int direction) {
    	
    	return move((direction+2)%4, true);
    }

    /**
     * moves the player
     * @param direction 0:up, 1: right, 2: down, 3: left
     * @param mark: marks/unmarks the place the player comes from
     * @return true: move was successful; false: there was a wall
     */    
    private boolean move(int direction, boolean mark) {
    	if(direction == 0) {
        	if(field[playerY-1][playerX] != wall) {
        		if(mark) field[playerY][playerX] = visited;
        		else field[playerY][playerX] = empty;
        		playerY -= 1;
                display.updatePlayer(playerX, playerY);
                waitAWhile();
        		return true;
        	}
        	return false;
    	}
    	else if(direction == 1) {
        	if(field[playerY][playerX+1] != wall) {
        		if(mark) field[playerY][playerX] = visited;
        		else field[playerY][playerX] = empty;
        		playerX += 1;
                display.updatePlayer(playerX, playerY);
                waitAWhile();
        		return true;
        	}
        	return false;
    	}
    	else if(direction == 2) {
        	if(field[playerY+1][playerX] != wall) {
        		if(mark) field[playerY][playerX] = visited;
        		else field[playerY][playerX] = empty;
        		playerY += 1;
                display.updatePlayer(playerX, playerY);
                waitAWhile();
        		return true;
        	}
        	return false;
    	}
    	else if(direction == 3) {
        	if(field[playerY][playerX-1] != wall) {
        		if(mark) field[playerY][playerX] = visited;
        		else field[playerY][playerX] = empty;
        		playerX -= 1;
                display.updatePlayer(playerX, playerY);
                waitAWhile();
        		return true;
        	}
        	return false;
    	}
    	System.err.println("Maze.move("+direction+"): impossible movement");
    	return false;
    }
    
    public boolean isPlayerOnGoal() {
    	return field[playerY][playerX] == goal;
    }
    
    public boolean isPlayerOnVisited() {
    	return field[playerY][playerX] == visited;
    }
    

    public int[][] getField() {
        return field;
    }
    
    public void waitAWhile() {
    	try {
    	Thread.sleep(waitingTimeMilliSeconds);
    	}catch(Exception e) {}
    }

    // Other methods and fields can be added here as needed

}
