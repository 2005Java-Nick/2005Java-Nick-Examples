package com.revature.blackjack.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.blackjack.domain.BlackJackGame;
import com.revature.blackjack.domain.Player;
import com.revature.blackjack.dto.BlackJackGameDTO;
import com.revature.blackjack.service.BlackJackGameService;
import com.revature.blackjack.service.BlackJackGameServiceImpl;
import com.revature.blackjack.service.PlayerService;
import com.revature.blackjack.service.PlayerServiceImpl;

public class GameServlet extends HttpServlet{

	private static Logger log = Logger.getRootLogger();
	private static BlackJackGameService blackJackGameService = new BlackJackGameServiceImpl();
	private static PlayerService playerService = new PlayerServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String username = req.getParameter("user");
		Player player = playerService.getPlayerByUsername(username);
		BlackJackGame blackJackGame = new BlackJackGame();
		blackJackGame.setPlayer(player);
		blackJackGameService.setUp(blackJackGame);
		log.info("Game created: " + blackJackGame);
		PrintWriter writer = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		String jsonReturn = mapper.writeValueAsString(new BlackJackGameDTO(blackJackGame));
		log.info("Json value: " + jsonReturn);
		writer.write(jsonReturn);
	}
	
}
