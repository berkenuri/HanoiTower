//BERKE NURI
import java.util.*;
public class Hanoi {
	
	private static HanoiGUI g;

	/**
	 * Gets #disks from user, initializes the GUI, and makes
	 * one call to the recursive method that solves the problem
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of disks: ");
		int n = input.nextInt();
		g = new HanoiGUI(n);
		
		System.out.println("The moves are:");
		moveDisks(n,'A','B','C');
	}
	
	/**
	 * TODO: write this method so it recursively moves disks 
	 * 1-n from their starting tower to the destination tower
	 * @param n, the number of disks to move
	 * @param fromTower, the tower that contains disks n,n-1,...,1, possibly on top of larger disks
	 * @param toTower, the tower to move n,n-1,...,1 to, possibly on top of larger disks 
	 * @param auxTower, an auxiliary tower containing only (possibly) disks larger than n
	 */
	public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
		/* use these lines to respectively print to console and update GUI when time to move */
		//System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
	
		/*
	 	g.move(1, 'A', 'B');
		g.move(2, 'A', 'C');
		g.move(1, 'B', 'C');
		
		g.move(3, 'A', 'B');
		
		g.move(1, 'C', 'A');
		g.move(2, 'C', 'B');
		g.move(1, 'A', 'B');
		
		*/
		
		if (n==1) {
			System.out.println(n + " from " + fromTower + " to " + toTower);
			g.move(n,  fromTower, toTower);
		} else {
			moveDisks(n-1, fromTower, auxTower, toTower);
			
			System.out.println(n + " from " + fromTower + " to " + toTower);
			g.move(n,  fromTower, toTower);
			
			moveDisks(n-1, auxTower, toTower, fromTower);
		}
		
	}
	
	
}
