package Drones;

import java.util.ArrayList;
import java.util.Random;

import Drones.Direction.NESW;

public class DroneArena {

	ArrayList<Drone> Drones = new ArrayList<Drone>();
	private int xSize, ySize, xRand, yRand;
	private Drone b;
	Random randGen = new Random();

	public DroneArena(int x, int y) {

		xSize = x;
		ySize = y;

	}

	public void addDrone() {

		xRand = randGen.nextInt(xSize - 1);
		yRand = randGen.nextInt(ySize - 1);

		if ((xRand == 0) || (xRand == xSize) || (yRand == 0) || (yRand == ySize)) {
			System.out.println("Drone cannot be placed in this location");
		} else {
			b = new Drone(xRand, yRand, NESW.getRandomDirection());
			if (getDroneAt(xRand, yRand) == null) {
				Drones.add(b);
			} else {
				System.out.println("Drone already exists at this location");
			}

		}
	}

	public String toString() {
		String info = "";

		for (Drone c : Drones)
			info += c.toString() + " in the arena of size " + xSize + "," + ySize + "\n";

		return info;

	}

	public static void main(String[] args) {
		DroneArena a = new DroneArena(20, 10); // create drone arena

		System.out.println(a.toString()); // print where is
	}

	public Drone getDroneAt(int x, int y) {
		for (Drone c : Drones) {
			if (c.isHere(x, y)) {
				return c;
			}
		}
		return null;

	}

	public void showDrones(ConsoleCanvas c) {
		for (Drone e : Drones) {
			e.displayDrone(c);
		}
	}

	public int getX(DroneArena g) {

		return g.xSize;
	}

	public int getY(DroneArena g) {

		return g.ySize;
	}

	public boolean canMoveHere(int x, int y) {

		for (Drone c : Drones) {
			if ((c.isHere(x, y) == true) || ((x == 0) || (x == (xSize - 1)) || (y == 0) || (y == (ySize - 1)))) {
				return false;
			}
		}
		return true;
		}

	public void moveAllDrones(DroneArena arena) {
		for (Drone c : Drones) {
			c.tryToMove(arena);
		}
	}
}
