package mru.test.driver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.game.controller.CardDeck;

class Cardtest {

	@Test
	void test() {
		CardDeck card = new CardDeck();
		System.out.println(card.getDeck().get(0).getSuit());
		System.out.println(card.getDeck().get(0).getRank());

		
	}

}
