package Drones;
import java.util.Random;


public class Direction {
	static Random randomDir = new Random();
	public enum NESW {
		North,
		East,
		South,
		West;
		
		
		  
		public static NESW getRandomDirection() {
			
			return values()[randomDir.nextInt(values().length)];
			
		
		}
		 private static NESW[] vals = values();
		   
		public NESW getNextDirection() {
			return vals[(this.ordinal()+1) % vals.length];
			         
		}
		
	    
	 	
	
	}
}
