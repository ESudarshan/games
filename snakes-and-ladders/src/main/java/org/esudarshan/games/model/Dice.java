package org.esudarshan.games.model;

import org.springframework.stereotype.Component;

@Component
public class Dice {

	public int rollTheDice() {
		return (int) ((Math.random() * 10) % 6) + 1;
	}

}
