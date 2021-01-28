package mru.game.controller;
import mru.game.model.*;
import java.util.*;

public class GameManager {
	ArrayList<Player> players = new ArrayList<Player>();
	/* In this class toy'll need these methods:
	 * A constructor
	 * A method to load the txt file into an arraylist (if it exists, so you check if the txt file exists first)
	 * A save method to store the arraylist into the the txt file 
	 * A method to search for a player based their name
	 * A method to find the top players
	 * Depending on your designing technique you may need and you can add more methods here 
	 */
	
	// the top score in the game
	private int topScore;
	
	public GameManager()
	{
		
	}
	private void loadFile()
	{
		
	}
	public void topPlayer()
	{
		// current location in the list
		int j=0;
		// contains the list size
		int listsize;
		// the player class to call functions
		Player user;
		
		
		listsize = players.size();
		while(j >= listsize)
		{
			// get the person in the list location j(number)
			user = players.get(j);
			
			if(user.getWin()>= topScore)
			{
				user.topPlayer();
			}
			// now check the next person in the list
			j++;
			
		}
		
	
		
	}
	/**
	 *@description searches the desire player 
	 * 
	 * 
	 * @param name  the name of the user
	 * @return none
	 */
	public void findPlayer(String name)
	{
		// location of the user in the list
		int userInList;
		// player class
		Player user ;
		// asign thr location using the search() function
		userInList = search( name);
		if(userInList >=0)
		{
			user = players.get(userInList);
			user.playerinfo();
		}
		else
		{
			System.out.print("user not found");
		}
	}
	private void saveFile()
	{
		
	}
	private int search(String name)
	{
		// check if an item is in the list if it remains as one item is not in the list
		int foundInfo = -1;
		// current location in the list
		int j = 0 ;
		// list size
		int dataSize;
		// player class
		Player found;
		
		// list size
		dataSize = players.size();
		
		while(j <= dataSize)
		{
			// get the item in the list and stores in in the player class
			found = players.get(j);
		
			// check if the inputed name matches the ones in the list
			if(found.getName().equals(name))
			{
				// store the item in foundinfo
				foundInfo = j;
			}
			j++;
		}
		return foundInfo;
		
	}
	
	
	
	

}
