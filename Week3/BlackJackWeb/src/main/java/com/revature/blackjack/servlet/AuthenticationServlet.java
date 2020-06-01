package com.revature.blackjack.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.blackjack.domain.Player;
import com.revature.blackjack.service.PlayerService;
import com.revature.blackjack.service.PlayerServiceImpl;

/**
 * Servlet implementation class AuthenticationServlet
 */
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static PlayerService playerService = new PlayerServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("username: " + request.getParameter("username"));
		Player player = playerService.getPlayerByUsername(request.getParameter("username"));
		HttpSession sess = request.getSession(true);
		sess.setAttribute("user", player);
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.getWriter().write(new ObjectMapper().writeValueAsString(player));

	}

}
