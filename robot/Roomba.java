package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/finalTestWorld2024.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 26, 101);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
	}

	// declared here so it is visible in all the methods!
	public Robot roomba;

	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(0);

		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		// inserting the robot at the starting position
		roomba = new Robot(startX, startY, East, 0);

		// setting the initial amounts to 0
		int totalBeepersCleaned = 0;
		int totalArea = 0;
		int largestPile = 0;
		int largestPileStreet = 0;
		int largestPileAvenue = 0;
		int totalPiles = 0;
		int currentPileStreet = 0;
		int currentPileAvenue = 0;
		
		// the code...
		while (true) {
			int pileSize = 0;
			if (roomba.nextToABeeper()) {
				totalPiles++;
				currentPileStreet = roomba.street();
				currentPileAvenue = roomba.avenue();
			}
			while (roomba.nextToABeeper()) {
				roomba.pickBeeper();
				totalBeepersCleaned++;
				pileSize++;
			}
			if (pileSize > largestPile) {
				largestPile = pileSize;
				largestPileStreet = currentPileStreet;
				largestPileAvenue = currentPileAvenue;
			}
			totalArea++;
			if (roomba.frontIsClear()) {
				roomba.move();
			} else {
				if (roomba.facingEast()) {
					roomba.turnLeft();
					if (roomba.frontIsClear() != true) {
						break;
					}
					roomba.move();
					roomba.turnLeft();
				} else {
					roomba.turnLeft();
					roomba.turnLeft();
					roomba.turnLeft();
					if (roomba.frontIsClear() != true) {
						break;
					}
					roomba.move();
					roomba.turnLeft();
					roomba.turnLeft();
					roomba.turnLeft();
				}
			}
		}

		double averagePileSize = 0;
		if (totalPiles > 0) {
			averagePileSize = (double) totalBeepersCleaned / totalPiles;
		}
		double percentDirty = 0;
		if (totalArea > 0) {
			percentDirty = ((double) totalPiles / totalArea) * 100;
		}
				
        // finalized outputs
		System.out.println("The total area is " + totalArea + " units");
		System.out.println("There are " + totalPiles + " total piles");
		System.out.println("The largest pile has " + largestPile + " beepers and is on street " + largestPileStreet + ", avenue " + largestPileAvenue);
		System.out.println("The average pile size is " + averagePileSize + " beepers per pile");
		System.out.println(percentDirty + "% of the room is dirty");
		return totalBeepersCleaned;
	}
}