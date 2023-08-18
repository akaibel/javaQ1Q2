package _test.backtracking;
import javax.swing.*;
import java.awt.*;

public class MazeDisplay {
	private MazeDisplayPanel display;
	
	public MazeDisplay(Maze maze) {
		display = new MazeDisplayPanel(maze);
	}
	
	public void updatePlayer(int playerX, int playerY) {
		display.updatePlayer(playerX, playerY);
	}
	
	public void repaintCell(int playerX, int playerY) {
		display.repaintCell(playerX, playerY);
		
	}

	private class MazeDisplayPanel extends JPanel {
	    private static final int CELL_SIZE = 20; // Size of each cell in pixels
	    private Maze maze;
	    private int playerX;
	    private int playerY;

	    public MazeDisplayPanel(Maze maze) {
	        this.maze = maze;
	        int[][] walls = maze.getField();

	        int width = walls[0].length * CELL_SIZE;
	        int height = walls.length * CELL_SIZE;

	        setPreferredSize(new Dimension(width, height));
	        
	        JFrame frame = new JFrame("Maze Display");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().add(this);
	        frame.pack();
	        frame.setLocationRelativeTo(null); // Center the frame
	        frame.setVisible(true);
	        
	    }

	    public void updatePlayer(int playerX, int playerY) {
	        repaintCell(this.playerX, this.playerY); // Repaint the old player position
	        this.playerX = playerX;
	        this.playerY = playerY;
	        repaintCell(this.playerX, this.playerY); // Repaint the new player position
	    }

	    public void repaintCell(int x, int y) {
	    	//System.out.println("repaintCell("+x+","+y+")");
	        int col = x;
	        int row = y;
	        repaint(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
	        //repaint();
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        int[][] walls = maze.getField();

	        for (int row = 0; row < walls.length; row++) {
	            for (int col = 0; col < walls[row].length; col++) {
	                int cellValue = walls[row][col];
	                Color color;

	                if (cellValue == Maze.wall) {
	                    color = Color.BLACK;
	                } else if (cellValue == Maze.goal) {
	                    color = Color.BLUE;
	                } else {
	                    color = Color.WHITE;
	                }

	                g.setColor(color);
	                g.fillRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);

	                if (cellValue == Maze.player) {
	                    int circleX = col * CELL_SIZE + CELL_SIZE / 2;
	                    int circleY = row * CELL_SIZE + CELL_SIZE / 2;
	                    g.setColor(Color.BLUE);
	                    g.fillOval(circleX - CELL_SIZE / 4, circleY - CELL_SIZE / 4, CELL_SIZE / 2, CELL_SIZE / 2);
	                }
	                if (cellValue == Maze.visited) {
	                	//System.out.println("paintComponent: cellValue == Maze.visited");
	                    int circleX = col * CELL_SIZE + CELL_SIZE / 2;
	                    int circleY = row * CELL_SIZE + CELL_SIZE / 2;
	                    //System.out.println("circleX, circleY: "+circleX+","+circleY);
	                    g.setColor(Color.YELLOW);
	                    g.fillOval(circleX - CELL_SIZE / 4, circleY - CELL_SIZE / 4, CELL_SIZE / 2, CELL_SIZE / 2);
	                }
	            }
	        }
            g.setColor(Color.RED);
            g.fillOval(playerX * CELL_SIZE + CELL_SIZE / 4, playerY * CELL_SIZE + CELL_SIZE / 4, CELL_SIZE / 2, CELL_SIZE / 2);
	    }

	}


}
