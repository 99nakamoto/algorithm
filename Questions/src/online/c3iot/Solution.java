package online.c3iot;
import java.util.List;

public class Solution {

	Pair currentLocation;
	int coinsCollected;

	/*
	 * representation of map: 
	 * 0 - location with coin 
	 * 1 - location without coin
	 * 2 - wall location
	 */
	int[][] map = null;
	
	public Solution(
			Pair board_dimension, 
			Pair initial_position, 
			String movementString, 
			List<Pair> walls
	) {
		this.coinsCollected = 0;
		if (board_dimension.x > 0 && board_dimension.y > 0) {
			
			// initialize variables
			this.currentLocation = initial_position;
			
			// build the map
			this.map = new int[board_dimension.x][board_dimension.y];
			this.buildMap(initial_position, walls);
			
			// make the movement and collect coins
			this.applyMovements(movementString.toCharArray());
		} else {
			// invalid input
			this.currentLocation = new Pair(0, 0);
			this.map = new int[0][0];
		}
	}

	private void buildMap(Pair initial_position, List<Pair> walls) {
		// mark initial_position
		if (positionLegit(initial_position.x, initial_position.y)) {
			this.map[initial_position.x][initial_position.y] = 1;
		}
		
		// mark wall locations
		for (Pair wallLocation: walls) {
			if (positionLegit(wallLocation.x, wallLocation.y)) {
				this.map[wallLocation.x][wallLocation.y] = 2;
			}
		}
	}

	private void applyMovements(char[] movements) {
		for (char direction: movements) {
			// get the next move position
			int x = 0, y = 0;
			if (direction == 'W') y = -1;
			if (direction == 'E') y = 1;
			if (direction == 'N') x = -1;
			if (direction == 'S') x = 1;
			Pair nextPosition = new Pair(this.currentLocation.x + x, this.currentLocation.y + y);
			
			// process the move
			if (positionLegit(nextPosition.x, nextPosition.y)) {
				// able to move because position not at border
				if (map[nextPosition.x][nextPosition.y] != 2) {
					// able to move because position is not wall
					if (map[nextPosition.x][nextPosition.y] == 0) {
						map[nextPosition.x][nextPosition.y] = 1;
						this.coinsCollected++;
					}
					this.currentLocation = nextPosition;
				}
			}
		}
		
	}

	public Pair getFinalLocation() {
		return this.currentLocation;
	}

	public int getTotalCoinsCollected() {
		return this.coinsCollected;
	}
	
	private boolean positionLegit(int a, int b) {
		int m = this.map.length;
		int n = this.map[0].length;
		if (a >= 0 && a < m && b >= 0 && b < n) {
			return true;
		}
		return false;
	}
}

class Pair {
	public Pair(int a, int b) {
		x = a;
		y = b;
	}
	int x, y;
}
