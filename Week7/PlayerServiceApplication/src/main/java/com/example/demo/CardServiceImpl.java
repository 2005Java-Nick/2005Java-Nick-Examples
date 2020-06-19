package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardServiceImpl implements CardService {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	private static final String URL = "http://localhost:10000/card/";

	@Override
	public Card getCardByFaceSuit(String face, String suit) {
		String url = URL + suit + "/face/" + face;
		System.out.println(url);
		return restTemplate.getForObject(url, Card.class);
	}

}
