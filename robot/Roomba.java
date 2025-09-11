package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/basicRoom.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
	}

	// declared here so it is visible in all the methods!
	public Robot roomba;

	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(5);

		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		// inserting the robot at the starting position
		roomba = new Robot(startX, startY, East, 0);

		// setting the initial amount to 0
		int totalBeepersCleaned = 0;
		int totalArea = 0;
		int largestPile = 0;
		
		// the code for cleaning up all the beepers
		while (true) {
			int pileSize = 0;
			while (roomba.frontIsClear()) {
				roomba.move();
				totalArea++;
				pileSize = 0;
				while (roomba.nextToABeeper()) {
					roomba.pickBeeper();
					totalBeepersCleaned++;
					pileSize++;
				}
				if (pileSize > largestPile)
				{
					largestPile = pileSize;
				}	
			}
			if (roomba.facingEast()) {
				roomba.turnLeft();
				roomba.move();
				roomba.turnLeft();
			}
			else {
				roomba.turnLeft();
				roomba.turnLeft();
				roomba.turnLeft();
				roomba.move();
				roomba.turnLeft();
				roomba.turnLeft();
				roomba.turnLeft();
			}
			if (roomba.frontIsClear() != true) {
				break;
			}
		}
				
        // This method should return the total number of beepers cleaned up.
		System.out.println("The total area is " + totalArea);
		System.out.println("The largest pile has " + largestPile + " beepers");
		return totalBeepersCleaned;
	}
}