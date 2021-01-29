package mru.game.controller;
import mru.game.model.*;
import mru.game.view.AppMenu;
import java.io.File;
import java.io.FileNotFoundException;
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

	
	// the top score in the game
	
	


public class GameManager {
	
	private final String FILE_PATH = "res/CasinoInfo.txt";
	ArrayList<Player> players;
	AppMenu appMenu;
	 
	
	private int topScore = 0;
	
	
	public GameManager() throws FileNotFoundException {
		players = new ArrayList<Player>();
		appMenu = new AppMenu();
		loadFile();
		
	
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
		
		String currentLine;
		String[] splittedLine;
		
		
		if(ci.exists())
		{
			Scanner fileReader = new Scanner(ci);
			
			while(fileReader.hasNextLine())
			{
				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(",");
				
				Player p = new Player(splittedLine[0], Double.parseDouble(splittedLine[1]) , Integer.parseInt(splittedLine[2]));
				players.add(p);
			}
			
			fileReader.close();
		}
		
	}
	
	public void topPlayer()
	{
		
		
		for(Player p: players)
		{
			if(p.getWin() >= topScore)
			{
				topScore = p.getWin();
			}
		}
		
		for(Player p: players)
		{
			if(p.getWin() >= topScore)
			{
				p.topPlayer();
			}
		}
	}
		
	

	private Player findPlayer()
	{
		Scanner input = new Scanner(System.in);
		String name;
		Player ply = null;
		
		name = input.nextLine();
		
		for(Player p: players)
		{
			if(p.getName().equals(name))
			{
				ply = p;
				break;

			}
		}
		return ply;
		
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
			Player ply = findPlayer();
			appMenu.plyInfo(ply);
			break;
		case 'b':
			launchGame();
			break;
		}
	}
	
	
	
	/**
	 * finds the location of an item in the list
	 * @param name name of the item
	 * @return foundinfo item position
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
		Player player;
		
		boolean found = false;
		
		// list size
		dataSize = players.size();
		
		while(j <= dataSize && !found)
		{
			// get the item in the list and stores in in the player class
			player = players.get(j);
		
			// check if the inputed name matches the ones in the list
			if(player.getName().equals(name))
			{
				// store the item in foundinfo
				foundInfo = j;
				found = true;
				
			}
			j++;
		}
		return foundInfo;
		
	}
	
	
	
	
	

}
