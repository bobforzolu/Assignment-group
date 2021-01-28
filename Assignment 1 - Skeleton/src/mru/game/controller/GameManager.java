package mru.game.controller;
import mru.game.model.*;
import mru.game.view.AppMenu;

import java.io.*;
import java.util.*;
	
	/* In this class toy'll need these methods:
	 * A constructor
	 * A method to load the txt file into an arraylist (if it exists, so you check if the txt file exists first)
	 * A save method to store the arraylist into the the txt file 
	 * A method to search for a player based their name
	 * A method to find the top players
	 * Depending on your designing technique you may need and you can add more methods here 
	 */
<<<<<<< HEAD
	
	// the top score in the game
	
	


public class GameManager {
	
	private final String FILE_PATH = "res/CasinoInfo.txt";
	ArrayList<Player> players = new ArrayList<Player>();
	AppMenu appMenu;
	private Scanner kb = new Scanner(System.in);
	
	private int topScore;
	
	
	public GameManager() throws FileNotFoundException {
		appMenu = new AppMenu();
		
	
		launchGame();
	}
	
	private void launchGame() { 
		
		char choice = appMenu.mainMenu();
		
		switch (choice) {
		case 'p':
			
			break;
		case 's':
			playerInfoMenu();
			break;
		case 'e':
			saveFile();
			break;
		}	
	}
	
	
	private void loadFile() throws FileNotFoundException {
		File ci = new File(FILE_PATH);
		
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
		
	

	public void findPlayer()
	{
		String playerName;
		// location of the user in the list
		int userInList;
		// player class
		Player user ;
		
		
		System.out.print("Enter The Player Name: ");
		playerName = kb.nextLine();
		
		// search for the user using the search() function
		userInList = search( playerName);
		
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
	private void saveFile() {
		

	}
	
	
	public void playerInfoMenu()
	{
		char choice = appMenu.subMenu();
	
		switch (choice) {
		case 't':
			topPlayer();
			break;
		case 'n':
			findPlayer();
			break;
		case 'b':
			launchGame();
			break;
		}
	}
	
	
	
	/**
	 * finds the location of an item in the list
	 * @param name name of the item
	 * @return
	 */
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
