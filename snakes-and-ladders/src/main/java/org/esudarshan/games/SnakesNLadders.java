package org.esudarshan.games;

import org.esudarshan.games.model.Board;
import org.esudarshan.games.model.Dice;
import org.esudarshan.games.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration
//@ComponentScan(basePackages = { "org.esudarshan" })
@SpringBootApplication(scanBasePackages = { "org.esudarshan" })
public class SnakesNLadders {

	@Autowired
	private Board board;

	@Autowired
	private Dice dice;

	private Player[] players;

	public SnakesNLadders() {
		// TODO Auto-generated constructor stub
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public void initializePlayers(int noOfPlayers) {
		players = new Player[noOfPlayers];
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player(i);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(SnakesNLadders.class, args);
	}

}
