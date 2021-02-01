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
	 
	
	private int score = 0;
	
	
	public GameManager() throws FileNotFoundException {
		players = new ArrayList<Player>();
		appMenu = new AppMenu();
		
		loadFile();
		
		showMainMenu();
	}
	private void playGame() {
		
	}
	
	private void showMainMenu() throws FileNotFoundException { 
		
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
			if(p.getWin() >= score)
			{
				score = p.getWin();
			} 
		}
		
		for(Player p: players)
		{
			if(p.getWin() >= score)
			{
				p.topPlayer();
			}
		}
	}
	
	private Player findPlayer(String name) {
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
	private void saveFile() throws FileNotFoundException {
		File ci = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(ci);
		
		System.out.println("\nSaving...\nDone! Please visit us again!");
		
		for (Player p : players) {
			pw.println(p.format());
		}
		pw.close();
	}
	
	
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
	
	
	
	
	
}