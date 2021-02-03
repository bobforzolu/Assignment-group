package mru.game.controller;

import java.util.Random;

public class PuntoBancoGame {
	
	/**
	 * In this class you implement the game
	 * You should use CardDeck class here
	 * See the instructions for the game rules
	 */
	CardDeck cardDeck;
	Random rdm;
	public PuntoBancoGame() 
	{
		 cardDeck = new CardDeck();
		 rdm = new Random();
		 launchGame();
	}
	
	public void launchGame() 
	{
		
		
		for(int i=0; i<=2; i++)
		{
		int playercard = rdm.nextInt(12) +1;
		int bankercard = rdm.nextInt(12) +1;
		
		Card player = cardDeck.getDeck().get(playercard);
		Card banker = cardDeck.getDeck().get(bankercard);
			
		System.out.println(banker);
		System.out.println(player);

		if(player.getRank() > banker.getRank())
		{
			System.out.println("player gets a point");

		}else if(player.getRank() < banker.getRank())
		{
			System.out.println("banker gets a point");

		}else
		{
			System.out.print("hk");
		}
			
		}
		
	}
}
