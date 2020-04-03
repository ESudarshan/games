package org.esudarshan.games;

public class SnakesNLadders {

	private Board board;
	private Player[] players;
	private Dice dice;

	public SnakesNLadders(int noOfPlayers) {
		board = new Board();
		players = new Player[noOfPlayers];
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player(i);
		}
		dice = new Dice();
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

	public static void main(String[] args) {
		SnakesNLadders snakesNLadders = new SnakesNLadders(2);
		Board board = snakesNLadders.getBoard();
		Dice dice = snakesNLadders.getDice();
		Player winner = null;
		while (true) {
			for (Player player : snakesNLadders.getPlayers()) {
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
	}

}
