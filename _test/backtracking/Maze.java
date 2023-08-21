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
     * makes a BACK-move in the direction
     * @param direction 0:up, 1: right, 2: down, 3: left
     * @return  true: move was successful; false: there was a wall
     */    
    public boolean moveBack(int direction) {
    	
    	return move((direction+2)%4);
    }

    /**
     * moves the player
     * @param direction 0:up, 1: right, 2: down, 3: left
     * @return true: move was successful; false: there was a wall
     */    
    public boolean move(int direction) {
    	if(isWallInDirection(direction)) {
    		System.err.println("impossible movement Maze.move("+direction+"): there is a wall!!");
    		return false;
    	}
    	if(direction == 0) {
        	if(field[playerY-1][playerX] != wall) {
        		playerY -= 1;
                display.updatePlayer(playerX, playerY);
                waitAWhile();
        		return true;
        	}
        	return false;
    	}
    	else if(direction == 1) {
        	if(field[playerY][playerX+1] != wall) {
        		playerX += 1;
                display.updatePlayer(playerX, playerY);
                waitAWhile();
        		return true;
        	}
        	return false;
    	}
    	else if(direction == 2) {
        	if(field[playerY+1][playerX] != wall) {
        		playerY += 1;
                display.updatePlayer(playerX, playerY);
                waitAWhile();
        		return true;
        	}
        	return false;
    	}
    	else if(direction == 3) {
        	if(field[playerY][playerX-1] != wall) {
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
    
    /**
     * checks, whether a wall is in the direction
     * @param direction 0:up, 1: right, 2: down, 3: left
     * @return true: there is a wall; false: there is no wall
     */    
    public boolean isWallInDirection(int direction) {
    	if(direction == 0) return field[playerY-1][playerX] == wall; 
    	else if(direction == 1) return field[playerY][playerX+1] == wall;
    	else if(direction == 2) return field[playerY+1][playerX] == wall;
    	else if(direction == 3) return field[playerY][playerX-1] == wall; 
    	System.err.println("impossible direction "+direction+" in Maze.isWallInDirection(int direction)");
    	System.exit(0);
    	return false;
    }
    
    public boolean isPlayerOnGoal() {
    	return field[playerY][playerX] == goal;
    }
    
    public void markPlayerFieldAsVisited(boolean pMark) {
    	if(pMark) {
    		field[playerY][playerX] = visited;
    	}
    	else {
    		field[playerY][playerX] = empty;    		
    	}
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
