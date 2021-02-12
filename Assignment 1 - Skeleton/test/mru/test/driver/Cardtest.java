package mru.test.driver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mru.game.controller.Card;
import mru.game.controller.CardDeck;

class Cardtest {
	private CardDeck card;
	
	@BeforeEach
	public void getDeck()
	{
		 card = new CardDeck();
	}
	@Test
	void getCardInfo() {
		
		System.out.println(card.getDeck().get(0));
		System.out.println("Suit: "+card.getDeck().get(0).getSuit());
		System.out.println("Rank: "+card.getDeck().get(0).getRank());	
	}
	@Test
	/**
	 * checks weather the numeric values of suits and values of the rank match
	 * the to their expected stings
	 */
	void cardtest() {
		
		if(card.getDeck().get(0).getRank() < 10)
		{
			int rank = card.getDeck().get(0).getRank();
			String name = card.getDeck().get(0).getSuit();
			String cardInfo = rank + " of " + name;
			String expectedcars = card.getDeck().get(0).toString();
		
			assertEquals(expectedcars, cardInfo);

		}else {
			int rank = card.getDeck().get(0).getRank();
			String name = card.getDeck().get(0).getSuit();
			String cardInfo = name + " of " +rank ;
			String expectedcars = card.getDeck().get(0).toString();
		
			assertEquals(expectedcars, cardInfo);
		}
			
	}
	/**
	 * create a newDeck and chaeck if the colections are not the same
	 */
	@Test
	void newDeck()
	{
		
		
		CardDeck deck2 = new CardDeck();
		
		
		
		assertNotEquals(card.getDeck(),deck2.getDeck());
	}
	@Test
	void newCard() {
		
		
		Card firstCard = card.getDeck().remove(0);
		Card secondCard = card.getDeck().remove(0);
		
		assertNotEquals(firstCard, secondCard);
		
	}
	@Test
	void ShuffleDeck() {
		CardDeck deck1 = new CardDeck();
		CardDeck deck2 = new CardDeck();
		
		assertNotEquals(deck1, deck2);
		
	}
	
}
