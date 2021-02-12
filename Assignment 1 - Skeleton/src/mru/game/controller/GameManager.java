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
	PuntoBancoGame game;
	 
	
	private int score = 0;
	
	/**
	 *@decription the game manager
	 *@param none
	 * @return none
	 */
	public GameManager() throws FileNotFoundException {
		players = new ArrayList<Player>();
		appMenu = new AppMenu();
		
		loadFile();
		
		showMainMenu();
	}
	
	private void playGame() throws FileNotFoundException  {
		
		String name;
		
		// the start screen to get the players name
		name = greetPlayer();
		
		// start the game and get the neacesery information
		
		
		
		// coditions to update game information and to loop the game
		boolean keepPlaying = true;
		double balance = getPlayerBalance(name);
		double betAmount;
		
		game = new PuntoBancoGame();
		
		// the game
		while(keepPlaying && balance > 0)
		{
			
			boolean ifHasWon = game.launchGame(balance);
			betAmount = game.getBet();
			endResult(name,ifHasWon, betAmount);
			balance = getPlayerBalance(name);

			if(balance > 0) 
			{
				keepPlaying = game.promptContinue();
			}
		}
		
		// bring back the player to the Main menu after the game is done
		if( balance <= 0)
		{
			System.out.println("\nyour balance is less or equal to zero u can no longer play");
			System.out.println("going back to the Main Menu");
			
		}
		showMainMenu();	
			

		

	}
	
	/**
	 *@decription displays the main menu
	 *@param none
	 * @return none
	 */
	public void showMainMenu() throws FileNotFoundException { 
		
		char choice = appMenu.mainMenu();
		
		switch (choice) {
		case 'p':
			playGame();

			break;
		case 's':
			playerInfoMenu();
			break;
		case 'e':
			saveFile();
			break;
		default:
			System.out.println("\nError: Please try again.");
			showMainMenu();
		}	
	}
	/**
	 *@decription load user data into the game
	 *@param none
	 * @return none
	 */
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
	/**
	 *@decription prints out the name of users with the highest win
	 *@param none
	 * @return none
	 */
	public void topPlayer()
	{
		
		for(Player p: players)
		{
			if(p.getWin() >= score)
			{
				score = p.getWin();
			} 
		}
		appMenu.topPlayerMenu();
		
		for(Player p: players)
		{
			if(p.getWin() >= score)
			{
				p.topPlayer();
			}
		}
	}
	
	/**
	 * finds the location of the requested player
	 * @param name name of the player
	 * @return ply location of the player in the list
	 */
	public Player findPlayer(String name) {
		Player ply = null;
		
		for(Player p: players) {
			if(p.getName().equals(name))
			{
				ply = p;
				break;
			}
		}
		return ply;
	}
	/**
	 * @decription : saves player data
	 * @throws FileNotFoundException
	 */
	private void saveFile() throws FileNotFoundException {
		File ci = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(ci);
		
		System.out.println("\nSaving...\nDone! Please visit us again!");
		
		for (Player p : players) {
			pw.println(p.format());
		}
		pw.close();
	}
	
	/**
	 *@decription saves the player data
	 *@param none
	 * @return none
	 */
	public void playerInfoMenu() throws FileNotFoundException
	{
		char choice = appMenu.subMenu();
	
		switch (choice) {
		case 't':
			topPlayer();
			showMainMenu();
			break;
		case 'n':
			String name = appMenu.enterName();
			Player ply = findPlayer(name);
			appMenu.plyInfo(ply);
			showMainMenu();
			break;
		case 'b':
			showMainMenu();
			break;
		default:
			System.out.println("\nError: Please try again.");
			playerInfoMenu();
		}
	}
	
	/** 
	 *  updates the players balance and wins
	 * @param name of the player
	 * @param ifHasWon checks weather the player has won or lost
	 * @param betAmount amount the plaer betted
	 * @throws FileNotFoundException
	 */
	public void endResult(String name , boolean ifHasWon, double betAmount) 
	{
		if(ifHasWon == true)
		{
			
			for(Player ply: players)
			{
				if(ply.getName().equals(name))
					{
						int win = ply.getWin();
						double money = ply.getBalance();
						ply.setBalance(money + betAmount);
						ply.setWin(win + 1);
					}
			}

		}
		else
		{
			for(Player ply: players)
			{
				if(ply.getName().equals(name))
				{
					
					double money = ply.getBalance();
					ply.setBalance(money - betAmount);		
				}			
			}
			
		}

		
	}
	
	
	/**
	 * Welcome screen to greet the player when he starts the game
	 * @return name the name of the player
	 */
	public String greetPlayer()
	{
		String name = appMenu.enterName();
		Player p = findPlayer(name);
		
		//new player seting
		double initialBal = 100;
		int inintalWin = 0;
		
		// balance
		
		
		
		if(p == null)
		{
			players.add(new Player(name,initialBal,inintalWin));
			
			System.out.printf("\n********************************************************************"
							+ "\n***    Welcome %-10s---    Your initial balance is: $%-7s***"
							+ "\n********************************************************************", name, initialBal);
			
			// greet the new player
		} else {
			// welcome the returning player
			System.out.printf("\n********************************************************************"
							+ "\n***    Welcome back %-10s---   Your balance is: $%-11s***"
							+ "\n********************************************************************", name, p.getBalance());
		}
		return name;
	}
	
	/**
	 * gets the current balance of the player
	 * @param name of the player
	 * @return balance players balance
	 */
	public double getPlayerBalance(String name)
	{
		double balance = 0;
		for(Player p: players) {
			if(p.getName().equals(name))
			{
				balance = p.getBalance();
			}
		
		}
		return balance;
	}
	
}