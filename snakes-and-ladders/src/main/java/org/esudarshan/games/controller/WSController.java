package org.esudarshan.games.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.esudarshan.games.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WSController {

	private Map<String, List<User>> gameUserMap = new HashMap<>();
	private Map<String, List<String>> gameMetadata = new HashMap<>();

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@MessageMapping("/create-game")
	@SendTo("/queue/create-game")
	public String createGame(User user, Principal principal) {
		user.setId(principal.getName());
		String gameId = UUID.randomUUID().toString();
		user.setGame(gameId);
		gameUserMap.put(gameId, new ArrayList<>(Arrays.asList(user)));
		return String.format("%s has created a game with id = %s", user.getName(), gameId);
	}

	@MessageMapping("/join-game")
	public void joinGame(User user, Principal principal) {
		user.setId(principal.getName());
		System.out.println("Principal = " + principal.getName());
		System.out.println(user);

		if (gameUserMap.containsKey(user.getGame())) {
			List<User> users = gameUserMap.get(user.getGame());
			if (users.size() == 2) {
				// TODO
//				System.out.println(gameUserMap);
//				return "Game is already in progress";
			}
			users.add(user);
			users.forEach((u) -> {
				System.out.println("Sending to " + u);
				messagingTemplate.convertAndSendToUser(u.getId(), "/queue/join-game",
						String.format("%s has joined a game with id = %s", user.getName(), user.getGame()));
			});
			System.out.println(gameUserMap);
		} else {
			// TODO
//			System.out.println(gameUserMap);
			System.out.println(String.format("Game with id = %s does not exist", user.getGame()));
		}
	}

}
