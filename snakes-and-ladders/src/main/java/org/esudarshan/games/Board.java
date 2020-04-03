package org.esudarshan.games;

import java.util.HashMap;
import java.util.Map;

public class Board {

	private int[] array;
	private Map<Integer, Integer> snakes;
	private Map<Integer, Integer> ladders;

	public Board() {
		array = new int[99];
		snakes = new HashMap<Integer, Integer>();
		snakes.put(17, 7);
		snakes.put(64, 60);
		snakes.put(89, 26);
		snakes.put(95, 75);
		snakes.put(99, 78);
		ladders = new HashMap<Integer, Integer>();
		ladders.put(4, 14);
		ladders.put(9, 30);
		ladders.put(28, 84);
		ladders.put(40, 59);
		ladders.put(51, 67);
		ladders.put(63, 81);
		System.out.println("Board initialized");

	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public Map<Integer, Integer> getSnakes() {
		return snakes;
	}

	public void setSnakes(Map<Integer, Integer> snakes) {
		this.snakes = snakes;
	}

	public Map<Integer, Integer> getLadders() {
		return ladders;
	}

	public void setLadders(Map<Integer, Integer> ladders) {
		this.ladders = ladders;
	}

}
