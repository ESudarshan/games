package org.esudarshan.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = { "org.esudarshan" })
public class SnakesNLadders {

	@Autowired
	private Board board;

	@Autowired
	private Dice dice;

	@Autowired
	private SnakesNLadders snakesNLadders;

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

	@CrossOrigin
	@RequestMapping("/snakes-n-ladders/play/{noOfPlayers}")
	public Player[] play(@PathVariable int noOfPlayers) {
		snakesNLadders.initializePlayers(noOfPlayers);
		Player winner = null;
		while (true) {
			for (Player player : players) {
				int location = player.getLocation();
				int offset = dice.rollTheDice();
				while (offset == 6) {
					location = player.makeAMove(offset, board);
					if (location == 100) {
						winner = player;
						break;
					}
					offset = dice.rollTheDice();
				}
				if (location != 100) {
					location = player.makeAMove(offset, board);

				}
				if (location == 100) {
					winner = player;
					break;
				}
			}
			if (winner != null) {
				break;
			}
		}
		System.out.println("winner = " + winner);
		return players;
	}

	@CrossOrigin
	@RequestMapping("/snakes-n-ladders/get-board")
	public Board getGameBoard() {
		System.out.println(board);
		return board;
	}

}
