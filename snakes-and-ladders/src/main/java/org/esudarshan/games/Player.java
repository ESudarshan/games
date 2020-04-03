package org.esudarshan.games;

import java.util.ArrayList;
import java.util.List;

public class Player {

	int id;
	String name;
	int location;
	List<Integer> path;

	public Player() {

	}

	public Player(int id) {
		super();
		this.id = id + 1;
		this.name = Integer.toString(id);
		this.location = 1;
		this.path = new ArrayList<Integer>();
		this.path.add(1);
		System.out.println("Player[" + this.id + "] initialized \t" + this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int makeAMove(int offset, Board board) {
		int newLocation = (this.location + offset) > 100 ? 100 : (this.location + offset);
		System.out.print(
				"Player[" + this.id + "] rolls the dice :\t\t" + this.location + "[+" + offset + "=]" + newLocation);
		this.location = newLocation;
		this.path.add(this.location);
		System.out.println("\t" + this);
		this.slidesSnake(board);
		this.climbsLadder(board);
		return this.location;
	}

	private void slidesSnake(Board board) {
		Integer newLocation = board.getSnakes().get(this.location);
		if (newLocation != null) {
			System.out.print("Player[" + this.id + "] slides the snake :\t\t" + this.location + "~~~~~" + newLocation);
			this.location = newLocation;
			this.path.add(this.location);
			System.out.println("\t" + this);
		}

	}

	private void climbsLadder(Board board) {
		Integer newLocation = board.getLadders().get(this.location);
		if (newLocation != null) {
			System.out.print("Player[" + this.id + "] climbs the ladder :\t\t" + location + "#####" + newLocation);
			this.location = newLocation;
			this.path.add(this.location);
			System.out.println("\t" + this);
		}
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", location=" + location + ", path=" + path + "]";
	}

}
