package org.esudarshan.games.model;

public class User {

	private String id;
	private String name;
	private String game;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", game=" + game + "]";
	}

}
