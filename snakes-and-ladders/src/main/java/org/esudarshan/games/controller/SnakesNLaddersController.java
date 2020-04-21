package org.esudarshan.games.controller;

import org.esudarshan.games.SnakesNLadders;
import org.esudarshan.games.model.Board;
import org.esudarshan.games.model.Dice;
import org.esudarshan.games.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/snakes-n-ladders")
public class SnakesNLaddersController {

	@Autowired
	private SnakesNLadders snakesNLadders;

	@CrossOrigin
	@RequestMapping(path = "/board", method = RequestMethod.GET)
	public Board getBoard() {
		return snakesNLadders.getBoard();
	}

	@CrossOrigin
	@RequestMapping("/initialize-players/{noOfPlayers}")
	public Player[] initializePlayers(@PathVariable int noOfPlayers) {
		snakesNLadders.initializePlayers(noOfPlayers);
		return snakesNLadders.getPlayers();
	}

	@CrossOrigin
	@RequestMapping("/play")
	public Player play() throws Exception {
		Player[] players = snakesNLadders.getPlayers();
		if (players == null) {
			throw new Exception("Players not initialized");
		}
		Dice dice = snakesNLadders.getDice();
		Board board = snakesNLadders.getBoard();
//		Player winner = null;
//		while (true) {
//			for (Player player : players) {
		Player player = players[0];
				int location = player.getLocation();
				int offset = dice.rollTheDice();
//				while (offset == 6) {
//					location = player.makeAMove(offset, board);
//					if (location == 100) {
//						winner = player;
//						break;
//					}
//					offset = dice.rollTheDice();
//				}
				if (location != 100) {
					location = player.makeAMove(offset, board);

				}
				if (location == 100) {
//					winner = player;
//					break;
				}
//			}
//			if (winner != null) {
//				break;
//			}
//		}
//		System.out.println("winner = " + winner);
//		return players;
		return player;
	}

}
