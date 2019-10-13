import java.util.Stack;

public class HanoiGUI {
	
	// application constants
	public static final int APP_WIDTH = 500;
	public static final int APP_HEIGHT = 400;
	public static final int PAUSE = 200; // wait half second between moves
	
	// three towers represented as stacks of disks
	private Stack<Integer> towerA = new Stack<Integer>();
	private Stack<Integer> towerB = new Stack<Integer>();
	private Stack<Integer> towerC = new Stack<Integer>();

	// # disks (provided by user)
	private int n; 
	
	/**
	 * Constructor takes user-provided #disks, pushes them all
	 * in reverse order onto Tower A, and sets up/draws canvas 
	 */
	public HanoiGUI(int n) {
		this.n = n;
		for (int i=n; i>=1; i--) {
			towerA.push(i);
		}
		// Set dimensions (in pixels) for canvas
		StdDraw.setCanvasSize(APP_WIDTH,APP_HEIGHT);
		// Scale canvas coordinate system 
		StdDraw.setXscale(-2, 2);
		StdDraw.setYscale(-.1, n+.1);
		StdDraw.enableDoubleBuffering();
		draw();
		StdDraw.pause(PAUSE);
	}
	
	/** Draw the 3 pegs and the 3 towers of disks */
	private void draw() {
		StdDraw.clear();
		// draw pegs
		StdDraw.filledRectangle(-1, n/2.0, .05, n/2.0);
		StdDraw.filledRectangle(0, n/2.0, .05, n/2.0);
		StdDraw.filledRectangle(1, n/2.0, .05, n/2.0);
		// draw disks
		drawTower(towerA,-1);
		drawTower(towerB,0);
		drawTower(towerC,1);
		StdDraw.show();
	}
	
	/** Draw a tower of disks at specified x center */
	private void drawTower(Stack<Integer> tower, double x) {
		// move onto tempTower
		Stack<Integer> tempTower = new Stack<Integer>();
		while (!tower.isEmpty()) {
			tempTower.push(tower.pop());
		}
		// draw from largest to smallest, incrementing y
		// as you move back to the original tower
		double y=0.5;
		while (!tempTower.isEmpty()) {
			Integer disk = tempTower.pop();
			tower.push(disk);
			StdDraw.filledRectangle(x, y, disk/(n*2.0), 0.5);
			y+=1;
		}
	}
	
	/** If n is at top of from tower, move it to the to tower, redraw, and pause */
	public void move(int n, char from, char to) {
		Stack<Integer> fromTower = getTower(from);
		Stack<Integer> toTower = getTower(to);
		if (fromTower.peek() != n) {
			System.out.println(n + " is not at the top of " + from);
			return;
		} 
		Integer disk = fromTower.pop();
		toTower.push(disk);
		draw();
		StdDraw.pause(PAUSE);
	}
	
	/** Return the ivar associated with the given character */
	private Stack<Integer> getTower(char ch) {
		switch (ch) {
		case 'A': return towerA;
		case 'B': return towerB;
		case 'C': return towerC;
		default: 
			System.out.println("Illegal tower specifier");
			return null;
		}
	}	

}
