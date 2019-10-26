package Drones;

public class ConsoleCanvas {
	String[][] arena;

	public ConsoleCanvas(int x, int y) {
		arena = new String[x][y];
		for (int ct = 0; ct < x; ct++) {
			for (int ct1 = 0; ct1 < y; ct1++) {
				arena[ct][ct1] = "#";

			}

		}
		for (int i = 1; i < x - 1; i++) {
			for (int j = 1; j < y - 1; j++) {
				arena[i][j] = " ";
			}

		}
	}

	public void showIt(int xPos, int yPos, String z) {

		arena[xPos][yPos] = z;

	}

	public String toString() {
		String info = "";
		for (String[] x : arena) {
			for (String y : x) {
				info += (y + " ");
			}
		info += "\n";
		}

		return info;
	}

	public static void main(String[] args) {
		ConsoleCanvas c = new ConsoleCanvas(20, 20); // create a canvas
		c.showIt(10, 6, "D"); // add a Drone at 4,3
		System.out.println(c.toString()); // display result
	}

}
