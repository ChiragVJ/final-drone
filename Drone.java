package Drones;

import Drones.Direction.NESW;

public class Drone {
	private int xPos, yPos, droneId, dirX, dirY;
	private NESW test;
	private static int droneCount;

	Drone(int x, int y, NESW w) {
		xPos = x;
		yPos = y;
		droneId = droneCount++;
		test = w;
	}

	public String toString() {
		return "Drone " + droneId + " is at " + xPos + "," + yPos + " and is travelling in the " + test.name()
				+ " direction.";

	}

	public static void main(String[] args) {
		Drone d = new Drone(5, 3, NESW.South); // create drone
		System.out.println(d.toString()); // print where is
		Drone e = new Drone(6, 4, NESW.North);
		System.out.println(e.toString());

	}

	public boolean isHere(int sx, int sy) {
		if ((xPos == sx) && (yPos == sy)) {
			return true;
		} else
			return false;

	}

	public void displayDrone(ConsoleCanvas c) {
		c.showIt(xPos, yPos, "D");
	}

	public void tryToMove(DroneArena arena) {
		if (test.name() == "North") {
			dirX = -1;
			if ((arena.canMoveHere(xPos + dirX, yPos) == true)) {
				xPos = xPos + dirX;
			
			}
			else {
				test = test.getNextDirection();
			}
		} 
		else if (test.name() == "East") {
			
			dirY = 1;
			if ((arena.canMoveHere(xPos, yPos + dirY) == true)) {
				yPos = yPos + dirY;
			}
			else {
				test = test.getNextDirection();
			}
		} 
		else if (test.name() == "South") {
			
			dirX = 1;
			if ((arena.canMoveHere(xPos + dirX, yPos) == true)) {
				xPos = xPos + dirX;
			}
			else {
				test = test.getNextDirection();
			}
		}

		else if (test.name() == "West") {
	
			dirY = -1;
			if ((arena.canMoveHere(xPos, yPos + dirY) == true)) {
				yPos = yPos + dirY;
			}
			else {
				test = test.getNextDirection();
			}
		}
	}
}
