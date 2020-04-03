package org.esudarshan.games;

public class Dice {

	public int rollTheDice() {
		return (int) ((Math.random() * 10) % 6) + 1;
	}

}
